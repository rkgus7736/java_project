package controller;

import java.util.Scanner;

import service.StudentService;
import vo.Student;

public class SelectStudentController implements Controller {
	@Override
	public void execute(Scanner sc) {
		System.out.println("학생정보 조회를 시작합니다.");
		System.out.print("조회할 학번 : ");
		String sno = sc.nextLine();
		Student std = StudentService.getInstance().selectStudent(sno);
		if (std == null) {
			System.out.println("조회 결과가 없습니다.");
			return;
		}
		int rank = StudentService.getInstance().getRank(std.getScore());
		std.printStudentInfo();
		System.out.println("석차 : "+rank);
	}
}





