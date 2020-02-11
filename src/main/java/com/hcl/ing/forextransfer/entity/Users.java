package com.hcl.ing.forextransfer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
	private String password;
	private String mobNum;
	private String eMail;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "User [uId=" + userId + ", uName=" + userName + ", password=" + password + ", mobNum=" + mobNum + ", eMail="
				+ eMail + "]";
	}

	

	public Users() {
		super();
	}

	public Users(Long userId, String userName, String password, String mobNum, String eMail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobNum = mobNum;
		this.eMail = eMail;
	}

}
