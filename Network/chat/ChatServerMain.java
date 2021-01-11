package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerMain {
	public static ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(1234);

			while (true) {
				Socket client = server.accept();
				System.out.println("현재 " + list.size() + "명 접속했습니다...");
				ServerWorker worker = new ServerWorker(client);
				worker.start();
				list.add(worker);
				System.out.println(client.getInetAddress() + " 접속했습니다...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static class ServerWorker extends Thread {
		private BufferedReader br;
		private PrintWriter pw;
		private Socket client;

		public ServerWorker(Socket client) {
			this.client = client;
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = new PrintWriter(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (true) {
					String str = br.readLine();
					if(str == null || str.equals("exit"))
						 break;
					broadCasting(client.getInetAddress() + "님의 메세지 :"+ str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				list.remove(this);
				System.out.println(client.getInetAddress() + "님이 접속 종료했습니다.");
				System.out.println("현재 " + list.size() + "분이 접속중입니다...");
			}
		}

		public void sendMessage(String str) {
			pw.println(str);
			pw.flush();
		}

	}

	public static void broadCasting(String str) {
		for(int i=0;i<list.size();i++)
			list.get(i).sendMessage(str);
	}
	
	
}




