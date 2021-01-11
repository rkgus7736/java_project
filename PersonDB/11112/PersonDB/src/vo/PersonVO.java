package vo;

public class PersonVO {
	// �̸�
	private String name;
	// ����
	private int age;

	// ������ (�̸�, ����)
	public PersonVO(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// setter/getter
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
		return name + "," + age;
	}

	// toString ---> "ȫ�浿,20"

}
