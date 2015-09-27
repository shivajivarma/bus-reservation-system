
package com.shivajivarma.brs.ui;

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

import com.shivajivarma.brs.dao.DBConnection;
import com.shivajivarma.brs.model.BusBean;

/**
 * 
 * This class is a frame which holds panels (login panel, administrator home page, customer home page etc).
 *
 */
public class BRSView extends JFrame {

	private static final long serialVersionUID = -1931380773333544736L;

	//public static MainFrame brs;
	static DBConnection conn;
	
	LoginPanelView loginPanel;
	RegistrationPanelView regPanel;
	HomeTabsView homePanel;
	JPanel bannerPanel;
	JLabel banner;
	
	/**
	 * The following constructor adds login panel to frame.
	 */
	public BRSView() {
	}
	
	
	
	
	public void homePage(){
		homePanel = new HomeTabsView(this);
		add(BorderLayout.CENTER,homePanel);
		homePanel.setVisible(true);
	}
	
	public void availableBusesPage(Collection<BusBean> bbs, String date){
		homePanel.setVisible(false);
		homePanel = null;
		add(BorderLayout.CENTER,new AvailableBusesPanel(this,bbs,date));
	}
	
	public void seatLayoutPage(Collection<Integer> occupiedSeats, BusBean bb, String date){
		add(BorderLayout.CENTER,new SeatLayout(this,occupiedSeats, bb, date));
	}
	
}
