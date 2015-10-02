package com.shivajivarma.brs.ui;

import java.awt.Color;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JComboBox;

import com.shivajivarma.brs.utility.DateUtil;
import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
@SuppressWarnings("serial")
public class ReservationTabView extends BaseView implements View{//
	JButton submitButton;
	JComboBox<String> origin, destination, date, month, year;
	
	int x=200,y=40;
	
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
		origin = ViewComponentFactory.createJComboBoxNormal(new int[]{x,y+50,200,30});
		destination = ViewComponentFactory.createJComboBoxNormal(new int[]{x+300,y+50,200,30});
		date = ViewComponentFactory.createJComboBoxNormal(new int[]{x+480,y+180,100,30});
		month = ViewComponentFactory.createJComboBoxNormal(new int[]{x+310,y+180,150,30});
		year = ViewComponentFactory.createJComboBoxNormal(new int[]{x+220,y+180,70,30});
		
		month.addItem("Select a month");
		for(int i=1;i<=12;i++)
			month.addItem(Month.of(i).toString());
		
		year.addItem(String.valueOf(DateUtil.currentYear()));
		year.addItem(String.valueOf(DateUtil.currentYear()+1));

		submitButton = ViewComponentFactory.createJButtonNormal(Labels.SUBMIT, new int[]{x+360,y+420,110,40});
		
		this.add(origin);
		this.add(destination);
		this.add(date);
		this.add(month);
		this.add(year);
	}
		/*		/*throws DBConnectException{
		
		this.mainFrame = mainFrame;
		
			
		
		cbOrigin=new JComboBox<String>();
		Iterator<Route> originIterator = new RouteDAO().findOrigins().iterator();
		do{
			Route rb = originIterator.next();
			cbOrigin.addItem(rb.getOrigin());
		}while(originIterator.hasNext());
		cbOrigin.setBounds(x+0,y+50,200,30);
		cbOrigin.setFont(StylesAndHelperMethods.FONT_NORMAL);
		
		cbDestination=new JComboBox<String>();
		Iterator<Route> destinationIteration = new RouteDAO().findDestinations(cbOrigin.getSelectedItem().toString()).iterator();
		do{
			Route rb = destinationIteration.next();
			cbDestination.addItem(rb.getDestination());
		}while(destinationIteration.hasNext());		
		
		cbOrigin.addItemListener(new ItemAdapter(){
			
			public void itemStateChanged(ItemEvent e){
				
				if(e.getStateChange()==1){
					cbDestination.removeAllItems();
					Iterator<Route> destinationIteration;
					try {
						destinationIteration = new RouteDAO().findDestinations(cbOrigin.getSelectedItem().toString()).iterator();
					
					do{
						Route rb = destinationIteration.next();
						cbDestination.addItem(rb.getDestination());
					}while(destinationIteration.hasNext());
				
					} catch (DBConnectException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
		cbMonth.addItemListener(new ItemAdapter(){
			
			public void itemStateChanged(ItemEvent e){
				
					cbDate.removeAllItems();
					if((e.getItem().equals("January"))||(e.getItem().equals("March"))||(e.getItem().equals("May"))||(e.getItem().equals("July"))||(e.getItem().equals("August"))||(e.getItem().equals("October"))||(e.getItem().equals("December"))){
						for(int i=1;i<=31;i++){
							cbDate.addItem(new Integer(i));
						}
					}
					else if((e.getItem().equals("April"))||(e.getItem().equals("June"))||(e.getItem().equals("September"))||(e.getItem().equals("November"))){
						for(int i=1;i<=30;i++){
							cbDate.addItem(new Integer(i));
						}
					}
					else if(e.getItem().equals("February")){
						for(int i=1;i<=29;i++){
							cbDate.addItem(new Integer(i));
						}
					}
					
					add(btnSubmit);
					add(cbDate);	
			}
			
		});
		
		btnSubmit.addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				if(cbMonth.getSelectedIndex()==0){
					StylesAndHelperMethods.errorMessage("Select month.");
				}
				else if(Integer.parseInt(cbYear.getSelectedItem().toString()) > StylesAndHelperMethods.currentYear()
						|| cbMonth.getSelectedIndex()>StylesAndHelperMethods.currentMonth() 
						|| ( cbMonth.getSelectedIndex()==StylesAndHelperMethods.currentMonth() && cbDate.getSelectedIndex() >= StylesAndHelperMethods.currentDay())
						){	
					
					String date = cbDate.getSelectedItem()+"-"+cbMonth.getSelectedItem()+"-"+cbYear.getSelectedItem();
					mainFrame.availableBusesPage(PassengerService.dbApplicationContext.availableBuses(cbOrigin.getSelectedItem().toString(), cbDestination.getSelectedItem().toString(),date), date);
				}
				else {
					StylesAndHelperMethods.errorMessage("Select a future date.");
				}
			}
			
		});
		*/
	
	public void addOrigin(String origin){
		this.origin.addItem(origin);
	}
	
	public void addDestination(String destination){
		this.destination.addItem(destination);
	}
	
	public int getMonthSelectedIndex() {
		return month.getSelectedIndex();
	}
	
	public int getDateSelectedIndex() {
		return date.getSelectedIndex();
	}
	
	public int getYearSelectedIndex() {
		return year.getSelectedIndex();
	}
	
	public JButton getSubmitButton() {
		return submitButton;
	}
	
}

