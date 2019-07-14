package com.entity;

import java.io.Serializable;

public class Guanzhu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String ufid;
	private String bianhao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "Guanzhu [id=" + id + ", ufid=" + ufid + ", bianhao=" + bianhao + "]";
	}
	
	
	
}
