package com.shivajivarma.brs.model.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.shivajivarma.brs.model.entity.Reserve;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class ReserveDAOImpl extends BaseDAO implements ReserveDAO {
		
	
	public ReserveDAOImpl(){
		this.table = Reserve.indentity;
	}
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
        Reserve reserve = (Reserve) getJdbcTemplate().queryForObject(query, 
        		new Object[] { id }, 
				new BeanPropertyRowMapper<Reserve>(Reserve.class));
       
        return reserve;
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
