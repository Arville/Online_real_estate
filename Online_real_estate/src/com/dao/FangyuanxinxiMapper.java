package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Fabu;
import com.entity.Fangyuantupian;
import com.entity.Fangyuanxinxi;
import com.entity.Fankui;
import com.entity.Fkjj;
import com.entity.Guanzhu;
import com.entity.Jingjiren;
import com.entity.Kanfang;
import com.entity.Kfjj;

public interface FangyuanxinxiMapper {
	
	int getCount();
	
	int getCountByCondition(Map<String, Object> map);
	
	int FindShaixuanCount(Map<String, Object> map);
	
	int getFyxxByUpdateByCount(Map<String, Object> map);
	
	int getGuanzhurenshu(String bianhao);
	
	void insertFyjj(Map<String, Object> map);
	
	void insertGuanzhu(Map<String, Object> map);
	
	void killGuanzhu(Map<String, Object> map);
	
	void deleteFyGuanzhu(String bianhao);
	
	List<String> recommendGuanzhu_dis();
	
	void insertFyxx(Map<String, Object> map);
	
	void insertKanfangjilu(Map<String, Object> map);
	
	List<String> FindguanzhuByufid(Map<String, Object> map);
	
	void updateKanfangjilu(Map<String, Object> map);
	
	void deleteKanfangjilu(Map<String, Object> map);
	
	List<Fangyuanxinxi> selectRadom(String bianhao);
	
	List<Kanfang> selectKanfangjilu(Map<String, Object> map);
	
	void updateFyxx(Map<String, Object> map);
	
	void deleteFyxx(Map<String, Object> map);
	
	void deleteFytp(String bianhao);
	
	void insertFankui(Map<String, Object> map);
	
	void updateFabubychuli0(Map<String, Object> map);
	
	Fankui selectupdateFankui(Map<String, Object> map);
	
	void updateFankui(Map<String, Object> map);
	
	void deleteFankui(Map<String, Object> map);
	
	Fangyuanxinxi getFyxxByUpdate(Map<String, Object> map);
	
	List<String> getFytpByUpdate(String bianhao);
	
	void insertFytp(Map<String, Object> map);
	
    int deleteByPrimaryKey(Integer id);
    
    int selectCountUncheckFy();
    
    List<Fabu> selectUncheckFy(Map<String, Object> map);

    int insert(Fangyuanxinxi record);
    
    List<String> recommendGuanzhu_bh(String ufid);
    
    int recommendGuanzhurenshu();

    int insertSelective(Fangyuanxinxi record);
    
    Guanzhu Findguanzhu(Map<String, Object> map);

    Fangyuanxinxi selectByBianhao(String bianhao);
    
    int FindCountguanzhuByufid(Map<String, Object> map);
    
    Jingjiren selectJingjirenByBihao(String bianhao);
    
    void insertFabu(Map<String, Object> map);
    
    List<Fkjj> selectFkByBh(String bianhao);
    
    List<Kfjj> selectKfByBh(String bianhao);
    
    List<Fangyuanxinxi> getFangyuanxinxiByPage(Map<String, Object> map);
    
    List<Fangyuanxinxi> getFyxxByGuihuaqi(Map<String, Object> map);
    
    List<Fangyuanxinxi> FindShaixuanFyxx(Map<String, Object> map);
    
    List<Fangyuanxinxi> FindShaixuanFyxxByTime(Map<String, Object> map);
    
    List<Fangyuanxinxi> getFyxxByKeyword(Map<String, Object> map);
    
    List<Fangyuanxinxi> getFyxxByKeywordOrderTime(Map<String, Object> map);
    
    List<Fangyuantupian> selectTupianByBihao(String bianhao);
    
    List<Fangyuanxinxi> getFyxxByTime(Map<String, Object> map);
    
    int updateByPrimaryKeySelective(Fangyuanxinxi record);
	
    int updateByPrimaryKey(Fangyuanxinxi record);
	public Fangyuanxinxi quchongFangyuanxinxi(Map<String, Object> faburen);
	public List<Fangyuanxinxi> getAll(Map<String, Object> map);
	public List<Fangyuanxinxi> getsyfangyuanxinxi1(Map<String, Object> map);
	public List<Fangyuanxinxi> getsyfangyuanxinxi3(Map<String, Object> map);
	public List<Fangyuanxinxi> getsyfangyuanxinxi2(Map<String, Object> map);
	public List<Fangyuanxinxi> getByPage(Map<String, Object> map);
	public List<Fangyuanxinxi> select(Map<String, Object> map);
//	所有List
}

