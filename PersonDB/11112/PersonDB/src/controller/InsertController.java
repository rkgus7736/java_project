package controller;

import java.util.Scanner;
import service.PersonService;

public class InsertController implements Controller {

	public void execute(Scanner sc) {
		System.out.println("Person 데이터를 추가합니다.");
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.println("나이:");
		int age = sc.nextInt();
		try {
			PersonService.getInstance().insertPerson(name, age);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
