/**
 * <Copyright information>
 * 
 * ALL WORKS © SHIVAJI VARMA[contact@shivajivarma.com]
 * 
 * PassengerDAO.java
 * 
 * This file contains PassengerDAO class which helps in accessing and
 * modifying Passenger table in database.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */

package com.brs.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.brs.entity.RouteBean;

/**
 * Following class tries to access and modify AccountDetails table in database.
 * 
 * @version 1.0
 */
public class RouteDAO {

	// Holds database connection object.
	Connection conn;

	/**
	 * Following constructor gets the connection object from DBConnection class
	 * and holds the connection.
	 */
	public RouteDAO() {
		conn = DBConnection.getConnection();
	}
	
	

	/**
	 * Following function retrieves collection of origins between where buses are available for transport.
	 * 
	 * @return Collect object holding set of origins.
	 */
	public Collection<RouteBean> findOrigins() {
		RouteBean rb = null;
		Collection<RouteBean> rbs = new ArrayList<RouteBean>();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery("SELECT DISTINCT(origin) FROM route r,bus b where r.rid=b.rid");
			while (rs.next()) {
				rb = new RouteBean();
				rb.setOrigin(rs.getString("origin"));
				rbs.add(rb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rbs;
	}
	
	/**
	 * Following function retrieves collection of origins between where buses are available for transport.
	 * 
	 * @return Collect object holding set of origins.
	 */
	public Collection<RouteBean> findDestinations(String origin) {
		RouteBean rb = null;
		Collection<RouteBean> rbs = new ArrayList<RouteBean>();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery("SELECT DISTINCT(destination) FROM route r,bus b where r.rid=b.rid AND origin='"+origin+"'");
			while (rs.next()) {
				rb = new RouteBean();
				rb.setDestination(rs.getString("destination"));
				rbs.add(rb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rbs;
	}

}
