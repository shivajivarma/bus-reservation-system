package com.shivajivarma.brs.model.dao;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.Passenger;

//CRUD operations
public interface PassengerDAO {
   
  //Create
  public void save(Passenger employee);
  
  //Read
  public Passenger findById(int id) throws EmptyResultDataAccessException;
  public Passenger findByUsername(String username) throws EmptyResultDataAccessException;
  
  //Update
 // public void update(Passenger employee);
  //Delete
 // public void deleteById(int id);
  //Get All
 // public List<Passenger> getAll();
}