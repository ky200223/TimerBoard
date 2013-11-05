package org.nhnnext.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@Column(length = 50, nullable = false)
	private String userEmail;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 100, nullable = false)
	private String nickName;
	
	@Column(length = 1000, nullable = false)
	private String profilePicName;
	
	public String getProfilePicName() {
		return profilePicName;
	}
	
//	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
//    private List<Board> boards;

	public void setProfilePicName(String profilePicName) {
		this.profilePicName = profilePicName;
	}

	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
