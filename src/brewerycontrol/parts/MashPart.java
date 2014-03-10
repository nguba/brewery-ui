package brewerycontrol.parts;

import java.text.SimpleDateFormat;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

import brewerycontrol.monitor.Pin;

/**
 * 
 * @author nguba_000
 * 
 */
public class MashPart {
	@Inject
	private UISynchronize sync;

	private GaugeFigure gaugeFigure;

	private CircularBufferDataProvider provider;
	private Table table;
	private Job timerJob;
	private Calendar calendar = Calendar.getInstance();

	private SimpleDateFormat dateFormat;

	private CLabel timerLabel;
	
	@Inject
	public MashPart() {
		ArrayList<MashStep> steps = new ArrayList<>();
		steps.add(new MashStep(38, 40, "Acid"));
		steps.add(new MashStep(55, 20, "Protease"));
		steps.add(new MashStep(67, 60, "Saccharification"));
		steps.add(new MashStep(76, 5, "Mash Out"));
		MashScheduleProvider.INSTANCE.setSteps(steps);
		
		calendar.set(0, 0, 0, 0, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR, 0);
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		timerJob = new Job("mash/timer") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				sync.asyncExec(new Runnable() {

					@Override
					public void run() {
						calendar.add(Calendar.SECOND, 1);
						timerLabel.setText(dateFormat.format(calendar.getTime()));
						schedule(1000);
					}
				});
				return Status.OK_STATUS;
			}
		};
	}

	@PostConstruct
	public void postConstruct(final Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		Canvas guageCanvas = new Canvas(composite, SWT.NO_FOCUS);
		guageCanvas.setLayout(new GridLayout(1, true));
		GridData gd_guageCanvas = new GridData(SWT.CENTER, SWT.FILL, true,
				false, 1, 1);
		gd_guageCanvas.widthHint = 136;
		gd_guageCanvas.heightHint = 160;
		guageCanvas.setLayoutData(gd_guageCanvas);

		Canvas historyCanvas = new Canvas(composite, SWT.NONE);
		GridData gd_historyCanvas = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 2);
		gd_historyCanvas.heightHint = 153;
		gd_historyCanvas.widthHint = 297;
		historyCanvas.setLayoutData(gd_historyCanvas);
		LightweightSystem historyLWS = new LightweightSystem(historyCanvas);

		final XYGraph mashGraph = new XYGraph();
		// xyGraph.setTitle("History");
		mashGraph.primaryYAxis.setRange(new Range(0, 80));
		mashGraph.primaryYAxis.setShowMajorGrid(true);
		mashGraph.primaryYAxis.setTitle("Temperature");

		mashGraph.primaryXAxis.setRange(new Range(0, 180));
		mashGraph.primaryXAxis.setShowMajorGrid(true);
		mashGraph.primaryXAxis.setTitle("Time");
		mashGraph.setShowLegend(false);
		
		provider = new CircularBufferDataProvider(false);
		provider.setPlotMode(PlotMode.N_STOP);
		provider.setBufferSize(200);
		
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
		LightweightSystem lws = new LightweightSystem(guageCanvas);

		ScrolledComposite scrolledComposite = new ScrolledComposite(composite,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd_scrolledComposite.widthHint = 167;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		CheckboxTableViewer mashSteps = CheckboxTableViewer.newCheckList(
				scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table = mashSteps.getTable();
		table.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableViewerColumn timeViewerColumn = new TableViewerColumn(mashSteps,
				SWT.NONE);
		timeViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}

			public String getText(Object element) {
				if (element != null) {
					MashStep step = (MashStep) element;
					return String.valueOf(step.getRest());
				} else
					return "";
			}
		});
		TableColumn timeColumn = timeViewerColumn.getColumn();
		timeColumn.setAlignment(SWT.CENTER);
		timeColumn.setMoveable(true);
		timeColumn.setWidth(45);
		timeColumn.setText("Time");

		TableViewerColumn tempViewerColumn = new TableViewerColumn(mashSteps,
				SWT.NONE);
		tempViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}

			public String getText(Object element) {
				if (element != null) {
					MashStep step = (MashStep) element;
					return String.valueOf(step.getTemp()) + "C";
				} else
					return "";
			}
		});
		TableColumn tempColumn = tempViewerColumn.getColumn();
		tempColumn.setAlignment(SWT.CENTER);
		tempColumn.setMoveable(true);
		tempColumn.setWidth(45);
		tempColumn.setText("Temp");

		TableViewerColumn nameViewerColumn = new TableViewerColumn(mashSteps,
				SWT.NONE);
		nameViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}

			public String getText(Object element) {
				if (element != null) {
					MashStep step = (MashStep) element;
					return step.getPhase();
				} else
					return "";
			}
		});
		TableColumn nameColumn = nameViewerColumn.getColumn();
		nameColumn.setMoveable(true);
		nameColumn.setWidth(120);
		nameColumn.setText("Phase");
		mashSteps.setContentProvider(new ArrayContentProvider());
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table
				.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		Composite statusBar = new Composite(composite, SWT.BORDER
				| SWT.NO_FOCUS);
		GridLayout gl_statusBar = new GridLayout(3, false);
		gl_statusBar.marginHeight = 1;
		gl_statusBar.verticalSpacing = 1;
		gl_statusBar.marginWidth = 1;
		statusBar.setLayout(gl_statusBar);
		GridData gd_statusBar = new GridData(SWT.FILL, SWT.FILL, true, false,
				2, 1);
		gd_statusBar.widthHint = 459;
		gd_statusBar.heightHint = 26;
		statusBar.setLayoutData(gd_statusBar);

		Composite composite_2 = new Composite(statusBar, SWT.NONE);
		GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_composite_2.widthHint = 173;
		gd_composite_2.heightHint = 24;
		composite_2.setLayoutData(gd_composite_2);

		Button buttonStart = new Button(composite_2, SWT.NONE);
		buttonStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				timerJob.schedule(1000);
			}
		});
		buttonStart.setBounds(0, 0, 45, 25);
		buttonStart.setText("Start");

		Button buttonStop = new Button(composite_2, SWT.NONE);
		buttonStop.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				timerJob.cancel();
			}
		});
		buttonStop.setBounds(51, 0, 53, 25);
		buttonStop.setText("Stop");

		Button buttonLoad = new Button(composite_2, SWT.NONE);
		buttonLoad.setBounds(110, 0, 59, 25);
		buttonLoad.setText("Load");
		buttonLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(parent.getShell());
				dialog.open();
				System.out.println(dialog.getFileName());
			}
		});

		ProgressBar progressBar = new ProgressBar(statusBar, SWT.NONE);
		progressBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		timerLabel = new CLabel(statusBar, SWT.BORDER | SWT.SHADOW_IN
				| SWT.SHADOW_OUT | SWT.CENTER);
		timerLabel
				.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		timerLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		timerLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel.widthHint = 77;
		timerLabel.setLayoutData(gd_lblNewLabel);
		timerLabel.setText("00:00:00");
		lws.setContents(gaugeFigure);

		mashSteps.setInput(MashScheduleProvider.INSTANCE.getSteps());
		System.out.println(mashSteps.getInput());

	}

	@Persist
	public void save() {
	}

	/**
	 * listens for pin 5
	 * 
	 * @param pin
	 */
	@Inject
	@Optional
	void pinEventReceived(@UIEventTopic("arduino/pin/5") final Pin pin) {

		final Job job = new Job("arduino/pin/5/updater") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				sync.asyncExec(new Runnable() {

					@Override
					public void run() {
						final double temperature = ((pin.value * 0.004882814) - 0.5) * 100;
						final double value = temperature;
						gaugeFigure.setValue(value);
					}
				});
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
}