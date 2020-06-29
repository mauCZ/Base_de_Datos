package Funcionalidades;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
public class MateriasDisponiblesDialog extends JDialog {
	private JLabel lblNewLabel ;
	private JComboBox materiasComboBox;
	private ArrayList<String> materias;
	private final JPanel contentPanel = new JPanel();
	public MateriasDisponiblesDialog(ArrayList<String> materias) {
		this.materias = materias;
		setBounds(100, 100, 587, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("MATERIAS DISPONIBLES");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(103, 40, 337, 53);
			contentPanel.add(lblNewLabel);
		}
		
		materiasComboBox = new JComboBox();
		materiasComboBox.setBounds(150, 162, 269, 40);
		contentPanel.add(materiasComboBox);
		materiasComboBox.addItem("");
		for(String m : materias) {
			materiasComboBox.addItem(m);
		}
		setModal(true);
		setVisible(true);
	}
	
}
