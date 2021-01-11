package service;

import java.util.ArrayList;
import java.util.Iterator;

import exception.PersonException;
import vo.Person;

//Person 정보를 관리하는 시스템
public class PersonManageSystem {

	// Person ArrayList 선언
	private ArrayList<Person> list;

	private static PersonManageSystem instance = new PersonManageSystem();

	// 생성자
	private PersonManageSystem() {
		// 리스트 생성 - 요소가 30개 저장되겠끔 할당
		list = new ArrayList<Person>(30);
		// 리스트에 객체 추가
		list.add(new Person("홍길동", 30));
		list.add(new Person("김철수", 23));
		list.add(new Person("박현우", 19));
	}

	public static PersonManageSystem getInstance() {
		if (instance == null)
			instance = new PersonManageSystem();
		return instance;
	}

	// Person 정보 등록
	public void insertPerson(Person p) {
		// 리스트에 추가
		list.add(p);
	}

	// Person 정보 삭제
	public void deletePerson(String name) throws PersonException {
		// 삭제가 실패 할경우
		// Exception 발생 -> 삭제할 데이터가 없습니다.
		if (!list.remove(new Person(name, 0)))
			throw new PersonException("삭제할 데이터가 없습니다.");
	}

	// Person 정보 전체 조회
	public void selectAllPerson() {
		// list에 Person 객체가 하나도 없으면 Exception
		// Exception 메세지 : 등록된 Person이 없습니다.
		// 전체 Person의 printInfo 실행
		try {
			if (list.isEmpty())
				throw new PersonException("등록된 Person이 없습니다.");
			Iterator<Person> it = list.iterator();
			while (it.hasNext())
				it.next().printInfo();
		} catch (PersonException e) {
			System.out.println(e.getMessage());
		}
	}

	// Person 정보 조회
	// 특정 Person 정보를 조회
	// Person 이름을 이용해서 검색
	// 입력한 이름을 가진 Person을 검색
	public Person selectPerson(Person p) {
		/*
		 * //반복문 버전 for (Person p : list) { if (p.equals(name)) return p; } for (int i =
		 * 0; i < list.size(); i++) { if (list.get(i).equals(name)) return list.get(i);
		 * } return 0;
		 */
//		return list.indexOf(name) != -1 ? list.get(list.indexOf(name)) : null ;
		// 삼항연산자 이용 부분
		return list.contains(p) ? list.get(list.indexOf(p)) : null;
	}
}
