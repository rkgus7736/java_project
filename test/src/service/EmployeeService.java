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
		readFile();// readfile �޼��带 ����ڴ�.
	}

	public void readFile() { // arraylist�� �ִ� ������ �о�ͼ� ���Ϸ� �Է�
		FileInputStream fis = null;// object ���� �ҷ��ö� �������
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("employee.dat");
			ois = new ObjectInputStream(fis);

			while (true) {
				list.add((EmployeeVO) ois.readObject());
				// (employeeVO)�� ����ȯ�ؼ� �о���ڴٴ� ��
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

	public void writeFile() { // arraylist�� �ִ� ������ ���Ϸ� ���
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
		String eno = JOptionPane.showInputDialog("����Է�:");
		String name = JOptionPane.showInputDialog("�̸��Է�:");
		String position = JOptionPane.showInputDialog("�����Է�:");
		String department = JOptionPane.showInputDialog("�μ��Է�:");
		int salary = Integer.parseInt("�����Է�:");

		EmployeeVO vo = new EmployeeVO(eno, name, position, department, salary);
		list.add(vo);
		writeFile();// �ڵ����� ���
	}

	public void updateEmployee() {
		String eno = JOptionPane.showInputDialog("������ ����Է�:");
		String name = JOptionPane.showInputDialog("������ �̸��Է�:");
		String position = JOptionPane.showInputDialog("������ �����Է�:");
		String department = JOptionPane.showInputDialog("������ �μ��Է�:");
		int salary = Integer.parseInt("������  �����Է�:");

		EmployeeVO vo = new EmployeeVO(eno, name, position, department, salary);
		list.add(vo);

		int index = list.indexOf(vo);// �� ���� ����ֳ� ���ϴ°�(-1�̸� ������ ���� 0�̸� ������ ����)
		if (index != -1)
			list.set(index, vo);// �������� ��ü
		writeFile();

	}

	public void searchManager() {// ����˻�
		for (int i = 0; i < list.size(); i++) {// ����Ʈ ó������ ������ ����
			if (list.get(i).getPosition().equals("����"))
				System.out.println(list.get(i).toString());
		}

	}

}
