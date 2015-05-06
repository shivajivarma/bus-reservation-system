package com.brs.ui;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.brs.application.Passenger;
import com.brs.entity.BusBean;

public class AvailableBusesPanel extends JPanel {
	
	private static final long serialVersionUID = -8424388738392769666L;
	
	AvailableBusesPanel self;
	int i=0,j=0;
	long sbusid=-1;
	long[] busid=new long[50];
	String date;
	Collection<BusBean> bbs;
	
	JRadioButton jrbSelectBus[]=new JRadioButton[100];
	JButton btnSubmit,btnBack;
		
		public AvailableBusesPanel(Collection<BusBean> bbs, String date){
			self = this;
			this.date = date;
			this.bbs = bbs;
			
			ButtonGroup bg=new ButtonGroup();
			setLayout(null);
			
			
			try {
				JLabel j1=new JLabel("B Id "+"         "+"Orgin"+"        "+"Destination"+"    "+"Type"+"           "+"Dept Tm"+"        "+"Arr tm"+"        "+"Availability"+"    "+"Fare");
				j1.setBounds(85,10,850,20);
				j1.setForeground(Color.BLUE);
				j1.setFont(StylesAndHelperMethods.FONT_NORMAL);
				
				
				btnSubmit=new JButton("Submit");
				btnSubmit.setBounds(500,500,100,40);
				btnSubmit.setFont(StylesAndHelperMethods.FONT_NORMAL);
				
				btnBack=new JButton("Back");
				btnBack.setBounds(300, 500, 100, 40);
				btnBack.setFont(StylesAndHelperMethods.FONT_NORMAL);
				
				add(j1);
				add(btnSubmit);
				add(btnBack);
				
				Iterator<BusBean> irbs = bbs.iterator();
			
				while(irbs.hasNext()){
					BusBean bb = irbs.next();
					String type;
					if(bb.isAc()) 
						type ="   AC     ";
					else 
						type="Non-AC";
					
					JLabel jl=new JLabel(bb.getBid()+"                 "+bb.getRouteBean().getOrigin()+"                 "+bb.getRouteBean().getDestination()+"             "+ type+"                 "+bb.getArrtime()+"                      "+bb.getDeptime()+"          	           "+bb.getAvailablityCount()+"                    Rs. "+bb.getFare());
					busid[j]=bb.getBid();
					jl.setBounds(85,50+i,850,20);
					add(jl);
				
					jrbSelectBus[j]=new JRadioButton();
					jrbSelectBus[j].setBounds(30,50+i,20,20);
					add (jrbSelectBus[j]);
					bg.add(jrbSelectBus[j]);

					
					i=i+30;
					j=j+1;
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			btnSubmit.addActionListener(new ActionAdapter() {
				
				public void actionPerformed(ActionEvent ae) {
					int k;
					Iterator<BusBean> irbs = self.bbs.iterator();
					for (k= 0; irbs.hasNext(); k++) {
						BusBean bb = irbs.next();
						if(jrbSelectBus[k].isSelected()){
							MainFrame.brs.seatLayoutPage(Passenger.session.seatsAvailablity(bb.getBid(),self.date), bb, self.date);
							self.setVisible(false);
							break;
						}
					}
	
					if(k == j){
						StylesAndHelperMethods.errorMessage("Please select a bus");
					}
				}
				
			});
				
			btnBack.addActionListener(new ActionAdapter() {
				
				public void actionPerformed(ActionEvent ae) {
					MainFrame.brs.homePage();
					self.setVisible(false);
				}
				
			});
				
		}
}
