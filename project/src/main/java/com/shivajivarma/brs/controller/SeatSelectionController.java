package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.Model;
import com.shivajivarma.brs.model.bean.ReservationBean;
import com.shivajivarma.brs.model.entity.Bus;
import com.shivajivarma.brs.model.entity.Reserve;
import com.shivajivarma.brs.model.entity.Route;
import com.shivajivarma.brs.model.service.PassengerService;
import com.shivajivarma.brs.model.service.ReserveService;
import com.shivajivarma.brs.ui.SeatSelectionView;
import com.shivajivarma.brs.ui.View;
import com.shivajivarma.brs.utility.DateUtil;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class SeatSelectionController implements Controller{
	
	private SeatSelectionController _this;
	
	private SeatSelectionView seatSelectionView;
	private Route route;
	private String date;
	private Bus bus;
	private long pid;
	private ReserveService reserveService;
	private List<ReservationBean> tickets = new ArrayList<ReservationBean>();
	
	
    public SeatSelectionController(View seatSelectionView, Model route, String date, Bus bus) {
    	_this = this;
    	this.seatSelectionView = (SeatSelectionView) seatSelectionView;
    	this.route = (Route) route;
    	this.date = date;
    	this.bus = bus;
    }
    
    public void control(Controller parentController){
    	MasterController masterController = (MasterController) parentController;
    	
    	pid = ((PassengerService) masterController.getPassengerService()).getModel().getId();
    	
    	this.populateSeats();
    	
    	seatSelectionView.getBackButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				masterController.busSelectionControl(route, date);
			}
		});
    	
    	seatSelectionView.getBookButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				if(seatSelectionView.validateFields()){
					for (JCheckBox seat : seatSelectionView.getSeats()) {
						if(seat.isSelected()){
							_this.reserve(Integer.parseInt(seat.getActionCommand()));
						}
					}
					reserveService.printTickets(tickets);
					masterController.applicationControl();
				}
			}
		});
    	

		/*
		btnBook.addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				
			boolean flag=true;
			Reserve rb;
			ArrayList<Reserve> rbs = new ArrayList<Reserve>();
			
			for (int i = 1; i <=40 ; i++) { 
				if(seat[i].isSelected()){
					rb = new Reserve();
					rb.setPid(PassengerService.dbApplicationContext.getSessionPassenger().getId());
					rb.setBusBean(self.bb);
					
					rb.setDate(self.date);
					rb.setSeat(i);
					flag = PassengerService.dbApplicationContext.reserve(rb);
					
					rbs.add(rb);
					if(!flag) 
						break;
				}
			}
			if(flag){
				StylesAndHelperMethods.successMessage("Tickets booked successfully");
				PassengerService.printTickets(rbs);
				mainFrame.homePage();
				self.setVisible(false);
			}
			else{
				StylesAndHelperMethods.errorMessage("Tickets reservation failed.");
			}
		}
		});
		
		*/
    	
    }
    
    private void populateSeats() {
    	if (reserveService == null) {
    		reserveService = new ReserveService();
    	}
		try {
			List<Integer> occupiedSeatNumbers = reserveService.getOccupiedSeatNumbers(bus.getId(), date);
			
			for (Integer occupiedSeat : occupiedSeatNumbers) {
				seatSelectionView.disableSeat(occupiedSeat);
			}	

		} catch (EmptyResultDataAccessException e) {
			System.out.print("No Seats");
		}		
	}
    
    private void reserve(int seatNumber) {
    	if (reserveService == null) {
    		reserveService = new ReserveService();
    	}
		try{
			Reserve reserve = new Reserve();
			reserve.setPid(pid);
			reserve.setBid(bus.getId());
			reserve.setDt(date);
			reserve.setTstamp(DateUtil.getTimeStamp());
			reserve.setSeat(seatNumber);
			int ticketNum = reserveService.reserve(reserve);
			
			reserve.setId(ticketNum);
			
			ReservationBean reservationBean = new ReservationBean(reserve);
			reservationBean.setOrigin(route.getOrigin());
			reservationBean.setDestination(route.getDestination());
			reservationBean.setArrtime(bus.getArrtime());
			reservationBean.setDepttime(bus.getDeptime());
			
			tickets.add(reservationBean);
		} catch (EmptyResultDataAccessException e) {
			System.out.print("Reservation Failed");
		}		
	}
    
    
}