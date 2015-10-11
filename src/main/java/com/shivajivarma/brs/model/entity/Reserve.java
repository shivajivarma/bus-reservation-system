package com.shivajivarma.brs.model.entity;

/**
 * The Bean class, which holds reserve table details.
 * 
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 * @see ReserveService
 */
public class Reserve implements Entity {

	public static final String indentity = "Reserve";

	private int id;
	private int passengerID;
	private int busID;
	private String dt;
	private String tstamp;
	private int seat;

	public Reserve() {
	}

	public Reserve(int id, int passengerID, int busID, String dt, String tstamp,
			int seat) {
		this.id = id;
		this.passengerID = passengerID;
		this.busID = busID;
		this.dt = dt;
		this.tstamp = tstamp;
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Reserve::[ID=" + id + ",PID=" + passengerID + ",BID=" + busID
				+ ",Date=" + dt + ",Time Stamp=" + tstamp + ",Seat=" + seat
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}

	public int getBusID() {
		return busID;
	}

	public void setBusID(int busID) {
		this.busID = busID;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
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
