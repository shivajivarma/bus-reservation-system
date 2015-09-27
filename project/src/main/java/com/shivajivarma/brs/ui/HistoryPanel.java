package com.shivajivarma.brs.ui;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.TableColumn;

import com.shivajivarma.brs.controller.PassengerController;
import com.shivajivarma.brs.model.ReserveBean;

public class HistoryPanel extends JPanel{
	
	private static final long serialVersionUID = -7032550603633581148L;
	
	private JTable table;
	private JButton btnPrint;
	private ArrayList<ReserveBean> rbs;
	
	public HistoryPanel(){
		setLayout(null);
		setBackground(Color.white);
		
		btnPrint=new JButton("Print");
		btnPrint.setBounds(910,400,80,40);
		
		rbs = (ArrayList<ReserveBean>) PassengerController.session.bookingHistory();
		Iterator<ReserveBean> irbs = rbs.iterator();
		Vector<String> columns=new Vector<String>();
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		
		/*
		 * Populating history table titles
		 */
		columns.addElement("Ticket ID");
		columns.addElement("BID");
		columns.addElement("Journey Date");
		columns.addElement("Origin");
		columns.addElement("Destination");
		columns.addElement("Departure");
		columns.addElement("Arrival");
		columns.addElement("Seat");     
			
		
		/*
		 * Populating data
		 */
		while(irbs.hasNext()){
			Vector<String> row=new Vector<String>();
			
			ReserveBean rb = irbs.next();
			row.addElement(Long.toString(rb.getTid()));
			row.addElement(Long.toString(rb.getBid()));
			row.addElement(rb.getDate().substring(0,10));
			row.addElement(rb.getBusBean().getRouteBean().getOrigin());
			row.addElement(rb.getBusBean().getRouteBean().getDestination());
			row.addElement(rb.getBusBean().getArrtime());
			row.addElement(rb.getBusBean().getArrtime());
			row.addElement(Integer.toString(rb.getSeat()));
			
			data.addElement(row);
		}
		
		table = new JTable(data,columns){
			private static final long serialVersionUID = -2036375536753325114L;

			public boolean isCellEditable(int arg0, int arg1) {
				return false;	
			}
		};
		
		TableColumn tc;
		for (int i = 0; i < table.getColumnCount(); i++) {
			tc=table.getColumnModel().getColumn(i);
			tc.setMaxWidth(400);
		}
		
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(50,20,850,400);	
		add(jsp);
		add(btnPrint);
		
		btnPrint.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ReserveBean> tickets = new ArrayList<ReserveBean>();
				
				for(int i=0;i<rbs.size();i++){		
					if(table.isRowSelected(i)){
						
						tickets.add(rbs.get(i));
						
					}
				}
				PassengerController.printTickets(tickets);
			}
		});
	}
	
}

