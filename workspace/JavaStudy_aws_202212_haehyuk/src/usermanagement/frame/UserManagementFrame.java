package usermanagement.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserManagementFrame extends JFrame {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		////////////////////////////////////////////////////////////////////////
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(loginPanel, "loginPanel");
		
		loginPanel.setLayout(null);
		
		/////////////////////////////////////////////////////////////////////////
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);
		
		/////////////////////////////////////////////////////////////////////////
		
		JLabel signinLink = new JLabel("Sign in");
		signinLink.setForeground(new Color(135, 244, 248));
		signinLink.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signinLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
			}
		});
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setBounds(234, 414, 106, 25);
		registerPanel.add(signinLink);
		
		JLabel logoText = new JLabel("UserManagement");
		logoText.setFont(new Font("CookieRun Bold", Font.BOLD, 22));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(82, 36, 213, 56);
		loginPanel.add(logoText);
		
		JLabel registerLogoText = new JLabel("UserManagement");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("CookieRun Bold", Font.BOLD, 22));
		registerLogoText.setBounds(82, 36, 213, 56);
		registerPanel.add(registerLogoText);
		
		JLabel loginText = new JLabel("Login");
		loginText.setFont(new Font("CookieRun Regular", Font.BOLD, 25));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(117, 76, 148, 56);
		loginPanel.add(loginText);
		
		JLabel registerText = new JLabel("Register");
		registerText.setForeground(new Color(0, 0, 0));
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("CookieRun Regular", Font.BOLD, 25));
		registerText.setBounds(117, 78, 148, 56);
		registerPanel.add(registerText);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(22, 144, 338, 30);
		registerPanel.add(registerUsernameField);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setBounds(22, 203, 338, 30);
		registerPanel.add(registerPasswordField);
		
		JLabel registerUsernameLabel = new JLabel("Username");
		registerUsernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerUsernameLabel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		registerUsernameLabel.setBounds(23, 130, 175, 15);
		registerPanel.add(registerUsernameLabel);
		
		JLabel registerPasswordLabel = new JLabel("Password");
		registerPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerPasswordLabel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		registerPasswordLabel.setBounds(22, 184, 79, 15);
		registerPanel.add(registerPasswordLabel);
		
		registerNameField = new JTextField();
		registerNameField.setColumns(10);
		registerNameField.setBounds(22, 260, 338, 30);
		registerPanel.add(registerNameField);
		
		JLabel registerEmailLabel = new JLabel("Name");
		registerEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerEmailLabel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		registerEmailLabel.setBounds(22, 246, 175, 15);
		registerPanel.add(registerEmailLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 14));
		lblEmail.setBounds(22, 300, 79, 15);
		registerPanel.add(lblEmail);
		
		registerEmailField = new JTextField();
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(22, 314, 338, 30);
		registerPanel.add(registerEmailField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setFont(new Font("CookieRun Bold", Font.PLAIN, 14));
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setBounds(22, 365, 338, 30);
		registerPanel.add(btnRegister);
		
		usernameField = new JTextField();
		usernameField.setBounds(23, 197, 338, 30);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(23, 273, 338, 30);
		loginPanel.add(passwordField);
		
		JLabel usernameLabel = new JLabel("Username or Email");
		usernameLabel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setBounds(23, 172, 175, 15);
		loginPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("D2Coding", Font.PLAIN, 14));
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setBounds(23, 248, 79, 15);
		loginPanel.add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBackground(new Color(192, 192, 192));
		loginButton.setFont(new Font("CookieRun Bold", Font.PLAIN, 14));
		loginButton.setBounds(23, 334, 338, 30);
		loginPanel.add(loginButton);
		
		JLabel signupDesc = new JLabel("Don't have an accounts?");
		signupDesc.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signupDesc.setHorizontalAlignment(SwingConstants.CENTER);
		signupDesc.setBounds(61, 399, 164, 15);
		loginPanel.add(signupDesc);
		
		/////////////////////////////////////////////////////////////////////
		
		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("회원가입 클릭함");
				mainCard.show(mainPanel, "registerPanel"); 
			}
		});
		signupLink.setForeground(new Color(135, 244, 248));
		signupLink.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signupLink.setHorizontalAlignment(SwingConstants.CENTER);
		signupLink.setBounds(219, 399, 52, 15);
		loginPanel.add(signupLink);
		
		///////////////////////////////////////////////////////////////////////
		
		JLabel forgotPasswordLink = new JLabel("Forgot your password?");
		forgotPasswordLink.setForeground(new Color(135, 244, 248));
		forgotPasswordLink.setFont(new Font("D2Coding", Font.PLAIN, 12));
		forgotPasswordLink.setHorizontalAlignment(SwingConstants.CENTER);
		forgotPasswordLink.setBounds(82, 426, 201, 15);
		loginPanel.add(forgotPasswordLink);
		
	}
}
