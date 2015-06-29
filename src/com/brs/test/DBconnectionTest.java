package com.brs.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.brs.utility.DBConnection;
import com.brs.utility.exceptions.DBConnectException;

public class DBconnectionTest {

	@Test
	public void test1() throws SQLException, DBConnectException {
		DBConnection conn = new DBConnection();
		
		assertFalse(DBConnection.getConnection().isClosed());
		
	}
	
	@Test
	public void test() throws SQLException, DBConnectException {
		DBConnection conn = new DBConnection();
		
		assertFalse(DBConnection.getConnection().isClosed());
		
	}
}
