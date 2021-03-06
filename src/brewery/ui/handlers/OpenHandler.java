/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Lars Vogel <lars.Vogel@gmail.com> - Bug 419770
 *******************************************************************************/
package brewery.ui.handlers;

import java.io.File;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

import brewery.BreweryFactory;
import brewery.MashSchedule;
import brewery.ui.BreweryEventTopic;

/**
 * 
 * @author nguba
 * 
 */
public class OpenHandler {

	@Inject
	private IEventBroker eventBroker;
	@Inject
	private Logger logger;
	@Inject
	@Preference(nodePath = "brewery.prefs.main")
	private IEclipsePreferences prefs;
	
	/**
	 * 
	 * @param shell
	 */
	@Execute
	public void execute(final Shell shell) {
		final FileDialog dialog = new FileDialog(shell);
		dialog.setFilterExtensions(new String[] { "mash" });
		final String fileName = dialog.open();

		if (fileName == null) {
			return;
		}
		BreweryFactory.eINSTANCE.eClass();
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("mash", new XMIResourceFactoryImpl());
		final ResourceSet resSet = new ResourceSetImpl();

		final URI uri = URI.createFileURI(fileName);
		
		Resource resource = resSet.createResource(uri);
		logger.info("Open: " + uri);
		
		MashSchedule schedule = null;

		final File f = new File(fileName);
		if (f.exists()) {
			resource = resSet.getResource(uri, true);
			final EObject eObject = resource.getContents().get(0);
			if (eObject != null) {
				schedule = (MashSchedule) eObject;
			}
		}
		if (schedule != null) {
			prefs.put("schedule", uri.path());
			try {
				prefs.flush();
				logger.info("Saved prefs:  scheulde=" + prefs.get("schedule", null));
			} catch (BackingStoreException e) {
				e.printStackTrace();
			}
			eventBroker.send(BreweryEventTopic.MASH_SCHEDULE, schedule);
		}
	}
}
