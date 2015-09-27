package com.shivajivarma.brs.ui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.shivajivarma.brs.controller.PassengerController;
import com.shivajivarma.brs.model.BusBean;
import com.shivajivarma.brs.model.ReserveBean;
import com.shivajivarma.brs.utility.ActionAdapter;

public class SeatLayout extends JPanel{

	SeatLayout self;
	
	private static final long serialVersionUID = -2795475292083804120L;
	BRSView mainFrame;
	JLabel seats[]=new JLabel[41];
	JCheckBox seat[]=new JCheckBox[41];
	ImageIcon booked=new ImageIcon(getClass().getResource("/assets/booked_seat.jpg"));
	ImageIcon avail=new ImageIcon(getClass().getResource("/assets/available_seat.jpg"));
	JButton btnBook,btnBack;
	BusBean bb;
	String date;
	
	public SeatLayout(BRSView mainFrame, Collection<Integer> occupiedSeats, BusBean bb, String date){
		this.mainFrame = mainFrame;
		self = this;
		
		btnBook=new JButton("Book");
		btnBack=new JButton("Back");
		
		this.bb=bb;
		this.date = date;
		
		
		setLayout(null);
		for (int i =1 ; i <=40; i++) {
			seats[i]=new JLabel(avail);
			seat[i]=new JCheckBox();
		}
		
		Iterator<Integer> iOccupiedSeats = occupiedSeats.iterator();
		while(iOccupiedSeats.hasNext()){
			int x = iOccupiedSeats.next();
			seats[x]=new JLabel(booked);
			seat[x].setEnabled(false);
			
		}
		 
	
		for (int i = 0; i <= 9; i++) {
			for (int j = 1; j <= 4; j++) {
				add(seat[(i*4)+j]);
				seat[(i*4)+j].setBounds(j*200,30+(i*50),20,20);
				
				add(seats[(i*4)+j]);
				seats[(i*4)+j].setBounds(22+(j*200),10+(i*50),70,70);
				
				JLabel sid=new JLabel((i*4)+j+"");
				sid.setBounds(70+(j*200),20+(i*50),20,20);
				add(sid);
			}
		}	
		
	
		btnBook.setBounds(10,0,90,30);
		btnBook.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		btnBack.setBounds(10,60,90,30);
		btnBack.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		
		add(btnBook);
		add(btnBack);
		
		btnBook.addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				
			boolean flag=true;
			ReserveBean rb;
			ArrayList<ReserveBean> rbs = new ArrayList<ReserveBean>();
			
			for (int i = 1; i <=40 ; i++) { 
				if(seat[i].isSelected()){
					rb = new ReserveBean();
					rb.setPid(PassengerController.session.getSessionPassenger().getId());
					rb.setBusBean(self.bb);
					
					rb.setDate(self.date);
					rb.setSeat(i);
					flag = PassengerController.session.reserve(rb);
					
					rbs.add(rb);
					if(!flag) 
						break;
				}
			}
			if(flag){
				StylesAndHelperMethods.successMessage("Tickets booked successfully");
				PassengerController.printTickets(rbs);
				mainFrame.homePage();
				self.setVisible(false);
			}
			else{
				StylesAndHelperMethods.errorMessage("Tickets reservation failed.");
			}
		}
		});
		
		btnBack.addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				mainFrame.homePage();
				self.setVisible(false);
			}
			
		});
		
	}
	
}

