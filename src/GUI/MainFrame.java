package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import TBD.*;
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cards;
	private LoginPanel loginPanel;
//	private UserPanel userPanel;
	
	private int id;
	
	final static String USER = "userPanel";
	final static String LOGIN = "loginPanel";
	
	private DBManager db;
	
	public MainFrame(DBManager db) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cards = new CardLayout(0,0);
		contentPane.setLayout(cards);
		
		this.db = db;
		
		loginPanel = new LoginPanel();
		loginPanel.getIniciarSesionButton().setLocation(293, 326);
//		userPanel = new UserPanel();
		
		contentPane.add(loginPanel,LOGIN);
//		contentPane.add(userPanel,USER);
		
		loginPanel.addActionListener(new ActionListener() {
			@Override
			/*
			 * ESTAMOS EN EL PANEL LOGIN
			 */
			public void actionPerformed(ActionEvent e){
				JButton pres = (JButton)e.getSource();
				
				//si el boton presionado es INICIAR SESION
				if(pres == loginPanel.getIniciarSesionButton()) {
					//conectamos primero
					try {
						db.conectar();
						String username = loginPanel.getUsername();
						String password = loginPanel.getPassword();
						id = db.getID(username,password);
						// si el username o password son erroneos
						if(id == -1) { 
							loginPanel.error();
							db.apagar();
						}
						//si el usuario ya esta loggeado
						else if(db.estaConectado(id)) {
							loginPanel.error2();
							db.apagar();
						}
						//sino, accedemos
						else {
//							db.usuario_activo(id);
//							int pid = db.getPID();
//							userPanel.getActUsername().setText(username);
//							userPanel.getActPassword().setText(password);
//							userPanel.getActPID().setText(Integer.toString(pid));
//							db.iniciarSesion(id);
//							cards.show(contentPane, USER);
						}
					}catch(SQLException ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		});
//		registerPanel.addActionListener(new ActionListener() {
//			@Override
//			//ESTAMOS EN EL PANEL REGISTRAR
//			public void actionPerformed(ActionEvent e) {
//				JButton pres = (JButton)e.getSource();
//				//si el boton que presionamos es REGISTRARSE volvemos a login pero con registro completo
//				if(pres == registerPanel.getRegistrarseButton()) {
//					String u = registerPanel.getUsername();
//					String p = registerPanel.getPassword();
//					String cp = registerPanel.getConfPass();
//					try {
//						db.conectar();
//						if(registerPanel.correcto()) {
//							if(!db.estaRegistrado(u, p)) {
//								db.registrarUsuario(u, p);
//								registerPanel.limpiarErrores();
//								registerPanel.limpiarTextFields();
//								db.apagar();
//								cards.show(contentPane, LOGIN);
//							}
//							else {
//								registerPanel.error1();
//							}
//						}
//					}catch(SQLException ex) {
//						System.out.println(ex.getMessage());
//					}
//					
//				}
//				//si el boton presionado es SALIR
//				else if(pres == registerPanel.getSalirButton()) {
//					
//					loginPanel.limpiarError();
//					cards.show(contentPane	,LOGIN);	
//				}
//			}
//		});
		userPanel.addActionListener(new ActionListener() {
			@Override
			//ESTAMOS EN PANEL DE USUARIO
			public void actionPerformed(ActionEvent e) {
				JButton pres = (JButton)e.getSource();
				if(pres == userPanel.getSalirButton()) {
					userPanel.limpiar();
					try {
						db.usuario_inactivo(id);
						db.terminarSesion(id);
						db.apagar();
					}catch(SQLException ex) {
						System.out.println(ex.getMessage());
					}
					loginPanel.limpiarError();
					cards.show(contentPane, LOGIN);
				}
			}
		});
		setVisible(true);
	}

}
