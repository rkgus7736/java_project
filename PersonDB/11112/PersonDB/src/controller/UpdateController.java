package controller;

import java.util.Scanner;

import service.PersonService;
import vo.PersonVO;

public class UpdateController implements Controller {

	@Override
	public void execute(Scanner sc) {
		System.out.println("Person ������ ������ �����մϴ�.....");
		System.out.print("�˻��� �̸� :");
		String oldName = sc.nextLine();
		System.out.print("����� �̸� :");
		String name = sc.nextLine();
		System.out.print("����� ���� :");
		int age = sc.nextInt();
		sc.nextLine();
		try {
			PersonService.getInstance().updatePerson(oldName, new PersonVO(name, age));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
