package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.Model;
import com.shivajivarma.brs.model.entity.Bus;
import com.shivajivarma.brs.model.entity.Route;
import com.shivajivarma.brs.model.service.BusService;
import com.shivajivarma.brs.ui.BusSelectionView;
import com.shivajivarma.brs.ui.View;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class BusSelectionController implements Controller{
	
	private BusSelectionController _this;
	
	private BusSelectionView busSelectionView;
	private BusService busService;
	private Route route;
	private String date;
	private List<Bus> buses;
	
	
    public BusSelectionController(View busSelectionView, Model route, String date) {
    	_this = this;
    	
    	this.busSelectionView = (BusSelectionView) busSelectionView;
    	this.route = (Route) route;
    	this.date = date;
    }
    
    public void control(Controller parentController){
    	MasterController masterController = (MasterController) parentController;
    	
    	this.populateBuses();
    	
    	busSelectionView.getBackButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				masterController.applicationControl();
			}
		});
    	
    	busSelectionView.getSubmitButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				if(busSelectionView.validateFields()){
					masterController.seatSelectionControl(route, date, _this.searchBus(busSelectionView.getSelectedBusId()));
				}
			}
		});
    	
    }
    
    private void populateBuses() {
		if (busService == null) {
			busService = new BusService();
		}
		
		try {
			buses = busService.findAvailableBuses(route, date);
			for (Bus bus : buses) {
				busSelectionView.addBus(bus.getId(), route.getOrigin(), route.getDestination(), bus.isAc()?"AC":"Non - AC", bus.getArrivalTime(), bus.getDepartureTime(), bus.getAvailablityCount(), bus.getFare());
			}

		} catch (EmptyResultDataAccessException e) {
			System.out.print("No Buses");
		}
		
	}
    
    private Bus searchBus(int bid){
    	for (Bus bus : buses) {
			if(bus.getId() == bid){
				return bus;
			}
		}
    	return null;
    }
    
}