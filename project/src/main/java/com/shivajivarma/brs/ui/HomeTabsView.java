package com.shivajivarma.brs.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class HomeTabsView extends BaseView implements View{

	HomeTabsView _this;
	
	JTabbedPane jTab;
	JLabel lWelcome,date;
	JButton btnLogout;
	JPanel reservationPanel,cancelPanel,histortyPanel;
	
	int x = 250, y = 125;

	/**
	 * The following constructor initializes buttons,fields,labels and adds them to panel.
	 */
	public HomeTabsView() {
		_this = this;
	
		/*
		 * Initializing elements and setting styles.
		 */
		/*try {
			reservationPanel = new ReservationPanel(mainFrame);
		} catch (DBConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cancelPanel = new CancelPanel();
		histortyPanel = new HistoryPanel();
		
		jTab=new JTabbedPane();
		jTab.add(reservationPanel,"Reservation");
		jTab.add(cancelPanel,"Cancellation ");
		jTab.add(histortyPanel,"Booking history ");
		jTab.setBounds(0,40,1024,500);
		jTab.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		lWelcome=new JLabel("Welcome "+PassengerController.session.getSessionPassenger().getName());
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
		/*add(lWelcome);
		add(date);
		add(btnLogout);
		add(jTab);
			
		
		/**
		 *  On clicking logout button, control goes back login form.
		 */
		/*btnLogout.addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				mainFrame.loginForm();
				self.setVisible(false);
			}
			
		})*/;
			
	}
	private static final long serialVersionUID = 7982044118849654641L;
}
