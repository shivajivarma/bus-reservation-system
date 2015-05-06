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
import javax.swing.JTabbedPane;

import com.brs.application.Passenger;
import com.brs.ui.StylesAndHelperMethods;

/**
 * This class is a login panel which holds buttons and labels of login form.
 * 
 * Contains method to handle login event. 
 */
public class HomePanel extends JPanel{

	private static final long serialVersionUID = 7982044118849654641L;
	
	// UI Components which help in taking input from user and display output.
	JTabbedPane jTab;
	JLabel lWelcome,date;
	JButton btnLogout;
	JPanel reservationPanel,cancelPanel,histortyPanel;
	HomePanel self;
	
	int x = 250, y = 125;

	/**
	 * The following constructor initializes buttons,fields,labels and adds them to panel.
	 */
	public HomePanel() {
		
		self = this;
		setLayout(null);

		/*
		 * Initializing elements and setting styles.
		 */
		reservationPanel = new ReservationPanel();
		cancelPanel = new CancelPanel();
		histortyPanel = new HistoryPanel();
		
		jTab=new JTabbedPane();
		jTab.add(reservationPanel,"Reservation");
		jTab.add(cancelPanel,"Cancellation ");
		jTab.add(histortyPanel,"Booking history ");
		jTab.setBounds(0,40,1024,500);
		jTab.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		lWelcome=new JLabel("Welcome "+Passenger.session.getSessionPassenger().getName());
		lWelcome.setBounds(600,10,300,30);
		lWelcome.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		date=new JLabel("Date :  "+StylesAndHelperMethods.currentDate());
		date.setBounds(10,10,300,30);
		date.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		btnLogout=new JButton("Logout");
		btnLogout.setBounds(900,10,100,32);
		btnLogout.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		/*
		 * Adding labels and text fields to login panel.
		 */
		add(lWelcome);
		add(date);
		add(btnLogout);
		add(jTab);
			
		
		/**
		 *  On clicking logout button, control goes back login form.
		 */
		btnLogout.addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				MainFrame.brs.loginForm();
				self.setVisible(false);
			}
			
		});
			
	}
}
