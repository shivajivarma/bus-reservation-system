package com.shivajivarma.brs.model.entity;

/**
 * 
 * This is Bean class, which holds all the bus details.
 * 
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 * @see PassengerService
 */
public class Bus implements Entity {

	public static final String indentity = "Bus";

	private long id;
	private long routeID;
	private boolean ac;
	private int fare;
	private String departureTime;
	private String arrivalTime;
	private int availablityCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRouteID() {
		return routeID;
	}

	public void setRouteID(long routeID) {
		this.routeID = routeID;
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

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getAvailablityCount() {
		return availablityCount;
	}

	public void setAvailablityCount(int availablityCount) {
		this.availablityCount = availablityCount;
	}

}
