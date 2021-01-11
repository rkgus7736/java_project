package VO;

import java.io.Serializable;

public class EmployeeVO implements Serializable{
	/*
	 * 사번,
	 * 이름,
	 * 직급,
	 * 부서,
	 * 연봉
	 */
	private String eno;
	private String name;
	private String position;
	private String department;
	private int salary;
	
	public EmployeeVO(String eno, String name, String position, String department, int salary) {
		super();
		this.eno = eno;
		this.name = name;
		this.position = position;
		this.department = department;
		this.salary = salary;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eno == null) ? 0 : eno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		if (eno == null) {
			if (other.eno != null)
				return false;
		} else if (!eno.equals(other.eno))
			return false;
		return true;
	}

	
	}