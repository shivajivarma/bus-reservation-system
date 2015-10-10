package com.shivajivarma.brs.model.entity;

/**
 * The Bean class, which holds reserve table details.
 * 
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 * @see ReserveService
 */
public class Reserve implements Entity {

	public static final String indentity = "Reserve";

	private long id;
	private long passengerID;
	private long busID;
	private String dt;
	private String tstamp;
	private int seat;

	public Reserve() {
	}

	public Reserve(long id, long passengerID, long busID, String dt, String tstamp,
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(long passengerID) {
		this.passengerID = passengerID;
	}

	public long getBusID() {
		return busID;
	}

	public void setBusID(long busID) {
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
