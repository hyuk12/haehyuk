package usermanagement.frame;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import usermanagement.dto.RequestDto;
import usermanagement.dto.ResponseDto;
import usermanagement.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserManagementFrame extends JFrame {

	private static Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private BufferedReader reader;
	private PrintWriter writer;
	private Gson gson;

	private List<JTextField> loginFields;
	private List<JTextField> registerFields;

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
					socket = new Socket("127.0.0.1", 9090);

					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (ConnectException e) {
					JOptionPane.showMessageDialog(null, "접속실패", "서버에 연결할 수 없습니다.", JOptionPane.ERROR_MESSAGE);
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

		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream));
			writer = new PrintWriter(outputStream, true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		gson = new Gson();

		loginFields = new ArrayList<>();
		registerFields = new ArrayList<>();

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
		// 로그인 화면으로 가는 sign in 을 눌렀을 때 로직////////////////////////
		
		JLabel signinLink = new JLabel("Sign in");
		signinLink.setForeground(new Color(135, 244, 248));
		signinLink.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signinLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setBounds(234, 414, 106, 25);
		registerPanel.add(signinLink);
		
		////////////////////////////////////////////////////////////
		
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
		registerUsernameField.setHorizontalAlignment(SwingConstants.CENTER);
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(22, 144, 338, 30);
		registerPanel.add(registerUsernameField);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
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
		registerNameField.setHorizontalAlignment(SwingConstants.CENTER);
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
		registerEmailField.setHorizontalAlignment(SwingConstants.CENTER);
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(22, 314, 338, 30);
		registerPanel.add(registerEmailField);
		
		////////////////////////////////////////////////////
		// 회원 가입 버튼 눌렀을 때 로직////////////////////
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());

				RequestDto<String> requestDto = new RequestDto<>("register", userJson.toString());
				writer.println(gson.toJson(requestDto));
				writer.flush();

				try {
					String response = reader.readLine();
					System.out.println("응답옴!!");
					ResponseDto<?> responseDto = gson.fromJson(response, ResponseDto.class);

					System.out.println(responseDto);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

//				UserService userService = UserService.getInstance();
//				Map<String, String> response = userService.register(userJson.toString());
//
//				if(response.containsKey("error")) {
//					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
//					return;
//				}
//
//				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
//				mainCard.show(mainPanel, "loginPanel");
//				clearFields(registerFields);
//
//				System.out.println(userJson.toString());
			}
		});
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setFont(new Font("CookieRun Bold", Font.PLAIN, 14));
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setBounds(22, 365, 338, 30);
		registerPanel.add(btnRegister);
		
		/////////////////////////////////////////////////////////
		
		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(23, 197, 338, 30);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		//////////////////////////////////////////////////////
		/////////////로그인 버튼을 눌렀을 때 로직/////////////
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			// 무조건 구현을 해야하는 interface를 추상클래스에 구현을 해놓고
			// 추상 메소드가아닌 일반 메소드로 빼놓아 이 추상클래스를 생성할 당시에
			// 쓰고 싶은 메소드를 골라서 override 구현하고픈 것만 하면된다.
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JsonObject loginUser = new JsonObject();
				loginUser.addProperty("usernameAndEmail", usernameField.getText());
				loginUser.addProperty("password", passwordField.getText());

				UserService userService = UserService.getInstance();
				Map<String, String> response = userService.authorize(loginUser.toString());

				if (response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"), "error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null, response.get("ok"), "ok", JOptionPane.INFORMATION_MESSAGE);
				clearFields(loginFields);
			}
		});
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBackground(new Color(240, 240, 240));
		loginButton.setFont(new Font("CookieRun Bold", Font.PLAIN, 14));
		loginButton.setBounds(23, 334, 338, 30);
		loginPanel.add(loginButton);
		
		///////////////////////////////////////////////////////
		
		JLabel signupDesc = new JLabel("Don't have an accounts?");
		signupDesc.setFont(new Font("D2Coding", Font.PLAIN, 12));
		signupDesc.setHorizontalAlignment(SwingConstants.CENTER);
		signupDesc.setBounds(61, 399, 164, 15);
		loginPanel.add(signupDesc);
		
		/////////////////////////////////////////////////////////////////////
		/// sign up 을 눌렀을 때 실행되는 로직///////////////////////////////
		
		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("회원가입 클릭함");
				mainCard.show(mainPanel, "registerPanel");
				clearFields(loginFields);
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

		loginFields.add(usernameField);
		loginFields.add(passwordField);

		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);
	}
	///////////////////////////////////////////////////////

	private void clearFields(List<JTextField> textFields) {
		for (JTextField textField : textFields) {
			if (textField.getText().isEmpty()) {
				continue;
			}
			textField.setText("");
		}
	}

}
