package main;

import javax.swing.JOptionPane;

import service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {
		String menu = "1.사원정보등록\n" + "2.직급이 과장인 사람들 조회\n" + "3.사원정보수정\n" + "0.프로그램 종료";
        EmployeeService service = new EmployeeService();
		while (true) {
			int no = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (no == 0)
				break;
			switch (no) {
			case 1:
				service.insertEmployee();
				break;
			case 2:
				service.searchManager();
				break;
			case 3:
				service.updateEmployee();
				break;

			}
		}

	}

}
