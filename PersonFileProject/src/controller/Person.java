package controller;

import java.io.Serializable;

public class Person implements Serializable{
private static final long serialVersionUID = 201494989483792113L;
private String name;
private String tel;
private String email;
private int age;

public Person(String name, String tel, String email, int age) {
	super();
	this.name = name;
	this.tel = tel;
	this.email = email;
	this.age = age;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getTel() {
	return tel;
}
public void setTel(String pnum) {
	this.tel = tel;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "Person [name=" + name + ", tel=" + tel + ", email=" + email + ", age=" + age + "]";
}



}
