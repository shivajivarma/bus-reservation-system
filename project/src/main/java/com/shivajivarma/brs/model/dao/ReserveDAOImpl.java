package com.shivajivarma.brs.model.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.shivajivarma.brs.model.Passenger;
import com.shivajivarma.brs.model.Reserve;
import com.shivajivarma.brs.utility.exceptions.CannotDeleteRecordException;

/**
 * Following class tries to access and modify AccountDetails table in database.
 * 
 * @version 1.0
 */
public class ReserveDAOImpl extends BaseDAO implements ReserveDAO {
		
	private static final String table = Reserve.indentity;
	/*
	public void save(Reserve reserve){
		
		String sql = "INSERT INTO "+table+" VALUES(TID_AUTO.NEXTVAL,?,?,?,?,?)";
			 
		getJdbcTemplate().update(sql, 
				new Object[] { 
				reserve.getPid(),
				reserve.getBid(),
				reserve.getDt(),
				reserve.getTstamp(),
				reserve.getSeat()});
			
	}*/
/*	public int create(Reserve rb)  throws  DBConnectException{
		try {
			DBConnection.openConnection();
			PreparedStatement pst = DBConnection.conn.prepareStatement("INSERT INTO reserve VALUES(TID_AUTO.NEXTVAL,?,?,?,?,?)");
				pst.setLong(1, rb.getPid());
				pst.setLong(2, rb.getBid());
				pst.setString(3, rb.getDate());
				pst.setString(4, new SimpleDateFormat("dd/MMM/yyyy").format(Calendar.getInstance().getTime()));
				pst.setInt(5, rb.getSeat());
				pst.executeQuery();
			
				return 1;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return 0;
	}*/
	
	 @Override
    public Reserve findById(long id) throws EmptyResultDataAccessException{
        String query = "select * from "+table+" where id = ?";
        
        //query single row with BeanPropertyRowMapper (Passenger.class)
        Reserve reserve = (Reserve)getJdbcTemplate().queryForObject(query, 
        		new Object[] { id }, 
				new BeanPropertyRowMapper<Reserve>(Reserve.class));
       
        return reserve;
    }

	@Override
	public void deleteById(long id){

		String query = "DELETE FROM "+table+" WHERE id=?";
		
		int out = getJdbcTemplate().update(query, id);
		if(out !=0){
			System.out.println("Reservation deleted with id="+id);
		}
	}
	
	/**
	 * Following function deletes ticket in Reserve table for given passenger id
	 * and ticket id
	 * 
	 * @param customerid
	 * @return '1'- if removal of customer is successful, else returns 0.
	 * @throws DBConnectException
	 * @throws EmptyResultSetException.
	 * 
	 */
	/*public int remove(Reserve rb) throws EmptyResultSetException, DBConnectException {
		try {
			DBConnection.openConnection();
			Statement st = DBConnection.conn.createStatement();
			int noOfRowsDeleted = st
					.executeUpdate("DELETE FROM reserve WHERE tid="
							+ rb.getTid() + " and pid=" + rb.getPid());
			if (noOfRowsDeleted == 0)
				throw new EmptyResultSetException();
			else
				return 1;
		} catch (SQLException e) {
			throw new DBConnectException("Unable to connect to database");
		}
	}

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
	}
	
	
	public Collection<Integer> findSeatsAvailablity(long bid,String date) throws  DBConnectException {
		
		Collection<Integer> occupiedSeats = new ArrayList<Integer>();
		try {
			DBConnection.openConnection();
			PreparedStatement pst = DBConnection.conn.prepareStatement("SELECT seat FROM reserve WHERE bid=? and dt=?");
			pst.setLong(1, bid);
			pst.setString(2, date);
			
			ResultSet rs = pst.executeQuery(); 

			while (rs.next()) {		
				occupiedSeats.add(rs.getInt("SEAT"));
			} 
	
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return occupiedSeats;
	}
*/
}
