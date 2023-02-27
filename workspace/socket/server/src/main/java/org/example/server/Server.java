package org.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//Main이 도는 순간 돌아가기 위해 server 를 싱글톤으로 제작한다.
	
	private static Server instance;
	private ServerSocket serverSocket;
	private ServerThread serverThread;
	private Socket socket;
	
	public static Server getInstance() {
		if(instance == null) {
			instance = new Server();
		}
		return instance;
	}
	
	private Server() {}
	
	public void start() {
		try {
			serverSocket = new ServerSocket(8889);
			System.out.println(" 서버 시작 ");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println(socket);
				boolean connected = socket.isConnected() && !socket.isClosed();
				if(connected) {
					serverThread = new ServerThread(socket);
					serverThread.start();

//					
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e) {
			System.err.println("클라이언트 강제종료 되었다.");
		} finally {
			if(serverSocket != null) {
				try {
					
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(" 서버 종료 ");
		}
		
	}
	
	

}
