package org.manu.CRUDApp.dto;

public class Student {
	private String Name, Email, password, Collage, Dept, year, Gender;
	private long Phone;
	private double Per10, Perc12, DegreePer;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCollage() {
		return Collage;
	}

	public void setCollage(String collage) {
		Collage = collage;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		Phone = phone;
	}

	public double getPer10() {
		return Per10;
	}

	public void setPer10(double per10) {
		Per10 = per10;
	}

	public double getPerc12() {
		return Perc12;
	}

	public void setPerc12(double perc12) {
		Perc12 = perc12;
	}

	public double getDegreePer() {
		return DegreePer;
	}

	public void setDegreePer(double degreePer) {
		DegreePer = degreePer;
	}
}
