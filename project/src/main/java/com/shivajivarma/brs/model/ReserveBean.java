/**
 * ALL WORKS � SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * ReserveBean.java
 * 
 * This files contains ReserveBean bean class.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 */
package com.shivajivarma.brs.model;

/**
 * 
 * This is Bean class, which holds all the reservation details.
 *
 */
public class ReserveBean{
	
	private long tid;
	private Passenger pb = new Passenger();
	private BusBean bb = new BusBean();
	private String date;
	private String tstamp;
	private int seat;

	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	
	/* PassengerBean */
	public long getPid() {
		return pb.getId();
	}
	public void setPid(long pid) {
		if(pb == null)
			pb = new Passenger();
		this.pb.setId(pid);
	}
	public Passenger getPassengerBean() {
		return pb;
	}
	public void setPassengerBean(Passenger pb) {
		this.pb = pb;
	}
	
	/* BusBean */
	public long getBid() {
		return bb.getBid();
	}
	public void setBid(long bid) {
		if(bb == null)
			bb = new BusBean();
		this.bb.setBid(bid);
	}
	public BusBean getBusBean() {
		return bb;
	}
	public void setBusBean(BusBean bb) {
		this.bb = bb;
	}
	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTstamp() {
		return tstamp;
	}
	public void setTstamp(String tstamp) {
		this.tstamp = tstamp;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}

}

