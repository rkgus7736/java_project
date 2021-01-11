package main;
import java.util.Scanner;

import controller.Controller;
import controller.HandlerMapping;
import service.StudentService;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu = "1. 학생정보등록\n"
				+ "2. 학생정보삭제\n"
				+ "3. 학생정보 수정\n"
				+ "4. 학생정보 조회\n"
				+ "5. 학생정보 전체 조회\n"
				+ "0. 프로그램 종료\n"
				+ "원하시는 메뉴 번호 입력하세요 : ";
		
		 while(true) {
			 //메뉴 출력
			 System.out.print(menu);
			 //메뉴 번호 입력
			 int no = sc.nextInt(); sc.nextLine();
			 //해당 기능을 실행
			 if(no==0) break;
			 
			 Controller controller = HandlerMapping.getInstance().createController(no);
			 
			 if(controller!=null)
				 controller.execute(sc);
		 }
	}
}



