package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import VO.EmployeeVO;

public class EmployeeService {
	private ArrayList<EmployeeVO> list;

	public EmployeeService() {
		list = new ArrayList<EmployeeVO>();
		readFile();// readfile 메서드를 만들겠다.
	}

	public void readFile() { // arraylist에 있는 내용을 읽어와서 파일로 입력
		FileInputStream fis = null;// object 파일 불러올때 써줘야함
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("employee.dat");
			ois = new ObjectInputStream(fis);

			while (true) {
				list.add((EmployeeVO) ois.readObject());
				// (employeeVO)를 형변환해서 읽어오겠다는 것
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void writeFile() { // arraylist에 있는 내용을 파일로 출력
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("employee.dat");
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i < list.size(); i++)
				oos.writeObject(list.get(i));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {

				if (oos != null)
					oos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void insertEmployee() {
		String eno = JOptionPane.showInputDialog("사번입력:");
		String name = JOptionPane.showInputDialog("이름입력:");
		String position = JOptionPane.showInputDialog("직급입력:");
		String department = JOptionPane.showInputDialog("부서입력:");
		int salary = Integer.parseInt("연봉입력:");

		EmployeeVO vo = new EmployeeVO(eno, name, position, department, salary);
		list.add(vo);
		writeFile();// 자동으로 등록
	}

	public void updateEmployee() {
		String eno = JOptionPane.showInputDialog("수정할 사번입력:");
		String name = JOptionPane.showInputDialog("수정할 이름입력:");
		String position = JOptionPane.showInputDialog("수정할 직급입력:");
		String department = JOptionPane.showInputDialog("수정할 부서입력:");
		int salary = Integer.parseInt("수정할  연봉입력:");

		EmployeeVO vo = new EmployeeVO(eno, name, position, department, salary);
		list.add(vo);

		int index = list.indexOf(vo);// 이 값이 어디있나 비교하는것(-1이면 데이터 없음 0이면 데이터 있음)
		if (index != -1)
			list.set(index, vo);// 기존값과 교체
		writeFile();

	}

	public void searchManager() {// 과장검색
		for (int i = 0; i < list.size(); i++) {// 리스트 처음부터 끝까지 접근
			if (list.get(i).getPosition().equals("과장"))
				System.out.println(list.get(i).toString());
		}

	}

}
