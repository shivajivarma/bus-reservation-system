package com.shivajivarma.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.shivajivarma.brs.model.bean.ReservationBean;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class ReservationDAOImpl extends BaseDAO implements ReservationDAO {
		
	
	public ReservationDAOImpl(){
		this.table = ReservationBean.indentity;
	}
	
	public List<ReservationBean> findByPid(long pid) throws EmptyResultDataAccessException{
		
		String query = "select * from "+table+" where pid = ?";
		
		List<ReservationBean> history = 
				getJdbcTemplate().query(query, 
		        		new Object[] { pid }, 
						new BeanPropertyRowMapper<ReservationBean>(ReservationBean.class));
		return history;
	}
	  
	
	/*
	public Collection<Reserve> findHistory(long pid) throws  DBConnectException {
		
		Collection<Reserve> rbs = new ArrayList<Reserve>();
		try {
			DBConnection.openConnection();
			PreparedStatement pst = DBConnection.conn.prepareStatement("SELECT r.tid, b.bid, r.dt, ro.origin, ro.destination, b.depttime, b.arrtime, r.seat "+
					"FROM reserve r, bus b, route ro "+
					"WHERE r.bid=b.bid and ro.rid=b.rid and pid=? "+ 
					"ORDER BY tid DESC");
			pst.setLong(1, pid);
			
			ResultSet rs = pst.executeQuery(); 
			Reserve rb = null;
			BusBean bb = null;
			RouteBean rob = null;
			while (rs.next()) {
				rb = new Reserve();
				rb.setTid(rs.getLong("TID"));
				rb.setBid(rs.getLong("BID"));
				rb.setDate(rs.getString("DT"));
				
				bb = rb.getBusBean();
				rob = new RouteBean();
				rob.setOrigin(rs.getString("ORIGIN"));
				rob.setDestination(rs.getString("DESTINATION"));
				bb.setRouteBean(rob);
				bb.setDeptime(rs.getString("DEPTTIME"));
				bb.setArrtime(rs.getString("ARRTIME"));
				rb.setSeat(rs.getInt("SEAT"));
				
				rbs.add(rb);
			} 
	
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rbs;
	}*/
}
