package com.shivajivarma.brs.ui;

import javax.swing.JOptionPane;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class Alert {
	public static final void errorMessage(String mesg){
		JOptionPane.showMessageDialog(null, mesg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static final void successMessage(String mesg){
		JOptionPane.showMessageDialog(null, mesg, "Success", JOptionPane.PLAIN_MESSAGE);
	}
}