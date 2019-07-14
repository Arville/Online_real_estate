package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Fangyuanxinxi;
import com.entity.Jingjiren;

public interface JingjirenMapper {
    Jingjiren selectJinjiren(Map<String, Object> map);
    
    List<Fangyuanxinxi> selectFyjjr(String gonghao);
}

