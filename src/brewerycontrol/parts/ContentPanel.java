package brewerycontrol.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ContentPanel extends Composite {
	private final Text text;
	private final Combo yeastCombo;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ContentPanel(Composite parent, int style) {
		super(parent, style);
		final GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.marginLeft = 2;
		gridLayout.marginTop = 2;
		gridLayout.marginRight = 2;
		gridLayout.marginBottom = 2;
		setLayout(gridLayout);

		final Label lblContent = new Label(this, SWT.NONE);
		lblContent.setText("Content");

		text = new Text(this, SWT.BORDER);
		final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_text.widthHint = 263;
		text.setLayoutData(gd_text);

		final Label lblDate = new Label(this, SWT.NONE);
		lblDate.setText("Date");

		new DateTime(this, SWT.BORDER);

		final Label lblYeast = new Label(this, SWT.NONE);
		lblYeast.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		lblYeast.setText("Yeast");

		yeastCombo = new Combo(this, SWT.READ_ONLY);

		final GridData gd_yeastCombo = new GridData(SWT.FILL, SWT.CENTER,
				false, false, 3, 1);
		gd_yeastCombo.widthHint = 275;
		yeastCombo.setLayoutData(gd_yeastCombo);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Combo getYeastCombo() {
		return yeastCombo;
	}
}
