package com.entity;

import java.io.Serializable;

public class Fabu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String xiaoqu;
	private String dizhi;
	private String chenghu;
	private String tel;
	private String jiage;
	private Integer check;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getXiaoqu() {
		return xiaoqu;
	}
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getChenghu() {
		return chenghu;
	}
	public void setChenghu(String chenghu) {
		this.chenghu = chenghu;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getJiage() {
		return jiage;
	}
	public void setJiage(String jiage) {
		this.jiage = jiage;
	}
	public Integer getCheck() {
		return check;
	}
	public void setCheck(Integer check) {
		this.check = check;
	}
	
	
}
