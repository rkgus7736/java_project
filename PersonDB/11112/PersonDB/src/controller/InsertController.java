package controller;

import java.util.Scanner;
import service.PersonService;

public class InsertController implements Controller {

	public void execute(Scanner sc) {
		System.out.println("Person �����͸� �߰��մϴ�.");
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.println("����:");
		int age = sc.nextInt();
		try {
			PersonService.getInstance().insertPerson(name, age);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
