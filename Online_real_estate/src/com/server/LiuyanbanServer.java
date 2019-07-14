package com.server;

import java.util.List;
import java.util.Map;

import com.entity.Liuyanban;
import com.entity.UserLiuyanban;

public interface LiuyanbanServer {
	// 插入留言内容
	void insertLiuyan(Map<String, Object> map);

	//经纪人查询未回复留言内容总数量
	int selectCountLiuyanByishf(Map<String, Object> map);
	
	//经纪人更新回复
	void updateLiuyanban(Map<String, Object> map);
	
	// 经纪人查询未回复留言内容
	List<Liuyanban> selectLiuyanByishf(Map<String, Object> map);
	
	//用户中心用户查看回复消息
	List<UserLiuyanban> selectLiuyanByYonghu(String ufid);
}
//	所有List
