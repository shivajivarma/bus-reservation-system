package com.shivajivarma.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Route;
import com.shivajivarma.brs.model.entity.Bus;

/**
 * CRUD operations for bus table.
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public interface BusDAO {
  
  //Read
  public List<Bus> findByRouteAndDate(Route route, String date) throws EmptyResultDataAccessException;

}