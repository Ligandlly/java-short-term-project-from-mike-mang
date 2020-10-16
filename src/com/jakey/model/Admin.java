package com.jakey.model;

import java.io.Serializable;

/**
 * ”√ªßModel¿‡
 * @author Administrator
 *
 */
public class Admin implements Serializable{
	private int adminId;
	private String password;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
