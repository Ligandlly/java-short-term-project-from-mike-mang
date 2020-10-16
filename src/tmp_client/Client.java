package tmp_client;
import java.net.*;
import java.io.*;

public class Client {
	public boolean response;
	public Client(String text, String serverName, int port) {
        try {
            // System.out.println("连接到主机：" + serverName + " ，端口号：" + port);  
            Socket client = new Socket(serverName, port);
            // System.out.println("远程主机地址：" + client.getRemoteSocketAddress());  /
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF(text);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
//            System.out.println("服务器响应： " + in.readUTF());
            response = in.readBoolean();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
