package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.bean.ReservationBean;
import com.shivajivarma.brs.model.service.ReserveService;
import com.shivajivarma.brs.model.service.RouteService;
import com.shivajivarma.brs.ui.Alert;
import com.shivajivarma.brs.ui.ReservationHistoryTabView;
import com.shivajivarma.brs.ui.ReservationTabView;
import com.shivajivarma.brs.ui.View;
import com.shivajivarma.brs.utility.DateUtil;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class ReservationController implements Controller {

	private ReservationTabView reservationTab;
	private RouteService routeService;

	public ReservationController(View reservationTab) {
		this.reservationTab = (ReservationTabView) reservationTab;
	}

	public void control(Controller parentController) {

		//pid = ((HomeTabsMediator)parentController).getPassengerService().getModel().getId();
		/*
		 * Populate table
		 */
		this.populateFields();

		reservationTab.getSubmitButton().addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
					if(reservationTab.getMonthSelectedIndex() == 0){
						Alert.errorMessage("Select month.");
					}
					else if(reservationTab.getYearSelectedIndex() > DateUtil.currentYear()
							|| reservationTab.getMonthSelectedIndex() > DateUtil.currentMonth() 
							|| (reservationTab.getMonthSelectedIndex() == DateUtil.currentMonth() && reservationTab.getDateSelectedIndex() >= DateUtil.currentDay())){	
						
						String date = reservationTab.getDateSelectedIndex() + "-" 
										+ reservationTab.getMonthSelectedIndex() + "-" 
											+reservationTab.getYearSelectedIndex();
						
						//mainFrame.availableBusesPage(PassengerService.dbApplicationContext.availableBuses(cbOrigin.getSelectedItem().toString(), cbDestination.getSelectedItem().toString(),date), date);
					}
					else {
						Alert.errorMessage("Select a future date.");
					}
			
			}

		});
	}

	private void populateFields() {
		if (routeService == null) {
			routeService = new RouteService();
		}
		
		try {
			List<String> origins = routeService.getOrigins();
			for (String origin : origins) {
				reservationTab.addOrigin(origin);
			}
			
			/*List<String> destinations = routeService.getDestinations(origin);
			for (String destination : destinations) {
				reservationTab.addDestination(destination);
			}*/

		} catch (EmptyResultDataAccessException e) {
			System.out.print("No reservation history");
		}
		
	}

}