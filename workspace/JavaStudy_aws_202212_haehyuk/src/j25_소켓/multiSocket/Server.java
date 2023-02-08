package j25_소켓.multiSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 9090;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("서버를 실행합니다.");

            while(true) {
                // 클라이언트의 연결을 기다림
                Socket socket = serverSocket.accept();
                // 클라이언트가 연결이 되면 소켓 객체를 하나 생성한다.

                SocketServer socketServer = new SocketServer(socket);
                socketServer.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("서버를 종료합니다.");
        }
    }
}
