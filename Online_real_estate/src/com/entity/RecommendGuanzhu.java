package com.entity;

import java.io.Serializable;
import java.util.List;

public class RecommendGuanzhu implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String ufid;
	private List<String> bianhao2;
	
	public String getUfid() {
		return ufid;
	}
	public void setUfid(String ufid) {
		this.ufid = ufid;
	}
	public List<String> getBianhao2() {
		return bianhao2;
	}
	public void setBianhao2(List<String> bianhao2) {
		this.bianhao2 = bianhao2;
	}
	@Override
	public String toString() {
		return "RecommendGuanzhu [ufid=" + ufid + ", bianhao2=" + bianhao2 + "]";
	}
	
	
}
