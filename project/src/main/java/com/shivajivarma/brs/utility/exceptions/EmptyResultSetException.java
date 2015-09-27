/**
 * ALL WORKS � SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * EmptyResultSetException.java
 * 
 * This file contains EmptyResultSetException class.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */


package com.shivajivarma.brs.utility.exceptions;

/**
 * Exception to indicate that no tuples are retrieved.
 */

public class EmptyResultSetException extends Exception{
	
	private static final long serialVersionUID = 773679854272490979L;

	/**
	 *  Constructs a EmptyResultSetException
	 */
	public EmptyResultSetException() {
		super("No Tuples Founds in database");
	}
}
