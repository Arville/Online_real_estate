package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kanfang;

public interface KanfangServer {

  public int add(Kanfang po);

  public int update(Kanfang po);
  
  
  
  public int delete(int id);

  public List<Kanfang> getAll(Map<String,Object> map);
  public List<Kanfang> getsykanfang1(Map<String,Object> map);
  public List<Kanfang> getsykanfang2(Map<String,Object> map);
  public List<Kanfang> getsykanfang3(Map<String,Object> map);
  public Kanfang quchongKanfang(Map<String, Object> acount);

  public Kanfang getById( int id);

  public List<Kanfang> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kanfang> select(Map<String, Object> map);
}
//	所有List
