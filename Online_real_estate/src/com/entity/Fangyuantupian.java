package com.entity;

import java.io.Serializable;

public class Fangyuantupian implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String bianhao;
	private String tupian;
	private String tupian2;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getTupian() {
		return tupian;
	}
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	public String getTupian2() {
		return tupian2;
	}
	public void setTupian2(String tupian2) {
		this.tupian2 = tupian2;
	}
	
	
}
