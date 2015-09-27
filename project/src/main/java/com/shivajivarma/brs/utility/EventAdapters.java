package com.shivajivarma.brs.utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventAdapters{

	public static class ActionAdapter implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {}
	
	}
	
	public static class ItemAdapter implements ItemListener{
		
		public void itemStateChanged(ItemEvent e) {}
	
	}
	
	public static class KeyAdapter implements KeyListener{
	
	    public void keyPressed(KeyEvent e) {}
	
		public void keyTyped(KeyEvent e) {}
		
		public void keyReleased(KeyEvent e) {}
	
	}
}