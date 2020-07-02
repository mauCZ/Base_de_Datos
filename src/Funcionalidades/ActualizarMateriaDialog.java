package Funcionalidades;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import TBD.DBManager;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
public class ActualizarMateriaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox materiasNoDisponiblesComboBox,materiasDisponiblesComboBox; //materias no disponibles
	JLabel lblNewLabel;
	JButton necesitaButton,quitarButton;
	DBManager db;
	ArrayList<String> materiasD, materiasND;
	public ActualizarMateriaDialog(int id,DBManager db) {
		materiasD = null;
		materiasND = null;
		this.db = db;
		setBounds(100, 100, 630, 398);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 628, 367);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		quitarButton = new JButton("No necesita auxiliar");
		quitarButton.setBounds(372, 249, 153, 41);
		contentPanel.add(quitarButton);
		{
			materiasNoDisponiblesComboBox= new JComboBox();
			materiasNoDisponiblesComboBox.setBounds(71, 129, 239, 49);
			contentPanel.add(materiasNoDisponiblesComboBox);
		}
		{
			lblNewLabel = new JLabel("No tiene auxliatura");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(95, 65, 190, 49);
			contentPanel.add(lblNewLabel);
		}
		{
			necesitaButton= new JButton("Necesita auxiliar");
			necesitaButton.setBounds(119, 249, 143, 41);
			contentPanel.add(necesitaButton);
		}
		class Listener implements ActionListener{
			public void actionPerformed(ActionEvent ev) {
				if(ev.getSource() == necesitaButton) {
					try {
						String materia = (String)materiasNoDisponiblesComboBox.getSelectedItem();
						int id = db.getIDMateria(materia);
						db.validarMateria(id);
						//actualizar(materia);
					}catch(SQLException ex) { System.out.println(ex.getMessage());}
				}
				else if(ev.getSource() == quitarButton) {
					try {
						String materia = (String)materiasDisponiblesComboBox.getSelectedItem();
						int id = db.getIDMateria(materia);
						db.retirarMateria(id);
						//actualizar(materia);
					}catch(SQLException ex) {System.out.println(ex.getMessage());}
				}
				
			}
		}
		Listener l = new Listener();
		necesitaButton.addActionListener(l);
		quitarButton.addActionListener(l);
		materiasDisponiblesComboBox = new JComboBox();
		materiasDisponiblesComboBox.setBounds(337, 129, 239, 49);
		contentPanel.add(materiasDisponiblesComboBox);
		try {
			materiasD = db.getMateriasDisponibles();
			materiasND = db.getMateriasNoDisponibles();
		}catch(SQLException ex) {System.out.println(ex.getMessage());}
		materiasDisponiblesComboBox.addItem("");
		for(String m : materiasD) {
			materiasDisponiblesComboBox.addItem(m);
		}
		materiasNoDisponiblesComboBox.addItem("");
		
		JLabel lblTiieneAuxliatura = new JLabel("Tiene auxliatura");
		lblTiieneAuxliatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiieneAuxliatura.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTiieneAuxliatura.setBounds(355, 65, 190, 49);
		contentPanel.add(lblTiieneAuxliatura);
		for(String m : materiasND) {
			materiasNoDisponiblesComboBox.addItem(m);
		}
		setModal(true);
		setVisible(true);
	}
	public void actualizar(String materia) throws SQLException{
		materiasND = db.getMateriasNoDisponibles();
		materiasD = db.getMateriasDisponibles();
		materiasNoDisponiblesComboBox.removeAllItems();
		materiasDisponiblesComboBox.removeAllItems();
		materiasDisponiblesComboBox.addItem("");
		materiasNoDisponiblesComboBox.addItem("");
		for(String m : materiasND) {
			materiasNoDisponiblesComboBox.addItem(m);
		}
		for(String m : materiasD) {
			materiasDisponiblesComboBox.addItem(m);
		}
	}
}
