package client;

import java.io.*;
import java.net.*;
import Message.Message;
import UserModel.UserModel;

public class TheClient {
  /*
   * Creating a TheClient object before call the sendAndReceive method.
   */
  private static String ip = "192.168.43.81";
  private static int port = 20086;

  public TheClient() {
  }

  public Message sendAndReceive(Message messageToSend) throws IOException, ClassNotFoundException {
    /*
     * @param messageToSend: The Message object which will be sent to srver
     * 
     * @return: The Message object received from server
     */

    Message messageReceived;

    // * Create Socket Object
    try {
      Socket socket = new Socket(ip, port);
      socket.setSoTimeout(2000);
      System.out.println("Es klappt!");

      // * Create output and input stream
      ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

      // * Send Message
      output.writeObject(messageToSend);

      // * Cast input to Message Object
      messageReceived = (Message) input.readObject();

      socket.close();
      return messageReceived;
    } catch (SocketException e) {
      System.out.println("In TheCilent: " + e);
      System.out.println("NOTA BENE: Fail to connect to server, informations are generated for testing only!");
      return test(messageToSend);
    }
  }

  public Message test(Message message) {
    UserModel userModel = new UserModel();
    userModel.setCard("213182087");
    userModel.setCollege("艺术学院");
    userModel.setEmail("976720383@qq.com");
    userModel.setIdentity("学生");
    userModel.setPassword("123456");
    userModel.setSex("男");
    userModel.setUser_Name("任国林");
    userModel.setIdentity("学生");
    Message result = new Message("", userModel);
    return result;
  }
}
