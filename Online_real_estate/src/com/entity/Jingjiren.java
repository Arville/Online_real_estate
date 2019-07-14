package com.entity;

import java.io.Serializable;

public class Jingjiren implements Serializable{
	private static final long serialVersionUID = 1L;

    private Integer id;
    private String gonghao;
    private String zhanghao;
    private String mima;
    private String xingming;
    private String xingbie;
    private String phone;
    private String touxiang;
    private String addtime;
    
	
	
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



	public String getZhanghao() {
		return zhanghao;
	}



	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}



	public String getMima() {
		return mima;
	}



	public void setMima(String mima) {
		this.mima = mima;
	}



	public String getXingming() {
		return xingming;
	}



	public void setXingming(String xingming) {
		this.xingming = xingming;
	}



	public String getXingbie() {
		return xingbie;
	}



	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getTouxiang() {
		return touxiang;
	}



	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}



	public String getAddtime() {
		return addtime;
	}



	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Jingjiren [id=" + id + ", gonghao=" + gonghao + ", zhanghao=" + zhanghao + ", mima=" + mima
				+ ", xingming=" + xingming + ", xingbie=" + xingbie + ", phone=" + phone + ", touxiang=" + touxiang
				+ ", addtime=" + addtime + "]";
	}
    
    
}
