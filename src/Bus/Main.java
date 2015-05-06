package Bus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import com.brs.ui.HomePanel;
import com.brs.ui.LoginPanel;
import com.brs.ui.RegistrationPanel;
import com.brs.utility.DBConnection;


/**
 * Creates frame which handles all the panels. [Contains main function] 
 */
public class Main extends JFrame {

	public static void main(String[] args) {
		try {
			new DBConnection();
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			mainFrame=new Main();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 *  Reference to main frame.
	 */
	public static Main mainFrame;

	/*
	 * Panels
	 */
	LoginPanel loginPanel;
	RegistrationPanel registerationPanel;
	SeatLayout seatlayout;
	
	BookedHistory history;

	/*
	 * User data.
	 */
	int pid;
	String pname;
	String date;
	//ResultSet busList;

	public Main(){
		/*
		 * Setting Look and feel.
		 */
		setBackground(Color.white);
		setResizable(false);
		setLayout(new BorderLayout());
		setBounds(0,0, 1024, 740);
		setTitle("Bus Reservation System");
		
		add(BorderLayout.NORTH,new JLabel(new ImageIcon("assets//banner.jpg")));
		add(BorderLayout.CENTER,loginPanel=new LoginPanel());
		
		/*
		 * Close application.
		 */
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	/**
	 * Opens registration page.
	 */
	public static void register(){
		mainFrame.registerationPanel=new RegistrationPanel();
		mainFrame.add(BorderLayout.CENTER,mainFrame.registerationPanel);
	}
	
	/**
	 * Opens home page.
	 */
	public static void loginsuccesful(){
		/*mainFrame.homePanel=*/
		mainFrame.add(BorderLayout.CENTER,new HomePanel());	
	}
	
	/**
	 * Opens login page.
	 */
	public static void returnToLogin(){
		mainFrame.loginPanel.setVisible(true);
	}
	

	/**
	 * Opens buses list page.
	 */
	/*public static void displaytable(){
		mainFrame.display=new Displaytable();
		mainFrame.add(BorderLayout.CENTER,mainFrame.display);
	}*/
	
	/**
	 * Opens seats layout page.
	 */
	public static void seatlayout(int busid){
	//	mainFrame.display.setVisible(false);
		mainFrame.seatlayout=new SeatLayout(busid);
		mainFrame.add(BorderLayout.CENTER,mainFrame.seatlayout);
	}
	
	
	
	
	/**
	 * Prints tickets when seats are reserved.
	 * @param count : number of tickets to be printed
	 */
	static void printTickets(int count) {
		
		FileWriter fw;
		try {
			fw = new FileWriter("bin\\tickets.html");
			
			/*ResultSet rst = new DBConnect().customerHistory(mainFrame.pid);
			
			for (int i = 0; i < count; i++) {
				rst.next();
				fw.write("<table border=0 height='357px' width='615px' style='background-image:url(ticket.jpg);'><tr height='160px'><td></td></tr><tr height='35px' valign='top'><td align='right'  width='110px'>Ticket id:</td><td width='180px'>");
				fw.write(rst.getString(1));
				fw.write("</td><td width='90'>Bus id:</td><td>");
				fw.write(rst.getString(2));
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Origin:</td><td width='180px'>");
				fw.write(rst.getString(4));
				fw.write("</td><td width='90'>Departure time:</td><td >");
				fw.write(rst.getString(6));
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Destination:</td><td width='180px'>");
				fw.write(rst.getString(5));
				fw.write("</td><td width='90'>Arrival time:</td><td >");
				fw.write(rst.getString(7));
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Date of travel:</td><td width='180px'>");
				fw.write(rst.getString(3));
				fw.write("</td><td width='90'>Seat number:</td><td >");
				fw.write(rst.getString(8));
				fw.write("</td></tr><tr height='*'></tr></table></body>");
			}*/
		
			fw.close();
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ClassLoader.getSystemResource("tickets.html"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	

	/**
	 * Prints tickets from history page.
	 */
	 public static void printTicket(String tid,String bid,String origin,String dest,String arr,String dept,String jdate,String seat){
		FileWriter fw;   
		try {
			 Thread.sleep(1000);
			fw = new FileWriter("bin\\tickets.html");

				fw.write("<table border=0 height='357px' width='615px' style='background-image:url(ticket.jpg);'><tr height='160px'><td></td></tr><tr height='35px' valign='top'><td align='right'  width='110px'>Ticket id:</td><td width='180px'>");
				fw.write(tid);
				fw.write("</td><td width='90'>Bus id:</td><td>");
				fw.write(bid);
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Origin:</td><td width='180px'>");
				fw.write(origin);
				fw.write("</td><td width='90'>Departure time:</td><td >");
				fw.write(dept);
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Destination:</td><td width='180px'>");
				fw.write(dest);
				fw.write("</td><td width='90'>Arrival time:</td><td >");
				fw.write(arr);
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Date of travel:</td><td width='180px'>");
				fw.write(jdate);
				fw.write("</td><td width='90'>Seat number:</td><td >");
				fw.write(seat);
				fw.write("</td></tr><tr height='*'></tr></table></body>");
				
			fw.close();	
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ClassLoader.getSystemResource("tickets.html"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	 
}
