package vo;

import java.io.Serializable;

public class AddressVO implements Serializable{
	private String name;
	private String tel;
	private String email;
	private int age;
	
	public AddressVO(String name, String tel, String email, int age) {
		super();
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.age = age;
	}

	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("연락처 : " + tel);
		System.out.println("이메일 : " + email);
		System.out.println("나이 : " + age);
		System.out.println();		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null) return false;
		if(!(obj instanceof AddressVO)) return false;
		AddressVO temp = (AddressVO) obj;
		if(name.equals(temp.name) && tel.equals(temp.tel)) return true;
		return false;
	}

	@Override
	public String toString() {
		return "AddressVO [name=" + name + ", tel=" + tel + ", email=" + email + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}
	
	
	
}



