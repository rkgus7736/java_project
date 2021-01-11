package controller;
import java.util.Scanner;

import log.LogController;
import service.PersonManageSystem;
import vo.Person;

public class InsertPersonController extends Controller {
	@Override
	public void execute(Scanner sc) {
		System.out.println("Person 정보 등록을 시작합니다.");
		// Person에 저장할 내용을 입력받아
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.println("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		// Person을 생성하고
		Person p = new Person(name, age);
		PersonManageSystem.getInstance().insertPerson(p);
		String content = this.getClass().getName() + " " + name + " " + age;
		LogController.getInstance().writeLog(1, content);
	}

}


