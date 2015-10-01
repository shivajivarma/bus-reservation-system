package com.shivajivarma.brs.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import com.shivajivarma.brs.utility.ValidationUtil;
import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
@SuppressWarnings("serial")
public class CancellationTabView extends BaseView implements View{
	
	CancellationTabView _this;
	
	JTextField ticketNumber;
	JButton submitButton;
	
	public JButton getSubmitButton() {
		return submitButton;
	}

	public CancellationTabView() {
		_this = this;
		
		this.setBackground(Color.white);
		this.initializeLabels();
		this.initializeComponents();
		
		/*
		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				if (tfTid.getText().equals("")) {
					StylesAndHelperMethods.errorMessage("Enter ticket number");
				}else{
					try {
						if (PassengerController.session.cancelTicket(tfTid.getText())) {
							StylesAndHelperMethods.successMessage("Cancellation Successful");
							self.reset();
						} else{
							StylesAndHelperMethods.errorMessage("Tid is not valid");
						}
					} catch (NumberFormatException ne) {
						StylesAndHelperMethods.errorMessage("Please use only numbers.");
						self.reset();
					}
				}

			}

		});*/
	}
	
	private void initializeLabels() {
		this.add(ViewComponentFactory.createJLabelNormal(Labels.ENTER_TICKET_ID, new int[]{50, 40, 200, 20}));
	}
	
	private void initializeComponents() {
		ticketNumber = ViewComponentFactory.createJTextFieldNormal(new int[]{270, 38, 150, 30});
		submitButton = ViewComponentFactory.createJButtonNormal(Labels.SUBMIT, new int[]{330, 100, 200, 40});
		
		ticketNumber.setName(Labels.TICKET_NO);
		
		inputFields.add(ticketNumber);
		
		this.add(ticketNumber);
		this.add(submitButton);
	}
	
	public boolean validateFields(){
		ArrayList<String> errors = new ArrayList<String>();
		String message;
		
		message = ValidationUtil.validateField(ticketNumber, new String[]{"required","numeric"});
		errors.add(message);
		
		errors.removeAll(Collections.singleton(null));
		if(!errors.isEmpty()){
			message = "";
			for (String error : errors) {message = message + error + "\n";}
			Alert.errorMessage(message);
			return false;
		}
		return true;
	}
	
}
