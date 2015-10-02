package com.shivajivarma.brs.model.entity;


/**
 * 
 * This is Bean class, which holds all the bus details.
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 * @see PassengerService
 */
public class Bus implements Entity{
	
	private long bid;
	private Route rob;
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
	/*public long getRid() {
		return rob.getRid();
	}
	public void setRid(long rid) {
		if(rob == null)
			rob = new Route();
		this.rob.setRid(rid);
	}
	public Route getRouteBean() {
		return rob;
	}
	public void setRouteBean(Route rob) {
		this.rob = rob;
	}*/
	
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

