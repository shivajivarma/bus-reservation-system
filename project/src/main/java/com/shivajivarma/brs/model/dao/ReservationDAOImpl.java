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
		
		List<ReservationBean> reservationBeans = 
				getJdbcTemplate().query(query, 
		        		new Object[] { pid }, 
						new BeanPropertyRowMapper<ReservationBean>(ReservationBean.class));
		return reservationBeans;
	}
}
