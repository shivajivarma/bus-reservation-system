package com.shivajivarma.brs.ui;

import java.awt.Color;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JComboBox;

import com.shivajivarma.brs.utility.DateUtil;
import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public class ReservationTabView extends BaseView implements View{
	
	private JButton submitButton;
	private JComboBox<String> origin, destination, month;
	private JComboBox<Integer> date, year;
	private int x=200,y=40;
	
	public ReservationTabView(){
		this.setBackground(Color.white);
		this.setBounds(0,0,1024,500);
		this.initializeLabels();
		this.initializeComponents();
	}
	
	private void initializeLabels() {
		this.add(ViewComponentFactory.createJLabelNormal(Labels.ORIGIN, new int[]{x,y,70,30}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.DESTINATION, new int[]{x+300,y,200,30}));
		this.add(ViewComponentFactory.createJLabelNormal(Labels.DESTINATION, new int[]{x,y+180,240,30}));
	}
	
	private void initializeComponents() {
		origin = ViewComponentFactory.createJComboBoxNormal(new int[]{x,y+50,200,30}, String.class);
		destination = ViewComponentFactory.createJComboBoxNormal(new int[]{x+300,y+50,200,30}, String.class);
		date = ViewComponentFactory.createJComboBoxNormal(new int[]{x+480,y+180,100,30}, Integer.class);
		month = ViewComponentFactory.createJComboBoxNormal(new int[]{x+310,y+180,150,30}, String.class);
		year = ViewComponentFactory.createJComboBoxNormal(new int[]{x+220,y+180,70,30}, Integer.class);
		
		month.addItem("Select a month");
		for(int i=1;i<=12;i++)
			month.addItem(Month.of(i).toString());
		
		year.addItem(DateUtil.currentYear());
		year.addItem(DateUtil.currentYear()+1);

		submitButton = ViewComponentFactory.createJButtonNormal(Labels.SUBMIT, new int[]{x+370,y+300,100,40});
		submitButton.setVisible(false);
		
		this.add(origin);
		this.add(destination);
		this.add(date);
		this.add(month);
		this.add(year);
		this.add(submitButton);
	}
	
	public void addOrigin(String origin){
		this.origin.addItem(origin);
	}
	
	public void addDestination(String destination){
		this.destination.addItem(destination);
	}
	
	public void addDate(Integer date){
		this.date.addItem(date);
	}
	
	public void clearDestinations(){
		destination.removeAllItems();
	}
	
	public void clearDate(){
		date.removeAllItems();
	}
	
	public int getMonthSelectedIndex() {
		return month.getSelectedIndex();
	}
	
	public String getSelectedMonth() {
		return month.getSelectedItem().toString();
	}
	
	public int getDateSelectedIndex() {
		return date.getSelectedIndex();
	}
	
	public int getSelectedDate() {
		return Integer.parseInt(date.getSelectedItem().toString());
	}
	
	public int getYearSeleted() {
		return Integer.parseInt(year.getSelectedItem().toString());
	}
	
	public JButton getSubmitButton() {
		return submitButton;
	}

	public JComboBox<String> getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination.getSelectedItem().toString();
	}

	public JComboBox<String> getMonth() {
		return month;
	}
	
	public JComboBox<Integer> getYear() {
		return year;
	}
	
}

