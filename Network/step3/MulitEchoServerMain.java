package step3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MulitEchoServerMain {
	public static ArrayList<EchoServerWorker> list =
			new ArrayList<EchoServerWorker>();
	
	public static void closeWorker(EchoServerWorker worker) {
		list.remove(worker);
		System.out.println("현재 접속중인 클라이언트 수 : "+ list.size());
	}
	
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(1234);
			
			while(true) {
				client = server.accept();
				//스레드 생성 - 실행
				EchoServerWorker worker = new EchoServerWorker(client);
				worker.start();
				list.add(worker);
				System.out.println("현재 접속중인 클라이언트 : "+ list.size());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}




