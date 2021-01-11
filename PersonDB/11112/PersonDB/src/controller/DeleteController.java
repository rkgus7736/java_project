package controller;

import java.util.Scanner;

import service.PersonService;

public class DeleteController implements Controller {

	@Override
	public void execute(Scanner sc) {
		System.out.println("Person 데이터 삭제를 시작합니다");
		System.out.println("이름:");
		String name = sc.nextLine();

		try {
			PersonService.getInstance().deletePerson(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
