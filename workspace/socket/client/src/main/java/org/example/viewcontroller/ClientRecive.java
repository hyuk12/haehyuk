package org.example.viewcontroller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import org.example.dto.response.CreateRoomRespDto;
import org.example.dto.response.ExitRespDto;
import org.example.dto.response.JoinRoomRespDto;
import org.example.dto.response.MessageRespDto;
import org.example.dto.response.ResponseDto;
import org.example.view.ChattingClient;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientRecive extends Thread{

	private final Socket socket;
	private InputStream inputStream;
	private Gson gson;

	private CardLayout mainLayout;
	private boolean isRunning = true;
	
	@Override
	public void run() {
		try {
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			gson = new Gson();
			
			while(isRunning) {
				String request = in.readLine();
				ResponseDto responseDto = gson.fromJson(request, ResponseDto.class);
				
				switch(responseDto.getResource()) {
					
					case "message" :
						MessageRespDto messageRespDto = gson.fromJson(responseDto.getBody(), MessageRespDto.class);
						String message = messageRespDto.getMessage();
						String toUser = messageRespDto.getToUser();
						
						ChattingClient.getInstance().getContentView().append(toUser + " > " + message + "\n");

						break;
						
					case "createRoom":
						try {
							CreateRoomRespDto createRoomRespDto = gson.fromJson(responseDto.getBody(), CreateRoomRespDto.class);
							
							String rNames = createRoomRespDto.getRoomName();
							

							ChattingClient.getInstance().getRoomTitle().setText("채팅방: " +rNames + "의 방입니다." );
							ChattingClient.getInstance().getContentView().setText("");
							ChattingClient.getInstance().getContentView().append(rNames + "방이 생성되었습니다."+"\n");
																
						} catch (JsonIOException e) {
							e.printStackTrace();
						}

						break;
						
					case "joinRoom":
						JoinRoomRespDto joinRoomRespDto = gson.fromJson(responseDto.getBody(), JoinRoomRespDto.class);

						String joinName = joinRoomRespDto.getJoinName();
						String roomName = joinRoomRespDto.getRoomName();
						
						if(ChattingClient.getInstance().getNickname().equals(joinName)) {
							
							ChattingClient.getInstance().getContentView().setText("");
						}
						
						ChattingClient.getInstance().getRoomTitle().setText(roomName+ "의 방입니다.");
						ChattingClient.getInstance().getContentView().append(joinName + "님이 방에 입장하셨습니다."+"\n");
						
						break;
						
					case "exitRoom":
						System.out.println("리시브: "+responseDto.getBody());
						ExitRespDto exitRespDto = gson.fromJson(responseDto.getBody(), ExitRespDto.class);
						String exitUsername = exitRespDto.getKingName();

						ChattingClient.getInstance().getContentView().append(exitUsername+ "님이 나가셨습니다."+"\n");
								
						
						break;
						
					case "exitKingRoom":
						
						mainLayout = (CardLayout)ChattingClient.getInstance().getMainPanel().getLayout();
						mainLayout.show(ChattingClient.getInstance().getMainPanel(), "chattingList");
						
						break;
						
					case "reflashRoom":
						List<String> roomNames = gson.fromJson(responseDto.getBody(), List.class);
						
						
						ChattingClient.getInstance().getModel().clear();
						ChattingClient.getInstance().getModel().addAll(roomNames);
						
						break;
						
					case "exit":
						throw new InterruptedException();
				}
				
			}
		} catch (InterruptedException e) {
			ChattingClient.getInstance().exit();
		} catch (NullPointerException e) {
			System.out.println("왜 로그인 안하고 그냥 끄냐?");
			ChattingClient.getInstance().exit();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
