package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JLabel usernameLabel,errorLabel,passwordLabel;
	private JButton iniSesionButton,regButton;
	public LoginPanel() {
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(346, 194, 250, 34);
		add(usernameTextField);
		usernameTextField.setColumns(10);
		
		usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameLabel.setBounds(141, 193, 129, 34);
		add(usernameLabel);
		
		iniSesionButton = new JButton("Iniciar Sesion");
		iniSesionButton.setBackground(Color.LIGHT_GRAY);
		iniSesionButton.setFont(new Font("Dialog", Font.BOLD, 18));
		iniSesionButton.setBounds(172, 381, 177, 34);
		add(iniSesionButton);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(346, 165, 250, 27);
		add(errorLabel);
		
		passwordLabel = new JLabel("PASSWORD:");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordLabel.setBounds(141, 259, 129, 34);
		add(passwordLabel);
		
		regButton = new JButton("Registrarse");
		regButton.setBackground(new Color(153, 255, 255));
		regButton.setFont(new Font("Dialog", Font.BOLD, 18));
		regButton.setBounds(361, 381, 177, 34);
		add(regButton);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(346, 262, 250, 34);
		add(passwordTextField);

	}
	//anhadimos listeners a los botones de loginPanel	
	public void addActionListener(ActionListener a) {
		iniSesionButton.addActionListener(a);
		regButton.addActionListener(a);
	}
	public JButton getIniciarSesionButton() {
		return iniSesionButton;
	}
	public JButton getRegistrarseButton() {
		return regButton;
	}
	public void limpiarError() {
		errorLabel.setText("");
	}
	public void error() {
		errorLabel.setText("Username o password no valido.");
	}
}
