package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			//1. Server Open
			server = new ServerSocket(1234);
			//2. Client Accept
			client = server.accept();//클라이언트가 접속할때까지 기달림
			System.out.println(client.getInetAddress() + "님 접속");
			//3. Stream Init
			pw = new PrintWriter(client.getOutputStream());
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//4. I/O Process
			String msg = br.readLine();
			System.out.println("클라이언트가 보낸 메세지 : " + msg);
			pw.println("서버가 보낸 메세지 : " + msg);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//5. close
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






