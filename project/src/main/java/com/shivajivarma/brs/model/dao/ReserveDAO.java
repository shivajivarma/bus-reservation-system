package com.shivajivarma.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Reserve;

//CRUD operations
public interface ReserveDAO {
   
  //Create
  public int save(Reserve reserve);
  
  //Read
  public int findNewId();
  public Reserve findById(long id) throws EmptyResultDataAccessException;
  
  //Delete
  public void deleteById(long id);
  
  //Get All
  public List<Integer> getSeatNumbersByBusAndDate(long bid, String date) throws EmptyResultDataAccessException;
}