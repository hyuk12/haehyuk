package simplechatting2.server;

import com.google.gson.Gson;
import lombok.Getter;
import simplechatting2.dto.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

@Getter
class ConnectedSocket extends Thread{
    private static List<ConnectedSocket> socketList = new ArrayList<>();
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Gson gson;
    private String username;

    public ConnectedSocket(Socket socket) {
        this.socket = socket;
        gson = new Gson();
        socketList.add(this);
    }

    @Override
    public void run() {
        try {
            inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while(true) {
                String request = reader.readLine(); // requestDto 가 JSON 형식으로 들어올 예정
                RequestDto requestDto = gson.fromJson(request, RequestDto.class);

                switch (requestDto.getResource()) {
                    case "join":
                        JoinReqDto joinReqDto = gson.fromJson(requestDto.getBody(), JoinReqDto.class);
                        username = joinReqDto.getUsername();
                        List<String> connectedUsers = new ArrayList<>();
                        for(ConnectedSocket connectedSocket : socketList) {
                            connectedUsers.add(connectedSocket.getUsername());
                        }
                        JoinRespDto joinRespDto = new JoinRespDto(username + "님이 접속하였습니다.", connectedUsers);
                        sendToAll(requestDto.getResource(), "ok", gson.toJson(joinRespDto));
                        break;

                    case "sendMessage":
                        MessageReqDto messageReqDto = gson.fromJson(requestDto.getBody(), MessageReqDto.class);

                        if (messageReqDto.getToUser().equalsIgnoreCase("all")) {
                            String message = messageReqDto.getFromUser() + "[전체]: " + messageReqDto.getMessageValue();
                            MessageRespDto messageRespDto = new MessageRespDto(message);
                            sendToAll(requestDto.getResource(), "ok", gson.toJson(messageRespDto));
                        }else {
                            String message = messageReqDto.getFromUser() + "[" + messageReqDto.getToUser() +" ]: " + messageReqDto.getMessageValue();
                            MessageRespDto messageRespDto = new MessageRespDto(message);
                            sendToUser(requestDto.getResource(), "ok", gson.toJson(messageRespDto), messageReqDto.getToUser());
                        }
                        break;

                }

                if(request == null) {
                    throw new SocketException();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToAll(String resource, String status, String body) throws IOException {
        ResponseDto responseDto = new ResponseDto(resource, status, body);
        for(ConnectedSocket connectedSocket : socketList) {
            outputStream = connectedSocket.getSocket().getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            writer.println(gson.toJson(responseDto));
        }
    }

    private void sendToUser(String resource, String status, String body, String toUser) throws IOException {
        ResponseDto responseDto = new ResponseDto(resource, status, body);
        for(ConnectedSocket connectedSocket : socketList) {


            if (connectedSocket.getUsername().equals(toUser) || connectedSocket.getUsername().equals(username)) {
                outputStream = connectedSocket.getSocket().getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);

                writer.println(gson.toJson(responseDto));
            }
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

                boolean connected = socket.isConnected() && ! socket.isClosed();

                if(connected) {
                    ConnectedSocket connectedSocket = new ConnectedSocket(socket);
                    connectedSocket.start();
                } else {

                }
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
