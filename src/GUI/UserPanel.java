package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class UserPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserPanel() {
		setLayout(null);
		
		JLabel usernameL1 = new JLabel("USERNAME");
		usernameL1.setHorizontalAlignment(SwingConstants.CENTER);
		usernameL1.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameL1.setBounds(149, 164, 140, 38);
		add(usernameL1);
		
		JLabel passwordL1 = new JLabel("PASSWORD");
		passwordL1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordL1.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordL1.setBounds(149, 254, 140, 38);
		add(passwordL1);
		
		JLabel pidL1 = new JLabel("P.I.D.");
		pidL1.setHorizontalAlignment(SwingConstants.CENTER);
		pidL1.setFont(new Font("Dialog", Font.BOLD, 18));
		pidL1.setBounds(149, 350, 140, 38);
		add(pidL1);
		
		JLabel actUsername = new JLabel("");
		actUsername.setFont(new Font("Dialog", Font.BOLD, 18));
		actUsername.setHorizontalAlignment(SwingConstants.CENTER);
		actUsername.setBounds(370, 164, 209, 38);
		add(actUsername);
		
		JLabel actPassword = new JLabel("");
		actPassword.setHorizontalAlignment(SwingConstants.CENTER);
		actPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		actPassword.setBounds(370, 254, 209, 38);
		add(actPassword);
		
		JLabel actPid = new JLabel("");
		actPid.setHorizontalAlignment(SwingConstants.CENTER);
		actPid.setFont(new Font("Dialog", Font.BOLD, 18));
		actPid.setBounds(370, 350, 209, 38);
		add(actPid);
		
		JButton salirButton = new JButton("SALIR");
		salirButton.setBackground(new Color(169, 169, 169));
		salirButton.setFont(new Font("Dialog", Font.BOLD, 16));
		salirButton.setBounds(308, 422, 124, 44);
		add(salirButton);

	}

}
