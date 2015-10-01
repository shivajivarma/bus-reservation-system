package com.shivajivarma.brs.model;

/**
 * The Bean class, which holds reservation details.
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 * @see ReserveService
 */
public class Reserve{
	
	public static final String indentity = "Reserve";
	
	private long id;
	private long pid;
	private long bid;
	private String dt;
	private String tstamp;
	private int seat;
	
	public Reserve(){
	}
	
	public Reserve(long id, long pid, long bid, String dt, String tstamp, int seat) {
		this.id = id;
		this.pid = pid;
		this.bid = bid;
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

	
	//private Passenger pb = new Passenger();
		//private BusBean bb = new BusBean();
		
	/*public long getPid() {
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
	}*/
	
	/* BusBean */
	/*public long getBid() {
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
	}*/
	

}

