package brewerycontrol.parts;

import gnu.io.CommPort;

import java.io.IOException;
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
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
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
	private CheckboxTableViewer mashScheduleTable;
	@Inject
	IEventBroker broker;
	private Combo selectedSchedule;
	private MashSchedule schedule;

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
	public CheckboxTableViewer getMashScheduleTable() {
		return mashScheduleTable;
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
		this.schedule = schedule;
		logger.info("Loaded mash schedule: " + schedule);
		mashScheduleTable.setInput(schedule.getSteps());
		selectedSchedule.add(schedule.getName(), 0);
		selectedSchedule.select(0);
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
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.marginTop = 5;
		gl_composite.marginRight = 5;
		gl_composite.marginLeft = 5;
		gl_composite.marginBottom = 5;
		composite.setLayout(gl_composite);

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

		SashForm sashForm_1 = new SashForm(composite, SWT.NONE);
		sashForm_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));

		Composite composite_1 = new Composite(sashForm_1, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));

		SashForm sashForm = new SashForm(composite_1, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));

		Group grpTunTemperature = new Group(sashForm, SWT.NONE);
		grpTunTemperature.setText("Tun Temperature");
		grpTunTemperature.setLayout(new GridLayout(1, false));

		final Canvas guageCanvas = new Canvas(grpTunTemperature, SWT.NO_FOCUS);
		GridData gd_guageCanvas = new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1);
		gd_guageCanvas.heightHint = 260;
		gd_guageCanvas.widthHint = 220;
		guageCanvas.setLayoutData(gd_guageCanvas);
		GridLayout gl_guageCanvas = new GridLayout(1, true);
		gl_guageCanvas.marginTop = 5;
		gl_guageCanvas.marginRight = 5;
		gl_guageCanvas.marginLeft = 5;
		gl_guageCanvas.marginBottom = 5;
		guageCanvas.setLayout(gl_guageCanvas);
		final LightweightSystem lws = new LightweightSystem(guageCanvas);

		Group grpSchedule = new Group(sashForm, SWT.NONE);
		grpSchedule.setText("Schedule");
		grpSchedule.setLayout(new GridLayout(1, false));

		selectedSchedule = new Combo(grpSchedule, SWT.READ_ONLY);
		selectedSchedule.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		final ScrolledComposite scrolledComposite = new ScrolledComposite(
				grpSchedule, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL, false,
				true, 1, 1);
		gd_scrolledComposite.widthHint = 212;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		mashScheduleTable = CheckboxTableViewer.newCheckList(scrolledComposite,
				SWT.BORDER | SWT.FULL_SELECTION);
		table = mashScheduleTable.getTable();
		table.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		final TableViewerColumn timeViewerColumn = new TableViewerColumn(
				mashScheduleTable, SWT.NONE);
		timeViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(final Object element) {
				return null;
			}

			@Override
			public String getText(final Object element) {
				if (element != null) {
					final MashStep step = (MashStep) element;
					return String.valueOf(step.getPause() / 60 / 1000 ) + " min";
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
				mashScheduleTable, SWT.NONE);
		tempViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(final Object element) {
				return null;
			}

			@Override
			public String getText(final Object element) {
				if (element != null) {
					final MashStep step = (MashStep) element;
					return String.valueOf(step.getTemperature()) + " C";
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
				mashScheduleTable, SWT.NONE);
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
		nameColumn.setWidth(113);
		nameColumn.setText("Description");
		mashScheduleTable.setContentProvider(new ArrayContentProvider());
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table
				.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		sashForm.setWeights(new int[] {287, 247});

		Group grpHistory = new Group(sashForm_1, SWT.NONE);
		grpHistory.setText("History");
		grpHistory.setLayout(new GridLayout(1, false));

		final Canvas historyCanvas = new Canvas(grpHistory, SWT.NONE);
		historyCanvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 2));
		final LightweightSystem historyLWS = new LightweightSystem(
				historyCanvas);
		sashForm_1.setWeights(new int[] {266, 511});
		historyLWS.setContents(mashGraph);

		final Composite statusBar = new Composite(composite, SWT.BORDER
				| SWT.NO_FOCUS);
		final GridLayout gl_statusBar = new GridLayout(2, false);
		gl_statusBar.marginHeight = 1;
		gl_statusBar.verticalSpacing = 1;
		gl_statusBar.marginWidth = 1;
		statusBar.setLayout(gl_statusBar);
		final GridData gd_statusBar = new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1);
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

		try {
			timerJob = new MashTimerJob(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			logger.info("PAUSE Mash");
			break;
		case START:
			logger.info("START Mash");
			provider.clearTrace();
			if (timerJob != null)
				timerJob.start(schedule);
			break;
		case STOP:
			logger.info("STOP Mash");
			gaugeFigure.setValue(0);
			if (timerJob != null)
				timerJob.stop();
			break;
		default:
			break;

		}
	}

	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * 
	 */
	@Persist
	public void save() {
	}
}