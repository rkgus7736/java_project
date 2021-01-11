package controller;

import java.util.Scanner;

import service.PersonManageSystem;
import vo.Person;

public class SelectPersonController extends Controller {
	@Override
	public void execute(Scanner sc) {
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		Person p = PersonManageSystem.getInstance().selectPerson(new Person(name, 0));
		if (p == null)
			System.out.println("검색 결과가 없습니다.");
		else
			p.printInfo();

	}

}
