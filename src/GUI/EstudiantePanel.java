package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class EstudiantePanel extends JPanel {
	
	private JLabel l1,estudianteLabel;
	private JComboBox funcionesComboBox;
	private JButton salirButton;
	
	public EstudiantePanel() {
		setLayout(null);
		
		l1 = new JLabel("Estudiante: ");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Dialog", Font.BOLD, 24));
		l1.setBounds(30, 10, 261, 85);
		add(l1);
		
		estudianteLabel = new JLabel("Mauricio Coca Zeballos");
		estudianteLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		estudianteLabel.setBounds(328, 29, 335, 51);
		add(estudianteLabel);
		
		funcionesComboBox = new JComboBox();
		funcionesComboBox.setBounds(210, 223, 311, 51);
		add(funcionesComboBox);
		
		salirButton = new JButton("SALIR");
		salirButton.setBackground(Color.LIGHT_GRAY);
		salirButton.setFont(new Font("Dialog", Font.BOLD, 18));
		salirButton.setBounds(274, 408, 208, 43);
		add(salirButton);

	}
	public void addActionListener(ActionListener a) {
		salirButton.addActionListener(a);
	}
}
