package com.capston.caps.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="newusers")
public class Users {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="user_id")
private int user_id;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="id")
//	private long id;
	@Column(name="lastname")
	private String lname;
	@Column(name="firstname")
	private String fname;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Transient
	private String repeatepass;
	private String role;
	@Transient
	@Column(name="file")
	MultipartFile file;
	private String image;
	private String code;



	@ManyToMany
	@JoinTable(
			name = "event_atendies",
			joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "event_id"))
	  private List<Event> userEvents;
//	@OneToMany(cascade	 = CascadeType.ALL)
//	@JoinColumn(name="email", referencedColumnName = "email")
//	private List<Event> usersEvents;

	public void setUserEvents(List<Event> userEvents) {
		this.userEvents = userEvents;
	}

	public List<Event> getUserEvents() {
		return userEvents;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

//	public List<Event> getUsersEvents() {
//		return usersEvents;
//	}
//
//	public void setUsersEvents(List<Event> usersEvents) {
//		this.usersEvents = usersEvents;
//	}

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
	public String getRepeatepass() {
		return repeatepass;
	}
	public void setRepeatepass(String repeatepass) {
		this.repeatepass = repeatepass;
	}
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Users [id=" + user_id + ", lname=" + lname + ", fname=" + fname + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", repeatepass=" + repeatepass + ", role=" + role + ", file=" + file
				+ ", image=" + image + "]";
	}
	
	
}
