package vo;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import controller.Person;

public class AdressList {

	public static void main(String[] args) {

		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("AdressVO.txt");
			pw = new PrintWriter(fw);

			Person p = new Person("홍길동", "01012341234", "rkg8227@naver.com", 24);
			pw.print(p);
			pw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();

		}
	}
}
