package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kanfang;

public interface KanfangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kanfang record);

    int insertSelective(Kanfang record);

    Kanfang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kanfang record);
	
    int updateByPrimaryKey(Kanfang record);
	public Kanfang quchongKanfang(Map<String, Object> jingjiren);
	public List<Kanfang> getAll(Map<String, Object> map);
	public List<Kanfang> getsykanfang1(Map<String, Object> map);
	public List<Kanfang> getsykanfang3(Map<String, Object> map);
	public List<Kanfang> getsykanfang2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kanfang> getByPage(Map<String, Object> map);
	public List<Kanfang> select(Map<String, Object> map);
//	所有List
}

