package controller;

import java.util.Scanner;

import service.StudentService;
import vo.Student;

public class UpdateStudentController implements Controller {
	@Override
	public void execute(Scanner sc) {
		System.out.println("학생정보 수정을 시작합니다.");
		System.out.print("수정할 학번 : ");
		String sno = sc.nextLine();
		Student std = StudentService.getInstance().selectStudent(sno);
		if(std == null) {
			System.out.println("수정할 데이터가 없습니다.");
			return;
		}
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 학과 : ");
		String major = sc.nextLine();
		System.out.print("수정할 평점 : ");
		double score = sc.nextDouble();
		std.setName(name);
		std.setMajor(major);
		std.setScore(score);
		System.out.println("수정이 정상적으로 끝났습니다.");
	}
}



