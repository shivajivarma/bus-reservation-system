package com.brs.ui;

import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.brs.application.Passenger;
import com.brs.utility.exceptions.DBConnectException;

public class RegistrationPanel extends JPanel{
	
	private static final long serialVersionUID = -6812176241795384605L;
	
	JLabel lUsername,lName,lPassword,lrPassword,lMobile,lEmail,lHeading;
	JTextField tfUsername,tfName,tfMobile,tfEmail;
	JPasswordField pfPassword,pfrPassword;
	JButton btnRegister, btnCancel;
	RegistrationPanel self;
	
	int x=250,y=40;
	public RegistrationPanel(){
		self=this;
		
		setLayout(null);
		lHeading=new JLabel("Registration");
		lHeading.setBounds(x+115,y+0,300,28);
		lHeading.setFont(StylesAndHelperMethods.FONT_HEADER);
		
		lUsername=new JLabel("Username :");
		lUsername.setBounds(x+93,y+60,150,20);
		lUsername.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		tfUsername=new JTextField();
		tfUsername.setBounds(x+220,y+60,250,30);
		tfUsername.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		lName=new JLabel("Full name :");
		lName.setBounds(x+100,y+120,150,20);
		lName.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		tfName=new JTextField();
		tfName.setBounds(x+220,y+120,250,30);
		tfName.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		lPassword=new JLabel("Enter your Password :");
		lPassword.setBounds(x+0,y+180,200,20);
		lPassword.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		pfPassword=new JPasswordField();
		pfPassword.setBounds(x+220,y+180,250,30);
		pfPassword.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		lrPassword=new JLabel("Re-Enter Password :");
		lrPassword.setBounds(x+10,y+240,200,20);
		lrPassword.setFont(StylesAndHelperMethods.FONT_NORMAL);
			
		pfrPassword=new JPasswordField();
		pfrPassword.setBounds(x+220,y+240,250,30);
		pfrPassword.setFont(StylesAndHelperMethods.FONT_NORMAL);
				
		lMobile=new JLabel("Mobile :");
		lMobile.setBounds(x+122,y+300,200,20);
		lMobile.setFont(StylesAndHelperMethods.FONT_NORMAL);
				
		tfMobile=new JTextField();
		tfMobile.setBounds(x+220,y+300,250,30);
		tfMobile.setFont(StylesAndHelperMethods.FONT_NORMAL);
				
		lEmail=new JLabel("Email :");
		lEmail.setBounds(x+128,y+360,200,20);
		lEmail.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		tfEmail=new JTextField();
		tfEmail.setBounds(x+220,y+360,250,30);
		tfEmail.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setBounds(x+180,y+420,110,40);
		btnCancel.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		btnRegister=new JButton("Register");
		btnRegister.setBounds(x+360,y+420,110,40);
		btnRegister.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		add(lHeading);
		add(lUsername);
		add(tfUsername);
		add(lName);
		add(tfName);
		add(lPassword);
		add(pfPassword);
		add(lrPassword);
		add(pfrPassword);
		add(lMobile);
		add(tfMobile);
		add(lEmail);
		add(tfEmail);
		add(btnRegister);
		add(btnCancel);
		
		btnRegister.addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				
				Passenger p = new Passenger();
				
				// Username validation.
				if(tfUsername.getText().equals("")){
					StylesAndHelperMethods.errorMessage("You can't leave 'Username' field empty.");
				} else if(!Pattern.matches("[A-Za-z1-9._]+", tfUsername.getText())){
					StylesAndHelperMethods.errorMessage("Please use only letters (a-z), numbers, and periods.");
					tfUsername.setText(null);
				} else
					try {
						if(!p.isUsernameAvailable(tfUsername.getText())){
							StylesAndHelperMethods.errorMessage("Someone already has that username. Try another.");
							tfUsername.setText(null);
						}
						
						// Customer full name validation.
						else if(tfName.getText().equals("")){
							StylesAndHelperMethods.errorMessage("You can't leave 'Name' field empty.");
						} else if(!Pattern.matches("[A-Za-z ]+", tfName.getText())){
							StylesAndHelperMethods.errorMessage("Enter valid customer name");
							tfName.setText(null);
						}
									
						// Password validataion.
						else if(new String(pfPassword.getPassword()).equals("")){
							StylesAndHelperMethods.errorMessage("You can't leave 'Password' field empty.");
						}else if(!Pattern.matches("[^ ]+",  new String(pfPassword.getPassword()))){
							StylesAndHelperMethods.errorMessage("No spaces are allowed in 'Password' field.");
							pfPassword.setText("");
							pfrPassword.setText("");
						}else if(!new String(pfPassword.getPassword()).equals(new String(pfrPassword.getPassword()))){
							StylesAndHelperMethods.errorMessage("Password Mismatch");
							pfPassword.setText(null);
							pfrPassword.setText(null);
						}
						
						// Mobile number validation.
						else if(((tfMobile.getText().length()!=10))||!(Pattern.matches("[0-9]+",tfMobile.getText()))){
							StylesAndHelperMethods.errorMessage("Enter a valid mobile number");
							tfMobile.setText(null);
						}
						
						// Email validation.
						else if(!(Pattern.matches("[A-Za-z]+@[A-Za-z]+[.]com",tfEmail.getText()))){
							StylesAndHelperMethods.errorMessage("Enter valid Email id");
							tfEmail.setText(null);
						}
						
						// On validation success.
						else{
							
							p.register(tfUsername.getText(), new String(pfPassword.getPassword()), tfName.getText(), tfEmail.getText(), tfMobile.getText());
							StylesAndHelperMethods.successMessage("Registration succesful. login to book the tickets.");
							
							/*
							 * Return to login page.
							 */
							MainFrame.brs.loginForm();
							setVisible(false);
						}
					} catch (DBConnectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		});
		
		
		btnCancel.addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				MainFrame.brs.loginForm();
				self.setVisible(false);
			}
			
		});
	}
	
	/**
	 * This function clears all fields.
	 */
	void reset(){
		tfUsername.setText(null);
		tfName.setText(null);
		pfPassword.setText(null);
		pfrPassword.setText(null);
		tfMobile.setText(null);
		tfEmail.setText(null);
		self.setVisible(true);
	}
	
}