package com.shivajivarma.brs.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import com.shivajivarma.brs.utility.ValidationUtil;
import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public class CancellationTabView extends BaseView implements View{
	
	private JTextField ticketNumber;
	private JButton submitButton;

	public CancellationTabView() {
		this.setBackground(Color.white);
		this.initializeLabels();
		this.initializeComponents();
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

	public int getTicketNumber() {
		return Integer.parseInt(ticketNumber.getText());
	}

	public JButton getSubmitButton() {
		return submitButton;
	}
	
}
