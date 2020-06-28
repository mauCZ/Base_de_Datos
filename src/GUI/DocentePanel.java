package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class DocentePanel extends JPanel {
	
	private JLabel l1,docenteLabel;
	private JComboBox funcionesComboBox;
	private JButton salirButton;
	
	public DocentePanel() {
		setLayout(null);
		
		l1 = new JLabel("Docente: ");
		l1.setFont(new Font("Dialog", Font.BOLD, 24));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(60, 35, 183, 57);
		add(l1);
		
		docenteLabel = new JLabel("Mauricio Coca Zeballos");
		docenteLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		docenteLabel.setBounds(299, 45, 392, 46);
		add(docenteLabel);
		
		funcionesComboBox = new JComboBox();
		funcionesComboBox.setBounds(194, 199, 321, 57);
		add(funcionesComboBox);
		
		salirButton = new JButton("SALIR");
		salirButton.setBackground(Color.LIGHT_GRAY);
		salirButton.setFont(new Font("Dialog", Font.BOLD, 18));
		salirButton.setBounds(259, 394, 196, 46);
		add(salirButton);

	}
	public void addActionListener(ActionListener a) {
		salirButton.addActionListener(a);
	}
	public void setDocenteNombre(String docente) {
		docenteLabel.setText(docente);
	}
	public void limpiar() {
		docenteLabel.setText("");
		
	}
}
