package simplechatting.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.UnknownHostException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChattingClient extends JFrame {
	
	private Socket socket;
	private String username;

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextField usernameInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList<DefaultListModel<String>> userList;
	private DefaultListModel<String> userListModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
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
	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
		ipInput.setBounds(222, 18, 66, 26);
		contentPane.add(ipInput);
		ipInput.setColumns(10);
		
		portInput = new JTextField();
		portInput.setText("9090");
		portInput.setBounds(295, 18, 66, 26);
		contentPane.add(portInput);
		portInput.setColumns(10);
		
		usernameInput = new JTextField();
		usernameInput.setBounds(222, 56, 139, 26);
		contentPane.add(usernameInput);
		usernameInput.setColumns(10);
		
		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;

				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());

				try {
					socket = new Socket(ip, port);

					JOptionPane.showMessageDialog(null,
							socket.getInetAddress() + "서버 접속",
							"접속성공",
							JOptionPane.INFORMATION_MESSAGE);

					InputStream inputStream = socket.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

					if(reader.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null,
								"사용자 이름을 입력하세요.",
								JOptionPane.INFORMATION_MESSAGE);

						OutputStream outputStream = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(outputStream, true);

						writer.println(username);

					}
					
					Thread thread = new Thread(() ->{
						try {
							InputStream input = socket.getInputStream();
							BufferedReader in = new BufferedReader(new InputStreamReader(input));
							
							while(true) {
								String message = in.readLine();
								if(message.startsWith("@welcome")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
								}else if(message.startsWith("@userList")) {
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userListModel.clear();
									for(String username: usernames) {
										userListModel.addElement(username);
									}
									continue;
								} 
								contentView.append(message + "\n");

								if(message == null) {
									throw new SocketException();
								}
							}
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
					
					thread.start();

				}catch (ConnectException e1) {

					JOptionPane.showMessageDialog(null,
							"서버 접속실 패",
							"접속실패",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (UnknownHostException e2) {
					e2.printStackTrace();
				}catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		connectButton.setBounds(361, 18, 83, 29);
		contentPane.add(connectButton);
		
		JButton joinButton = new JButton("접속");
		joinButton.setBounds(360, 56, 76, 29);
		contentPane.add(joinButton);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(20, 16, 176, 206);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(220, 106, 204, 112);
		contentPane.add(userListScroll);
		
		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(30, 234, 320, 32);
		contentPane.add(messageScroll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!messageInput.getText().isBlank()) {
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter writer = new PrintWriter(outputStream, true);

							writer.println(username + ": " + messageInput.getText());
							messageInput.setText("");

						} catch(IOException ex){
							ex.printStackTrace();
						}
					}
				}
			}
		});
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!messageInput.getText().isBlank()) {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(outputStream, true);

						writer.println(username + ": " + messageInput.getText());
						messageInput.setText("");

					} catch(IOException ex){
						ex.printStackTrace();
					}
				}
			}
		});

		sendButton.setBounds(353, 230, 76, 36);
		contentPane.add(sendButton);
	}
}
