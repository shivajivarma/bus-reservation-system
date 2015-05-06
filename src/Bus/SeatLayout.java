package Bus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SeatLayout extends JPanel implements ActionListener{
	JLabel seats[]=new JLabel[41];
	JCheckBox seat[]=new JCheckBox[41];
	ImageIcon booked=new ImageIcon("booked.jpg");
	ImageIcon avail=new ImageIcon("av.jpg");
	JButton book,back;
	int bsid;
	
	public SeatLayout(int busid){
		
		book=new JButton("book");
		back=new JButton("Back");
		
		bsid=busid;
		ResultSet rst=new DBConnect().retrieveseat(busid);
		
		
		
		
		setLayout(null);
		for (int i =1 ; i <=40; i++) {
			seats[i]=new JLabel(avail);
			seat[i]=new JCheckBox();
		}
		
		try {
			while(rst.next()){
				int x=rst.getInt(1);
				seats[x]=new JLabel(booked);
				seat[x].setEnabled(false);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		
	
		book.setBounds(10,0,90,30);
		book.setFont(Hardcode.buttonFont);
		
		back.setBounds(10,60,90,30);
		back.setFont(Hardcode.buttonFont);
		
		
		add(book);
		book.addActionListener(this);
		add(back);
		back.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==book){
			DBConnect d=new DBConnect();
			boolean flag=true;
			int count=0;
			
			for (int i = 1; i <=40 ; i++) { 
				if(seat[i].isSelected()){
					flag=d.reserveTicket(Main.mainFrame.pid, bsid, Main.mainFrame.date,i);					
					if(!flag) break;
					count++;
				}
			}
			if(flag){
				JOptionPane.showMessageDialog(this, "Tickets booked successfully");
				Main.printTickets(count);
				setVisible(false);
				Main.loginsuccesful();
			}
			else{
				JOptionPane.showMessageDialog(this, "Tickets reservation failed.");
				setVisible(false);
			//	Main.mainFrame.display.setVisible(true);
			}
		}
		else if(e.getSource()==back){
			setVisible(false);
			//Main.mainFrame.display.setVisible(true);
		}
	}
}

