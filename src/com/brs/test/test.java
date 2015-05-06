package com.brs.test;

import Bus.DBConnect;

import com.brs.utility.DBConnection;
import com.brs.utility.exceptions.DBConnectException;

public class test {
	public static void main(String[] args) throws DBConnectException{
		new DBConnection();
		new DBConnect().reserveTicket(120, 1001, "10/12/2015", 4);
		System.out.println("test");
	}
}
