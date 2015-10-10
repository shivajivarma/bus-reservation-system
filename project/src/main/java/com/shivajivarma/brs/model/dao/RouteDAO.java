package com.shivajivarma.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Route;

//CRUD operations
public interface RouteDAO {

	// Read
	public List<String> findAllOrigins() throws EmptyResultDataAccessException;
	public List<Route> findByOrigin(String origin) throws EmptyResultDataAccessException;

}