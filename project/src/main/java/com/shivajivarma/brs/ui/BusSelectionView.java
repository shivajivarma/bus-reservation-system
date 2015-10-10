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
public class BusSelectionView extends BaseView implements View {
		
	private static final long serialVersionUID = -8424388738392769666L;
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
		
		public void addBus(long bid, String origin, String destination, String type,String arrtime,String depttime, int count,long fare){
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
		
		public long getSelectedBusId() {
			return Long.parseLong(buses.getSelection().getActionCommand());
		}
		
		/*BRSView mainFrame, Collection<Bus> bbs, String date){	
			/*this.date = date;
			this.bbs = bbs;
			
			ButtonGroup bg=new ButtonGroup();
			setLayout(null);
			
			
			btnSubmit.addActionListener(new ActionAdapter() {
				
				public void actionPerformed(ActionEvent ae) {
					int k;
					Iterator<Bus> irbs = self.bbs.iterator();
					for (k= 0; irbs.hasNext(); k++) {
						Bus bb = irbs.next();
						if(jrbSelectBus[k].isSelected()){
							//mainFrame.seatLayoutPage(PassengerController.session.seatsAvailablity(bb.getBid(),self.date), bb, self.date);
							self.setVisible(false);
							break;
						}
					}
	
					if(k == j){
						StylesAndHelperMethods.errorMessage("Please select a bus");
					}
				}
				
			});
		}*/
}
