package j25_소켓;

import com.google.gson.Gson;
import usermanagement.dto.RequestDto;

import java.io.*;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class SocketClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("127.0.0.1", 9090);
            System.out.println("서버에 접속 성공!");
            InputStream inputStream = socket.getInputStream();
            // 버퍼 리더에는 생성될 당시에 reader 를 넣어야 하고 그 reader 를 상속받는 InputStreamReader 를 넣어 줄 수 있다.
            // 버퍼드 리더도 Reader 를 상속받는다.
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

//            System.out.println(reader.readLine());

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            Gson gson = new Gson();
            RequestDto<String> dto = new RequestDto<>("test", "test data");

            writer.println(gson.toJson(dto));

        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
