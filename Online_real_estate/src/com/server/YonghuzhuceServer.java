package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Fangyuanxinxi;
import com.entity.Yonghu;
import com.entity.Yonghuzhuce;

public interface YonghuzhuceServer {
	
	int insertYonghu(Yonghu yonghu);
	
	Yonghu selectYonghu(Map<String, Object> map);
	
	Fangyuanxinxi selectGuanzhufangyuan(String bianhao);
	
	List<String> selectBianhao(Map<String, Object> map);
	
	int selecCounttBianhao(String ufid);

  public int add(Yonghuzhuce po);

  public int update(Yonghuzhuce po);
  
  Yonghu selectBuUsername(String username);
  
  public int delete(int id);

  public List<Yonghuzhuce> getAll(Map<String,Object> map);
  public List<Yonghuzhuce> getsyyonghuzhuce1(Map<String,Object> map);
  public List<Yonghuzhuce> getsyyonghuzhuce2(Map<String,Object> map);
  public List<Yonghuzhuce> getsyyonghuzhuce3(Map<String,Object> map);
  public Yonghuzhuce quchongYonghuzhuce(Map<String, Object> acount);

  public Yonghuzhuce getById( int id);

  public List<Yonghuzhuce> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yonghuzhuce> select(Map<String, Object> map);
}
//	所有List
