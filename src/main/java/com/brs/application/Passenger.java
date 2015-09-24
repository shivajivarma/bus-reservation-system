/**
 * ALL WORKS � SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * Passenger.java
 * 
 * This file contains Passenger class which holds all controller methods to perform all passenger operations link login, registration, reservation and cancellation.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2010
 * 
 */
package com.brs.application;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	public int login(String username,String password) throws EmptyResultSetException, DBConnectException{
		
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
	
	
	public boolean isUsernameAvailable(String username) throws DBConnectException{
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
	
	public void register(String username, String password, String name, String email, String mobile) throws DBConnectException{
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
	 public BufferedReader loadTicketHTML(){
		return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/assets/ticket.html")));
	 }
	 
	 public static void printTickets(ArrayList<ReserveBean> rbs){
		FileWriter fw;
		BufferedReader ticketHTML = session.loadTicketHTML();;
		try {
			 Thread.sleep(1000);
			  
			 fw = new FileWriter(System.getenv("APPDATA")+"\\ticket.html");
			
			 String str;
			 while((str=ticketHTML.readLine())!=null){
				 fw.write(str);
			 }
			 
			Iterator<ReserveBean> irbs = rbs.iterator();
			ReserveBean rb;
			while(irbs.hasNext()){
				rb = irbs.next();
				fw.write("<script>");
				String render = "render({'tid':'"+rb.getTid()+"',"+
						"'bid':'"+rb.getBid()+"',"+
						"'origin':'"+rb.getBusBean().getRouteBean().getOrigin()+"',"+
						"'deptime':'"+rb.getBusBean().getDeptime()+"',"+
						"'arrtime':'"+rb.getBusBean().getArrtime()+"',"+
						"'destination':'"+rb.getBusBean().getRouteBean().getDestination()+"',"+
						"'seat':'"+rb.getSeat()+"',"+
						"'date':'"+rb.getDate()+"',"+
								 "})";	
				fw.write(render);
				fw.write("</script>");
			}
			fw.write("</body></html>");
			ticketHTML.close();
			fw.close();	
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler file:///"+System.getenv("APPDATA")+"/ticket.html");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
}
