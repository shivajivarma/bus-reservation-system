package com.shivajivarma.brs.model.dao;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Reserve;

//CRUD operations
public interface ReserveDAO {
   
  //Create
 // public void save(Reserve reserve);
  
  //Read
  public Reserve findById(long id) throws EmptyResultDataAccessException;
  //public Reserve findByUsername(String username) throws EmptyResultDataAccessException;
  
  //Update
 // public void update(Passenger employee);
  //Delete
  public void deleteById(long id);
  
  //Get All
 // public List<Passenger> getAll();
}