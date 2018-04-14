package model;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private int id;
	private String firstname;
	private String lastname;
	private int age;
	private boolean sex;
	private String username;
	private String password;
	
	private Address address;
	
	
	private Set<Score> scores = new HashSet<Score>();
	
	public Student() {
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public boolean isSex() {
		return sex;
	}



	public void setSex(boolean sex) {
		this.sex = sex;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Set<Score> getScores() {
		return scores;
	}



	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "name: " + this.firstname + " id: " + this.id;
	}


	

}
