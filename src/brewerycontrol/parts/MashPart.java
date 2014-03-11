package brewerycontrol.parts;

import gnu.io.CommPort;

import java.util.ArrayList;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.csstudio.swt.widgets.figures.GaugeFigure;
import org.csstudio.swt.xygraph.dataprovider.CircularBufferDataProvider;
import org.csstudio.swt.xygraph.dataprovider.CircularBufferDataProvider.PlotMode;
import org.csstudio.swt.xygraph.figures.Trace;
import org.csstudio.swt.xygraph.figures.Trace.BaseLine;
import org.csstudio.swt.xygraph.figures.XYGraph;
import org.csstudio.swt.xygraph.linearscale.Range;
import org.csstudio.swt.xygraph.util.XYGraphMediaFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

import brewerycontrol.BreweryEventTopic;
import brewerycontrol.job.MashTimerJob;
import brewerycontrol.monitor.Sensor;

/**
 * 
 * @author nguba_000
 * 
 */
public class MashPart {
	@Inject
	private UISynchronize sync;
	@Inject
	private CommPort serialPort;
	private GaugeFigure gaugeFigure;
	private CircularBufferDataProvider provider;
	private Table table;
	private MashTimerJob timerJob;
	private final Calendar calendar = Calendar.getInstance();

	private CLabel timerLabel;

	@Inject
	public MashPart() {
		final ArrayList<MashStep> steps = new ArrayList<>();
		steps.add(new MashStep(38, 40, "Acid"));
		steps.add(new MashStep(55, 20, "Protease"));
		steps.add(new MashStep(67, 60, "Saccharification"));
		steps.add(new MashStep(76, 5, "Mash Out"));
		MashScheduleProvider.INSTANCE.setSteps(steps);
	}

	/**
	 * listens for pin 5
	 * 
	 * @param pin
	 */
	@Inject
	@Optional
	void pinEventReceived(@UIEventTopic("sensor/mash") final Sensor sensor) {

		final Job job = new Job("sensor/mash/ui") {
			/**
			 * 
			 */
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				sync.asyncExec(new Runnable() {
					/**
					 * 
					 */
					@Override
					public void run() {
						gaugeFigure.setValue(sensor.getValue());
						provider.setCurrentYData(sensor.getValue());
						calendar.add(Calendar.HOUR, 1);
						final long newValue = calendar.getTimeInMillis() / 1000 / 60;
						// System.out.println(newValue);
						provider.setCurrentXData(newValue);
					}
				});
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	@PostConstruct
	public void postConstruct(final Composite parent) {

		parent.setLayout(new FillLayout(SWT.HORIZONTAL));

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		final Canvas guageCanvas = new Canvas(composite, SWT.NO_FOCUS);
		guageCanvas.setLayout(new GridLayout(1, true));
		final GridData gd_guageCanvas = new GridData(SWT.CENTER, SWT.FILL,
				true, false, 1, 1);
		gd_guageCanvas.widthHint = 136;
		gd_guageCanvas.heightHint = 134;
		guageCanvas.setLayoutData(gd_guageCanvas);

		final Canvas historyCanvas = new Canvas(composite, SWT.NONE);
		final GridData gd_historyCanvas = new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 2);
		gd_historyCanvas.heightHint = 153;
		gd_historyCanvas.widthHint = 297;
		historyCanvas.setLayoutData(gd_historyCanvas);
		final LightweightSystem historyLWS = new LightweightSystem(
				historyCanvas);

		final XYGraph mashGraph = new XYGraph();
		// xyGraph.setTitle("History");
		mashGraph.primaryYAxis.setRange(new Range(0, 80));
		mashGraph.primaryYAxis.setShowMajorGrid(true);
		mashGraph.primaryYAxis.setShowMinorGrid(true);
		mashGraph.primaryYAxis.setAutoFormat(true);
		mashGraph.primaryYAxis.setTitle("Temperature");

		mashGraph.primaryXAxis.setRange(new Range(0, 260));
		mashGraph.primaryXAxis.setShowMajorGrid(true);
		mashGraph.primaryXAxis.setTitle("Time");
		mashGraph.setShowLegend(false);

		provider = new CircularBufferDataProvider(false);
		provider.setPlotMode(PlotMode.N_STOP);
		provider.setBufferSize(320 * 60);

		final Trace trace = new Trace("Temp Graph", mashGraph.primaryXAxis,
				mashGraph.primaryYAxis, provider);
		trace.setBaseLine(BaseLine.ZERO);
		trace.setAntiAliasing(true);
		mashGraph.addTrace(trace);
		historyLWS.setContents(mashGraph);

		gaugeFigure = new GaugeFigure();
		gaugeFigure.setBackgroundColor(XYGraphMediaFactory.getInstance()
				.getColor(0, 0, 0));
		gaugeFigure.setForegroundColor(XYGraphMediaFactory.getInstance()
				.getColor(255, 255, 255));

		gaugeFigure.setRange(0, 100);
		gaugeFigure.setLoLevel(38);
		// gaugeFigure.setLoloLevel(-80);
		gaugeFigure.setHiLevel(78);
		// gaugeFigure.setHihiLevel(100);
		gaugeFigure.setMajorTickMarkStepHint(50);
		gaugeFigure.setEffect3D(true);
		gaugeFigure.setShowMarkers(true);
		gaugeFigure.setValue(0);
		final LightweightSystem lws = new LightweightSystem(guageCanvas);

		final ScrolledComposite scrolledComposite = new ScrolledComposite(
				composite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		final GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1);
		gd_scrolledComposite.widthHint = 167;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		final CheckboxTableViewer mashSteps = CheckboxTableViewer.newCheckList(
				scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table = mashSteps.getTable();
		table.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableViewerColumn timeViewerColumn = new TableViewerColumn(
				mashSteps, SWT.NONE);
		timeViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return null;
			}

			@Override
			public String getText(Object element) {
				if (element != null) {
					final MashStep step = (MashStep) element;
					return String.valueOf(step.getRest());
				} else {
					return "";
				}
			}
		});
		final TableColumn timeColumn = timeViewerColumn.getColumn();
		timeColumn.setAlignment(SWT.CENTER);
		timeColumn.setMoveable(true);
		timeColumn.setWidth(45);
		timeColumn.setText("Time");

