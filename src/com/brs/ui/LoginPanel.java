/**
 * <Copyright information>
 * 
 * <Customer specific copyright notice (if any) >
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

package com.brs.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import com.brs.application.Passenger;
import com.brs.ui.StylesAndHelperMethods;
import com.brs.utility.exceptions.EmptyResultSetException;

/**
 * This class is a login panel which holds buttons and labels of login form.
 * 
 * Contains method to handle login event. 
 */
public class LoginPanel extends JPanel{

	private static final long serialVersionUID = 7982044118849654641L;
	
	// UI Components which help in taking input from user and display output.
	JLabel lUsername,lPassword,lHeading;
	JTextField tfUsername;
	JPasswordField pfPassword;
	JButton btnLogin,btnRegister;
	LoginPanel self;
	
	int x = 250, y = 125;

	/**
	 * The following constructor initializes buttons,fields,labels and adds them to panel.
	 */
	public LoginPanel() {
		
		self = this;
		setLayout(null);

		/*
		 * Initializing elements and setting styles.
		 */
		lHeading=new JLabel("Login");
		lHeading.setBounds(x,y,120,28);
		lHeading.setFont(StylesAndHelperMethods.FONT_HEADER);
			
		lUsername=new JLabel("Username :");
		lUsername.setBounds(x+20,y+80,150,20);
		lUsername.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		
		tfUsername=new JTextField();
		tfUsername.setBounds(x+170,y+76,250,30);
		tfUsername.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		lPassword=new JLabel("Password  :");
		lPassword.setBounds(x+20,y+140,150,20);
		lPassword.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		pfPassword=new JPasswordField();
		pfPassword.setBounds(x+170,y+136,250,30);
		pfPassword.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		btnLogin=new JButton("Login");
		btnLogin.setBounds(x+210,y+230,80,40);
		btnLogin.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		btnRegister=new JButton("Register");
		btnRegister.setBounds(x+310,y+230,110,40);
		btnRegister.setFont(StylesAndHelperMethods.FONT_NORMAL);
	
	
		
		/*
		 * Adding labels and text fields to login panel.
		 */
		add(lHeading);
		add(lUsername);
		add(tfUsername);
		add(lPassword);
		add(pfPassword);
		add(btnLogin);
		add(btnRegister);
		
		
		
		
		
		/**
		 *  On clicking login button login validation is been initiated.
		 */
		btnLogin.addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				
				Passenger p = new Passenger();
				String username = self.tfUsername.getText(), password = new String(self.pfPassword.getPassword());
					
					/*
					 * Validation.
					 * Checking whether username field is empty or not.
					 */
					if(username.equals("")){
						StylesAndHelperMethods.errorMessage("Enter Username.");
					}
					
					// Checking whether password field is empty or not.
					else if(password.equals("")){
						StylesAndHelperMethods.errorMessage("Enter Password.");
					}
					
					/*
					 * Validating username and password against database.
					 */
					else
						try {
							if(p.login(username,password) == 0){
								StylesAndHelperMethods.errorMessage("Login Failed !! Wrong password");
								self.pfPassword.setText(null);
							}
							
							// Login success. Open main panel
							else{
								MainFrame.brs.homePage();
								self.setVisible(false);
							}
						}  catch (EmptyResultSetException e) {
							StylesAndHelperMethods.errorMessage("Login Failed !! Invalid username");
							self.reset();
						}
			}
		});
		
		/**
		 *  On clicking register button Registration form is initialized.
		 */
		btnRegister.addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				MainFrame.brs.registrationForm();
				self.setVisible(false);
			}
		});
			
	}

		
	/**
	 * This function clears username and password fields.
	 */
	void reset(){
		tfUsername.setText(null);
		pfPassword.setText(null);
		self.setVisible(true);
	}

}
