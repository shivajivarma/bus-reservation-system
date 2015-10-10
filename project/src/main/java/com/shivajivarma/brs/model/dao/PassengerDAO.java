package com.shivajivarma.brs.model.dao;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Passenger;

/**
 * CRUD operations for passenger table.
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public interface PassengerDAO {
   
  //Create
  public void save(Passenger employee);
  
  //Read
  public Passenger findById(int id) throws EmptyResultDataAccessException;
  public Passenger findByUsername(String username) throws EmptyResultDataAccessException;

}