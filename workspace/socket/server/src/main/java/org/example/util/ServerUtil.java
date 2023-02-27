package org.example.util;


import java.io.IOException;
import java.io.OutputStream;

import org.example.dto.response.ResponseDto;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ServerUtil {
	private final Gson gson;
	

//	public LoginRespDto loginUser(RequestDto requestDto) {
//
//		LoginReqDto loginReqDto = gson.fromJson(requestDto.getBody(), LoginReqDto.class);
//
//		return new LoginRespDto(loginReqDto.getNickname() + "님이 접속하셨습니다.");
//	}
	
//	public void sendToAll(String resource, String status, String body) throws IOException {
//		
//		ResponseDto responseDto = new ResponseDto(resource, status, body);
//		
//		outputSocket(responseDto);
//	}
//	
//	public void sendToRoom(String resource, String status, String body, String toRoom) throws IOException {
//		ResponseDto responseDto = new ResponseDto(resource, status, body);

//		for(ServerThread thread : ServerThread.getSocketList()) {
//			if(thread.getRoom().getRoomName().equalsIgnoreCase(toRoom) ) {
//				OutputStream outputStream = thread.getSocket().getOutputStream();
//				PrintWriter writer = new PrintWriter(outputStream, true);
//
//				writer.println(gson.toJson(responseDto));
		
//		for(ServerThread thread : ServerThread.getSocketList()) {
//			System.out.println("유틸: "+thread.getRoom().getRoomName());
//			
//			if(thread.getRoom() != null) {
//				System.out.println("시발유틸");
//			}else if(thread.getRoom().getRoomName().equals(toRoom)) {
//				OutputStream outputStream = thread.getSocket().getOutputStream();
//				PrintWriter writer = new PrintWriter(outputStream, true);
//				
//				writer.println(gson.toJson(responseDto));
//			}
//		}
//	}
//
//	public void createRoom(String resource,  String status, String body) throws IOException {
//		ResponseDto responseDto = new ResponseDto(resource, status, body);
//		OutputStream outputStream  = thread.getSocket().getOutputStream();
//		PrintWriter writer = new PrintWriter(outputStream, true);
//
//		writer.println(gson.toJson(responseDto))
//		outputSocket(responseDto);
//	}



//	private void outputSocket(ResponseDto responseDto) throws IOException {
//		for (ServerThread thread : ServerThread.getSocketList()) {
//			OutputStream outputStream  = thread.getSocket().getOutputStream();
//			PrintWriter writer = new PrintWriter(outputStream, true);
//
//			writer.println(gson.toJson(responseDto));
//		}
//	}
	
	
}
