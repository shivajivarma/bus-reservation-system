package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;

import com.shivajivarma.brs.model.Model;
import com.shivajivarma.brs.model.Passenger;
import com.shivajivarma.brs.ui.Alert;
import com.shivajivarma.brs.ui.LoginPanelView;
import com.shivajivarma.brs.ui.View;
import com.shivajivarma.brs.utility.EventAdapters.ActionAdapter;
import com.shivajivarma.brs.utility.constants.Messages;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class LoginController implements Controller{
	
	private LoginController _this;
	private PassengerController passengerController;
	private LoginPanelView loginView;
	private Passenger passenger;
	
    public LoginController(View loginView) {
    	_this = this;
    	this.loginView = (LoginPanelView) loginView;
    	this.passenger = new Passenger();
    }
    
    public void control(MasterController masterController){
    	/**
		 *  On click of register button, switch control to RegistrationController
		 */
    	loginView.getLoginButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				if(loginView.validateFields()){
					passenger.setUsername(loginView.getUsername());
					if(_this.checkUsername()){
						if(_this.passwordCheck()){
							Alert.errorMessage(Messages.SUCCESS_REGISTRATION);
							masterController.loginControl();
						}else{
							Alert.errorMessage(Messages.ERROR_WRONG_PASSWORD);
						}
					}else{
						Alert.errorMessage(Messages.ERROR_NO_USERNAME);
					}
				}
			}
		});
    	
    	loginView.getRegisterButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				masterController.registrationControl();
			}
		});
    	
    }
    
    private boolean checkUsername(){
    	if(passengerController == null){
    		passengerController = new PassengerController(passenger);
    	}else{
    		passengerController.updateModel(passenger);
    	}
    	return !passengerController.isUsernameAvailable();
    }
    
    private boolean passwordCheck(){
    	passenger.setPassword(loginView.getPassword());
    	passengerController.updateModel(passenger);
    	return passengerController.login();
    }
    
}