package com.shivajivarma.brs.model.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.bean.ReservationBean;
import com.shivajivarma.brs.model.dao.ReservationDAO;
import com.shivajivarma.brs.model.dao.ReserveDAO;
import com.shivajivarma.brs.model.entity.Reserve;
import com.shivajivarma.brs.utility.IOHelpers;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class ReserveService implements Service{
	
	/**
	 * Session variable which holds account details of the customer until he logout.
	 */
	private Reserve reserve;
	public static ClassPathXmlApplicationContext dbApplicationContext;
	
	public ReserveService(){
		dbApplicationContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	}
	
	public void setModel(Reserve reserve){
		this.reserve = reserve;
	}
		
	public boolean cancelTicket() throws EmptyResultDataAccessException{
		ReserveDAO reserveDAO = dbApplicationContext.getBean("reserveDAO", ReserveDAO.class);
		
		Reserve dbRecord = reserveDAO.findById(reserve.getId());
		if(dbRecord.getPid() == reserve.getPid()){
			reserveDAO.deleteById(reserve.getId());
			return true;
		}else{
			return false;
		}
	}
	
	
	public List<ReservationBean> getReservationHistory(long pid) throws EmptyResultDataAccessException{
		
		ReservationDAO reservationDAO = dbApplicationContext.getBean("reservationDAO", ReservationDAO.class);
		
		List<ReservationBean> reservationList = reservationDAO.findByPid(pid);
		return reservationList;
	}
	
	public void printTickets(List<ReservationBean> tickets) {
		String html = IOHelpers.getFileAsString("/html/ticket-head.html");
		
		for (ReservationBean reservationBean : tickets) {
			html = html + createTicketCard(reservationBean);
		}
		
		html = html + IOHelpers.getFileAsString("/html/ticket-end.html");
		
		IOHelpers.printHTML(html, "tickets");
	}
	
	private static String createTicketCard(ReservationBean reservationBean){
		String card;
		card = "<div class='card'>"+
				  "<div class='card-header'>"+
					"Ticket no : "+reservationBean.getId()+
				  "</div>"+
				  "<div class='card-block row'>"+
					"<div class='col-md-6'>"+
						"<p class='card-text'><b>Passenger id :</b> "+reservationBean.getPid()+"</p>"+
						"<p class='card-text'><b>Bus no. :</b> "+reservationBean.getBid()+"</p>"+
						"<p class='card-text'><b>Seat no. :</b> "+reservationBean.getSeat()+"</p>"+
						"<p class='card-text'><b>Depature Time. :</b> "+reservationBean.getDepttime()+"</p>"+
						"<p class='card-text'><b>Arrival Time. :</b> "+reservationBean.getArrtime()+"</p>"+
					"</div>"+
					"<div class='col-md-6'>"+
						"<p class='card-text'><b>From :</b> "+reservationBean.getOrigin()+"</p>"+
						"<p class='card-text'><b>To :</b> "+reservationBean.getDestination()+"</p>"+
						"<div class='card-text'><div class='input-group'><span class='input-group-addon'>Cost : Rs.</span>"+
							"<input type='text' class='form-control' aria-label='Amount (to the nearest dollar)' disabled='disabled' value=100>"+
							  "<span class='input-group-addon'>.00</span>"+
						"</div></div>"+
					"</div>"+
				  "</div>"+
				"</div>";
		return card;
	}
	
	/*public Collection<BusBean> availableBuses(String origin, String destination, String date){
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
	*/
	
	 protected void finalize(){
		dbApplicationContext.close();
		dbApplicationContext = null;
	 }

	
}
