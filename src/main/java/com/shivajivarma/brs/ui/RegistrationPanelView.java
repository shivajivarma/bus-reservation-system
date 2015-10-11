package com.shivajivarma.brs.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.shivajivarma.brs.utility.ValidationUtil;
import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;
import com.shivajivarma.brs.utility.constants.Messages;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public class RegistrationPanelView extends BaseView implements View{
	
	private JTextField username, fullname, mobile, email;
	private JPasswordField password, reEnterPassword;
	private JButton submitButton, cancelButton;
	
	private int x=250, y=40;
	
	public RegistrationPanelView(){
		this.initializeLabels();
		this.initializeComponents();
	}
	
	private void initializeLabels(){
		this.add(ViewComponentFactory.createJLabelHeader(Labels.REGISTER, new int[]{x+115,y+0,300,28}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.USERNAME, new int[]{x+95,y+60,150,20}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.FULL_NAME, new int[]{x+100,y+120,150,20}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.PASSWORD, new int[]{x+99,y+180,200,20}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.RE_ENTER_PASSWORD, new int[]{x+10,y+240,200,20}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.MOBILE, new int[]{x+122,y+300,200,20}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.EMAIL, new int[]{x+128,y+360,200,20}));
	}
	
	private void initializeComponents(){
		username = ViewComponentFactory.createJTextFieldNormal(new int[]{x+220,y+60,250,30});
		fullname = ViewComponentFactory.createJTextFieldNormal(new int[]{x+220,y+120,250,30});
		password = ViewComponentFactory.createJPasswordFieldNormal(new int[]{x+220,y+180,250,30});
		reEnterPassword = ViewComponentFactory.createJPasswordFieldNormal(new int[]{x+220,y+240,250,30});
		mobile = ViewComponentFactory.createJTextFieldNormal(new int[]{x+220,y+300,250,30});
		email = ViewComponentFactory.createJTextFieldNormal(new int[]{x+220,y+360,250,30});
		submitButton = ViewComponentFactory.createJButtonNormal(Labels.SUBMIT, new int[]{x+360,y+420,110,40});
		cancelButton = ViewComponentFactory.createJButtonNormal(Labels.CANCEL, new int[]{x+180,y+420,110,40});
		
		username.setName(Labels.USERNAME);
		fullname.setName(Labels.FULL_NAME);
		password.setName(Labels.PASSWORD);
		reEnterPassword.setName(Labels.RE_ENTER_PASSWORD);
		mobile.setName(Labels.MOBILE);
		email.setName(Labels.EMAIL);
		
		inputFields.add(username);
		inputFields.add(fullname);
		inputFields.add(password);
		inputFields.add(reEnterPassword);
		inputFields.add(mobile);
		inputFields.add(email);
		
		mobile.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent arg) {
                int keyCode = arg.getKeyCode();
                if ((keyCode > 47 && keyCode < 58) || keyCode == 45) {
                	arg.consume();
                }
            }

        });
		
		this.add(username);
		this.add(fullname);
		this.add(password);
		this.add(reEnterPassword);
		this.add(mobile);
		this.add(email);
		this.add(submitButton);
		this.add(cancelButton);
	}
	
	public boolean validateFields(){
		
		ArrayList<String> errors = new ArrayList<String>();
		String message;
		
		message = ValidationUtil.validateField(username, new String[]{"required","username"});
		errors.add(message);
		
		message = ValidationUtil.validateField(fullname, new String[]{"required","alphabetsOnly"});
		errors.add(message);
		
		message = ValidationUtil.validateField(password, new String[]{"required", "noSpaces"});
		errors.add(message);
		
		message = ValidationUtil.validateField(reEnterPassword, new String[]{"required", "noSpaces"});
		errors.add(message);
		
		message = ValidationUtil.validateField(mobile, new String[]{"mobile"});
		errors.add(message);
		
		message = ValidationUtil.validateField(email, new String[]{"email"});
		errors.add(message);
		
		errors.removeAll(Collections.singleton(null));
		if(!errors.isEmpty()){
			message = "";
			for (String error : errors) {message = message + error + "\n";}
			Alert.errorMessage(message);
			return false;
		}
		
		else if(!getPassword().equals(getReEnterPassword())){
			Alert.errorMessage(Messages.ERROR_PASSWORD_MISMATCH);
			password.setText(null);
			reEnterPassword.setText(null);
			return false;
		}
		
		return true;
	}

	public String getUsername() {
		return username.getText().toLowerCase();
	}
	
	public String getFullname() {
		return fullname.getText();
	}

	public String getPassword() {
		return new String(password.getPassword());
	}

	private String getReEnterPassword() {
		return new String(reEnterPassword.getPassword());
	}

	public int getMobile() {
		return Integer.parseInt(mobile.getText());
	}
	
	public String getEmail() {
		return email.getText();
	}
	
	public JButton getSubmitButton() {
		return submitButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
	
}