/**
 * <Copyright information>
 * 
 * ALL WORKS © SHIVAJI VARMA[contact@shivajivarma.com]
 * 
 * AccountDetails.java
 * 
 * This files contains AccountDetails bean class.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */
package com.brs.entity;

/**
 * 
 * This is Bean class, which holds all the route details.
 *
 */
public class RouteBean{
	
	private long rid;
	private String origin;
	private String destination;
	
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
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
	
}

