package socketChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

  public static void main(String[] args) throws IOException {
    int port = 8888;
    ServerSocket socketServer = new ServerSocket(port);
    while(true) {
      Socket sock = socketServer.accept();
      System.out.println("ip : " + sock.getInetAddress() + " 와 연결되었습니다.");
      ReceiveThread receiveThread = new ReceiveThread(sock);
      receiveThread.start();
      SendThead sendThead = new SendThead(sock);
      sendThead.start();
    }
  }
}