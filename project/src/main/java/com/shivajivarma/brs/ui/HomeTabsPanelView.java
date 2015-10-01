package com.shivajivarma.brs.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.text.ViewFactory;

import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
@SuppressWarnings("serial")
public class HomeTabsPanelView extends BaseView implements View{

	HomeTabsPanelView _this;
	
	JTabbedPane tabs;
	JLabel welcome,date;
	JButton logoutButton;

	/**
	 * The following constructor initializes buttons,fields,labels and adds them to panel.
	 */
	public HomeTabsPanelView() {
		_this = this;
		this.initializeLabels();
		this.initializeComponents();
		
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
			
		
		*/
			
	}
	
	private void initializeLabels() {
		welcome = ViewComponentFactory.createJLabelNormal("", new int[]{600,10,300,30});
		date = ViewComponentFactory.createJLabelNormal("", new int[]{10,10,300,30});
		this.add(welcome);
		this.add(date);
	}

	private void initializeComponents() {
		tabs=new JTabbedPane();
		tabs.setBounds(0,40,1024,500);
		tabs.setFont(ViewComponentFactory.FONT_NORMAL);
		
		logoutButton = ViewComponentFactory.createJButtonNormal(Labels.LOGOUT, new int[]{900,10,100,32});
		
		this.add(tabs);
		this.add(logoutButton);
	}
	
	public void insertTab(JPanel tab, String tabName){
		tabs.add(tab,tabName);
		this.revalidate();
		this.repaint();
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public void setWelcome(String username) {
		this.welcome.setText("Welcome : " + username);
	}

	public void setDate(String date) {
		this.date.setText("Date : " + date);
	}
}
