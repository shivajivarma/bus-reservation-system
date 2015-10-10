package com.shivajivarma.brs.ui;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
@SuppressWarnings("serial")
public abstract class BaseView extends JPanel{
	
	ArrayList<JTextField> inputFields;
	
	public BaseView() {
		this.setLayout(null);
		this.inputFields = new ArrayList<JTextField>();
	}
	
	/**
	 * Clears all input and repaints the panel.
	 */
	public void refresh(){
		inputFields.forEach(field -> field.setText(null));
		this.revalidate();
	}
}