package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.entity.Route;
import com.shivajivarma.brs.model.service.RouteService;
import com.shivajivarma.brs.ui.Alert;
import com.shivajivarma.brs.ui.ReservationTabView;
import com.shivajivarma.brs.ui.View;
import com.shivajivarma.brs.utility.DateUtil;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class ReservationController implements Controller {
	
	private ReservationController _this;
	private ReservationTabView reservationTab;
	private RouteService routeService;
	private List<Route> routeStore;

	public ReservationController(View reservationTab) {
		_this = this;
		this.reservationTab = (ReservationTabView) reservationTab;
	}

	public void control(Controller parentController) {

		_this.populateOrigins();

		reservationTab.getSubmitButton().addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				if(reservationTab.getMonthSelectedIndex() == 0){
					Alert.errorMessage("Select month.");
				}
				else if(reservationTab.getYearSeleted() > DateUtil.currentYear()
						|| reservationTab.getMonthSelectedIndex() > DateUtil.currentMonth() 
						|| (reservationTab.getMonthSelectedIndex() == DateUtil.currentMonth() && reservationTab.getDateSelectedIndex() >= DateUtil.currentDay())){	
					
					String date = reservationTab.getSelectedDate() + "-" 
									+ reservationTab.getSelectedMonth() + "-" 
										+reservationTab.getYearSeleted();
					
					Route route = findByDestination(reservationTab.getDestination());
					
					((HomeTabsMediator) parentController).getMasterController().busSelectionControl(route,date);
					
				}
				else {
					Alert.errorMessage("Select a future date.");
				}
			}

		});
		
		reservationTab.getOrigin().addItemListener(new ItemAdapter(){
			
			public void itemStateChanged(ItemEvent e){
				
				if(e.getStateChange()==1){
					reservationTab.clearDestinations();
					_this.populateDestinations((String)reservationTab.getOrigin().getSelectedItem());
				}	
			}
		});
		
		reservationTab.getMonth().addItemListener(new ItemAdapter(){
			
			public void itemStateChanged(ItemEvent e){
				
				if(e.getStateChange()==1){
					reservationTab.clearDate();
					
					int selectedYear = Integer.parseInt(String.valueOf(reservationTab.getYear().getSelectedItem()));
					int selectedMonth = reservationTab.getMonth().getSelectedIndex();
					int maxDayOfMonth = DateUtil.maxDaysOfAMonth(selectedYear, selectedMonth);
					
					for(int i=1;i<=maxDayOfMonth;i++){
						reservationTab.addDate(i);
					}
				}
				reservationTab.getSubmitButton().setVisible(true);
			}
			
		});
	}

	private void populateOrigins() {
		if (routeService == null) {
			routeService = new RouteService();
		}
		
		try {
			List<String> origins = routeService.getOrigins();
			for (String origin : origins) {
				reservationTab.addOrigin(origin);
			}
			
			if(!origins.isEmpty())
				this.populateDestinations(origins.get(0));

		} catch (EmptyResultDataAccessException e) {
			System.out.print("No Origins");
		}
		
	}
	
	private void populateDestinations(String origin) {
		try {
			
			routeStore = routeService.getDestinationsWithRoute(origin);
			for (Route destination : routeStore) {
				reservationTab.addDestination(destination.getDestination());
			}

		} catch (EmptyResultDataAccessException e) {
			System.out.print("No Destinations");
		}
		
	}
	
	private Route findByDestination(String destination) {
		for (Route route : routeStore) {
			if(route.getDestination().equals(destination))
					return route;
		}
		return null;
	}	
	

}