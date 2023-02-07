package j25_소켓.multiSocket;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread{

    public static List<SocketServer> clientList = new ArrayList<>();
    private Socket socket;
    private String name;

    public SocketServer(Socket socket) {
        this.socket = socket;
        clientList.add(this);
    }

    @Override
    public void run() {
        System.out.println("[연결된 클라이언트 정보]");
        System.out.println("IP: " + socket.getInetAddress());

        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            writer.println("서버 접속 성공!");
            writer.println("사용자 이름을 입력하세요!");

            String messase = null;
            boolean loginFlag = false;
            while((messase = reader.readLine()) != null) {
                if(name == null) {
                    name = messase;
                    System.out.println("\n서버에 " + name + "님이 접속하였습니다.");
                }

                for(SocketServer s : clientList) {
                    try {
                        outputStream = s.socket.getOutputStream();
                        writer = new PrintWriter(outputStream, true);
                        if(!loginFlag) {
                            writer.println("\n" + s.name + "님이 접속하였습니다.");
                            loginFlag = true;
                            continue;
                        }
                        writer.println("\n" + s.name + ": " + messase);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
