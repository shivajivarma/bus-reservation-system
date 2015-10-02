package com.shivajivarma.brs.model.entity;

/**
 * The Bean class, which holds route details.
 * 
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class Route implements Entity {

	public static final String indentity = "Route";
	
	private long id;
	private String origin;
	private String destination;

	public Route() {
	}

	public Route(long id, String origin, String destination) {
		this.id = id;
		this.origin = origin;
		this.destination = destination;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Route::[ID=" + id + ",ORIGIN=" + origin + ",DESTINATION="
				+ destination + "]";
	}
}
