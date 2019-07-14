package com.entity;

import java.io.Serializable;

public class Kanfang implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String gonghao;
	private String bianhao;
	private String kfsj;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGonghao() {
		return gonghao;
	}
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getKfsj() {
		return kfsj;
	}
	public void setKfsj(String kfsj) {
		this.kfsj = kfsj;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
