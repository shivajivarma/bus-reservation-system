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
	
	private String depttime;
	private String arrtime;
	
	public ReservationBean(){
	}
	
	public ReservationBean(long id, long pid, long bid, String dt, String tstamp, int seat, String origin, String destination, String depttime, String arrtime) {
		this.id = id;
		this.passenger_id = pid;
		this.bus_id = bid;
		this.dt = dt;
		this.tstamp = tstamp;
		this.seat = seat;
		this.origin = origin;
		this.destination = destination;
		this.depttime = depttime;
		this.arrtime = arrtime;
	}
	
	public ReservationBean(Reserve reserve){
		this.id = reserve.getId();
		this.passenger_id = reserve.getPassengerId();
		this.bus_id = reserve.getBid();
		this.dt = reserve.getDt();
		this.tstamp = reserve.getTstamp();
		this.seat = reserve.getSeat();
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

	public String getDepttime() {
		return depttime;
	}

	public void setDepttime(String depttime) {
		this.depttime = depttime;
	}

	public String getArrtime() {
		return arrtime;
	}

	public void setArrtime(String arrtime) {
		this.arrtime = arrtime;
	}
	
}
