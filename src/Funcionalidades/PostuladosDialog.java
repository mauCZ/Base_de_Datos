package Funcionalidades;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
public class PostuladosDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public PostuladosDialog(ArrayList<String> postulaciones) {
		setBounds(100, 100, 580, 362);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1, 331);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("POSTULADOS-MATERIAS");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(170, 32, 226, 42);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea area = new JTextArea();
		area.setFont(new Font("Dialog", Font.PLAIN, 15));
		area.setColumns(10);
		area.setEditable(false);
		area.setRows(10);
		area.setBounds(77, 129, 410, 178);
		getContentPane().add(area);
		
		JLabel lblNewLabel = new JLabel("Estudiante");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(77, 86, 119, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(208, 86, 116, 31);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Materia");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(347, 86, 115, 31);
		getContentPane().add(lblNewLabel_3);
		
		for(String s : postulaciones) {
			area.append(s+'\n');
		}
		
		setModal(true);
		setVisible(true);
	}
}
