package com.flickr.modelattribute.beans;

import org.springframework.web.multipart.MultipartFile;

public class User implements java.io.Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -384387049333965527L;
	
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private MultipartFile picture;
	private String username;
	private String password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
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
		return "User [firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", phonenumber=" + phonenumber
				+ ", picture=" + picture + ", username=" + username
				+ ", password=" + password + "]";
	}
	public User(String firstname, String lastname, String email,
			String phonenumber, MultipartFile picture, String username,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.picture = picture;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}

	

}
