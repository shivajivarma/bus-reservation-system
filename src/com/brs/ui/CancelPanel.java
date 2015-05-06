package com.brs.ui;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import com.brs.application.Passenger;

public class CancelPanel extends JPanel{

	private static final long serialVersionUID = -5093905890888022713L;
	
	JLabel lTid;
	JTextField tfTid;
	JButton btnSubmit;
	CancelPanel self;

	public CancelPanel() {
		self = this;
		setLayout(null);
		setBackground(Color.white);

		lTid = new JLabel("Enter your Ticket ID:");
		lTid.setBounds(50, 40, 200, 20);
		lTid.setFont(StylesAndHelperMethods.FONT_NORMAL);

		tfTid = new JTextField();
		tfTid.setBounds(270, 38, 150, 30);
		tfTid.setFont(StylesAndHelperMethods.FONT_NORMAL);

		btnSubmit = new JButton("Cancel Ticket");
		btnSubmit.setBounds(330, 100, 200, 40);
		btnSubmit.setFont(StylesAndHelperMethods.FONT_NORMAL);

		add(lTid);
		add(tfTid);
		add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				if (tfTid.getText().equals("")) {
					StylesAndHelperMethods.errorMessage("Enter ticket number");
				}else{
					try {
						if (Passenger.session.cancelTicket(tfTid.getText())) {
							StylesAndHelperMethods.successMessage("Cancellation Successful");
							self.reset();
						} else{
							StylesAndHelperMethods.errorMessage("Tid is not valid");
						}
					} catch (NumberFormatException ne) {
						StylesAndHelperMethods.errorMessage("Please use only numbers.");
						self.reset();
					}
				}

			}

		});
	}
	
	void reset(){
			tfTid.setText(null);
			self.setVisible(true);
		}

}
