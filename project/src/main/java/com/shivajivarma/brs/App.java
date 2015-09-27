package com.shivajivarma.brs;

import com.shivajivarma.brs.controller.MasterController;
import com.shivajivarma.brs.ui.MasterView;

/**
 * <h1>App</h1>
 * <p>Entry point for BRS application.</p>
 * 
 * @author Shivaji Varma (contact@shivajivarma.com)
 */
public class App {
	
	
	
	/**
	 * Main method, which initiates program to run on opening the application.
	 */
	public static void main(String[] args) {
		MasterView masterView = new MasterView();
		
		MasterController controller = new MasterController(masterView);
		controller.control();
		
	}


}
