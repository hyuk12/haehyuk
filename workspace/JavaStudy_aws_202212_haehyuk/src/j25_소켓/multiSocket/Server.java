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
                Socket socket = serverSocket.accept();
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
