package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

            System.out.println(reader.readLine());

        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
