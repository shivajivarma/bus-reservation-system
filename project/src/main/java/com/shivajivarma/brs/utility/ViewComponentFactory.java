package com.shivajivarma.brs.utility;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class ViewComponentFactory {
	
	public static final Font FONT_HEADER=new Font("Copperplate Gothic Bold",Font.BOLD,32);
	public static final Font FONT_NORMAL=new Font("Arial",Font.PLAIN,20);
	public static final Font FONT_SMALL=new Font("Arial",Font.PLAIN,18);
	public static final Font FONT_LARGE=new Font("Times New Roman",Font.BOLD,40);
	
	/*
	 * Labels
	 */
	public static JLabel createJLabelLarge(String name){
		JLabel label = new JLabel(name);
		label.setFont(FONT_LARGE);
		return label;
	}
	
	public static JLabel createJLabelLarge(String name, int[] coordinates){
		JLabel label = createJLabelLarge(name);
		label.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return label;
	}
	
	public static JLabel createJLabelHeader(String name){
		JLabel label = new JLabel(name);
		label.setFont(FONT_HEADER);
		return label;
	}
	
	public static JLabel createJLabelHeader(String name, int[] coordinates){
		JLabel label = createJLabelHeader(name);
		label.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return label;
	}
	
	public static JLabel createJPanelNormal(String name){
		JLabel label = new JLabel(name);
		label.setFont(FONT_NORMAL);
		return label;
	}
	
	public static JLabel createJLabelNormal(String name, int[] coordinates){
		JLabel label = createJPanelNormal(name);
		label.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return label;
	}
	
	public static JLabel createJLabelSmall(String name){
		JLabel label = new JLabel(name);
		label.setFont(FONT_SMALL);
		return label;
	}
	
	public static JLabel createJLabelSmall(String name, int[] coordinates){
		JLabel label = createJLabelSmall(name);
		label.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return label;
	}
	
	public static JLabel createJLabelImage(String path){
		return new JLabel(new ImageIcon(ViewComponentFactory.class.getResource(path)));
	}
	
	public static ImageIcon createImageIcon(String path){
		return new ImageIcon(ViewComponentFactory.class.getResource(path));
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
	
	/*
	 * Combo boxes
	 */
	
	public static <T> JComboBox<T> createJComboBoxNormal(Class<T> type){
		JComboBox<T> comboBox = new JComboBox<>();
		comboBox.setFont(FONT_NORMAL);
		return comboBox;
	}
	
	public static <T> JComboBox<T> createJComboBoxNormal(int[] coordinates, Class<T> type){
		JComboBox<T> comboBox = createJComboBoxNormal(type);
		comboBox.setBounds(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);
		return comboBox;
	}
}
