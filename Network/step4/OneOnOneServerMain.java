package step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneOnOneServerMain {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);

		try {
			server = new ServerSocket(1234);
			client = server.accept();
			Worker worker = new Worker(client);
			worker.start();
			pw = new PrintWriter(client.getOutputStream());
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

		public Worker(Socket client) {
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
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
					System.out.println("상대방이 보낸 메세지 : " + msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
