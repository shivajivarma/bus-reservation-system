package com.shivajivarma.brs.controller;

import java.util.ArrayList;

import com.shivajivarma.brs.model.Model;
import com.shivajivarma.brs.model.Passenger;
import com.shivajivarma.brs.ui.BannerViewPanel;
import com.shivajivarma.brs.ui.HomeTabsView;
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
    private Controller loginController, registrationController, passengerController;

    public MasterController() {
    }
    
    public MasterController(MasterView masterView) {
    	this.masterView = masterView;
    	this.bannerView = new BannerViewPanel();
    }
    
      
    public void control(){
    	this.loginControl();
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
    	HomeTabsView homeTabs = new HomeTabsView();
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(homeTabs, "center");
    	
    }

    public void _load(){        
           
    }
    
}