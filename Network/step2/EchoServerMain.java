package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMain {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			server = new ServerSocket(1234);
			System.out.println("클라이언트 접속 대기중.....");
			client = server.accept();
			System.out.println(client.getInetAddress() + " 접속함....");
			br = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(client.getOutputStream());
			while(true) {
				String msg = br.readLine();
				if(msg.equals("exit")) break;
				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null)br.close();
				if(pw != null)pw.close();
				if(client != null)client.close();
				if(server != null)server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}








