package com.school.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.school.users.requestbean.LoginBean;
import com.school.users.requestbean.RegistrationBean;

@Entity 
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

  	private String firstName;
  	private String lastName;
  	private String username;
  	private String password;
  	private String email;
  	private String address;
  	private String phone;
  	private String authenticationToken;
  	
  	public User() {
  		
  	}
  	
  	public User(LoginBean user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

	public User(RegistrationBean user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.address = user.getAddress();
		this.phone = user.getPhone();
	}
	
	public void copy(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.address = user.getAddress();
		this.phone = user.getPhone();
		this.authenticationToken = user.getAuthenticationToken();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ ", authenticationToken=" + authenticationToken + "]";
	}

}