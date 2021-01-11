package vo;

public class AdressVO {

	private String name;
	private String tel;
	private String email;
	private int age;

	public AdressVO(String name, String tel, String email, int age) {

		this.name = name;
		this.tel = tel;
		this.email = email;
		this.age = age;
	}

	public void prinInfo() {
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + tel);
		System.out.println("이메일:" + email);
		System.out.println("나이:" + age);

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AdressVO))
			return false;
		AdressVO temp = (AdressVO) obj;
		if (name.equals(temp.name) && tel.equals(temp.tel))
			return true;
		// 이름 + 전화번호로 찾겠다는것.이름으로만 할거면 && 이후를 지우면 됨
		return false;

	}

}