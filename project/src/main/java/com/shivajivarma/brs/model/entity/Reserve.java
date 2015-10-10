package com.shivajivarma.brs.model.entity;

/**
 * The Bean class, which holds reserve table details.
 * 
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 * @see ReserveService
 */
public class Reserve implements Entity {

	public static final String indentity = "Reserve";

	protected long id;
	protected long passenger_id;
	protected long bus_id;
	protected String dt;
	protected String tstamp;
	protected int seat;

	public Reserve() {
	}

	public Reserve(long id, long pid, long bid, String dt, String tstamp,
			int seat) {
		this.id = id;
		this.passenger_id = pid;
		this.bus_id = bid;
		this.dt = dt;
		this.tstamp = tstamp;
		this.seat = seat;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(long passenger_id) {
		this.passenger_id = passenger_id;
	}

	public long getBus_id() {
		return bus_id;
	}

	public void setBus_id(long bus_id) {
		this.bus_id = bus_id;
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

	@Override
	public String toString() {
		return "Reserve::[ID=" + id + ",PID=" + passenger_id + ",BID=" + bus_id
				+ ",Date=" + dt + ",Time Stamp=" + tstamp + ",Seat=" + seat
				+ "]";
	}

}
