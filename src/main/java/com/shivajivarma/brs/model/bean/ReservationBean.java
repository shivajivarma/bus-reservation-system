package com.shivajivarma.brs.model.bean;

import com.shivajivarma.brs.model.entity.Reserve;

/**
 * The Bean class, which holds full reservation details, it a logical bean with represent database view.
 * 
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class ReservationBean extends Reserve implements Bean {

	public static final String indentity = "Reservation";
	
	private String origin;
	private String destination;
	
	private String departuretime;
	private String arrivaltime;
	
	public ReservationBean(){
	}
	
	public ReservationBean(int id, int passengerID, int busID, String dt, String tstamp, int seat, String origin, String destination, String departuretime, String arrivaltime) {
		this.setId(id);
		this.setPassengerID(passengerID);
		this.setBusID(busID);
		this.setDt(dt);
		this.setTstamp(tstamp);
		this.setSeat(seat);
		this.origin = origin;
		this.destination = destination;
		this.departuretime = departuretime;
		this.arrivaltime = arrivaltime;
	}
	
	public ReservationBean(Reserve reserve){
		this.setId(reserve.getId());
		this.setPassengerID(reserve.getPassengerID());
		this.setBusID(reserve.getBusID());
		this.setDt(reserve.getDt());
		this.setTstamp(reserve.getTstamp());
		this.setSeat(reserve.getSeat());
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

}
