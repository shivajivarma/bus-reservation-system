package Bus;

import java.awt.Color;
import java.awt.event.*;

import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class BookedHistory extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTable table;
	JScrollPane jsp;
	JButton print;
	
	int k=0;
	
	public BookedHistory(){
		setLayout(null);
		setBackground(Color.white);
		
		print=new JButton("Print Ticket");
		print.setBounds(910,400,100,30);
		
		//Constructing table
		//ResultSet rst=new DBConnect().customerHistory(Main.mainFrame.pid);
		Vector columns=new Vector();
		Vector data=new Vector();
		/*
		ResultSetMetaData metdata;
		try {
			//Populating columns
			metdata = rst.getMetaData();
			for (int i = 1; i <=8; i++) 
				columns.addElement(metdata.getColumnName(i));
			
			//Populating data
			while(rst.next()){
				Vector row=new Vector();
				
				for (int i = 1; i <=8; i++) {
					if(i==3) row.add(rst.getString(i).substring(0,10));
					else  row.addElement(rst.getString(i));
				}
				data.addElement(row);
				k++;
			}
		
			table=new JTable(data,columns){
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		add(print);
		print.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		for(int i=0;i<k;i++){		
			if(table.isRowSelected(i))	
				Main.printTicket(table.getValueAt(i, 0).toString(),table.getValueAt(i, 1).toString(),table.getValueAt(i, 3).toString(),table.getValueAt(i, 4).toString(),table.getValueAt(i, 6).toString(),table.getValueAt(i,5).toString(),table.getValueAt(i,2).toString(),table.getValueAt(i,7).toString());
		}
	}
	
	
}

