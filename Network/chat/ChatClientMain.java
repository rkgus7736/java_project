package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientMain {

	public static void main(String[] args) {
		Socket server = null;
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);

		try {
			server = new Socket("192.168.1.101", 1234);
			Worker worker = new Worker(server);
			worker.start();
			pw = new PrintWriter(server.getOutputStream());
			while (true) {
				System.out.println("메세지 입력 > ");
				String msg = sc.nextLine();
				pw.println(msg);
				pw.flush();
				if (msg.equals("exit"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static class Worker extends Thread {
		private BufferedReader br;

		public Worker(Socket server) {
			try {
				br = new BufferedReader(new InputStreamReader(server.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (true) {
					String msg = br.readLine();
					if (msg == null || msg.equals("exit"))
						break;
					System.out.println(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
