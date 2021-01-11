package main;

import javax.swing.JOptionPane;

import controller.Controller;
import controller.HandlerMapping;

public class EmployeeMain {

	public static void main(String[] args) {

		String menu = "register -- 사원정보 등록\n"
		            + "search -- 사원정보 검색\n" 
				    + "update -- 사원정보 수정\n"
				    + "delete -- 실적이 100 미만인 사원 삭제\n" 
				    + "all -- 전체 사원정보 출력" 
				    + "exit -- 프로그램 종료" 
				    + "원하시는 메뉴를 입력해주세요.";
		while (true) {
			String command = JOptionPane.showInputDialog(menu);
			if (command.equals("exit"))
				break;
			Controller controller = HandlerMapping.getInstance().createController(command);

			if (controller != null)
				controller.execute();

		}

	}

}
