package com.shivajivarma.brs.ui;

import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class StylesAndHelperMethods {
	
	/* Display position */
	public static final int POSITION_X=50;
	
	
	/* Fonts */
	public static final Font FONT_HEADER=new Font("Copperplate Gothic Bold",Font.BOLD,32);
	public static final Font FONT_NORMAL=new Font("Arial",Font.PLAIN,20);
	public static final Font FONT_SMALL=new Font("Arial",Font.PLAIN,18);
	public static final Font FONT_BANNER=new Font("Times New Roman",Font.BOLD,40);
	
	/* Label heights */
	public static final int HEIGHT_HEADER=28;	
	public static final int HEIGHT_NORMAL=20;
	
	public static final boolean isNumber(String str){
		return Pattern.matches("[0-9]*",str);
	}
	
	public static final boolean isEmpty(String str){
		if(str.equals("")) return true;
		else return false;
	}
	
	public static final boolean isEmpty(char[] c){
		if(String.valueOf(c).equals("")) return true;
		else return false;
	}
	
	public static final void errorMessage(String mesg){
		JOptionPane.showMessageDialog(null, mesg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static final void successMessage(String mesg){
		JOptionPane.showMessageDialog(null, mesg, "Success", JOptionPane.PLAIN_MESSAGE);
	}
	
}
