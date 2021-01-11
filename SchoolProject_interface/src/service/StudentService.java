package service;
import java.util.Arrays;
import java.util.Scanner;

import vo.Student;

public class StudentService {
	//Student 배열 선언
	private Student[] arr;
	//Student 배열 인덱스
	private int index;
	private static StudentService instance = new StudentService();
	//생성자
	//	배열길이 10 인 배열 생성
	private StudentService() {
		super();
		arr = new Student[10];
		arr[index++] = new Student("1001", "홍길동","컴퓨터공학과", 4.1);
		arr[index++] = new Student("1002", "이길동","경제학과", 3.1);
		arr[index++] = new Student("1003", "박길동","전자공학과", 4.2);
		arr[index++] = new Student("1004", "김길동","기계공학과", 1.3);
	}
	public static StudentService getInstance() {
		if(instance == null)
			instance = new StudentService();
		return instance;
	}
	
	//학생정보 추가
	public void insertStudent(Student std) {
		if(index == arr.length)
			Arrays.copyOf(arr, arr.length+5);
		//배열에 추가
		arr[index++] = std;
	}
	//학생정보 삭제
	public void deleteStudent(String no) {
		for(int i=0;i<index;i++) {
			if(arr[i].getSno().equals(no)) {
				for(;i<index-1;i++) {
					arr[i] = arr[i+1];
				}//for
				index--;
				System.out.println("삭제완료");
				return;//삭제완료
			}//if
		}//for
		System.out.println("삭제할 데이터가 없습니다.");
	}//deleteStudent

	//학생정보 조회
	public Student selectStudent(String no) {
		for(int i=0;i<index;i++) {
			if(no.equals(arr[i].getSno())) 
				return arr[i];
		}
		return null;
	}
	//학생정보 전체 조회
	public void selectAllStudent() {
		for(int i=0;i<index;i++) {
			arr[i].printStudentInfo();
			System.out.println(arr[i].getName() + "의 석차 : "
					+getRank(arr[i].getScore()));
		}
	}
	//해당 학생 석차 구하는 부분
	public int getRank(double score) {
		int rank = 1;
		
		for(int i=0;i<index ;i++) {
			if(score < arr[i].getScore())
				rank++;
		}
				
		return rank;
	}
	
}//end of class







