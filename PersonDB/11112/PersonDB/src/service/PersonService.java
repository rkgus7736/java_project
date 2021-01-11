package service;
//�̱���

import java.util.ArrayList;

import DAO.PersonDAO;
import vo.PersonVO;

public class PersonService {
	private static PersonService instance = new PersonService();

	private PersonService() {
	}

	public static PersonService getInstance() {
		if (instance == null)
			instance = new PersonService();
		return instance;
	}

	public ArrayList<PersonVO> selectAllPerson() throws Exception {
		return PersonDAO.getInstance().selectAllPerson();
	}

	public ArrayList<PersonVO> selectPerson(String name) throws Exception {
		if (name == null || name.length() == 0)
			// if () �� ������ �ٲ�� �ȵ�.
			// ������ �ĺ��� ó�� �Ǳ� ������ �̸��� �Է��ߴ������� Ȯ���ؾ���
			throw new Exception("�̸� �����Ͱ� �Էµ��� �ʾҽ��ϴ�.");
		return PersonDAO.getInstance().selectPerson(name);
	}

	public void insertPerson(String name, int age) throws Exception {
		if (name == null || name.length() == 0)
			throw new Exception("�̸� �����Ͱ� �Էµ��� �ʾҽ��ϴ�.");
		if (age < 0)
			throw new Exception("���� ���� �������Դϴ�.");
		PersonDAO.getInstance().insertPerson(new PersonVO(name, age));
	}

	public void deletePerson(String name) throws Exception {
		if (name == null || name.length() == 0)
			throw new Exception("�̸� �����Ͱ� �Էµ��� �ʾҽ��ϴ�.");
		PersonDAO.getInstance().deletePerson(name);
	}

	public void updatePerson(String name, PersonVO p) throws Exception {
		if (name == null || name.length() == 0)
			throw new Exception("�̸� �����Ͱ� �Էµ��� �ʾҽ��ϴ�.");
		if (p == null || p.getName() == null || p.getName().length() == 0 || p.getAge() < 0)
			throw new Exception("�����Ͱ� �Էµ��� �ʾҽ��ϴ�.");

		PersonDAO.getInstance().updatePerson(name, p);

	}
}
