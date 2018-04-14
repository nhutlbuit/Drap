package model;

import java.util.HashSet;
import java.util.Set;


public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	private String address;
	private Set<Score> score = new HashSet<Score>(0);
	public Student() {
		super();
	}




	public int getStudentId() {
		return studentId;
	}




	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}




	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Score> getScore() {
		return score;
	}




	public void setScore(Set<Score> score) {
		this.score = score;
	}




	@Override
	public String toString() {
		return "Student [id=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ "]";
	}


}
