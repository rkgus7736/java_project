package controller;

import java.util.Scanner;

import service.StudentService;
import vo.Student;

public class InsertStudentController implements Controller {
	@Override
	public void execute(Scanner sc) {
		System.out.println("지금부터 학생 정보 추가를 시작합니다.......");
		//학번 이름 학과 평점 입력
		System.out.print("학번 입력 : ");
		String no = sc.nextLine();
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("전공 입력 : ");
		String major = sc.nextLine();
		System.out.print("평점 입력 : ");
		double score = sc.nextDouble();
		//Student 생성
		Student std = new Student(no,name,major,score);
		StudentService.getInstance().insertStudent(std);
	}
}



