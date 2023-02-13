package simplechatting.server;

import lombok.Data;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

@Data
class ConnectedSocket extends Thread{
    private static List<ConnectedSocket> socketList = new ArrayList<>();
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    private String username;

    public ConnectedSocket(Socket socket) {
        this.socket = socket;
        socketList.add(this);
    }

    @Override
    public void run() {
        try {
            outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("join");

            inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            username = reader.readLine();
            System.out.println(username + "님이 접속하였습니다.");

            String userListStr = "";

            for(int i = 0; i < socketList.size(); i++) {
                userListStr += socketList.get(i).getUsername();
                if(i < socketList.size() - 1) {
                    userListStr += ",";
                }
            }

            for(ConnectedSocket connectedSocket : socketList) {
                outputStream = connectedSocket.getSocket().getOutputStream();
                writer = new PrintWriter(outputStream, true);
                writer.println("@welcome/" + username + "님이 접속하였습니다.");
                writer.println("@userList/" + userListStr);
            }

            while (true) {
                String message = reader.readLine();
                for(ConnectedSocket connectedSocket : socketList) {
                    outputStream = connectedSocket.getSocket().getOutputStream();
                    writer = new PrintWriter(outputStream, true);
                    writer.println(message);
                }

                if(message == null) {
                    throw new SocketException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ServerApplication{

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9090);
            System.out.println("=======<<< 서버 실행 >>> =======");

            while(true) {
                Socket socket = serverSocket.accept();
                ConnectedSocket connectedSocket = new ConnectedSocket(socket);
                connectedSocket.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("=======<<< 서버 종료 >>> =======");
        }
    }
}
