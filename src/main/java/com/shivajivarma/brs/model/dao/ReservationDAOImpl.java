package com.shivajivarma.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.shivajivarma.brs.model.bean.ReservationBean;

/**
 * CRUD operations for reservation view.
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class ReservationDAOImpl extends BaseDAO implements ReservationDAO {
		
	
	public ReservationDAOImpl(){
		this.table = ReservationBean.indentity;
	}
	
	public List<ReservationBean> findByPid(int passengerID) throws EmptyResultDataAccessException{
		
		String query = "select * from "+table+" where passengerid = ?";
		
		List<ReservationBean> reservationBeans = 
				getJdbcTemplate().query(query, 
		        		new Object[] { passengerID }, 
						new BeanPropertyRowMapper<ReservationBean>(ReservationBean.class));
		return reservationBeans;
	}
}
