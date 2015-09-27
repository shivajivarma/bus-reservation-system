
package com.shivajivarma.brs.model;

/**
 * <h1>Passenger</h1>
 * <p>This is a Model class, which holds all the passenger properties.</p>
 * 
 * @author Shivaji Varma (contact@shivajivarma.com)
 */
public class Passenger implements Model{
	
	public static final String indentity = "Passenger";
	
	private long id;
	private String username;
	private String password;
	private String name;
	private String email;
	private long mobile;

	public Passenger() {
	}

	public Passenger(long id, String username, String password, String name, String email, long mobile) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "Passenger::[ID=" + id + ",Name=" + name + ",Username=" + username
				+ ",Password=" + password + ",Name=" + name + ",Email=" + email
				+ ",Mobile=" + mobile + "]";
	}

}