package main;

import javax.swing.JOptionPane;

import service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {
		String menu = "1.����������\n" + "2.������ ������ ����� ��ȸ\n" + "3.�����������\n" + "0.���α׷� ����";
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
