package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JLabel usernameLabel,errorLabel,passwordLabel;
	private JButton iniSesionButton;
	public LoginPanel() {
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
		usernameTextField.setBounds(284, 130, 250, 34);
		add(usernameTextField);
		usernameTextField.setColumns(10);
		
		usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameLabel.setBounds(55, 129, 129, 34);
		add(usernameLabel);
		
		iniSesionButton = new JButton("Iniciar Sesion");
		iniSesionButton.setBackground(Color.LIGHT_GRAY);
		iniSesionButton.setFont(new Font("Dialog", Font.BOLD, 18));
		iniSesionButton.setBounds(201, 303, 177, 34);
		add(iniSesionButton);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(346, 165, 250, 27);
		add(errorLabel);
		
		passwordLabel = new JLabel("PASSWORD:");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordLabel.setBounds(55, 204, 129, 34);
		add(passwordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
		passwordTextField.setBounds(284, 204, 250, 34);
		add(passwordTextField);
	}
	//anhadimos listeners a los botones de loginPanel	
	public void addActionListener(ActionListener a) {
		iniSesionButton.addActionListener(a);
	}
	public JButton getIniciarSesionButton() {
		return iniSesionButton;
	}
	public void limpiarError() {
		errorLabel.setText("");
	}
	public void error	() {
		errorLabel.setText("Username o password no valido.");
	}
	public void error2() {
		errorLabel.setText("Este usuario ya inicio sesion.");
	}
	public String getUsername() {
		return usernameTextField.getText();
	}
	public String getPassword() {
		return new String(passwordTextField.getPassword());
	}
}
