package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;

import com.shivajivarma.brs.ui.HomeTabsPanelView;
import com.shivajivarma.brs.ui.View;
import com.shivajivarma.brs.utility.EventAdapters.ActionAdapter;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class HomeTabsController implements Controller{
	
	private HomeTabsPanelView homeTabs;
	
    public HomeTabsController(View homeTabs) {
    	this.homeTabs = (HomeTabsPanelView) homeTabs;
    }
    
    public void control(MasterController masterController){
    	/**
		 *  On clicking logout button, control goes back login form.
		 */
    	homeTabs.getLogoutButton().addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				masterController.loginControl();
			}
			
		});
    	
    }
        
}