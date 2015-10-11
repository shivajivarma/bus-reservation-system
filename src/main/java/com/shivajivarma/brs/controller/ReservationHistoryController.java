package com.shivajivarma.brs.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shivajivarma.brs.model.bean.ReservationBean;
import com.shivajivarma.brs.model.service.ReserveService;
import com.shivajivarma.brs.ui.ReservationHistoryTabView;
import com.shivajivarma.brs.ui.View;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class ReservationHistoryController implements Controller {

	private ReservationHistoryTabView historyTab;
	private ReserveService reserveService;
	private int pid;
	private List<ReservationBean> reservationsList;

	public ReservationHistoryController(View historyTab) {
		this.historyTab = (ReservationHistoryTabView) historyTab;
	}

	public void control(Controller parentController) {

		pid = ((HomeTabsMediator)parentController).getPassengerService().getModel().getId();
		/*
		 * Populate table
		 */
		this.populateReservationHistoryTable();

		historyTab.getPrintButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				List<ReservationBean> tickets = new ArrayList<ReservationBean>();
				
				int i=0;
				for (ReservationBean reservationBean : reservationsList) {	
					if(historyTab.isRowSelected(i)){						
						tickets.add(reservationBean);
					}
					i++;
				}
				reserveService.printTickets(tickets);
			}

		});
	}

	protected void populateReservationHistoryTable() {
		if (reserveService == null) {
			reserveService = new ReserveService();
		}
		
		historyTab.clearTable();
		try {
			reservationsList = reserveService
					.getReservationHistory(pid);

			for (ReservationBean reservationBean : reservationsList) {
				historyTab
						.addTableRow(String.valueOf(reservationBean.getId()),
								String.valueOf(reservationBean.getBusID()),
								reservationBean.getDt(),
								reservationBean.getOrigin(),
								reservationBean.getDestination(),
								reservationBean.getDeparturetime(),
								reservationBean.getArrivaltime(),
								String.valueOf(reservationBean.getSeat()));
			}

		} catch (EmptyResultDataAccessException e) {
			System.out.print("No reservation history");
		}
	}

}