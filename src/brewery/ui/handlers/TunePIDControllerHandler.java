package brewery.ui.handlers;

import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.IWorkbench;

import brewery.PID;
import brewery.impl.ArduinoControllerImpl;
import brewery.ui.BreweryEventTopic;
import brewery.ui.dialog.TunePIDControllerDialog;

/**
 * 
 * @author nguba
 * 
 */
public class TunePIDControllerHandler {
	@Inject
	private ArduinoControllerImpl controller;
	
	private TunePIDControllerDialog dialog;
	@Inject
	@Preference(nodePath = "brewery.prefs.serial")
	private IEclipsePreferences serialPrefs;
	private PID reply;
	
	@CanExecute
	public boolean load() throws Exception {
		controller.start(serialPrefs.get("port", null));
		controller.sendPIDCommand();
		return reply != null;
	}

	/**
	 * 
	 * @param context
	 * @param workbench
	 * @throws IOException
	 * @throws UnsupportedCommOperationException
	 * @throws PortInUseException
	 */
	@Execute
	public void execute(final IEclipseContext context,
			final IWorkbench workbench) throws IOException, PortInUseException,
			UnsupportedCommOperationException {
		
		dialog = (TunePIDControllerDialog) ContextInjectionFactory.make(
				TunePIDControllerDialog.class, context);
		dialog.create();
		if(reply != null) {
			dialog.getKP().setSelection(reply.getP());
			dialog.getKI().setSelection(reply.getI());
			dialog.getKD().setSelection(reply.getD());
		}
		dialog.open();
	}

	/**
	 * 
	 * @param command
	 */
	@Inject
	@Optional
	void processPIDReply(@UIEventTopic(BreweryEventTopic.PID) final PID reply) {
		this.reply = reply;
	}

}