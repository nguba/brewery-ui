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
package brewerycontrol.handlers;

import java.io.File;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import brewery.BreweryFactory;
import brewery.MashSchedule;
import brewerycontrol.BreweryEventTopic;

/**
 * 
 * @author nguba
 * 
 */
public class OpenHandler {

	@Inject
	private IEventBroker eventBroker;

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
		System.out.println(uri);
		Resource resource = resSet.createResource(uri);

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
			eventBroker.send(BreweryEventTopic.MASH_SCHEDULE, schedule);
		}
	}
}
