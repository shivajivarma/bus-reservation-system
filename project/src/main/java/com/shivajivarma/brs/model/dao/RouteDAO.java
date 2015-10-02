package com.shivajivarma.brs.model.dao;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

//CRUD operations
public interface RouteDAO {

	// Read
	public List<String> findAllOrigins() throws EmptyResultDataAccessException;
	public List<String> findAllDestinationsByOrigin(String origin) throws EmptyResultDataAccessException;

}