package com.shivajivarma.brs.controller;

import com.shivajivarma.brs.ui.BannerViewPanel;
import com.shivajivarma.brs.ui.CancelTabView;
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
    private Controller loginController, registrationController, passengerController, homeTabsController;

    public MasterController() {
    }
    
    public MasterController(MasterView masterView) {
    	this.masterView = masterView;
    	this.bannerView = new BannerViewPanel();
    }
    
      
    public void control(){
    	this.applicationControl(new PassengerController());
    }
    
    public void loginControl(){
    	View loginForm = new LoginPanelView();
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(loginForm, "center");
    	
    	loginController = new LoginController(loginForm);
    	loginController.control(this);
    }
    
    public void registrationControl(){
    	View registrationPanelView = new RegistrationPanelView();
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(registrationPanelView, "center");
    	
    	registrationController = new RegistrationController(registrationPanelView);
    	registrationController.control(this);
    }
    
    public void applicationControl(Controller passengerController){
    	this.passengerController = passengerController;
    	HomeTabsPanelView homeTabs = new HomeTabsPanelView();
    	CancelTabView cancelTab = new CancelTabView();
    	
    	homeTabs.insertTab(cancelTab, "Cancel ticket");
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(homeTabs, "center");
    	
    	homeTabsController = new HomeTabsController(homeTabs);
    	homeTabsController.control(this);
    }

    public void _load(){        
           
    }
    
}