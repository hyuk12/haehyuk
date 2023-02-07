package j25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
    private static final int PORT = 9090;

    public static void main(String[] args) {
        List<Socket> clients = new ArrayList<Socket>();

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(true) {
                System.out.println("클라이언트의 접속을 기다리는 중입니다.");
                Socket socket = serverSocket.accept();
                clients.add(socket);
                System.out.println("클라이언트가 연결되었습니다.");
                System.out.println(clients);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream, true);
                out.println("___서버에 접속한 것을 환영합니다.");
            }
            // 클라이언트의 접속을 기다리는 server accept
            // 서버가 클라이언트와 연결이되면 끊어져버린다 그렇기 때문에 무한루프를 돌려 끊기지 않게 해주어야한다.
            // socket 하나당 클라이언트 하나다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
