package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JingjirenMapper;
import com.entity.Fangyuanxinxi;
import com.entity.Jingjiren;
import com.server.JingjirenServer;
@Service
public class JingjirenServerImpi implements JingjirenServer {
   @Resource
   private JingjirenMapper gdao;

@Override
public Jingjiren selectJinjiren(Map<String, Object> map) {
	return gdao.selectJinjiren(map);
}

@Override
public List<Fangyuanxinxi> selectFyjjr(String gonghao) {
	return gdao.selectFyjjr(gonghao);
}
	

}

