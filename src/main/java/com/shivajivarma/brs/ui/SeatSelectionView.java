package com.shivajivarma.brs.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import com.shivajivarma.brs.utility.ViewComponentFactory;
import com.shivajivarma.brs.utility.constants.Labels;
import com.shivajivarma.brs.utility.constants.ResourcePaths;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public class SeatSelectionView extends BaseView implements View{

	private List<JCheckBox> seats = new ArrayList<JCheckBox>();
	private List<JLabel> icons = new ArrayList<JLabel>();
	
	private static ImageIcon disabledSeat = ViewComponentFactory.createImageIcon(ResourcePaths.REDSEAT),
			availableSeat = ViewComponentFactory.createImageIcon(ResourcePaths.GREENSEAT);
	private JButton bookButton, backButton;
	private int i=0,j=1;
	
	public SeatSelectionView(){
		this.initializeComponents();
	}
	
	private void initializeComponents(){
		bookButton = ViewComponentFactory.createJButtonNormal(Labels.BOOK, new int[]{10,0,90,30});
		backButton = ViewComponentFactory.createJButtonNormal(Labels.BACK, new int[]{10,60,90,30});
		
		for (int i =1 ; i <=40; i++) {
			this.addSeat();
		}
		
		this.add(bookButton);
		this.add(backButton);
	}

	public JButton getBookButton() {
		return bookButton;
	}

	public JButton getBackButton() {
		return backButton;
	}
	
	public void addSeat(){
		JCheckBox seat = new JCheckBox();
		JLabel icon = new JLabel(availableSeat);
		
		seat.setEnabled(true);
		seat.setBounds(j*200,30+(i*50),20,20);
		seat.setActionCommand(Integer.toString((i*4)+j));
		seats.add(seat);
		
		icon.setBounds(22+(j*200),10+(i*50),70,70);
		icons.add(icon);
	
		this.add(seat);
		this.add(icon);
		this.add(ViewComponentFactory.createJLabelNormal(Integer.toString((i*4)+j), new int[]{70+(j*200),20+(i*50),30,20}));
		
		if(j==4){
			j=1;
			i++;
		} else{
			j++;
		}
	}
	
	public void disableSeat(int seatNumber){
		seats.get(seatNumber-1).setEnabled(false);
		icons.get(seatNumber-1).setIcon(disabledSeat);
	}

	public List<JCheckBox> getSeats() {
		return seats;
	}
	
}