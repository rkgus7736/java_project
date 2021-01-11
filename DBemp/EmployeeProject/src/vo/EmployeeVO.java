package vo;

// 사원정보 하나 저장하는 클래스
public class EmployeeVO {

	private String eno;
	private String name;
	private String department;
	private int position; // position은 SQL에서 숫자로 등록했었음

	public EmployeeVO(String eno, String name, String department, int position) {
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.position = position;
	}

	@Override
	public String toString() {
		return "EmployeeVO [eno=" + eno + ", name=" + name + ", department=" + department + ", position=" + position
				+ "]";
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
