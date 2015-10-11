package com.shivajivarma.brs.ui;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public class BusSelectionView extends BaseView implements View {
		
	private int i=0;
	private JButton submitButton,backButton;
	private ButtonGroup buses;
		
		public BusSelectionView(){
			this.initializeLabels();
			this.initializeComponents();
		}
		
		private void initializeLabels() {
			JLabel temp;
			temp = ViewComponentFactory.createJLabelNormal("B Id          Orgin        Destination    Type           Dept Tm        Arr tm        Availability          Fare", new int[]{85,10,850,20});
			temp.setForeground(Color.BLUE);
			this.add(temp);
		}
		
		private void initializeComponents() {
			submitButton = ViewComponentFactory.createJButtonNormal(Labels.SUBMIT, new int[]{500,500,100,40});
			backButton = ViewComponentFactory.createJButtonNormal(Labels.BACK, new int[]{300, 500, 100, 40});
			buses = new ButtonGroup();
			
			this.add(submitButton);
			this.add(backButton);
		}
		
		public void addBus(int bid, String origin, String destination, String type,String arrtime,String depttime, int count,int fare){
			this.add(ViewComponentFactory.createJLabelNormal(bid+"        "+
															origin+"       "+
															destination+"      "+
															type+"        "+
															arrtime+"       "+
															depttime+"        "+
															count+"             Rs. "+fare, new int[]{85,50+i,850,20}));
			
			JRadioButton busRadioButton = new JRadioButton();
			busRadioButton.setActionCommand(String.valueOf(bid));
			busRadioButton.setBounds(30,50+i,20,20);
			
			buses.add(busRadioButton);
			this.add(busRadioButton);
			i=i+30;
		}

		public JButton getSubmitButton() {
			return submitButton;
		}

		public JButton getBackButton() {
			return backButton;
		}

		public boolean validateFields() {
			return buses.getSelection() != null;
		}
		
		public int getSelectedBusId() {
			return Integer.parseInt(buses.getSelection().getActionCommand());
		}

}
