package brewerycontrol.handlers;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.Dialog;

import brewerycontrol.AddYeastDialog;

public class AddYeastHandler {
	@Execute
	public void execute(final IEclipseContext context,
			final IWorkbench workbench) {
		final Dialog dialog = ContextInjectionFactory.make(
				AddYeastDialog.class, context);
		dialog.create();
		dialog.open();
	}

}