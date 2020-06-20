package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cards;
	private LoginPanel loginPanel;
	private UserPanel userPanel;
	private RegisterPanel registerPanel;
	
	final static String USER = "userPanel";
	final static String LOGIN = "loginPanel";
	final static String REGISTER = "registerPanel";
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cards = new CardLayout(0,0);
		contentPane.setLayout(cards);
		
		loginPanel = new LoginPanel();
		userPanel = new UserPanel();
		registerPanel = new RegisterPanel();
		
		contentPane.add(loginPanel,LOGIN);
		contentPane.add(userPanel,USER);
		contentPane.add(registerPanel,REGISTER);
		
		
			
		
		setVisible(true);
	}

}
