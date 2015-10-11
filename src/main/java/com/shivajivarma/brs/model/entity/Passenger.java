package com.shivajivarma.brs.model.entity;

/**
 * The Bean class, which holds passenger properties.
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 * @see PassengerService
 */
public class Passenger implements Entity{
	
	public static final String indentity = "Passenger";
	
	private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	private long mobile;

	public Passenger() {
	}

	public Passenger(int id, String username, String password, String name, String email, long mobile) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "Passenger::[ID=" + id + ",Name=" + name + ",Username=" + username
				+ ",Password=" + password + ",Name=" + name + ",Email=" + email
				+ ",Mobile=" + mobile + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
