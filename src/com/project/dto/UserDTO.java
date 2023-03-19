package com.project.dto;

public class UserDTO {

	private String username;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String address;

	public UserDTO() {

	}

	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserDTO(String username, String name, String password, String email, String phone, String address) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public UserDTO(String name, String password, String email, String phone, String address) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n" + "이메일 : " + email + "\n" + "전화번호 : " + phone + "\n" + "주소 : " + address;
	}

}
