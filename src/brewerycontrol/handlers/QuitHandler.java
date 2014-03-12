/*******************************************************************************
 * Copyright (c) 2010 - 2013 IBM Corporation and others.
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

import gnu.io.CommPort;
import gnu.io.SerialPort;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author nguba
 *
 */
public class QuitHandler {
	@Inject
	CommPort port;

	/**
	 * 
	 * @param workbench
	 * @param shell
	 */
	@Execute
	public void execute(final IWorkbench workbench, final Shell shell) {
		if (MessageDialog.openConfirm(shell, "Confirmation",
				"Do you want to exit?")) {
			final SerialPort serialPort = (SerialPort) port;
			serialPort.notifyOnDataAvailable(false);
			try {
				serialPort.getOutputStream().close();
				serialPort.getInputStream().close();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			serialPort.removeEventListener();
			port.close();
			workbench.close();
		}
	}
}
