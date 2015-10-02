package com.shivajivarma.brs.model.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.dao.RouteDAO;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class RouteService implements Service {

	/**
	 * Session variable which holds account details of the customer until he
	 * logout.
	 */
	public static ClassPathXmlApplicationContext dbApplicationContext;

	public RouteService() {
		dbApplicationContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	}

	public List<String> getOrigins() throws EmptyResultDataAccessException {

		RouteDAO routeDAO = dbApplicationContext.getBean("routeDAO",RouteDAO.class);

		return routeDAO.findAllOrigins();
	}
	
	public List<String> getDestinations(String origin) throws EmptyResultDataAccessException {

		RouteDAO routeDAO = dbApplicationContext.getBean("routeDAO",RouteDAO.class);

		return routeDAO.findAllDestinationsByOrigin(origin);
	}

	protected void finalize() {
		dbApplicationContext.close();
		dbApplicationContext = null;
	}

}
