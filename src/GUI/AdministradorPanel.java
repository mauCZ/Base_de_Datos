package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdministradorPanel extends JPanel {
	
	private JLabel l1;
	private JComboBox funcionesComboBox;
	private JButton salirButton;
	
	public AdministradorPanel() {
		setLayout(null);
		
		l1 = new JLabel("ADMINISTRADOR");
		l1.setFont(new Font("Dialog", Font.BOLD, 20));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(60, 47, 255, 51);
		add(l1);
		
		funcionesComboBox = new JComboBox();
		funcionesComboBox.setBounds(233, 212, 310, 51);
		add(funcionesComboBox);
		
		salirButton = new JButton("SALIR");
		salirButton.setBackground(Color.LIGHT_GRAY);
		salirButton.setFont(new Font("Dialog", Font.BOLD, 18));
		salirButton.setBounds(303, 358, 144, 36);
		add(salirButton);

	}
	public void addActionListener(ActionListener a) {
		salirButton.addActionListener(a);
	}
	public void setFunciones(ArrayList<String> funciones) {
		for(String f : funciones) {
			funcionesComboBox.addItem(f);;
		}
	}
}
