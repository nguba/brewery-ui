package brewerycontrol.parts;

import gnu.io.CommPort;

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
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
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

import brewery.MashSchedule;
import brewery.MashStep;
import brewery.Sensor;
import brewerycontrol.BreweryEventTopic;
import brewerycontrol.job.MashTimerJob;
import brewerycontrol.job.SensorEventHandler;

/**
 * 
 * @author nguba_000
 * 
 */
public class MashPart {
	@Inject
	UISynchronize sync;
	@Inject
	private CommPort serialPort;

	GaugeFigure gaugeFigure;
	CircularBufferDataProvider provider;
	private Table table;
	MashTimerJob timerJob;
	final Calendar calendar = Calendar.getInstance();
	@Inject
	private Logger logger;
	private CLabel timerLabel;
	private CheckboxTableViewer mashSteps;
	@Inject
	IEventBroker broker;

	@Inject
	public MashPart() {

	}

	/**
	 * @return the broker
	 */
	public IEventBroker getBroker() {
		return broker;
	}

	/**
	 * @return the calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}

	/**
	 * @return the gaugeFigure
	 */
	public GaugeFigure getGaugeFigure() {
		return gaugeFigure;
	}

	/**
	 * @return the mashSteps
	 */
	public CheckboxTableViewer getMashSteps() {
		return mashSteps;
	}

	/**
	 * @return the provider
	 */
	public CircularBufferDataProvider getProvider() {
		return provider;
	}

	/**
	 * @return the serialPort
	 */
	public CommPort getSerialPort() {
		return serialPort;
	}

	/**
	 * @return the sync
	 */
	public UISynchronize getSync() {
		return sync;
	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @return the timerJob
	 */
	public MashTimerJob getTimerJob() {
		return timerJob;
	}

	/**
	 * @return the timerLabel
	 */
	public CLabel getTimerLabel() {
		return timerLabel;
	}

	@Inject
	@Optional
	void loadMashSchedule(
			@UIEventTopic(BreweryEventTopic.MASH_SCHEDULE) final MashSchedule schedule) {
		logger.info("Loaded mash schedule: " + schedule);
		mashSteps.setInput(schedule.getSteps());
	}

	/**
	 * listens for pin 5
	 * 
	 * @param pin
	 */
	@Inject
	@Optional
	void pinEventReceived(
			@UIEventTopic(BreweryEventTopic.SENSOR) final Sensor sensor) {
		final Job job = new SensorEventHandler(this, "sensor/mash/ui", sensor);
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

		mashSteps = CheckboxTableViewer.newCheckList(scrolledComposite,
				SWT.BORDER | SWT.FULL_SELECTION);
		table = mashSteps.getTable();
		table.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		final TableViewerColumn timeViewerColumn = new TableViewerColumn(
				mashSteps, SWT.NONE);
		timeViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(final Object element) {
				return null;
			}

			@Override
			public String getText(final Object element) {
				if (element != null) {
					final MashStep step = (MashStep) element;
					return String.valueOf(step.getPause());
				} else {
					return "";
				}
			}
		});
		final TableColumn timeColumn = timeViewerColumn.getColumn();
		timeColumn.setAlignment(SWT.CENTER);
		timeColumn.setMoveable(true);
		timeColumn.setWidth(45);
		timeColumn.setText("Pause");

		final TableViewerColumn tempViewerColumn = new TableViewerColumn(
				mashSteps, SWT.NONE);
		tempViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(final Object element) {
				return null;
			}

			@Override
			public String getText(final Object element) {
				if (element != null) {
					final MashStep step = (MashStep) element;
					return String.valueOf(step.getTemperature()) + "C";
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
			public Image getImage(final Object element) {
				return null;
			}

			@Override
			public String getText(final Object element) {
				if (element != null) {
					final MashStep step = (MashStep) element;
					return step.getDescription();
				} else {
					return "";
				}
			}
		});
		final TableColumn nameColumn = nameViewerColumn.getColumn();
		nameColumn.setMoveable(true);
		nameColumn.setWidth(120);
		nameColumn.setText("Description");
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
		final GridData gd_progressBar = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		gd_progressBar.heightHint = 23;
		progressBar.setLayoutData(gd_progressBar);

		timerLabel = new CLabel(statusBar, SWT.BORDER | SWT.SHADOW_IN
				| SWT.SHADOW_OUT | SWT.CENTER);
		timerLabel.setFont(SWTResourceManager.getFont("Lucida Sans Typewriter",
				11, SWT.NORMAL));
		timerLabel.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		timerLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		final GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblNewLabel.widthHint = 77;
		timerLabel.setLayoutData(gd_lblNewLabel);
		timerLabel.setText("00:00:00");
		lws.setContents(gaugeFigure);

		timerJob = new MashTimerJob(this);
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