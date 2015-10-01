package com.shivajivarma.brs.model.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.Reserve;
import com.shivajivarma.brs.model.dao.ReserveDAO;
import com.shivajivarma.brs.utility.exceptions.CannotDeleteRecordException;

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
	
	public void updateModel(Reserve reserve){
		this.reserve = reserve;
	}
		
	public void cancelTicket() throws EmptyResultDataAccessException{
		ReserveDAO reserveDAO = dbApplicationContext.getBean("reserveDAO", ReserveDAO.class);
		
		Reserve dbRecord = reserveDAO.findById(reserve.getId());
		if(dbRecord.getPid() == reserve.getPid()){
			reserveDAO.deleteById(reserve.getId());
		}
	}
	/*
	public Collection<ReserveBean> bookingHistory(){
		ReserveDAO rd = new ReserveDAO();
		
		Collection<ReserveBean> rbs = null;
		try {
			rbs = rd.findHistory(sessionPassenger.getId());
		} catch (DBConnectException e) {
			e.printStackTrace();
		}
		return rbs;
	}*/
	
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
	
	/**
	 * Prints tickets from history page.
	 */
	/* public static BufferedReader loadTicketHTML(){
		 try {
			return new BufferedReader(new InputStreamReader(null, "/assets/ticket.html"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }*/
	 
	 /*
	 public static void printTickets(ArrayList<ReserveBean> rbs){
		FileWriter fw;
		BufferedReader ticketHTML = loadTicketHTML();;
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
	}*/
	
	 protected void finalize(){
		dbApplicationContext.close();
		dbApplicationContext = null;
	 }
}
