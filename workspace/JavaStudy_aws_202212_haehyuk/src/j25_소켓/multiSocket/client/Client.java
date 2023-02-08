package j25_소켓.multiSocket.client;

import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

// 인텔리제이에서 클라이언트 서버를 실행하기위해 하나의 클래스를 여러개 실행해야 할경우 런디버그 옵션에서 edit configuration 안의 modify option 에서 allow multiple connections 를 선택해주면 된다.
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9090);

            ClientReceive clientReceive = new ClientReceive(socket);
            clientReceive.start();

            ClientSend clientSend = new ClientSend(socket);
            clientSend.start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
