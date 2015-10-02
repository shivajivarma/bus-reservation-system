package com.shivajivarma.brs.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Route;

/**
 * Following class tries to access and modify AccountDetails table in database.
 * 
 * @version 1.0
 */
public class RouteDAOImpl extends BaseDAO implements RouteDAO {
	
	public RouteDAOImpl(){
		this.table = Route.indentity;
	}

	public List<String> findAllOrigins() throws EmptyResultDataAccessException{
		String query = "SELECT DISTINCT(ORIGIN) FROM ROUTE WHERE ID IN (SELECT RID FROM BUS)";
		
		List<Map<String, Object>> rows = 
				getJdbcTemplate().queryForList(query);
		
		List<String> origins = new ArrayList<String>();
		for (Map<String, Object> row : rows) {
			origins.add((String)row.get("ORIGIN"));
		}
		
		return origins;
	}
	
	public List<String> findAllDestinationsByOrigin(String origin) throws EmptyResultDataAccessException{
		String query = "SELECT DISTINCT(DESTINATION) FROM ROUTE"+
						" WHERE ORIGIN = ? AND ID IN (SELECT RID FROM BUS)";
		List<Map<String, Object>> rows = 
				getJdbcTemplate().queryForList(query, new Object[]{origin});
		
		List<String> destinations = new ArrayList<String>();
		for (Map<String, Object> row : rows) {
			destinations.add((String)row.get("DESTINATION"));
		}
		
		return destinations;
	}
	
}
	/**
	 * Following function retrieves collection of origins between where buses are available for transport.
	 * 
	 * @return Collect object holding set of origins.
	 * @throws DBConnectException 
	 */
	/*public Collection<Route> findOrigins() throws DBConnectException {
		Route rb = null;
		Collection<Route> rbs = new ArrayList<Route>();

		try {
			DBConnection.openConnection();
			Statement st = DBConnection.conn.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery("SELECT DISTINCT(origin) FROM route r,bus b where r.rid=b.rid");
			while (rs.next()) {
				rb = new Route();
				rb.setOrigin(rs.getString("origin"));
				rbs.add(rb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rbs;
	}*/
	
	/**
	 * Following function retrieves collection of origins between where buses are available for transport.
	 * 
	 * @return Collect object holding set of origins.
	 * @throws DBConnectException 
	 */
	/*public Collection<Route> findDestinations(String origin) throws DBConnectException {
		Route rb = null;
		Collection<Route> rbs = new ArrayList<Route>();

		try {
			DBConnection.openConnection();
			Statement st = DBConnection.conn.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery("SELECT DISTINCT(destination) FROM route r,bus b where r.rid=b.rid AND origin='"+origin+"'");
			while (rs.next()) {
				rb = new Route();
				rb.setDestination(rs.getString("destination"));
				rbs.add(rb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rbs;
	}*/


