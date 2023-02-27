package org.example.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import org.example.dto.request.CreateRoomReqDto;
import org.example.dto.request.ExitReqDto;
import org.example.dto.request.ForceQuitReqDto;
import org.example.dto.request.JoinRoomReqDto;
import org.example.dto.request.LoginReqDto;
import org.example.dto.request.MessageReqDto;
import org.example.dto.request.RequestDto;
import org.example.entity.Room;
import org.example.viewcontroller.ClientRecive;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;


@Getter
public class ChattingClient extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static ChattingClient instance;
	
	public static ChattingClient getInstance() {
		if(instance == null) {
			instance = new ChattingClient();
		}
		return instance;
	}
	
	public void exit() {
		System.exit(0);
	}
	
	private ClientRecive clientRecive;
	

	private Socket socket;
	private Gson gson;
	private Room room;
	private int index;
	
	private JPanel mainPanel;
	private JList<String> userList;

	private JPanel joinPanel ;
	private JButton joinButton;
	private JTextField joinNickname;
	private ImageIcon kakaoImage;

	private String roomName;
	private String nickname;
	private JPanel chattingRoomPanel;
	private JTextField messageInput;
	private JList<String> roomList;
	private JScrollPane scrollpane;
	
	@Getter @Setter
	private DefaultListModel<String> model;

	private DefaultListModel<String> userListModel;

	private JPanel chattingListPanel;
	private JLabel roomTitle;
	private JTextArea contentView;
	private JButton exitRoomButton;

	
	private String title;
	
	/**
	 * Create the frame.
	 */
	
	private ChattingClient() {
		
		
				
		gson = new Gson();
		userListModel = new DefaultListModel<>();
		userList = new JList<String>(userListModel);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(ChattingClient.this, "클라이언트 끄시겠습니까?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
				if (confirmResult == JOptionPane.YES_OPTION) {
					if (socket != null) {
						ForceQuitReqDto forceQuitReqDto = new ForceQuitReqDto(nickname);
						sendRequest("exit", gson.toJson(forceQuitReqDto));//gson => null
					} else {
						dispose();
						System.exit(0);
					}
				}
			}
			
		});
		setBounds(100, 100, 480, 800);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		

		joinPanel = new JPanel();
		joinPanel.setBackground(new Color(255, 217, 0));
		mainPanel.add(joinPanel, "joinPanel");
		joinPanel.setLayout(null);
		
		kakaoImage = new ImageIcon(ChattingClient.class.getResource("../image/카카오메인이미지.png"));
		joinPanel.setLayout(null);
		JLabel background = new JLabel(kakaoImage);
		background.setLocation(62, 90);
		background.setSize(328, 312);
		joinPanel.add(background);
		

		
		joinNickname = new JTextField();
		
		joinNickname.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					if (joinNickname.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "please input nickname", "입장불가", JOptionPane.ERROR_MESSAGE);
					} else {
						String ip = "127.0.0.1";
						int port = 8889;

						try {
							socket = new Socket(ip, port);
							ClientRecive clientRecive = new ClientRecive(socket);
							clientRecive.start();

							nickname = joinNickname.getText() + " [" +  socket.getLocalPort() + "]";
							
							LoginReqDto loginReqDto = new LoginReqDto(nickname.replaceAll(" ",""));
							
							String joinJson = gson.toJson(loginReqDto);
							sendRequest("join", joinJson);

							if (socket != null) {
					
								CardLayout mainLayout = (CardLayout) mainPanel.getLayout();
								mainLayout.show(mainPanel, "chattingList");
										
							}
						} catch (ConnectException ex) {
							JOptionPane.showMessageDialog(null, "접속오류", "접속오류", JOptionPane.ERROR_MESSAGE);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});

		joinButton = new JButton("");
		joinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (joinNickname.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "please input nickname", "입장불가", JOptionPane.ERROR_MESSAGE);

				} else{
					joinButton.setEnabled(true);
					joinButton.setFocusable(true);
					String ip = "127.0.0.1";
					int port = 8889;

					try {
						socket = new Socket(ip, port);
						ClientRecive clientRecive = new ClientRecive(socket);
						clientRecive.start();

						nickname = joinNickname.getText() + " [" +  socket.getLocalPort() + "]";
						System.out.println("로그인시:" + nickname);
						
						LoginReqDto loginReqDto = new LoginReqDto(nickname.replaceAll(" ",""));
						
						
						userListModel.addElement(nickname);

						String joinJson = gson.toJson(loginReqDto);
						sendRequest("join", joinJson);


						if (socket != null && !joinNickname.getText().isBlank()) {
							joinButton.setEnabled(true);
							CardLayout mainLayout = (CardLayout) mainPanel.getLayout();
							mainLayout.show(mainPanel, "chattingList");
						}

					} catch (ConnectException ex) {
						JOptionPane.showMessageDialog(null, "접속오류", "접속오류", JOptionPane.ERROR_MESSAGE);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		
		joinButton.setBounds(62, 559, 328, 49);
		joinPanel.add(joinButton);

		ImageIcon joinButtonImg = new ImageIcon(ChattingClient.class.getResource("../image/로그인.png"));
		joinButton.setIcon(joinButtonImg);
		joinButton.setBorderPainted(false);
		joinButton.setFocusPainted(false);
		joinButton.setContentAreaFilled(false);

		joinNickname.setBounds(62, 473, 328, 49);
		joinPanel.add(joinNickname);
		joinNickname.setColumns(10);

		chattingListPanel = new JPanel();
		mainPanel.add(chattingListPanel, "chattingList");
		chattingListPanel.setLayout(null);
		chattingListPanel.setBackground(new Color(255, 217, 0));

		ImageIcon plusButton = new ImageIcon(ChattingClient.class.getResource("../image/플러스버튼이미지.png"));
		JButton roomPlusButton = new JButton("");

		roomPlusButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				title = JOptionPane.showInputDialog(null, "방제목을 입력해주세요.").replaceAll(" ","");

				String kingName = nickname;
				System.out.println("방장:" + kingName);
				boolean flag = true;
				if (title == null) { //값이 없을 때 취소버튼
					CardLayout mainLayout = (CardLayout) mainPanel.getLayout();
					mainLayout.show(mainPanel, "chattingList");
				} else if (title.isBlank()) { //값이 없을때 확인버튼
					while (flag) { //값이 없을때 확인버튼 시 돌아가는 무한루프
						JOptionPane.showMessageDialog(null, "방제목 입력 해주세요!!!", "!!", JOptionPane.ERROR_MESSAGE);
						title = JOptionPane.showInputDialog(null, "방제목을 입력해주세요.");

						if (title == null) { // 값 입력 대기중에 취소 버튼
							break; //반복종료 while 문 밖으로 나감
						} else if (!title.isBlank()) {
							CardLayout mainLayout = (CardLayout) mainPanel.getLayout();
							mainLayout.show(mainPanel, "chattingRoom");
							break; // 입력됐을때 반복종료
						}
					}
				} else {
					CreateRoomReqDto createRoomReqDto = new CreateRoomReqDto(title, kingName.replaceAll(" ",""));
					String createRoomJson = gson.toJson(createRoomReqDto);

					sendRequest("createRoom", createRoomJson);
					
					CardLayout mainLayout = (CardLayout) mainPanel.getLayout();
					mainLayout.show(mainPanel, "chattingRoom");
				}
			}
		});
		model = new DefaultListModel<>();
		roomList = new JList<>(model);
		scrollpane = new JScrollPane(roomList);
		
		scrollpane.setViewportView(roomList);
		chattingListPanel.add(scrollpane);


		roomPlusButton.setBounds(0, 102, 113, 98);
		chattingListPanel.add(roomPlusButton);
		roomPlusButton.setIcon(plusButton);
		roomPlusButton.setBorderPainted(false);
		roomPlusButton.setFocusPainted(false);
		roomPlusButton.setContentAreaFilled(false);

		JLabel kakaoImg = new JLabel(kakaoImage);
		kakaoImg.setBounds(0, 17, 101, 81);
		chattingListPanel.add(kakaoImg);




		roomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					
					index = roomList.locationToIndex(e.getPoint());
					roomName = roomList.getModel().getElementAt(index);

					System.out.println("조인:" + nickname);
					JoinRoomReqDto joinRoomReqDto = new JoinRoomReqDto(roomName, nickname.replaceAll(" ",""));
					String joinRoomJson = gson.toJson(joinRoomReqDto);

					sendRequest("joinRoom", joinRoomJson);
					
					CardLayout mainLayout = (CardLayout)ChattingClient.getInstance().getMainPanel().getLayout();
					mainLayout.show(ChattingClient.getInstance().getMainPanel(), "chattingRoom");

				}
			}
		});
		
		roomList.setBounds(0, 212, 324, -81);
		scrollpane.setBounds(113, 0, 351, 762);
		chattingRoomPanel = new JPanel();
		mainPanel.add(chattingRoomPanel, "chattingRoom");
		chattingRoomPanel.setLayout(null);
		chattingRoomPanel.setBackground(new Color(255, 217, 0));
		roomTitle = new JLabel();
		roomTitle.setFont(new Font("D2coding", Font.PLAIN, 16));
		roomTitle.setHorizontalAlignment(SwingConstants.CENTER);
		roomTitle.setBounds(6, 6, 372, 52);
		chattingRoomPanel.add(roomTitle);


		
		JButton exitRoomButton = new JButton("");
		exitRoomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ExitReqDto exitReqDto = new ExitReqDto(nickname.replaceAll(" ", ""), roomName);
				
				String exitJson = gson.toJson(exitReqDto);
				System.out.println(exitJson);
				sendRequest("exitRoom", exitJson);
				
				CardLayout mainLayout = (CardLayout)mainPanel.getLayout();
				mainLayout.show(mainPanel, "chattingList");
			}
		});
		
		
		exitRoomButton.setBounds(373, 0, 97, 70);
		chattingRoomPanel.add(exitRoomButton);

		ImageIcon exitButton = new ImageIcon(ChattingClient.class.getResource("../image/나가기.png"));
		exitRoomButton.setIcon(exitButton);
		exitRoomButton.setBorderPainted(false);
		exitRoomButton.setFocusPainted(false);
		exitRoomButton.setContentAreaFilled(false);


		JButton messageSendButton = new JButton("");
		messageSendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendMessage();
				messageInput.setText("");
			}
		});
		messageSendButton.setBounds(398, 707, 66, 42);
		chattingRoomPanel.add(messageSendButton);

		ImageIcon sendButton = new ImageIcon(ChattingClient.class.getResource("../image/send-3.png"));
		messageSendButton.setIcon(sendButton);
		messageSendButton.setBorderPainted(false);
		messageSendButton.setFocusPainted(false);
		messageSendButton.setContentAreaFilled(false);

		
		messageInput = new JTextField();
//		messageInput.setForeground(Color.RED);
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					sendMessage();
					messageInput.setText("");

				}
			}
		});
		messageInput.setBounds(6, 699, 399, 57);
		chattingRoomPanel.add(messageInput);
		messageInput.setColumns(10);
		
		contentView = new JTextArea();
		contentView.setEditable(false);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 70, 457, 624);
		scrollPane_1.setColumnHeaderView(contentView);
		scrollPane_1.setViewportView(contentView);
		chattingRoomPanel.add(scrollPane_1);

	}
	
	

	private void sendMessage() {
		if(!messageInput.getText().isBlank()) {

			/*from : room 객체에있는 유저들*/
			MessageReqDto messageReqDto = new MessageReqDto(nickname.replaceAll(" ", ""), messageInput.getText());

			sendRequest("message", gson.toJson(messageReqDto));


		}
	}

	private void sendRequest(String resource, String body){
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);

			RequestDto requestDto = new RequestDto(resource, body);


			out.println(gson.toJson(requestDto));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}



	public void setClientRecive(ClientRecive clientRecive) {
		this.clientRecive = clientRecive;
	}
	
}
