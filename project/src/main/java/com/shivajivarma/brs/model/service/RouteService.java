package com.shivajivarma.brs.model.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.dao.RouteDAO;
import com.shivajivarma.brs.model.entity.Route;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
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
	
	public List<Route> getDestinationsWithRoute(String origin) throws EmptyResultDataAccessException {

		RouteDAO routeDAO = dbApplicationContext.getBean("routeDAO",RouteDAO.class);

		return routeDAO.findByOrigin(origin);
	}

	protected void finalize() {
		dbApplicationContext.close();
		dbApplicationContext = null;
	}

}