		final TableViewerColumn tempViewerColumn = new TableViewerColumn(
				mashSteps, SWT.NONE);
		tempViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return null;
			}

			@Override
			public String getText(Object element) {
				if (element != null) {
					final MashStep step = (MashStep) element;
					return String.valueOf(step.getTemp()) + "C";
				} else {
					return "";
				}
			}
		});
		final TableColumn tempColumn = tempViewerColumn.getColumn();
		tempColumn.setAlignment(SWT.CENTER);
		tempColumn.setMoveable(true);
		tempColumn.setWidth(45);
		tempColumn.setText("Temp");

		final TableViewerColumn nameViewerColumn = new TableViewerColumn(
				mashSteps, SWT.NONE);
		nameViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return null;
			}

			@Override
			public String getText(Object element) {
				if (element != null) {
					final MashStep step = (MashStep) element;
					return step.getPhase();
				} else {
					return "";
				}
			}
		});
		final TableColumn nameColumn = nameViewerColumn.getColumn();
		nameColumn.setMoveable(true);
		nameColumn.setWidth(120);
		nameColumn.setText("Phase");
		mashSteps.setContentProvider(new ArrayContentProvider());
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table
				.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		final Composite statusBar = new Composite(composite, SWT.BORDER
				| SWT.NO_FOCUS);
		final GridLayout gl_statusBar = new GridLayout(2, false);
		gl_statusBar.marginHeight = 1;
		gl_statusBar.verticalSpacing = 1;
		gl_statusBar.marginWidth = 1;
		statusBar.setLayout(gl_statusBar);
		final GridData gd_statusBar = new GridData(SWT.FILL, SWT.FILL, true,
				false, 2, 1);
		gd_statusBar.widthHint = 459;
		gd_statusBar.heightHint = 26;
		statusBar.setLayoutData(gd_statusBar);

		final ProgressBar progressBar = new ProgressBar(statusBar, SWT.NONE);
		GridData gd_progressBar = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_progressBar.heightHint = 23;
		progressBar.setLayoutData(gd_progressBar);

		timerLabel = new CLabel(statusBar, SWT.BORDER | SWT.SHADOW_IN
				| SWT.SHADOW_OUT | SWT.CENTER);
		timerLabel.setFont(SWTResourceManager.getFont("Lucida Sans Typewriter", 11, SWT.NORMAL));
		timerLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		timerLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		final GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblNewLabel.widthHint = 77;
		timerLabel.setLayoutData(gd_lblNewLabel);
		timerLabel.setText("00:00:00");
		lws.setContents(gaugeFigure);

		timerJob = new MashTimerJob(sync, serialPort, calendar, timerLabel);
		mashSteps.setInput(MashScheduleProvider.INSTANCE.getSteps());
	}

	/**
	 * 
	 * @param command
	 */
	@Inject
	@Optional
	void processMashtunCommands(
			@UIEventTopic(BreweryEventTopic.MASH_COMMAND) final MashPartCommand command) {
		switch (command) {
		case PAUSE:
			break;
		case START:
			timerJob.start();
			break;
		case STOP:
			gaugeFigure.setValue(0);
			timerJob.stop();
			break;
		default:
			break;

		}
	}

	/**
	 * 
	 */
	@Persist
	public void save() {
	}
}