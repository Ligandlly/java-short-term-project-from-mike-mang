package com.ycz.net;

import java.io.*;
import java.net.*;

import Message.*;

public class Client {
  /*
   * Creating a TheClient object before call the sendAndReceive method.
   */
  private static String ip = "192.168.43.66";
	//private static String ip = "localhost";
  private static int port = 10086;

  public Client() {
  }

  public Message sendAndReceive(Message messageToSend)
      throws UnknownHostException, IOException, ClassNotFoundException {
    /*
     * @param messageToSend: The Message object which will be sent to srver
     * 
     * @return: The Message object received from server
     */

    Message messageReceived;

    // * Create Socket Object
    Socket socket = new Socket(ip, port);
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
  }
}
