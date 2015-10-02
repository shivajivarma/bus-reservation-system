package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import com.shivajivarma.brs.model.service.PassengerService;
import com.shivajivarma.brs.ui.CancellationTabView;
import com.shivajivarma.brs.ui.HomeTabsPanelView;
import com.shivajivarma.brs.ui.ReservationHistoryTabView;
import com.shivajivarma.brs.ui.View;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class HomeTabsMediator implements Controller{
	
	private HomeTabsMediator _this;
	
	private HomeTabsPanelView homeTabs;
	private CancellationController cancellationController;
	private ReservationHistoryController historyTabController;
	private PassengerService passengerService;
	
    public HomeTabsMediator(View homeTabs) {
    	_this = this;
    	this.homeTabs = (HomeTabsPanelView) homeTabs;
    }
    
    public void control(Controller parentController){
    	MasterController masterController = (MasterController) parentController;
    	passengerService = (PassengerService) masterController.getPassengerService();
    	
    	View cancelTab = new CancellationTabView();
    	View historyTab = new ReservationHistoryTabView();
    	
    	homeTabs.insertTab(cancelTab, "Cancel ticket");
    	homeTabs.insertTab(historyTab, "History");
    	homeTabs.setWelcome(passengerService.getModel().getName());
    	
    	cancellationController = new CancellationController(cancelTab);
    	cancellationController.control(this);
    	
    	historyTabController = new ReservationHistoryController(historyTab);
    	historyTabController.control(this);
    	
    	/**
		 *  On clicking logout button, control goes back login form.
		 */
    	homeTabs.getLogoutButton().addActionListener(new ActionAdapter() {
    		
    		@Override
			public void actionPerformed(ActionEvent ae) {
				masterController.loginControl();
			}
		});
    	
    	homeTabs.getTabs().addChangeListener(new ChangeAdapter() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				_this.updateTabs();
			}
		});
    	
    }
    
    public PassengerService getPassengerService() {
		return passengerService;
	}
    
    public void updateTabs(){
    	historyTabController.populateReservationHistoryTable();
    }
        
}