package main;

import java.util.Scanner;

import controller.Controller;
import controller.HandlerMapping;

public class PersonMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.Person 정보 입력:");
			System.out.println("2.Person 정보 조회:");
			System.out.println("3.Person 정보 수정:");
			System.out.println("4.Person 정보 삭제:");
			System.out.println("5.Person 정보 조회:");
			System.out.println("6.Person 정보 전체조회:");
			System.out.println("0.프로그램 종료:");
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
