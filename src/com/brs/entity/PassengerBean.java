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
 * This is Bean class, which holds all the passenger details.
 *
 */
public class PassengerBean{
	
	private long pid;
	private String username;
	private String password;
	private String name;
	private String email;
	private long mobile;
	
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
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

