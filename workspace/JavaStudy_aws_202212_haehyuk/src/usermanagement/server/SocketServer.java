package usermanagement.server;

import com.google.gson.Gson;
import usermanagement.dto.RequestDto;
import usermanagement.dto.ResponseDto;
import usermanagement.server.controller.AccountController;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread{
    private static List<SocketServer> socketServerList = new ArrayList<>();

    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Gson gson;

    public SocketServer(Socket socket) {
        this.socket = socket;
        gson = new Gson();
        socketServerList.add(this);
    }

    @Override
    public void run() {
        try {
            receiveRequest();
        } catch (IOException e) {
            System.out.println(socket.getInetAddress() + ":" + socket.getPort() +  " 클라이언트의 접속이 끊어졌습니다.");
        }
    }

    private void receiveRequest() throws IOException {
        inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        while(true) {
            String request = reader.readLine();
            if(request == null){
                throw new ConnectException();
            }

            RequestMapping(request);
        }
    }

    private void RequestMapping(String request) throws IOException {

        RequestDto<?> requestDto = gson.fromJson(request, RequestDto.class);

        String resource = requestDto.getResource();

        switch (resource) {
            case "register":
                ResponseDto<?> responseDto = AccountController.getInstance().register((String)requestDto.getBody());
                sendResponse(responseDto);
                break;
            default:
                System.out.println("해당 요청은 처리할 수 없습니다.(404)");
                break;
        }
    }

    private void sendResponse(ResponseDto<?> responseDto) throws IOException {
        String response = gson.toJson(responseDto);
        outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream, true);
        writer.println(response);
        writer.flush();
    }
}
