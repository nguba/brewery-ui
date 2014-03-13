package brewery.ui.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;

import brewery.ui.BreweryEventTopic;
import brewery.ui.parts.MashPartCommand;

/**
 * 
 * @author nguba_000
 * 
 */
public class StopMashHandler {
	@Inject
	private IEventBroker broker;

	/**
	 * 
	 */
	@Execute
	public void execute() {
		broker.send(BreweryEventTopic.MASH_COMMAND, MashPartCommand.STOP);
	}

}