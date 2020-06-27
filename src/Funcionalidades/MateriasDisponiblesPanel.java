package Funcionalidades;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MateriasDisponiblesPanel extends JPanel {
	
	
	public MateriasDisponiblesPanel() {
		setLayout(null);
		
		JLabel l1 = new JLabel("MATERIAS DISPONIBLES");
		l1.setFont(new Font("Dialog", Font.BOLD, 22));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(225, 42, 296, 56);
		add(l1);
		
		JComboBox materiasComboBox = new JComboBox();
		materiasComboBox.setBounds(262, 205, 251, 41);
		add(materiasComboBox);
		
		JButton atrasButton = new JButton("ATRAS");
		atrasButton.setFont(new Font("Dialog", Font.BOLD, 18));
		atrasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		atrasButton.setBounds(281, 453, 185, 41);
		add(atrasButton);

	}
}
