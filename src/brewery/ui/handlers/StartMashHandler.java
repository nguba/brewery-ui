/**
 * 
 */
package brewery.ui.handlers;

import javax.inject.Inject;

import org.eclipse.core.commands.IObjectWithState;
import org.eclipse.core.commands.State;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Shell;

import brewery.ui.BreweryEventTopic;
import brewery.ui.parts.MashPartCommand;

/**
 * @author nguba_000
 * 
 */
public class StartMashHandler implements IObjectWithState {
	@Inject
	IEventBroker eventBroker;

	@Execute
	public void execute(final IWorkbench workbench, final Shell shell) {
		eventBroker.send(BreweryEventTopic.MASH_COMMAND, MashPartCommand.START);
	}
	
	@CanExecute
	public boolean canExecute(final EPartService partService) {
		return true;
	}

	@Override
	public void addState(String id, State state) {
		System.out.println(state);
		
	}

	@Override
	public State getState(String stateId) {
		System.out.println(stateId);
		return null;
	}

	@Override
	public String[] getStateIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeState(String stateId) {
		// TODO Auto-generated method stub
		
	}
}
