package com.server;

import java.util.List;
import java.util.Map;

import com.entity.Fangyuanxinxi;
import com.entity.Jingjiren;

public interface JingjirenServer {
	Jingjiren selectJinjiren(Map<String, Object> map);
	
	List<Fangyuanxinxi> selectFyjjr(String gonghao);
  
}
