package com.shivajivarma.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.bean.ReservationBean;

//CRUD operations
public interface ReservationDAO {
   
	public List<ReservationBean> findByPid(int pid) throws EmptyResultDataAccessException;
  
}