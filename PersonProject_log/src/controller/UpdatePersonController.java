package controller;

import java.util.Scanner;

import service.PersonManageSystem;
import vo.Person;

public class UpdatePersonController extends Controller {
	@Override
	public void execute(Scanner sc) {
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		// 검색결과를 확인후
		Person p = PersonManageSystem.getInstance().selectPerson(new Person(name, 0));
		if (p == null)
			System.out.println("수정할 회원 정보가 없습니다.");
		else {
			// 수정
			p.setAge(age);
		}

	}
}
