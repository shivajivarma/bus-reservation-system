package com.shivajivarma.brs;

import java.awt.EventQueue;

import com.shivajivarma.brs.controller.MasterController;
import com.shivajivarma.brs.ui.MasterView;

/**
 * The main launcher for java bus reservation system application. Creates the {@code MasterController} object.
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 * @version 2.0
 * @see MasterController
 */
public class AppLaucher {

	/**
	 * @param args
	 * Currently no arguments required to be passed to this program.
	 */
	public static void main(String[] args) {
		
		// Use the event dispatch thread for Swing components
		EventQueue.invokeLater(new Runnable() {
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				new MasterView();
			}
		});
	}

}
