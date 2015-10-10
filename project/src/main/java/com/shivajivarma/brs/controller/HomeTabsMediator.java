package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import com.shivajivarma.brs.model.service.PassengerService;
import com.shivajivarma.brs.ui.CancellationTabView;
import com.shivajivarma.brs.ui.HomeTabsPanelView;
import com.shivajivarma.brs.ui.ReservationHistoryTabView;
import com.shivajivarma.brs.ui.ReservationTabView;
import com.shivajivarma.brs.ui.View;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class HomeTabsMediator implements Controller{
	
	private HomeTabsMediator _this;
	private MasterController masterController;
	
	private HomeTabsPanelView homeTabs;
	private CancellationController cancellationController;
	private ReservationHistoryController historyTabController;
	private ReservationController reservationController;
	private PassengerService passengerService;
	
    public HomeTabsMediator(View homeTabs) {
    	_this = this;
    	this.homeTabs = (HomeTabsPanelView) homeTabs;
    }
    
    public void control(Controller parentController){
    	masterController = (MasterController) parentController;
    	passengerService = (PassengerService) masterController.getPassengerService();
    	
    	View reservationTab = new ReservationTabView();
    	View cancelTab = new CancellationTabView();
    	View historyTab = new ReservationHistoryTabView();
    	
    	homeTabs.insertTab(reservationTab, "Reservation ");
    	homeTabs.insertTab(cancelTab, "Cancel ticket ");
    	homeTabs.insertTab(historyTab, "History ");
    	homeTabs.setWelcome(passengerService.getModel().getName());
    	
    	
    	/*
		 * Initializing elements and setting styles.
		 */
		/*try {
			reservationPanel = new ReservationPanel(mainFrame);
		} catch (DBConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    	
    	reservationController = new ReservationController(reservationTab);
    	reservationController.control(this);
    	
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
    
    public MasterController getMasterController() {
		return masterController;
	}

	public PassengerService getPassengerService() {
		return passengerService;
	}
    
    public void updateTabs(){
    	historyTabController.populateReservationHistoryTable();
    }
        
}