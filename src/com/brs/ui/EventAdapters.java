/**
 * ALL WORKS © SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * ActionAdapter.java
 * 
 * The file contains adapter class for action listener interface.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */
package com.brs.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 
 * This is Adapter class for ActionListener interface,
 *  contains empty actionPerformed Event.
 *
 */
class ActionAdapter implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {}

}

/**
 * 
 * This is Adapter class for ItemListener interface,
 *  contains empty  Event.
 *
 */
class ItemAdapter implements ItemListener{
	
	public void itemStateChanged(ItemEvent arg0) {
	}

}
