package com.raqib91.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "admin_tbl")
public class Admin {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "admin_id")
	private long adminID;
	@Column(name = "admin_username")
	private String adminUsername;
	@Column(name = "admin_password")
	private String adminPassword;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminUsername, String adminPassword) {
		super();
//		this.adminID = adminID;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public long getAdminID() {
		return adminID;
	}

	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ "]";
	}

}
