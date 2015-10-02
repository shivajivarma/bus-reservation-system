package com.shivajivarma.brs.model.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.dao.PassengerDAO;
import com.shivajivarma.brs.model.entity.Passenger;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class PassengerService implements Service{
	
	/**
	 * Session variable which holds account details of the customer until he logout.
	 */
	private Passenger passenger;
	public static ClassPathXmlApplicationContext dbApplicationContext;
	
	public PassengerService(){
		dbApplicationContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	}
	
	public void setModel(Passenger passenger){
		this.passenger = passenger;
	}
	
	public Passenger getModel(){
		return passenger;
	}
	
	public boolean isUsernameAvailable(){
		PassengerDAO passengerDAO = dbApplicationContext.getBean("passengerDAO", PassengerDAO.class);
		try{
			passengerDAO.findByUsername(passenger.getUsername());
		}catch(EmptyResultDataAccessException e){
			return true;
		}
		return false;
	}
	
	public void register(){
		PassengerDAO passengerDAO = dbApplicationContext.getBean("passengerDAO", PassengerDAO.class);
		passengerDAO.save(passenger);
	}
	
	public boolean login() throws EmptyResultDataAccessException{
		PassengerDAO passengerDAO = dbApplicationContext.getBean("passengerDAO", PassengerDAO.class);
		
		Passenger dbRecord = passengerDAO.findByUsername(passenger.getUsername());
		if(passenger.getPassword().equals(dbRecord.getPassword())){
			setModel(dbRecord);
			return true;
		}
		return false;
	}
	
	
/*	
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
		ReserveDAOImpl rd = new ReserveDAOImpl();
		
		Collection<Integer> occupiedSeats = null;
		try {
			occupiedSeats = rd.findSeatsAvailablity(bid, date);
		} catch (DBConnectException e) {
			e.printStackTrace();
		}
		return occupiedSeats;
	}
	
	
	public boolean reserve(Reserve rb){
		ReserveDAOImpl rd = new ReserveDAOImpl();
		
		try{
			rd.create(rb);
			return true;
		}catch (DBConnectException e) {
			e.printStackTrace();
			return false;
		}
	}
	}*/
	
	 protected void finalize(){
		dbApplicationContext.close();
		dbApplicationContext = null;
	 }
}
