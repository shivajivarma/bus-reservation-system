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
  public Reserve findById(int id) throws EmptyResultDataAccessException;
  
  //Delete
  public void deleteById(int id);
  
  //Get All
  public List<Integer> getSeatNumbersByBusAndDate(int bid, String date) throws EmptyResultDataAccessException;
}