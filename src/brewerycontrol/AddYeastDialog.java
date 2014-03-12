package brewerycontrol;

import java.io.IOException;
import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import brewery.BreweryFactory;
import brewery.TemperatureRange;
import brewery.TemperatureUnit;
import brewery.Yeast;
import brewery.impl.InventoryImpl;

/**
 * 
 * @author nguba
 *
 */
public class AddYeastDialog extends TitleAreaDialog {
	private Text nameText;
	private Text manufacturerText;
	private Text attenuationText;
	private Combo flocculationCombo;
	private Combo tempHighCombo;
	private Combo tempLowCombo;

	@Inject
	private InventoryImpl inventory;

	@Inject
	XMIResourceImpl resource;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	@Inject
	public AddYeastDialog(
			@Named(IServiceConstants.ACTIVE_SHELL) final Shell parentShell) {
		super(parentShell);
		setHelpAvailable(false);
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		setTitle("Add Yeast");
		setMessage("The definitions in here will be used in Fermentation control.");
		final Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(6, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Label lblName = new Label(container, SWT.RIGHT);
		lblName.setText("Name");

		nameText = new Text(container, SWT.BORDER);
		final GridData gd_nameText = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 5, 1);
		gd_nameText.widthHint = 343;
		nameText.setLayoutData(gd_nameText);

		final Label lblManufacturer = new Label(container, SWT.RIGHT);
		lblManufacturer.setText("Manufacturer");

		manufacturerText = new Text(container, SWT.BORDER);
		final GridData gd_manufacturerText = new GridData(SWT.FILL, SWT.CENTER,
				false, false, 5, 1);
		gd_manufacturerText.widthHint = 235;
		manufacturerText.setLayoutData(gd_manufacturerText);

		final Label lblAttenuation = new Label(container, SWT.RIGHT);
		lblAttenuation.setText("Attenuation");

		attenuationText = new Text(container, SWT.BORDER);
		attenuationText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		new Label(container, SWT.NONE);

		final Label lblFlocculation = new Label(container, SWT.RIGHT);
		lblFlocculation.setText("Flocculation");

		flocculationCombo = new Combo(container, SWT.READ_ONLY);
		flocculationCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		flocculationCombo.setVisibleItemCount(3);
		flocculationCombo.setItems(new String[] { "Low", "Medium", "High" });
		flocculationCombo.select(1);

		final Group group = new Group(container, SWT.NONE);
		final GridData gd_group = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 6, 1);
		gd_group.widthHint = 432;
		group.setLayoutData(gd_group);
		group.setText("Fermentation Temperature");
		group.setLayout(new GridLayout(4, false));

		final Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label.setText("Low");

		tempHighCombo = new Combo(group, SWT.READ_ONLY);
		tempHighCombo.setItems(new String[] { "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24" });
		tempHighCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		tempHighCombo.select(11);

		final Label label_1 = new Label(group, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label_1.setText("High");

		tempLowCombo = new Combo(group, SWT.READ_ONLY);
		tempLowCombo.setItems(new String[] { "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24" });
		tempLowCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		tempLowCombo.select(14);

		return area;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		save();
		super.okPressed();
	}

	/**
	 * 
	 */
	protected void save() {
		final Yeast yeast = BreweryFactory.eINSTANCE.createYeast();
		yeast.setAttenuation(attenuationText.getText());
		yeast.setFlocculation(flocculationCombo.getText());
		yeast.setName(nameText.getText());
		yeast.setManufacturer(manufacturerText.getText());
		final TemperatureRange range = BreweryFactory.eINSTANCE
				.createTemperatureRange();
		range.setHigh(Integer.parseInt(tempHighCombo.getText()));
		range.setLow(Integer.parseInt(tempLowCombo.getText()));
		range.setUnit(TemperatureUnit.CELSIUS);
		yeast.setRange(range);
		inventory.getYeast().add(yeast);

		// Get the first model element and cast it to the right type, in
		// my
		// example everything is hierarchical included in this first
		// node
		resource.getContents().add(inventory);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (final IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
