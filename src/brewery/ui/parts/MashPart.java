package brewery.ui.parts;

import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.nebula.visualization.widgets.figures.GaugeFigure;
import org.eclipse.nebula.visualization.xygraph.dataprovider.CircularBufferDataProvider;
import org.eclipse.nebula.visualization.xygraph.dataprovider.CircularBufferDataProvider.PlotMode;
import org.eclipse.nebula.visualization.xygraph.dataprovider.CircularBufferDataProvider.UpdateMode;
import org.eclipse.nebula.visualization.xygraph.figures.ToolbarArmedXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.BaseLine;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.nebula.visualization.xygraph.linearscale.Range;
import org.eclipse.nebula.visualization.xygraph.util.XYGraphMediaFactory;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import brewery.MashSchedule;
import brewery.MashStep;
import brewery.Sensor;
import brewery.SensorReply;
import brewery.impl.ArduinoControllerImpl;
import brewery.ui.BreweryEventTopic;
import brewery.ui.dialog.EditMashStepDialog;
import brewery.ui.job.MashTimerJob;
import brewery.ui.job.SensorEventHandler;
import brewery.ui.job.TimerEventListener;

/**
 * 
 * @author nguba_000
 * 
 */
public class MashPart implements TimerEventListener {
	@Inject
	UISynchronize sync;
	@Inject
	@Optional
	private ArduinoControllerImpl controller;
	@Inject
	@Preference(nodePath = "brewery.prefs.serial")
	private IEclipsePreferences serialPrefs;
	@Inject
	@Preference(nodePath = "brewery.prefs.main")
	private IEclipsePreferences mainPrefs;
	@Inject
	private Shell shell;
	@Inject
	ECommandService commandService;

	GaugeFigure gaugeFigure;
	CircularBufferDataProvider provider;
	private Table table;
	MashTimerJob timerJob;

	@Inject
	private Logger logger;
	private CLabel timerLabel;
	private CheckboxTableViewer mashScheduleTable;
	@Inject
	IEventBroker broker;
	private Combo selectedSchedule;
	private MashSchedule schedule;
	private ProgressBar progressBar;
	private CLabel statusLabel;
	@Inject
	IEclipseContext context;
	private int currentProgress;

	@Inject
	private MDirtyable dirty;
	private XYGraph mashGraph;

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
	 * listens for pin 5 TODO decouple this from the main mash scheduler so we
	 * can get readings on demand
	 * 
	 * @param pin
	 */
	@Inject
	@Optional
	void pinEventReceived(
			@UIEventTopic(BreweryEventTopic.SENSOR) final Sensor sensor) {
		final Job sensorJob = new SensorEventHandler(this, "sensor/mash/ui",
				sensor);
		sensorJob.schedule();
	}

