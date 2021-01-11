package controller;

import java.util.Scanner;

import service.PersonService;

public class DeleteController implements Controller {

	@Override
	public void execute(Scanner sc) {
		System.out.println("Person ������ ������ �����մϴ�");
		System.out.println("�̸�:");
		String name = sc.nextLine();

		try {
			PersonService.getInstance().deletePerson(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
