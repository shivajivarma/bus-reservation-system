package com.shivajivarma.brs.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Bus;
import com.shivajivarma.brs.model.entity.Route;

/**
 * CRUD operations for bus table.
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class BusDAOImpl extends BaseDAO implements BusDAO{

	private static final String table = Bus.indentity;

	public List<Bus> findByRouteAndDate(Route route, String date) throws EmptyResultDataAccessException{
		
		String query = "select ID,AC,DEPARTURETIME,ARRIVALTIME,FARE,(select 40-count(*) from reserve where busid=bus.id and dt=?)  as AVAILABLITY"+
		" from "+table+
		" where routeid in (select id from route where origin=? and destination=?)";
		
		System.out.println(query);
		
		List<Bus> buses = new ArrayList<Bus>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query,new Object[] {date,route.getOrigin(),route.getDestination()});
		for (Map<String, Object> row : rows) {
			Bus bus = new Bus();
			bus.setId(((BigDecimal) row.get("ID")).longValue());
			bus.setAc(((BigDecimal) row.get("AC")).intValue()==1?true:false);
			bus.setDepartureTime((String)row.get("DEPARTURETIME"));
			bus.setArrivalTime((String)row.get("ARRIVALTIME"));
			bus.setFare(((BigDecimal) row.get("FARE")).intValue());
			bus.setAvailablityCount(((BigDecimal) row.get("AVAILABLITY")).intValue());
			buses.add(bus);
		}
		
		return buses;
	}
		
}
