package com.shivajivarma.brs.model.bean;

import com.shivajivarma.brs.model.entity.Reserve;

/**
 * The Bean class, which holds full reservation details, it a logical bean with represent database view.
 * 
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class ReservationBean extends Reserve implements Bean {

	public static final String indentity = "Reservation";
	
	private long id;
	private long pid;
	private long bid;
	private String dt;
	private int seat;
	private String tstamp;
	
	private String origin;
	private String destination;
	
	private String depttime;
	private String arrtime;
	
	public ReservationBean(){
	}
	
	public ReservationBean(long id, long pid, long bid, String dt, String tstamp, int seat, String origin, String destination, String depttime, String arrtime) {
		this.id = id;
		this.pid = pid;
		this.bid = bid;
		this.dt = dt;
		this.tstamp = tstamp;
		this.seat = seat;
		this.origin = origin;
		this.destination = destination;
		this.depttime = depttime;
		this.arrtime = arrtime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getTstamp() {
		return tstamp;
	}

	public void setTstamp(String tstamp) {
		this.tstamp = tstamp;
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
