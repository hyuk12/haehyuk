package j25_소켓.multiSocket.client;

import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Client {

    public static String name;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9090);
            System.out.println("서버에 접속함?");

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
