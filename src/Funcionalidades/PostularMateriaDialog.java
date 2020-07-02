package Funcionalidades;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import TBD.DBManager;

import java.awt.event.*;
import java.sql.SQLException;
import java.awt.*;
import java.util.ArrayList;
public class PostularMateriaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox materiasComboBox;
	JLabel errorLabel,lblPostularse,lblNewLabel;
	JButton postularButton;
	DBManager db;
	public PostularMateriaDialog(int id,ArrayList<String> materias,DBManager db) {
		this.db = db;
		setBounds(100, 100, 557, 338);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 555, 307);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			materiasComboBox = new JComboBox();
			materiasComboBox.setBounds(165, 138, 196, 45);
			contentPanel.add(materiasComboBox);
		}
		{
			errorLabel = new JLabel("");
			errorLabel.setForeground(Color.RED);
			errorLabel.setBounds(171, 108, 236, 27);
			contentPanel.add(errorLabel);
		}
		{
			lblPostularse = new JLabel("POSTULARSE");
			lblPostularse.setFont(new Font("Dialog", Font.BOLD, 20));
			lblPostularse.setHorizontalAlignment(SwingConstants.CENTER);
			lblPostularse.setBounds(149, 12, 248, 45);
			contentPanel.add(lblPostularse);
		}
		{
			lblNewLabel = new JLabel("Elige alguna materia disponible:");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel.setBounds(149, 69, 271, 27);
			contentPanel.add(lblNewLabel);
		}
		
		postularButton = new JButton("POSTULAR");
		postularButton.setBounds(383, 147, 105, 27);
		
		postularButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					errorLabel.setText("");
					db.postularEstudiante(id, String.valueOf(materiasComboBox.getSelectedItem()));
					errorLabel.setText("TE POSTULASTE!!");
				}catch(SQLException ex) {
					if(ex.getSQLState().equals(String.valueOf(23505))) {
						error();
					}
				}
			}
		});
		contentPanel.add(postularButton);
		materiasComboBox.addItem("");
		for(String m : materias) {
			materiasComboBox.addItem(m);
		}
		
		setModal(true);
		setVisible(true);
	}
	public JComboBox getMateriasComboBox() {
		return materiasComboBox;
	}
	public void addActionListener(ActionListener a) {
		postularButton.addActionListener(a);
	}
	public void error() {
		errorLabel.setText("ya te postulaste a esta materia");
	}
	public JButton getPostularseButton() {
		return postularButton;
	}
}
