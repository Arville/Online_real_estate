package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KanfangMapper;
import com.entity.Kanfang;
import com.server.KanfangServer;
@Service
public class KanfangServerImpi implements KanfangServer {
   @Resource
   private KanfangMapper gdao;
	@Override
	public int add(Kanfang po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kanfang po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kanfang> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kanfang> getsykanfang1(Map<String, Object> map) {
		return gdao.getsykanfang1(map);
	}
	public List<Kanfang> getsykanfang2(Map<String, Object> map) {
		return gdao.getsykanfang2(map);
	}
	public List<Kanfang> getsykanfang3(Map<String, Object> map) {
		return gdao.getsykanfang3(map);
	}
	
	@Override
	public Kanfang quchongKanfang(Map<String, Object> account) {
		return gdao.quchongKanfang(account);
	}

	@Override
	public List<Kanfang> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kanfang> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kanfang getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

