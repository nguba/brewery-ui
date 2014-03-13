package brewery.ui.handlers;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.Dialog;

import brewery.ui.dialog.TunePIDControllerDialog;

/**
 * 
 * @author nguba
 *
 */
public class TunePIDControllerHandler {
	@Execute
	public void execute(final IEclipseContext context,
			final IWorkbench workbench) {
		final Dialog dialog = ContextInjectionFactory.make(
				TunePIDControllerDialog.class, context);
		dialog.create();
		dialog.open();
	}

}