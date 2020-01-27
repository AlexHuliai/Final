package com.capstone.caps.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="person")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private long id;
	@Column(name="last_name")
	private String lname;
	@Column(name="first_name")
	private String fname;
	@Column(name="telephone")
	private String telephone;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="age")
	private int age;
	@Column(name="zipcode")
	private String zipcode;
	@Transient
	private String pass2;
	private String role;
	@Transient
	MultipartFile file;
	private String image;
	
	
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public int getAge() {
		return age;
	}

	public String getZipcode() {
		return zipcode;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", lname='" + lname + '\'' +
				", fname='" + fname + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", telephone='" + telephone + '\'' +
				", age=" + age +
				", zipcode='" + zipcode + '\'' +
				", pass2='" + pass2 + '\'' +
				", role='" + role + '\'' +
				", file=" + file +
				", image='" + image + '\'' +
				'}';
	}
}
