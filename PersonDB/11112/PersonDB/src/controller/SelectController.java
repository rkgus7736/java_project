package controller;

import java.util.ArrayList;
import java.util.Scanner;

import service.PersonService;
import vo.PersonVO;

public class SelectController implements Controller {

	@Override
	public void execute(Scanner sc) {
		System.out.println("Preson ���� �˻��� �����մϴ�....");
		System.out.print("�˻��� �̸��� �Է� : ");
		String name = sc.nextLine();

		try {
			ArrayList<PersonVO> list = PersonService.getInstance().selectPerson(name);
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}