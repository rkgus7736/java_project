package controller;

import java.util.Scanner;

import exception.PersonException;
import log.LogController;
import service.PersonManageSystem;

public class DeletePersonController extends Controller {
	@Override
	public void execute(Scanner sc) {
		System.out.print("삭제할 이름 입력 : ");
		String name = sc.nextLine();
		try {
			PersonManageSystem.getInstance().deletePerson(name);
			String content = this.getClass().getName() + "받아온 데이터" + name;
			LogController.getInstance().writeLog(2, content);
		} catch (PersonException e) {
			String content = this.getClass().getName() + "받아온 데이터" + name;
			content += "Exception 발생";
			LogController.getInstance().writeLog(0, content);
			System.out.println(e.getMessage());

		}
	}
}
