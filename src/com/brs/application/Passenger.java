/**
 * <Copyright information>
 * 
 * <Customer specific copyright notice (if any) >
 * 
 * Customer.java
 * 
 * This file contains Customer class which holds 
 * all methods to perform all customer operations.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */
package com.brs.application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.brs.entity.BusBean;
import com.brs.entity.PassengerBean;
import com.brs.entity.ReserveBean;
import com.brs.utility.BusDAO;
import com.brs.utility.PassengerDAO;
import com.brs.utility.LoginCredentialsDAO;
import com.brs.utility.ReserveDAO;
import com.brs.utility.exceptions.DBConnectException;
import com.brs.utility.exceptions.EmptyResultSetException;

/**
 * This class represents customer which holds all methods 
 * to perform customer operations like changing pin, withdraw, Deposit, Generate mini statement etc.
 */
public class Passenger {
	
	/**
	 * Session variable which holds account details of the customer until he logout.
	 */
	private PassengerBean sessionPassenger;
	public static Passenger session;
	/**
	 * This function verifies user login credentials.
	 * 
	 * @param cardno ATM card number
	 * @param pin Pin number of card.
	 * @return '0'- if password is not valid, '1'- if login credentials are valid.
	 * @throws EmptyResultSetException 
	 */
	public Passenger(){
		session=this;
	}
	
	public PassengerBean getSessionPassenger(){
		return sessionPassenger;
	}
	
	public int login(String username,String password) throws EmptyResultSetException{
		
		LoginCredentialsDAO lcdao=new LoginCredentialsDAO();
		
		// Fetching card details from AccountDetails table.
		String dbPassword=lcdao.fetchPassword(username);
		
		if(dbPassword == null || !dbPassword.equals(dbPassword)){
			return 0;
		} else{
			sessionPassenger = new PassengerDAO().findByUsername(username);
			return 1;
		}
	}
	
	
	public boolean isUsernameAvailable(String username){
		LoginCredentialsDAO lcdao=new LoginCredentialsDAO();
		
	
		// Fetching card details from AccountDetails table.
		try{
			lcdao.fetchPassword(username);
			return false;
		}catch(EmptyResultSetException erse){
			return true;
		}
		
	}
	
	public boolean cancelTicket(String tid){
		ReserveDAO rd = new ReserveDAO();
		ReserveBean rb = new ReserveBean();
		rb.setPid(sessionPassenger.getPid());
		rb.setTid(Long.parseLong(tid));
		
		try{
			rd.remove(rb);
			return true;
		}catch(EmptyResultSetException erse){
			return false;
		} catch (DBConnectException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Collection<ReserveBean> bookingHistory(){
		ReserveDAO rd = new ReserveDAO();
		
		Collection<ReserveBean> rbs = null;
		try {
			rbs = rd.findHistory(sessionPassenger.getPid());
		} catch (DBConnectException e) {
			e.printStackTrace();
		}
		return rbs;
	}
	
	public Collection<BusBean> availableBuses(String origin, String destination, String date){
		BusDAO bd = new BusDAO();
		
		Collection<BusBean> bbs = null;
		try {
			bbs = bd.find(origin, destination, date);
		} catch (DBConnectException e) {
			e.printStackTrace();
		}
		return bbs;
	}
	
	public Collection<Integer> seatsAvailablity(long bid, String date){
		ReserveDAO rd = new ReserveDAO();
		
		Collection<Integer> occupiedSeats = null;
		try {
			occupiedSeats = rd.findSeatsAvailablity(bid, date);
		} catch (DBConnectException e) {
			e.printStackTrace();
		}
		return occupiedSeats;
	}
	
	public void register(String username, String password, String name, String email, String mobile){
		PassengerBean pb = new PassengerBean();
		pb.setUsername(username);
		pb.setPassword(password);
		pb.setName(name);
		pb.setEmail(email);
		pb.setMobile(Long.parseLong(mobile));
	    new PassengerDAO().create(pb);
	}
	
	public boolean reserve(ReserveBean rb){
		ReserveDAO rd = new ReserveDAO();
		
		try{
			rd.create(rb);
			return true;
		}catch (DBConnectException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Prints tickets from history page.
	 */
	 public static void printTickets(ArrayList<ReserveBean> rbs){
		FileWriter fw;   
		try {
			 Thread.sleep(1000);
			fw = new FileWriter("bin\\tickets.html");
			
			Iterator<ReserveBean> irbs = rbs.iterator();
			ReserveBean rb;
			while(irbs.hasNext()){
				rb = irbs.next();
				fw.write("<table border=0 height='357px' width='615px' style='background-image:url(ticket.jpg);'><tr height='160px'><td></td></tr><tr height='35px' valign='top'><td align='right'  width='110px'>Ticket id:</td><td width='180px'>");
				fw.write(Long.toString(rb.getTid()));
				fw.write("</td><td width='90'>Bus id:</td><td>");
				fw.write(Long.toString(rb.getBid()));
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Origin:</td><td width='180px'>");
				fw.write(rb.getBusBean().getRouteBean().getOrigin());
				fw.write("</td><td width='90'>Departure time:</td><td >");
				fw.write(rb.getBusBean().getDeptime());
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Destination:</td><td width='180px'>");
				fw.write(rb.getBusBean().getRouteBean().getDestination());
				fw.write("</td><td width='90'>Arrival time:</td><td >");
				fw.write(rb.getBusBean().getArrtime());
				fw.write("</td></tr><tr height='35px'><td align='right' width='110px'>Date of travel:</td><td width='180px'>");
				fw.write(rb.getDate());
				fw.write("</td><td width='90'>Seat number:</td><td >");
				fw.write(Integer.toString(rb.getSeat()));
				fw.write("</td></tr><tr height='*'></tr></table>");
			}	
			fw.close();	
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ClassLoader.getSystemResource("tickets.html"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
}
