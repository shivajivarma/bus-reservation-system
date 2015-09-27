package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;

import com.shivajivarma.brs.model.Passenger;
import com.shivajivarma.brs.ui.Alert;
import com.shivajivarma.brs.ui.RegistrationPanelView;
import com.shivajivarma.brs.ui.View;
import com.shivajivarma.brs.utility.EventAdapters.ActionAdapter;
import com.shivajivarma.brs.utility.constants.Messages;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class RegistrationController implements Controller{
	
	private RegistrationController _this;
	
	private RegistrationPanelView registrationView;
	private Passenger passenger;
	private PassengerController passengerController;
	
	
    public RegistrationController(View registrationView) {
    	_this = this;
    	this.registrationView = (RegistrationPanelView) registrationView;
    	this.passenger =  new Passenger();
    }
    
    public void control(MasterController masterController){
    
    	registrationView.getCancelButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				registrationView.refresh();
			}
		});
    	
    	registrationView.getSubmitButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				if(registrationView.validateFields()){
					passenger.setUsername(registrationView.getUsername());
					if(_this.isUsernameAvailable()){
						_this.register();
						Alert.errorMessage(Messages.SUCCESS_REGISTRATION);
						masterController.loginControl();
					}else{
						Alert.errorMessage(Messages.ERROR_USERNAME_NOT_AVAILABLE);
					}
				}
			}
		});
    	
    }
    
    private boolean isUsernameAvailable(){
    	if(passengerController == null){
    		passengerController = new PassengerController(passenger);
    	}else{
    		passengerController.updateModel(passenger);
    	}
    	return passengerController.isUsernameAvailable();
    }
    
    private void register(){
    	passenger.setName(registrationView.getFullname());
    	passenger.setPassword(registrationView.getPassword());
    	passenger.setMobile(Long.parseLong(registrationView.getMobile()));
    	passenger.setEmail(registrationView.getEmail());
    	passengerController.updateModel(passenger);
    	passengerController.register();
    }
    
}