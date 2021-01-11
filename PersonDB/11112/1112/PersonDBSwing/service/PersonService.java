package service;
//싱글톤

import java.util.ArrayList;

import dao.PersonDAO;
import vo.PersonVO;

public class PersonService {
	private static PersonService instance = new PersonService();

	private PersonService() {
	}

	public static PersonService getInstance() {
		if(instance == null)
			instance = new PersonService();
		return instance;
	}
	public ArrayList<PersonVO> selectAllPerson() throws Exception{
		return PersonDAO.getInstance().selectAllPerson();
	}

	public ArrayList<PersonVO> selectPerson(String name) throws Exception {
		if(name == null || name.length() == 0)
			throw new Exception("이름 데이터가 입력되지 않았습니다.");
		return PersonDAO.getInstance().selectPerson(name);
	}
	
	public void insertPerson(String name, int age) throws Exception {
		if(name == null || name.length() == 0)
			throw new Exception("이름 데이터가 입력되지 않았습니다.");
		if(age < 0)
			throw new Exception("나이 값이 비정상입니다.");
		PersonDAO.getInstance().insertPerson(new PersonVO(name, age));
	}
	
	public void deletePerson(String name) throws Exception {
		if(name == null || name.length() == 0)
			throw new Exception("이름 데이터가 입력되지 않았습니다.");
		PersonDAO.getInstance().deletePerson(name);
	}
	
	public void updatePerson(String name, PersonVO p) throws Exception{
		if(name == null || name.length() == 0)
			throw new Exception("이름 데이터가 입력되지 않았습니다.");
		if(p==null|| p.getName() == null || p.getName().length() == 0 || p.getAge()<0)
			throw new Exception("데이터가 입력되지 않았습니다.");
		
		PersonDAO.getInstance().updatePerson(name, p);
	
		
	}
}













