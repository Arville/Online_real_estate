package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Liuyanban;
import com.entity.UserLiuyanban;

public interface LiuyanbanMapper {
	
	
	//插入留言内容
	void insertLiuyan(Map<String, Object> map);
	
	//经纪人查询未回复留言内容总数量
	int selectCountLiuyanByishf(Map<String, Object> map);
	
	//经纪人更新回复
	void updateLiuyanban(Map<String, Object> map);
	
	//经纪人查询未回复留言内容
	List<Liuyanban> selectLiuyanByishf(Map<String, Object> map);
	
	//用户中心用户查看回复消息
	List<UserLiuyanban> selectLiuyanByYonghu(String ufid);
	
	
    int deleteByPrimaryKey(Integer id);
    int insert(Liuyanban record);
    int insertSelective(Liuyanban record);
    Liuyanban selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Liuyanban record);
	int updateByPrimaryKeySelectivelb(Liuyanban record);
    int updateByPrimaryKey(Liuyanban record);
	public Liuyanban quchongLiuyanban(Map<String, Object> uname);
	public List<Liuyanban> getAll(Map<String, Object> map);
	public List<Liuyanban> getsyliuyanban1(Map<String, Object> map);
	public List<Liuyanban> getsyliuyanban3(Map<String, Object> map);
	public List<Liuyanban> getsyliuyanban2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Liuyanban> getByPage(Map<String, Object> map);
	public List<Liuyanban> select(Map<String, Object> map);
//	所有List
}

