package com.school.users.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "login")
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
  	private String username;
  	private String authenticationToken;
  	
//  	@OneToOne(mappedBy = "userLogin")
//    private UserRegistration userRegistration;
  	
  	
  	
  	

	public UserLogin() {
	}



	public UserLogin(String username, String authenticationToken) {
		this.username = username;
		this.authenticationToken = authenticationToken;
	}

	

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the authenticationToken
	 */
	public String getAuthenticationToken() {
		return authenticationToken;
	}

	/**
	 * @param authenticationToken the authenticationToken to set
	 */
	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}


//	/**
//	 * @return the userRegistration
//	 */
//	public UserRegistration getUserRegistration() {
//		return userRegistration;
//	}
//
//
//
//	/**
//	 * @param userRegistration the userRegistration to set
//	 */
//	public void setUserRegistration(UserRegistration userRegistration) {
//		this.userRegistration = userRegistration;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "UserLogin [loginId=" + id + ", username=" + username + ", authenticationToken="
//				+ authenticationToken + ", userRegistration=" + userRegistration + "]";
//	}

	
	
  	
  	

}