	@PostConstruct
	public void postConstruct(final Composite parent) {

		parent.setLayout(new FillLayout(SWT.HORIZONTAL));

		final Composite composite = new Composite(parent, SWT.NONE);
		final GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.marginTop = 5;
		gl_composite.marginRight = 5;
		gl_composite.marginLeft = 5;
		gl_composite.marginBottom = 5;
		composite.setLayout(gl_composite);
		mashGraph = new XYGraph();
		
		ToolbarArmedXYGraph toolbarArmedXYGraph = new ToolbarArmedXYGraph(mashGraph);
		// xyGraph.setTitle("History");
		mashGraph.primaryYAxis.setRange(new Range(0, 100));
		mashGraph.primaryYAxis.setShowMajorGrid(true);
		mashGraph.primaryYAxis.setShowMinorGrid(true);
		mashGraph.primaryYAxis.setAutoFormat(true);
		mashGraph.primaryYAxis.setAutoScale(false);
		mashGraph.primaryYAxis.setTitle("Temperature");
		
		mashGraph.primaryXAxis.setRange(new Range(System.currentTimeMillis(),  System.currentTimeMillis()  + (60000 * 60 * 5)));
		mashGraph.primaryXAxis.setShowMajorGrid(true);
		mashGraph.primaryXAxis.setTitle("Time");
		mashGraph.primaryXAxis.setDateEnabled(true);
		mashGraph.primaryXAxis.setAutoScale(true);
		mashGraph.primaryXAxis.setAutoScaleThreshold(1);
		//mashGraph.primaryXAxis.setFormatPattern("k:m:s");
		mashGraph.primaryXAxis.setTimeUnit(Calendar.MINUTE);
		mashGraph.primaryXAxis.setAutoFormat(true);
		mashGraph.setShowLegend(false);
		
		provider = new CircularBufferDataProvider(false);
		provider.setPlotMode(PlotMode.LAST_N);
		provider.setChronological(true);
		provider.setUpdateMode(UpdateMode.X_AND_Y);
		provider.setBufferSize(320 * 60);
		
		final Trace trace = new Trace("Temp Graph", mashGraph.primaryXAxis,
				mashGraph.primaryYAxis, provider);
		trace.setBaseLine(BaseLine.POSITIVE_INFINITY);
		trace.setAntiAliasing(true);
		//provider.setChronological(true);
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

		final SashForm sashForm_1 = new SashForm(composite, SWT.NONE);
		sashForm_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				1, 1));

		final Composite composite_1 = new Composite(sashForm_1, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));

		final SashForm sashForm = new SashForm(composite_1, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));

		final Group grpTunTemperature = new Group(sashForm, SWT.NONE);
		grpTunTemperature.setText("Tun Temperature");
		grpTunTemperature.setLayout(new GridLayout(1, false));

		final Canvas guageCanvas = new Canvas(grpTunTemperature, SWT.NO_FOCUS);
		final GridData gd_guageCanvas = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd_guageCanvas.heightHint = 260;
		gd_guageCanvas.widthHint = 220;
		guageCanvas.setLayoutData(gd_guageCanvas);
		final GridLayout gl_guageCanvas = new GridLayout(1, true);
		gl_guageCanvas.marginTop = 5;
		gl_guageCanvas.marginRight = 5;
		gl_guageCanvas.marginLeft = 5;
		gl_guageCanvas.marginBottom = 5;
		guageCanvas.setLayout(gl_guageCanvas);
		final LightweightSystem lws = new LightweightSystem(guageCanvas);

		final Group grpSchedule = new Group(sashForm, SWT.NONE);
		grpSchedule.setText("Schedule");
		grpSchedule.setLayout(new GridLayout(1, false));

		selectedSchedule = new Combo(grpSchedule, SWT.READ_ONLY);
		selectedSchedule.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		final ScrolledComposite scrolledComposite = new ScrolledComposite(
				grpSchedule, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		final GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL,
				false, true, 1, 1);
		gd_scrolledComposite.widthHint = 212;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		mashScheduleTable = CheckboxTableViewer.newCheckList(scrolledComposite,
				SWT.BORDER | SWT.FULL_SELECTION);
		mashScheduleTable.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(final DoubleClickEvent event) {
				final EditMashStepDialog dialog = ContextInjectionFactory.make(
						EditMashStepDialog.class, context);
				dialog.create();
				dialog.setBlockOnOpen(true);
				final StructuredSelection s = (StructuredSelection) event
						.getSelection();
				final MashStep step = (MashStep) s.getFirstElement();
				dialog.getDescription().setText(step.getDescription());
				final long pause = step.getPause();
				final int duration = (int) (pause / 60000);
				dialog.getDuration().setSelection(duration);
				dialog.getTemperature().setSelection(
						(int) step.getTemperature());
				dialog.open();
			}
		});
		table = mashScheduleTable.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
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
					return String.valueOf(step.getPause() / 60 / 1000) + " min";
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
					return String.valueOf((int) step.getTemperature()) + " C";
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
		sashForm.setWeights(new int[] { 287, 247 });

		final Group grpHistory = new Group(sashForm_1, SWT.NONE);
		grpHistory.setText("History");
		grpHistory.setLayout(new GridLayout(1, false));

		final Canvas historyCanvas = new Canvas(grpHistory, SWT.NONE);
		historyCanvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 2));
		final LightweightSystem historyLWS = new LightweightSystem(
				historyCanvas);
		sashForm_1.setWeights(new int[] { 266, 511 });
		historyLWS.setContents(toolbarArmedXYGraph);

		final Composite statusBar = new Composite(composite, SWT.BORDER
				| SWT.NO_FOCUS);
		final GridLayout gl_statusBar = new GridLayout(2, false);
		gl_statusBar.marginTop = 2;
		gl_statusBar.marginBottom = 2;
		gl_statusBar.marginHeight = 1;
		gl_statusBar.verticalSpacing = 1;
		gl_statusBar.marginWidth = 1;
		statusBar.setLayout(gl_statusBar);
		final GridData gd_statusBar = new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1);
		gd_statusBar.widthHint = 459;
		gd_statusBar.heightHint = 27;
		statusBar.setLayoutData(gd_statusBar);

		final SashForm sashForm_2 = new SashForm(statusBar, SWT.NONE);
		final GridData gd_sashForm_2 = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_sashForm_2.heightHint = 21;
		gd_sashForm_2.widthHint = 597;
		sashForm_2.setLayoutData(gd_sashForm_2);

		progressBar = new ProgressBar(sashForm_2, SWT.NONE);

		statusLabel = new CLabel(sashForm_2, SWT.BORDER);
		statusLabel.setTopMargin(2);
		sashForm_2.setWeights(new int[] { 506, 200 });

		timerLabel = new CLabel(statusBar, SWT.BORDER | SWT.SHADOW_IN
				| SWT.SHADOW_OUT | SWT.CENTER);
		timerLabel.setFont(SWTResourceManager.getFont("Lucida Sans Typewriter",
				11, SWT.NORMAL));
		timerLabel.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		timerLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		timerLabel.setText("00:00:00");
		lws.setContents(gaugeFigure);

		final String name = serialPrefs.get("port", null);
		if (name != null) {
			statusLabel.setText(name);
		}
		final String fileName = mainPrefs.get("schedule", null);
		if (fileName != null) {
			final File f = new File(fileName);
			final ResourceSet resSet = new ResourceSetImpl();
			final URI uri = URI.createFileURI(fileName);
			Resource resource = resSet.createResource(uri);
			if (f.exists()) {
				resource = resSet.getResource(uri, true);
				final EObject eObject = resource.getContents().get(0);
				if (eObject != null) {
					schedule = (MashSchedule) eObject;
				}
			}
			if (schedule != null) {
				broker.send(BreweryEventTopic.MASH_SCHEDULE, schedule);
			}
		}
	}

	/**
	 * 
	 * @param command
	 */
	@Inject
	@Optional
	void processMashSetpointNew(
			@UIEventTopic(BreweryEventTopic.MASH_SETPOINT_NEW) final MashStep step) {
		progressBar.setSelection(++currentProgress);
	}

	/**
	 * 
	 * @param command
	 */
	@Inject
	@Optional
	void processMashSetpointReached(
			@UIEventTopic(BreweryEventTopic.MASH_SETPOINT_REACHED) final MashStep step) {
		progressBar.setSelection(++currentProgress);
	}

	/**
	 * 
	 * @param command
	 */
	@Inject
	@Optional
	void processMashStepComplete(
			@UIEventTopic(BreweryEventTopic.MASH_STEP_COMPLETE) final MashStep step) {
		int index = schedule.complete(step);
		final TableItem item = mashScheduleTable.getTable().getItem(index);
		item.setChecked(true);
		progressBar.setSelection(++currentProgress);
		if (schedule.hasNext()) {
			mashScheduleTable.setSelection(new StructuredSelection(
					mashScheduleTable.getElementAt(++index)), true);
		}
	}

	/**
	 * 
	 * @param command
	 */
	@Inject
	@Optional
	void processMashStepModified(
			@UIEventTopic(BreweryEventTopic.MASH_STEP_MODIFIED) final MashStep step) {
		final StructuredSelection s = (StructuredSelection) mashScheduleTable
				.getSelection();
		final MashStep selected = (MashStep) s.getFirstElement();
		final int idx = schedule.getSteps().indexOf(selected);
		schedule.getSteps().set(idx, step);
		mashScheduleTable.setInput(schedule.getSteps());
		dirty.setDirty(true);
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
			final String serialPortName = serialPrefs.get("port", null);
			try {
				controller.start(serialPortName);
				if (timerJob != null) {
					final boolean result = MessageDialog.openConfirm(shell,
							"Mash already in progress",
							"Abort the current Mash program?");
					if (result) {
						timerJob.stop();
						gaugeFigure.setValue(0);
						timerJob = null;
					}
				} else {
					timerLabel.setText("00:00:00");
					mashGraph.primaryXAxis.setRange(new Range(System.currentTimeMillis(),  System.currentTimeMillis()  + (60000 * 60 * 5)));
					timerJob = new MashTimerJob(this, controller);
					ContextInjectionFactory.inject(timerJob, context);
					provider.clearTrace();
					if (timerJob != null) {
						timerJob.start(schedule);
					}
					logger.info("START Mash");
					currentProgress = 0;
					progressBar.setSelection(currentProgress);
					progressBar.setMaximum(schedule.getSteps().size() * 3);
					mashScheduleTable.setSelection(new StructuredSelection(
							mashScheduleTable.getElementAt(0)), true);
					mashScheduleTable.setAllChecked(false);
				}
			} catch (final PortInUseException e) {
				MessageDialog
						.openError(
								shell,
								"Port in use",
								serialPortName
										+ " is used by another application, try selecting another one.");
			} catch (final UnsupportedCommOperationException e) {
				MessageDialog.openError(shell, "Error configuring port",
						e.getMessage());
			} catch (final IOException e) {
				MessageDialog.openError(shell, "Error", e.getMessage());
			}
			break;
		case RUNNING:
			// TODO this doesn't work. use a boolean instead
			break;
		case STOP:
			logger.info("STOP Mash");
			gaugeFigure.setValue(0);
			if (timerJob != null) {
				timerJob.stop();
			}
			timerJob = null;
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
		System.out.println("SAVING");
		dirty.setDirty(false);
	}

	@Override
	public void timeUpdatedEvent(final String string) {
		if (timerLabel.isDisposed() == false) {
			timerLabel.setText(string);
		}
	}

	/**
	 * updates the status label with the message
	 * 
	 * @param message
	 */
	@Inject
	@Optional
	void updateStatus(
			@UIEventTopic(BreweryEventTopic.MASH_STATUS) final String message) {
		statusLabel.setText(message);
	}
	
	/**
	 * 
	 * @param command
	 */
	@Inject
	@Optional
	void processSensorReply(@UIEventTopic(BreweryEventTopic.SENSOR) final SensorReply reply) {
		provider.setCurrentYData(reply.getTemperature());
		provider.setCurrentYDataTimestamp(System.currentTimeMillis());
		//provider.setCurrentXData(System.currentTimeMillis());
	}
}