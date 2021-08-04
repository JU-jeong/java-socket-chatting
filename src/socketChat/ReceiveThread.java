package socketChat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveThread extends Thread {

  private final Socket socket;
  private String receiveString;

  public ReceiveThread(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
      while (true) {
        receiveString = tmpbuf.readUTF();
        if (receiveString == null) {
          System.out.println("상대방 연결이 종료되었습니다.");
        } else {
          System.out.println("상대방 : " + receiveString);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}