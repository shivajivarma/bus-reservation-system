/**
 * ALL WORKS � SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * DBConnectException.java
 * 
 * This file contains DBConnection class with helps in connecting to database.
 * 
 * Version 1.0
 * 
 * Created on 31 AUG 2012
 * 
 * <Modification History>
 */

package com.shivajivarma.brs.utility.exceptions;

public class DBConnectException extends Exception{
	
	private static final long serialVersionUID = 6711653909817790078L;

	public DBConnectException(String mesg) {
		super(mesg);
	}
	
}
