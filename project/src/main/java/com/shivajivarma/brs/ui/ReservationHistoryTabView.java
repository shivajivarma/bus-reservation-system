package com.shivajivarma.brs.ui;

import java.awt.Color;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
@SuppressWarnings("serial")
public class ReservationHistoryTabView extends BaseView implements View{
	
	private DefaultTableModel tableModel;
	private JButton printButton;
	private JTable table;
	
	public ReservationHistoryTabView(){
		this.setBackground(Color.white);
		this.initializeLabels();
		this.initializeComponents();
	}
	
	private void initializeLabels() {
	}
	
	private void initializeComponents() {
		printButton = ViewComponentFactory.createJButtonNormal(Labels.PRINT, new int[]{910,400,80,40});
		
		table = new JTable(null,columns()){
			public boolean isCellEditable(int arg0, int arg1) {
				return false;	
			}
		};
		TableColumn tc;
		for (int i = 0; i < table.getColumnCount(); i++) {
			tc=table.getColumnModel().getColumn(i);
			tc.setMaxWidth(400);
		}
		
		tableModel = (DefaultTableModel) table.getModel();
			
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(50,20,850,400);	
		this.add(scrollPane);
		
		this.add(printButton);
	}
	
	private static Vector<String> columns(){
		Vector<String> columns=new Vector<String>();
		/*
		 * Populating history table column titles
		 */
		columns.addElement("Ticket ID");
		columns.addElement("BID");
		columns.addElement("Journey Date");
		columns.addElement("Origin");
		columns.addElement("Destination");
		columns.addElement("Departure");
		columns.addElement("Arrival");
		columns.addElement("Seat");
		return columns;
	}

	public JButton getPrintButton() {
		return printButton;
	}
	
	public void clearTable(){
		int rowCount = tableModel.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
	
	public void addTableRow(String id, String bid, String dt, String origin, String destination, String depttime, String arrtime, String seat) {
		tableModel.addRow(new Object[]{id, bid, dt,origin,destination,depttime,arrtime,seat});
	}

	public boolean isRowSelected(int i) {
		return table.isRowSelected(i);
	}
	
}

