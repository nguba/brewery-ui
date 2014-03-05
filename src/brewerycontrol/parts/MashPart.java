package brewerycontrol.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.csstudio.swt.widgets.figures.GaugeFigure;
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
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import brewerycontrol.monitor.Pin;

/**
 * 
 * @author nguba_000
 * 
 */
public class MashPart {
	private Table table;
	
	@Inject
	private UISynchronize sync;

	private GaugeFigure gaugeFigure;
	
	@Inject
	public MashPart() {
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(11, false));
		
		CheckboxTableViewer checkboxTableViewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = checkboxTableViewer.getTable();
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 10, 1);
		gd_table.widthHint = 151;
		table.setLayoutData(gd_table);
		
		final Canvas canvas = new Canvas(parent, SWT.NONE);
		canvas.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_canvas = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_canvas.heightHint = 284;
		gd_canvas.widthHint = 208;
		canvas.setLayoutData(gd_canvas);
		final LightweightSystem lws = new LightweightSystem(canvas);
		gaugeFigure = new GaugeFigure();
		gaugeFigure.setBackgroundColor(
				XYGraphMediaFactory.getInstance().getColor(0, 0, 0));
		gaugeFigure.setForegroundColor(
				XYGraphMediaFactory.getInstance().getColor(255, 255, 255));
		
		gaugeFigure.setRange(0, 100);
		gaugeFigure.setLoLevel(30);
		//gaugeFigure.setLoloLevel(-80);
		gaugeFigure.setHiLevel(78);
		//gaugeFigure.setHihiLevel(100);
		gaugeFigure.setMajorTickMarkStepHint(50);
		gaugeFigure.setEffect3D(true);
		gaugeFigure.setShowMarkers(true);
		gaugeFigure.setValue(0);
		lws.setContents(gaugeFigure);
	}

	@Persist
	public void save() {
		// TODO Your code here
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