package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;

public class LoginPanel extends JPanel {
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(346, 194, 250, 34);
		add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameLabel.setBounds(141, 193, 129, 34);
		add(usernameLabel);
		
		JButton iniSesionButton = new JButton("Iniciar Sesion");
		iniSesionButton.setBackground(Color.LIGHT_GRAY);
		iniSesionButton.setFont(new Font("Dialog", Font.BOLD, 18));
		iniSesionButton.setBounds(172, 381, 177, 34);
		add(iniSesionButton);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(346, 165, 250, 27);
		add(errorLabel);
		
		JLabel passwordLabel = new JLabel("PASSWORD:");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordLabel.setBounds(141, 259, 129, 34);
		add(passwordLabel);
		
		JButton regButton = new JButton("Registrarse");
		regButton.setBackground(new Color(153, 255, 255));
		regButton.setFont(new Font("Dialog", Font.BOLD, 18));
		regButton.setBounds(361, 381, 177, 34);
		add(regButton);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(346, 262, 250, 34);
		add(passwordTextField);

	}
}
