/**
 * ALL WORKS � SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * LoginForm.java
 * 
 * This file contains Panel which accepts user credentials and validates its format. 
 * And calls User Class login method to check user existance
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */

package com.shivajivarma.brs.ui;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.shivajivarma.brs.utility.ValidationUtil;
import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public class LoginPanelView extends BaseView implements View{
	
	// UI Components which help in taking input from user and display output.
	private JTextField username;
	private JPasswordField password;
	private JButton loginButton,registerButton;
	private int x = 250, y = 125;

	/**
	 * The following constructor initializes buttons,fields,labels and adds them to panel.
	 */
	public LoginPanelView() {
		this.initializeLabels();
		this.initializeComponents();	
	}
	
	private void initializeLabels(){
		this.add(ViewComponentFactory.createJLabelHeader(Labels.LOGIN, new int[]{x,y,120,28}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.USERNAME, new int[]{x+20,y+80,150,20}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.PASSWORD, new int[]{x+20,y+140,150,20}));
	}
	
	private void initializeComponents(){
		username = ViewComponentFactory.createJTextFieldNormal(new int[]{x+170,y+76,250,30});
		password = ViewComponentFactory.createJPasswordFieldNormal(new int[]{x+170,y+136,250,30});
		loginButton = ViewComponentFactory.createJButtonNormal(Labels.LOGIN, new int[]{x+210,y+230,80,40});
		registerButton = ViewComponentFactory.createJButtonNormal(Labels.REGISTER, new int[]{x+310,y+230,110,40});
		
		username.setName(Labels.USERNAME);
		password.setName(Labels.PASSWORD);
		
		inputFields.add(username);
		inputFields.add(password);
		
		this.add(username);
		this.add(password);
		this.add(loginButton);
		this.add(registerButton);
	}
	
	public boolean validateFields(){
		ArrayList<String> errors = new ArrayList<String>();
		String message;
		
		message = ValidationUtil.validateField(username, new String[]{"required","username"});
		errors.add(message);
		
		message = ValidationUtil.validateField(password, new String[]{"required", "noSpaces"});
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
	
	public String getUsername() {
		return username.getText().toLowerCase();
	}

	public String getPassword() {
		return new String(password.getPassword());
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}
}
