package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServerWorker extends Thread {
	private BufferedReader br;
	private PrintWriter pw;
	private Socket client;

	public EchoServerWorker(Socket client) {
		try {
			this.client = client;
			pw = new PrintWriter(client.getOutputStream());
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
				if (msg.equals("exit"))
					break;
				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println(client.getInetAddress()+" 접속 종료");
			MulitEchoServerMain.closeWorker(this);
		}
	}

}



