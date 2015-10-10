package com.shivajivarma.brs.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public class HomeTabsPanelView extends BaseView implements View{

	private JTabbedPane tabs;
	private JLabel welcome,date;
	private JButton logoutButton;

	/**
	 * The following constructor initializes buttons,fields,labels and adds them to panel.
	 */
	public HomeTabsPanelView() {
		this.initializeLabels();
		this.initializeComponents();	
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
	
	public void insertTab(View tab, String tabName){
		tabs.add((JPanel)tab,tabName);
		this.revalidate();
		this.repaint();
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}
	
	public JTabbedPane getTabs() {
		return tabs;
	}
	
	public void setWelcome(String username) {
		this.welcome.setText("Welcome : " + username);
	}

	public void setDate(String date) {
		this.date.setText("Date : " + date);
	}
}
