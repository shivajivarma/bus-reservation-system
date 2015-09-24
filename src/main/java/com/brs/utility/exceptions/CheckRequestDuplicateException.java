/**
 * ALL WORKS © SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * CheckRequestDuplicateException.java
 * 
 * This file contains Exception which handles CheckRequestDuplicateException when CheckRequest.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */

package com.brs.utility.exceptions;

/**
 *  Following Class is user defined Exception, This is thrown when check request already exists in database.
 */
public class CheckRequestDuplicateException extends Exception {

	private static final long serialVersionUID = 6864851480969581418L;

	/**
	 * Following function sets message, which is.
	 */
	public CheckRequestDuplicateException() {
		super("Check request already submited. Please check the status");
	}
}
