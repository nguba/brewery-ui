package brewery.ui.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.csstudio.swt.widgets.figures.ThermometerFigure;
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
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import brewery.Sensor;
import brewery.Yeast;
import brewery.impl.InventoryImpl;

/**
 * 
 * @author nguba_000
 * 
 */
public class FermentationPart {
	private ThermometerFigure thermo;
	@Inject
	private InventoryImpl inventory;

	@Inject
	UISynchronize sync;

	private CircularBufferDataProvider provider;
	long xAxis = 0;

	public FermentationPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(final Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		final ContentPanel contentPanel = new ContentPanel(parent, SWT.NONE);
		contentPanel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));

		final Canvas canvas = new Canvas(parent, SWT.NONE);
		final GridData gd_canvas = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_canvas.verticalIndent = 5;
		gd_canvas.horizontalIndent = 5;
		gd_canvas.widthHint = 309;
		gd_canvas.heightHint = 208;
		canvas.setLayoutData(gd_canvas);

		final XYGraph xyGraph = new XYGraph();
		// xyGraph.setTitle("History");
		xyGraph.primaryYAxis.setRange(new Range(0, 30));
		xyGraph.primaryYAxis.setShowMajorGrid(true);
		// xyGraph.primaryYAxis.setShowMinorGrid(true);

		provider = new CircularBufferDataProvider(false);
		provider.setPlotMode(PlotMode.N_STOP);
		provider.setBufferSize(200);

		final Trace trace = new Trace("Temp Graph", xyGraph.primaryXAxis,
				xyGraph.primaryYAxis, provider);
		trace.setBaseLine(BaseLine.ZERO);
		trace.setAntiAliasing(true);
		xyGraph.addTrace(trace);

		final LightweightSystem lws = new LightweightSystem(canvas);
		lws.setContents(xyGraph);

		final Canvas canvas_1 = new Canvas(parent, SWT.NONE);
		final GridData gd_canvas_1 = new GridData(SWT.FILL, SWT.TOP, false,
				false, 1, 1);
		gd_canvas_1.widthHint = 123;
		gd_canvas_1.heightHint = 210;
		canvas_1.setLayoutData(gd_canvas_1);
		final LightweightSystem lws_1 = new LightweightSystem(canvas_1);

		thermo = new ThermometerFigure();
		thermo.setRange(0, 30);
		thermo.setLoLevel(10);
		// thermo.setLoloLevel(8);
		// thermo.setHihiLevel(25);
		thermo.setHiLevel(23);
		thermo.setMajorTickMarkStepHint(10);
		thermo.setEffect3D(true);
		thermo.setShowHihi(false);
		thermo.setShowLolo(false);

		thermo.setValue(0);
		lws_1.setContents(thermo);

		for (final Yeast y : inventory.getYeast()) {
			contentPanel.getYeastCombo().add(y.getName());
		}
		contentPanel.getYeastCombo().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						final String name = contentPanel.getYeastCombo()
								.getText();
						Yeast yeast = null;
						for (final Yeast y : inventory.getYeast()) {
							if (name.equals(y.getName())) {
								yeast = y;
							}
						}
						// System.out.println(yeast);
						final int high = yeast.getRange().getHigh();
						final int low = yeast.getRange().getLow();
						final Job job = new Job("set temperature") {
							@Override
							protected IStatus run(final IProgressMonitor monitor) {
								sync.asyncExec(new Runnable() {

									@Override
									public void run() {
										thermo.setHiLevel(high);
										thermo.setLoLevel(low);
										final Range r = new Range(low - 5,
												high + 5);
										thermo.setRange(r);
										thermo.repaint();
									}
								});
								return Status.OK_STATUS;
							}
						};
						job.schedule();
					}
				});
	}

	@PreDestroy
	public void dispose() {
	}

	/**
	 * listens for pin 5
	 * 
	 * @param sensor
	 */
	@Inject
	@Optional
	void pinEventReceived(@UIEventTopic("arduino/pin/5") final Sensor sensor) {

		final Job job = new Job("arduino/pin/5/updater") {

			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				sync.asyncExec(new Runnable() {

					@Override
					public void run() {
						final double temperature = (sensor.getValue() * 0.004882814 - 0.5) * 100;
						final double value = temperature;
						thermo.setValue(value);

						if (value > thermo.getHiLevel()
								|| value < thermo.getLoLevel()) {
							thermo.setFillColor(XYGraphMediaFactory
									.getInstance().getColor(
											XYGraphMediaFactory.COLOR_RED));
						} else {
							thermo.setFillColor(XYGraphMediaFactory
									.getInstance().getColor(
											XYGraphMediaFactory.COLOR_GREEN));
						}
						provider.setCurrentYData(value);
						provider.setCurrentXData(xAxis++);
					}
				});
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	@Focus
	public void setFocus() {
	}
}
