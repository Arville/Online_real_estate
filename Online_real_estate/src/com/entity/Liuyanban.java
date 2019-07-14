package com.entity;

import java.io.Serializable;

public class Liuyanban implements Serializable{
   
	private static final long serialVersionUID = 1L;
	
	private String ufid;
	private String bianhao;
	private String gonghao;
	private String lyneirong;
	private String addtime;
	
	
	public String getUfid() {
		return ufid;
	}
	public void setUfid(String ufid) {
		this.ufid = ufid;
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getGonghao() {
		return gonghao;
	}
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	public String getLyneirong() {
		return lyneirong;
	}
	public void setLyneirong(String lyneirong) {
		this.lyneirong = lyneirong;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
	
   
}
