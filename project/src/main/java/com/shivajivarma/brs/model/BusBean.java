/**
 * Author: SHIVAJI VARMA <contact@shivajivarma.com>
 */
package com.shivajivarma.brs.model;

/**
 * 
 * This is Bean class, which holds all the bus details.
 *
 */
public class BusBean{
	
	private long bid;
	private RouteBean rob;
	private boolean ac;
	private int fare;
	private String deptime;
	private String arrtime;
	private int availablityCount;
	
	
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	
	/* RouteBean */
	public long getRid() {
		return rob.getRid();
	}
	public void setRid(long rid) {
		if(rob == null)
			rob = new RouteBean();
		this.rob.setRid(rid);
	}
	public RouteBean getRouteBean() {
		return rob;
	}
	public void setRouteBean(RouteBean rob) {
		this.rob = rob;
	}
	
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getDeptime() {
		return deptime;
	}
	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}
	public String getArrtime() {
		return arrtime;
	}
	public void setArrtime(String arrtime) {
		this.arrtime = arrtime;
	}
	
	public int getAvailablityCount() {
		return availablityCount;
	}
	public void setAvailablityCount(int availablityCount) {
		this.availablityCount = availablityCount;
	}
	
}

