package socketChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThead extends Thread{

  private final Socket socket;
  private Scanner scanner = new Scanner(System.in);

  public SendThead(Socket socket){
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
      String sendString;
      while(true){
        sendString = scanner.nextLine();
        sendWriter.writeUTF(sendString);
        sendWriter.flush();
      }
    }catch (IOException e){
      e.printStackTrace();
    }
  }
}