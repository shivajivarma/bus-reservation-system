package com.shivajivarma.brs.utility;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author: Shivaji Varma (contact@shivajivarma.com)
 */
public class ViewComponentFactory {
	
	public static final Font FONT_HEADER=new Font("Copperplate Gothic Bold",Font.BOLD,32);
	public static final Font FONT_NORMAL=new Font("Arial",Font.PLAIN,20);
	public static final Font FONT_SMALL=new Font("Arial",Font.PLAIN,18);
	public static final Font FONT_LARGE=new Font("Times New Roman",Font.BOLD,40);
	
	/*
	 * Labels
	 */
	public static JLabel createJPanelLarge(String name){
		JLabel label = new JLabel(name);
		label.setFont(FONT_LARGE);
		return label;
	}
	
	public static JLabel createJPanelLarge(String name, int[] coordinates){
		JLabel label = createJPanelLarge(name);
		label.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return label;
	}
	
	public static JLabel createJPanelHeader(String name){
		JLabel label = new JLabel(name);
		label.setFont(FONT_HEADER);
		return label;
	}
	
	public static JLabel createJPanelHeader(String name, int[] coordinates){
		JLabel label = createJPanelHeader(name);
		label.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return label;
	}
	
	public static JLabel createJPanelNormal(String name){
		JLabel label = new JLabel(name);
		label.setFont(FONT_NORMAL);
		return label;
	}
	
	public static JLabel createJPanelNormal(String name, int[] coordinates){
		JLabel label = createJPanelNormal(name);
		label.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return label;
	}
	
	public static JLabel createJPanelSmall(String name){
		JLabel label = new JLabel(name);
		label.setFont(FONT_SMALL);
		return label;
	}
	
	public static JLabel createJPanelSmall(String name, int[] coordinates){
		JLabel label = createJPanelSmall(name);
		label.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return label;
	}
	
	public static JLabel createJPanelImage(String path){
		if(path != null){
			return new JLabel(new ImageIcon(ViewComponentFactory.class.getResource(path)));
		}
		return null;
	}
	
	/*
	 * Buttons
	 */
	public static JButton createJButtonNormal(String name){
		JButton button = new JButton(name);
		button.setFont(FONT_NORMAL);
		return button;
	}
	
	public static JButton createJButtonNormal(String name, int[] coordinates){
		JButton button = createJButtonNormal(name);
		button.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return button;
	}
	
	/*
	 * Text fields
	 */
	public static JTextField createJTextFieldNormal(){
		JTextField textField = new JTextField();
		textField.setFont(FONT_NORMAL);
		return textField;
	}
	
	public static JTextField createJTextFieldNormal(int[] coordinates){
		JTextField textField = createJTextFieldNormal();
		textField.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return textField;
	}
	
	public static JPasswordField createJPasswordFieldNormal(){
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(FONT_NORMAL);
		return passwordField;
	}
	
	public static JPasswordField createJPasswordFieldNormal(int[] coordinates){
		JPasswordField passwordField = createJPasswordFieldNormal();
		passwordField.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return passwordField;
	}
}