package com.entity;

import java.io.Serializable;

public class Yonghu implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private String tel;
	private String ufid;
	private String touxiang;
	private String touxiang2;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUfid() {
		return ufid;
	}
	public void setUfid(String ufid) {
		this.ufid = ufid;
	}
	public String getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	public String getTouxiang2() {
		return touxiang2;
	}
	public void setTouxiang2(String touxiang2) {
		this.touxiang2 = touxiang2;
	}
	
	public Yonghu() {
	}
	
	public Yonghu(String username, String password, String tel, String ufid, String touxiang,String touxiang2) {
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.ufid = ufid;
		this.touxiang = touxiang;
		this.touxiang2 = touxiang2;
	}
	
	
}
