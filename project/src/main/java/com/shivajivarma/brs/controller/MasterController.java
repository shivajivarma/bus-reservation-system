package com.shivajivarma.brs.controller;

import com.shivajivarma.brs.model.Model;
import com.shivajivarma.brs.model.services.Service;
import com.shivajivarma.brs.ui.BannerViewPanel;
import com.shivajivarma.brs.ui.CancellationTabView;
import com.shivajivarma.brs.ui.HomeTabsPanelView;
import com.shivajivarma.brs.ui.LoginPanelView;
import com.shivajivarma.brs.ui.MasterView;
import com.shivajivarma.brs.ui.RegistrationPanelView;
import com.shivajivarma.brs.ui.View;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class MasterController{
	
	private MasterView masterView;
	private View bannerView;
	private Service passengerService;
	private Model passenger;
    
	public MasterController(MasterView masterView) {
    	this.masterView = masterView;
    }
    
      
    public void control(){
    	this.bannerView = new BannerViewPanel();
    	this.loginControl();
    }
    
    public void loginControl(){
    	View loginForm = new LoginPanelView();
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(loginForm, "center");
    	
    	Controller loginController = new LoginController(loginForm);
    	loginController.control(this);
    }
    
    public void registrationControl(){
    	View registrationPanelView = new RegistrationPanelView();
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(registrationPanelView, "center");
    	
    	Controller registrationController = new RegistrationController(registrationPanelView);
    	registrationController.control(this);
    }
    
    public void applicationControl(){
    	HomeTabsPanelView homeTabs = new HomeTabsPanelView();
    	CancellationTabView cancelTab = new CancellationTabView();
    	
    	homeTabs.insertTab(cancelTab, "Cancel ticket");
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(homeTabs, "center");
    	
    	Controller homeTabsController = new HomeTabsController(homeTabs);
    	homeTabsController.control(this);
    	
    	Controller cancellationController = new CancellationController(cancelTab);
    	cancellationController.control(this);
    }
    
    public Service getPassengerService() {
		return passengerService;
	}

	public void setPassengerService(Service passengerService) {
		this.passengerService = passengerService;
	}


    
}