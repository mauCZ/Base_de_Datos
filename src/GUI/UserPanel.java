package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserPanel extends JPanel {
	private JLabel usernameL1,passwordL1,pidL1,actUsername,actPassword,actPid;
	private JButton salirButton;
	public UserPanel() {
		setLayout(null);
		
		usernameL1 = new JLabel("USERNAME");
		usernameL1.setHorizontalAlignment(SwingConstants.CENTER);
		usernameL1.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameL1.setBounds(149, 164, 140, 38);
		add(usernameL1);
		
		passwordL1 = new JLabel("PASSWORD");
		passwordL1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordL1.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordL1.setBounds(149, 254, 140, 38);
		add(passwordL1);
		
		pidL1 = new JLabel("P.I.D.");
		pidL1.setHorizontalAlignment(SwingConstants.CENTER);
		pidL1.setFont(new Font("Dialog", Font.BOLD, 18));
		pidL1.setBounds(149, 350, 140, 38);
		add(pidL1);
		
		actUsername = new JLabel("");
		actUsername.setFont(new Font("Dialog", Font.BOLD, 18));
		actUsername.setHorizontalAlignment(SwingConstants.CENTER);
		actUsername.setBounds(370, 164, 209, 38);
		add(actUsername);
		
		actPassword = new JLabel("");
		actPassword.setHorizontalAlignment(SwingConstants.CENTER);
		actPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		actPassword.setBounds(370, 254, 209, 38);
		add(actPassword);
		
		actPid = new JLabel("");
		actPid.setHorizontalAlignment(SwingConstants.CENTER);
		actPid.setFont(new Font("Dialog", Font.BOLD, 18));
		actPid.setBounds(370, 350, 209, 38);
		add(actPid);
		
		salirButton = new JButton("SALIR");
		salirButton.setBackground(new Color(169, 169, 169));
		salirButton.setFont(new Font("Dialog", Font.BOLD, 16));
		salirButton.setBounds(308, 422, 124, 44);
		add(salirButton);

	}
	//anhadimos listeners a los botones de userPanel
	public void addActionListener(ActionListener a) {
		salirButton.addActionListener(a);
	}
	public JButton getSalirButton() {
		return salirButton;
	}
	public JLabel getActUsername() {
		return actUsername;
	}
	public JLabel getActPassword() {
		return actPassword;
	}
	public JLabel getActPID() {
		return actPid;
	}
	public void limpiar() {
		actUsername.setText("");
		actPassword.setText("");
		actPid.setText("");
	}
}
