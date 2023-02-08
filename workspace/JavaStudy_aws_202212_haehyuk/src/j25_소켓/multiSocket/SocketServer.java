package j25_소켓.multiSocket;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread{

    public static List<SocketServer> clientList = new ArrayList<>();
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    private static int autoIncreament = 1;
    private String name;

    public SocketServer(Socket socket) {
        this.socket = socket;
        name = "user" + autoIncreament++;
        clientList.add(this);
    }

    @Override
    public void run() {
        System.out.println("[연결된 클라이언트 정보]");
        System.out.println("IP: " + socket.getInetAddress());

        try {
            inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            sendToAll(name + "님이 접속하였습니다.");

            while(true) {
                String message = reader.readLine();
                if(message == null) {
                    break;
                }
                sendToAll(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 브로드 캐스팅
    private void sendToAll(String message) throws IOException {
        for(SocketServer socketServer : clientList) {
            outputStream = socketServer.socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println(name + ": " + message);
        }
    }
}
