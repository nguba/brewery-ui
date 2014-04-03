package brewery.ui.dialog;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

import brewery.impl.ArduinoControllerImpl;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TunePIDControllerDialog extends TitleAreaDialog {
	private Spinner kP;
	private Spinner kI;
	private Spinner kD;
	@Inject
	private ArduinoControllerImpl controller;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	@Inject
	public TunePIDControllerDialog(
			@Named(IServiceConstants.ACTIVE_SHELL) final Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Use this tool to tune the PID controller for the mash tun");
		setTitle("PID Controller");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Group grpP = new Group(container, SWT.NONE);
		grpP.setLayout(new GridLayout(1, false));
		GridData gd_grpP = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpP.widthHint = 144;
		grpP.setLayoutData(gd_grpP);
		grpP.setText("Potential");

		kP = new Spinner(grpP, SWT.BORDER);
		kP.setMaximum(100000);
		kP.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));

		Group grpI = new Group(container, SWT.NONE);
		grpI.setLayout(new GridLayout(1, false));
		GridData gd_grpI = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpI.widthHint = 140;
		grpI.setLayoutData(gd_grpI);
		grpI.setText("Integral");

		kI = new Spinner(grpI, SWT.BORDER);
		kI.setMaximum(100000);
		kI.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));

		Group grpD = new Group(container, SWT.NONE);
		GridData gd_grpD = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpD.widthHint = 151;
		grpD.setLayoutData(gd_grpD);
		grpD.setText("Differential");
		grpD.setLayout(new GridLayout(2, false));

		kD = new Spinner(grpD, SWT.BORDER);
		kD.setMaximum(100000);
		kD.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 2, 2));

		return area;
	}

	
	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.FINISH_ID, "Apply", true);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					controller.sendTuneCommand(kP.getSelection(), kI.getSelection(), kD.getSelection());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.CLOSE_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	public Spinner getKP() {
		return kP;
	}

	public Spinner getKI() {
		return kI;
	}

	public Spinner getKD() {
		return kD;
	}
}
