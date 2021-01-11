package vo;

public class PersonVO {
	//이름
	private String name;
	//나이
	private int age;
	//생성자 (이름, 나이)
	public PersonVO(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//setter/getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return name + ","+ age;
	}
	
	//toString ---> "홍길동,20"
	
}




