package com.server.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.LiuyanbanMapper;
import com.entity.Liuyanban;
import com.entity.UserLiuyanban;
import com.server.LiuyanbanServer;
@Service
public class LiuyanbanServerImpi implements LiuyanbanServer {
   @Resource
   private LiuyanbanMapper gdao;

@Override
public void insertLiuyan(Map<String, Object> map) {
	gdao.insertLiuyan(map);
}

@Override
public List<Liuyanban> selectLiuyanByishf(Map<String, Object> map) {
	return gdao.selectLiuyanByishf(map);
}

@Override
public int selectCountLiuyanByishf(Map<String, Object> map) {
	return gdao.selectCountLiuyanByishf(map);
}

@Override
public void updateLiuyanban(Map<String, Object> map) {
	gdao.updateLiuyanban(map);
}

@Override
public List<UserLiuyanban> selectLiuyanByYonghu(String ufid) {
	return gdao.selectLiuyanByYonghu(ufid);
}
	

}

