/**
 * 
 */
package brewery.ui.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.swt.widgets.Shell;

import brewery.ui.BreweryEventTopic;
import brewery.ui.parts.MashPartCommand;

/**
 * @author nguba_000
 * 
 */
public class StartMashHandler {
	@Inject
	IEventBroker eventBroker;

	@Execute
	public void execute(final IWorkbench workbench, final Shell shell) {
		eventBroker.send(BreweryEventTopic.MASH_COMMAND, MashPartCommand.START);
	}
}
