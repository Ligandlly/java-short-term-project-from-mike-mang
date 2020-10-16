package com.ycz.Server;

import java.net.*;
import java.sql.Connection;
import java.sql.ResultSet;

import UserDAO.UserDAO;
import java.io.*;

import UserModel.UserModel;
import com.ycz.Ubtil.*;

import Message.*;

public class greetingserver extends Thread {
	private static ServerSocket serverSocket;
	public Socket socket;
	private static Message receivedMessage;

	public greetingserver(Socket s) throws IOException {
		socket = s;
	}

	public void run() {
		//连接上数据库
		Connection con = null;
		Library_dbUtil D = new Library_dbUtil();
		try {
			con = D.getCon();
			try {
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				receivedMessage = (Message) in.readObject();
				Message messageToSend = new Message();
				messageToSend = selectmode(con, receivedMessage);
				out.writeObject(messageToSend);
				out.flush();
				socket.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static Message selectmode(Connection con, Message message) {
		Message messageToSend = new Message();
		switch (message.getCheckCode()) {
		case 1:
			try {
				//messageToSend = DealProblem.Login(con, message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:
			try {
				//messageToSend = DealProblem.Shop(con, message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 3:
			try {
				messageToSend = DealProblem.Library(con, message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 4:
			try {
				//messageToSend = DealProblem.StudentManagement(con, message);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 5:
			try {
				//messageToSend = DealProblem.Hospital(con, message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 6:
			try {
				//messageToSend = DealProblem.Course(con, message);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}

		return messageToSend;

	}

	public static void main(String[] args) throws IOException {
		int port = 10086;
		serverSocket = new ServerSocket(port);
		while (true) {
			greetingserver greetingServer = new greetingserver(serverSocket.accept());
			greetingServer.start();
		}
	}
}
