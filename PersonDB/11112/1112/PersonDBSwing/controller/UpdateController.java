package controller;

import java.util.Scanner;

import service.PersonService;
import vo.PersonVO;

public class UpdateController implements Controller {

	@Override
	public void execute(Scanner sc) {
		System.out.println("Person 데이터 수정을 시작합니다.....");
		System.out.print("검색할 이름 :");
		String oldName = sc.nextLine();
		System.out.print("변경될 이름 :");
		String name = sc.nextLine();
		System.out.print("변경될 나이 :");
		int age = sc.nextInt(); sc.nextLine();
		try {
			PersonService.getInstance().
			updatePerson(oldName, new PersonVO(name, age));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





