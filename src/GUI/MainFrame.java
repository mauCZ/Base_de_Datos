package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cards;
	private LoginPanel loginPanel;
	private UserPanel userPanel;
	private RegisterPanel registerPanel;
	
	final static String USER = "userPanel";
	final static String LOGIN = "loginPanel";
	final static String REGISTER = "registerPanel";
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cards = new CardLayout(0,0);
		contentPane.setLayout(cards);
		
		loginPanel = new LoginPanel();
		userPanel = new UserPanel();
		registerPanel = new RegisterPanel();
		
		contentPane.add(loginPanel,LOGIN);
		contentPane.add(userPanel,USER);
		contentPane.add(registerPanel,REGISTER);
		
		loginPanel.addActionListener(new ActionListener() {
			@Override
			/*
			 * ESTAMOS EN EL PANEL LOGIN
			 */
			public void actionPerformed(ActionEvent e) {
				JButton pres = (JButton)e.getSource();
				
				//si el boton presionado es SALIR
				if(pres == loginPanel.getIniciarSesionButton()) {
					cards.show(contentPane, USER);
				}
				//si el boton presionado es REGISTRAR
				else if(pres == loginPanel.getRegistrarseButton()) {
					cards.show(contentPane, REGISTER);
				}
			}
		});
		registerPanel.addActionListener(new ActionListener() {
			@Override
			//ESTAMOS EN EL PANEL REGISTRAR
			public void actionPerformed(ActionEvent e) {
				JButton pres = (JButton)e.getSource();
				//si el boton que presionamos es REGISTRARSE volvemos a login pero con registro completo
				if(pres == registerPanel.getRegistrarseButton()) {
					cards.show(contentPane, LOGIN);
				}
				//si el boton presionado es SALIR
				else if(pres == registerPanel.getSalirButton()) {
					cards.show(contentPane	,LOGIN);	
				}
			}
		});
		userPanel.addActionListener(new ActionListener() {
			@Override
			//ESTAMOS EN PANEL DE USUARIO
			public void actionPerformed(ActionEvent e) {
				JButton pres = (JButton)e.getSource();
				if(pres == userPanel.getSalirButton()) {
					cards.show(contentPane, LOGIN);
				}
			}
		});
		setVisible(true);
	}

}
