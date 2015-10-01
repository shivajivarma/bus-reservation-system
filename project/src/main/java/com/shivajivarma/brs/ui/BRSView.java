
package com.shivajivarma.brs.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import java.util.Collection;

import com.shivajivarma.brs.model.BusBean;
import com.shivajivarma.brs.model.dao.DBConnection;

/**
 * 
 * This class is a frame which holds panels (login panel, administrator home page, customer home page etc).
 *
 */
public class BRSView extends JFrame {

	private static final long serialVersionUID = -1931380773333544736L;

	//public static MainFrame brs;
	static DBConnection conn;
	
	HomeTabsPanelView homePanel;
	
	
	public void availableBusesPage(Collection<BusBean> bbs, String date){
		homePanel.setVisible(false);
		homePanel = null;
		add(BorderLayout.CENTER,new AvailableBusesPanel(this,bbs,date));
	}
	
	public void seatLayoutPage(Collection<Integer> occupiedSeats, BusBean bb, String date){
		add(BorderLayout.CENTER,new SeatLayout(this,occupiedSeats, bb, date));
	}
	
}
