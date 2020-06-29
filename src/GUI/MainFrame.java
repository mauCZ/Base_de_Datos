package GUI;

import javax.swing.*;

import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

import Funcionalidades.MateriasDisponiblesDialog;
import Funcionalidades.PostuladosDialog;
import Funcionalidades.PostularMateriaDialog;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import TBD.*;
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cards;
	private LoginPanel loginPanel;
	private DocentePanel docentePanel;
	private EstudiantePanel estudiantePanel;
	private AdministradorPanel administradorPanel;
	
	private int id;
	final static String LOGIN = "loginPanel";
	final static String ESTUDIANTE = "estudiantePanel";
	final static String DOCENTE = "docentePanel";
	final static String ADMINISTRADOR = "adminPanel";
	
	private DBManager db;
	
	public MainFrame(DBManager db) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cards = new CardLayout(0,0);
		contentPane.setLayout(cards);
		
		docentePanel = new DocentePanel();
		estudiantePanel = new EstudiantePanel();
		administradorPanel = new AdministradorPanel();
		this.db = db;
		loginPanel = new LoginPanel();
		loginPanel.getIniciarSesionButton().setLocation(293, 326);
		contentPane.add(loginPanel,LOGIN);
		
		contentPane.add(docentePanel,DOCENTE);
		contentPane.add(estudiantePanel,ESTUDIANTE);
		contentPane.add(administradorPanel,ADMINISTRADOR);
		
		docentePanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					db.usuario_inactivo(id);
					db.terminarSesion(id);
					db.apagar();
				}catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				cards.show(contentPane, LOGIN);
			}
		});
		estudiantePanel.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				JComboBox c = estudiantePanel.getFuncionesComboBox();
				String s = String.valueOf(c.getSelectedItem());
				if(ev.getStateChange() == ItemEvent.SELECTED) {
					if(s.equals("lista_postulados")) {
						try {
							ArrayList<String> pos = db.getPostulaciones();
							PostuladosDialog p = new PostuladosDialog(pos);
							
						}catch(SQLException ex) {
							System.out.println(ex.getMessage());
						}
					}
					else if(s.equals("ver_materias_disponibles")) {
						try {
							ArrayList<String> ma = db.getMateriasDisponibles();
							MateriasDisponiblesDialog m = new MateriasDisponiblesDialog(ma);
						}catch(SQLException ex) {
							System.out.println(ex.getMessage());
						}
					}
					else if(s.equals("postular_materia")) {
						try {
							ArrayList<String> ma = db.getMateriasDisponibles();
							PostularMateriaDialog po = new PostularMateriaDialog(ma);
							po.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent ev) {
									
								}
							});
							po.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent ev) {
									if(ev.getStateChange()==ItemEvent.SELECTED) {
										
									}
								}
							});
						}catch(SQLException ex) {
							System.out.println(ex.getMessage());
						}
					}
				}
			}
		});
		estudiantePanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					db.usuario_inactivo(id);
					db.terminarSesion(id);
					estudiantePanel.limpiar();
					db.apagar();
				}catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				cards.show(contentPane, LOGIN);
			}
		});
		administradorPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					db.terminarSesion(id);
					db.usuario_inactivo(id);
					db.apagar();
				}catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				cards.show(contentPane, LOGIN);
			}
		});
		
		loginPanel.addActionListener(new ActionListener() {
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
						//sino, accedemos a un panel dependiendo si es est, doc o admin
						else {
							String rolNecesario = db.getRol(id);
							if(rolNecesario.equals("Estudiante")) {
								try {
									String nombre = db.getNombreUsuario(id);
									estudiantePanel.setEstudianteNombre(nombre);
									db.usuario_activo(id);
									db.iniciarSesion(id);
									estudiantePanel.setFunciones(db.getFunciones(rolNecesario));
									
									
								}catch(SQLException ex) {
									System.out.println(ex.getMessage());
								}
								cards.show(contentPane, ESTUDIANTE);
							}
							else if(rolNecesario.equals("Docente")) {
								try {
									String nombre = db.getNombreUsuario(id);
									docentePanel.setDocenteNombre(nombre);
									db.usuario_activo(id);
									db.iniciarSesion(id);
									docentePanel.setFunciones(db.getFunciones(rolNecesario));
									
								}catch(SQLException ex) {
									System.out.println(ex.getMessage());
								}
								cards.show(contentPane, DOCENTE);
							}
							else if(rolNecesario.equals("Administrador")) {
								try {
									db.usuario_activo(id);
									db.iniciarSesion(id);
									administradorPanel.setFunciones(db.getFunciones(rolNecesario));
									
								}catch(SQLException ex) {
									System.out.println(ex.getMessage());
								}
								cards.show(contentPane, ADMINISTRADOR);
							}
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
		
		setVisible(true);
	}
}
