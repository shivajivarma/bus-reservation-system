package com.shivajivarma.brs.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Bus;
import com.shivajivarma.brs.model.entity.Route;

/**
 * Following class tries to access and modify AccountDetails table in database.
 * 
 * @version 1.0
 */
public class BusDAOImpl extends BaseDAO implements BusDAO{

	private static final String table = Bus.indentity;

	/** 
	 * Provides the list of buses from selected origin to selected destination on given date 
	 * */
	public List<Bus> findByRouteAndDate(Route route, String date) throws EmptyResultDataAccessException{
		
		String query = "select ID,AC,DEPTTIME,ARRTIME,FARE,(select 40-count(*) from reserve where bid=bus.id and dt=?)  as AVAILABLITY"+
		" from "+table+
		" where rid in (select id from route where origin=? and destination=?)";
		
		System.out.println(query);
		
		List<Bus> buses = new ArrayList<Bus>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query,new Object[] {date,route.getOrigin(),route.getDestination()});
		for (Map<String, Object> row : rows) {
			Bus bus = new Bus();
			bus.setId(((BigDecimal) row.get("ID")).longValue());
			bus.setAc(((BigDecimal) row.get("AC")).intValue()==1?true:false);
			bus.setDeptime((String)row.get("DEPTTIME"));
			bus.setArrtime((String)row.get("ARRTIME"));
			bus.setFare(((BigDecimal) row.get("FARE")).intValue());
			bus.setAvailablityCount(((BigDecimal) row.get("AVAILABLITY")).intValue());
			buses.add(bus);
		}
		
		return buses;
		/*
		try {
			DBConnection.openConnection();
			PreparedStatement pst = DBConnection.conn.prepareStatement();
			
			pst.setString(1, date);
			pst.setString(2, origin);
			pst.setString(3, destination);			
			
			ResultSet rs = pst.executeQuery(); 
			Bus bb = null;
			Route rob = null;
			while (rs.next()) {
				
				bb = new Bus();
				bb.setBid(rs.getLong("BID"));
				
				rob = new Route();
				rob.setOrigin(rs.getString("ORIGIN"));
				rob.setDestination(rs.getString("DESTINATION"));
				//bb.setRouteBean(rob);
				
				if(rs.getInt("AC") == 1)
					bb.setAc(true);
				else
					bb.setAc(false);
				
				bb.setDeptime(rs.getString("DEPTTIME"));
				bb.setArrtime(rs.getString("ARRTIME"));
				bb.setFare(rs.getInt("FARE"));
				bb.setAvailablityCount(rs.getInt("AvailablityCount"));
				
				bbs.add(bb);
			}
	
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return bbs;*/
	}
		
}
