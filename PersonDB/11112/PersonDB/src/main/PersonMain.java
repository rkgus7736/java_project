package main;

import java.util.Scanner;

import controller.Controller;
import controller.HandlerMapping;

public class PersonMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.Person ���� �Է�:");
			System.out.println("2.Person ���� ��ȸ:");
			System.out.println("3.Person ���� ����:");
			System.out.println("4.Person ���� ����:");
			System.out.println("5.Person ���� ��ȸ:");
			System.out.println("6.Person ���� ��ü��ȸ:");
			System.out.println("0.���α׷� ����:");
			int no = sc.nextInt();
			sc.nextLine();
			Controller controller = HandlerMapping.getInstance().createController(no);
			if (controller != null)
				controller.execute(sc);
			if (no == 0)
				break;
		}

	}

}
