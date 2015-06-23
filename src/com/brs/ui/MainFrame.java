/**
 * <Copyright information>
 * 
 * <Customer specific copyright notice (if any) >
 * 
 * MainFrame.java
 * 
 * The file contains class for application frame where panels are placed.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */
package com.brs.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.util.Collection;

import com.brs.entity.BusBean;
import com.brs.utility.DBConnection;
import com.brs.utility.exceptions.DBConnectException;

/**
 * 
 * This class is a frame which holds panels (login panel, administrator home page, customer home page etc).
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -1931380773333544736L;

	public static MainFrame brs;
	static DBConnection conn;
	
	LoginPanel loginPanel;
	RegistrationPanel regPanel;
	HomePanel homePanel;
	JPanel bannerPanel;
	JLabel banner;
	
	/**
	 * The following constructor adds login panel to frame.
	 */
	public MainFrame() {
		try {
			/*
			 * Establishing connection with database.
			 */
			MainFrame.conn = new DBConnection();
			
			/*
			 * Setting look and feel
			 */
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
			/*
			 * Setting styles.
			 */
			setBackground(Color.white);
			setResizable(false);
			setLayout(new BorderLayout());
			setBounds(0,0, 1024, 740);
			setTitle("Bus Reservation System");
			
			JPanel banner = new JPanel();
			JLabel bannerLabel = new JLabel("Bus Resevation System");
			bannerLabel.setFont(StylesAndHelperMethods.FONT_BANNER);
			banner.add(new JLabel(new ImageIcon(getClass().getResource("/assets/banner.jpg"))));//bannerLabel);
			add(BorderLayout.NORTH, banner);
			
			loginForm();
			/*
			 * Close application.
			 */
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent arg0) {
					System.exit(0);
				}
			});
			setVisible(true);
		} catch (DBConnectException dbce) {
			StylesAndHelperMethods.errorMessage(dbce.getMessage());
		} catch (UnsupportedLookAndFeelException ulafe) {
			StylesAndHelperMethods.errorMessage("Application Look and Feel setting and not supported in this environment");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void loginForm(){
		loginPanel = new LoginPanel();
		add(BorderLayout.CENTER,loginPanel);
		loginPanel.setVisible(true);
	}
	
	public void registrationForm(){
		regPanel = new RegistrationPanel();
		add(BorderLayout.CENTER,regPanel);
		regPanel.setVisible(true);
	}
	
	public void homePage(){
		homePanel = new HomePanel();
		add(BorderLayout.CENTER,homePanel);
		homePanel.setVisible(true);
	}
	
	public void availableBusesPage(Collection<BusBean> bbs, String date){
		homePanel.setVisible(false);
		homePanel = null;
		add(BorderLayout.CENTER,new AvailableBusesPanel(bbs,date));
	}
	
	public void seatLayoutPage(Collection<Integer> occupiedSeats, BusBean bb, String date){
		add(BorderLayout.CENTER,new SeatLayout(occupiedSeats, bb, date));
	}
	/**
	 * 
	 * Main method, which initiates program to run on opening the application. 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		brs = new MainFrame();
	}
}
