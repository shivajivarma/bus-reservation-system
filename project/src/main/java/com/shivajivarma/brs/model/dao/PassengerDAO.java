package com.shivajivarma.brs.model.dao;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Passenger;

//CRUD operations
public interface PassengerDAO {
   
  //Create
  public void save(Passenger employee);
  
  //Read
  public Passenger findById(int id) throws EmptyResultDataAccessException;
  public Passenger findByUsername(String username) throws EmptyResultDataAccessException;

}