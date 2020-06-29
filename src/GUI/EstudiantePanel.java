package GUI;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
		
		estudianteLabel = new JLabel("");
		estudianteLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		estudianteLabel.setBounds(328, 29, 335, 51);
		add(estudianteLabel);
		
		funcionesComboBox = new JComboBox();
		funcionesComboBox.setBounds(210, 223, 311, 51);
		add(funcionesComboBox);
		
		salirButton = new JButton("SALIR");
		salirButton.setBackground(Color.LIGHT_GRAY);
		salirButton.setFont(new Font("Dialog", Font.BOLD, 18));
		salirButton.setBounds(385, 411, 208, 43);
		add(salirButton);

	}
	public void addActionListener(ActionListener a) {
		salirButton.addActionListener(a);
	}
	public void addItemListener(ItemListener i) {
		funcionesComboBox.addItemListener(i);
	}
	public void setEstudianteNombre(String estudiante) {
		estudianteLabel.setText(estudiante);
	}
	public void limpiar() {
		estudianteLabel.setText("");
		funcionesComboBox.removeAllItems();
	}
	public void setFunciones(ArrayList<String> funciones) {
		funcionesComboBox.addItem("");
		for(String f : funciones) {
			funcionesComboBox.addItem(f);;
		}
	}
	public JComboBox getFuncionesComboBox() {
		return funcionesComboBox;
	}
}
