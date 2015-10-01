package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;

import com.shivajivarma.brs.model.Reserve;
import com.shivajivarma.brs.model.services.PassengerService;
import com.shivajivarma.brs.ui.Alert;
import com.shivajivarma.brs.ui.CancellationTabView;
import com.shivajivarma.brs.ui.View;
import com.shivajivarma.brs.utility.EventAdapters.ActionAdapter;
import com.shivajivarma.brs.utility.constants.Messages;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class CancellationController implements Controller{
	
	private CancellationTabView cancellationTab;
	private Reserve reserve;
	private Passenger passenger;
	
    public CancellationController(View cancellationTab) {
    	this.cancellationTab = (CancellationTabView) cancellationTab;
    }
    
    public void control(MasterController masterController ){
    	/**
		 *  On clicking logout button, control goes back login form.
		 */
    	cancellationTab.getSubmitButton().addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				if(cancellationTab.validateFields()){
					reserve.getId(masterController.getPassenger());
					if(_this.isUsernameAvailable()){
						_this.register();
						Alert.successMessage(Messages.SUCCESS_REGISTRATION);
						masterController.loginControl();
					}else{
						Alert.errorMessage(Messages.ERROR_USERNAME_NOT_AVAILABLE);
					}
				}
			}
			
		});
    	
    }
        
}