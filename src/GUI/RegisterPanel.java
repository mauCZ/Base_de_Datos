package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPanel extends JPanel {
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JPasswordField confPasswordTextField;
	private JButton registrarseButton,salirButton;
	private JLabel usernameLabel,passwordLabel,confPasswordLabel,regL,errorLabel;
	public RegisterPanel() {
		setLayout(null);
		
		registrarseButton = new JButton("Registrarse");
		registrarseButton.setFont(new Font("Dialog", Font.BOLD, 20));
		registrarseButton.setBounds(181, 398, 158, 44);
		add(registrarseButton);
		
		salirButton = new JButton("Salir");
		salirButton.setBackground(Color.LIGHT_GRAY);
		salirButton.setFont(new Font("Dialog", Font.BOLD, 20));
		salirButton.setBounds(400, 398, 141, 44);
		add(salirButton);
		
		usernameLabel = new JLabel("USERNAME: ");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(120, 151, 193, 36);
		add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Dialog", Font.PLAIN, 18));
		usernameTextField.setBounds(341, 152, 248, 36);
		add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordLabel = new JLabel("PASSWORD: ");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(120, 226, 193, 36);
		add(passwordLabel);
		
		confPasswordLabel = new JLabel("CONFIRM PASSWORD: ");
		confPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confPasswordLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		confPasswordLabel.setBounds(58, 294, 255, 36);
		add(confPasswordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordTextField.setBounds(341, 226, 248, 36);
		add(passwordTextField);
		
		confPasswordTextField = new JPasswordField();
		confPasswordTextField.setFont(new Font("Dialog", Font.PLAIN, 18));
		confPasswordTextField.setBounds(341, 294, 248, 36);
		add(confPasswordTextField);
		
		regL = new JLabel("REGISTRO");
		regL.setFont(new Font("Dialog", Font.BOLD, 20));
		regL.setHorizontalAlignment(SwingConstants.CENTER);
		regL.setBounds(254, 64, 193, 36);
		add(regL);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		errorLabel.setToolTipText("");
		errorLabel.setBounds(341, 112, 248, 34);
		add(errorLabel);
		
		
	}
	//anhadimos listeners a los botones de registerPanel
	public void addActionListener(ActionListener a) {
		registrarseButton.addActionListener(a);
		salirButton.addActionListener(a);
	}
	public JButton getRegistrarseButton() {
		return registrarseButton;
	}
	public JButton getSalirButton() {
		return salirButton;
	}
	public void limpiarErrores() {
		errorLabel.setText("");
	}
	//error cuando intentamos registrarnos con un username que ya existe
	public void error1() {
		errorLabel.setText("Username ya existente, elija otro.");
	}
	//error cuando la conf_cont no es la misma que la cont
	public void error2() {
		errorLabel.setText("Password y confirmacion no son la misma.");
	}
	//error cuando username o password esta vacio e intentamos registrarnos
	public void error3() {
		errorLabel.setText("Username o password nulos.");
	}
}
