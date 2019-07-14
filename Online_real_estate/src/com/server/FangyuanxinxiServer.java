package com.server;

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

public interface FangyuanxinxiServer {
	
	

  public int add(Fangyuanxinxi po);

  public int update(Fangyuanxinxi po);
  
  
  

  public List<Fangyuanxinxi> getAll(Map<String,Object> map);
  public List<Fangyuanxinxi> getsyfangyuanxinxi1(Map<String,Object> map);
  public List<Fangyuanxinxi> getsyfangyuanxinxi2(Map<String,Object> map);
  public List<Fangyuanxinxi> getsyfangyuanxinxi3(Map<String,Object> map);
  public Fangyuanxinxi quchongFangyuanxinxi(Map<String, Object> acount);

  int getCount();
  
  int getCountByCondition(Map<String, Object> map);
  
  List<Fangyuanxinxi> RecommendFyxx(Map<String,Object> map);
  
  List<String> recommendGuanzhu_dis();
  
  int FindShaixuanCount(Map<String, Object> map);
  
  void updateFabubychuli0(Map<String, Object> map);
  
  Fankui selectupdateFankui(Map<String, Object> map);
  
  void insertFyjj(Map<String, Object> map);
  
  void updateFankui(Map<String, Object> map);
  
  List<Fangyuanxinxi> getFyxxByGuihuaqi(Map<String, Object> map);
  
  int getGuanzhurenshu(String bianhao);
  
  void insertGuanzhu(Map<String, Object> map);
  
  void killGuanzhu(Map<String, Object> map);
  
  void updateKanfangjilu(Map<String, Object> map);
  
  void insertFabu(Map<String, Object> map);
  
  List<String> FindguanzhuByufid(Map<String, Object> map);
  
  int FindCountguanzhuByufid(Map<String, Object> map);
  
  void deleteFyGuanzhu(String bianhao);
  
  void insertFyxx(Map<String, Object> map);
  
  void deleteFyxx(Map<String, Object> map);
  
  void insertFytp(Map<String, Object> map);
  
  void insertKanfangjilu(Map<String, Object> map);
  
  void deleteKanfangjilu(Map<String, Object> map);
  
  List<Kanfang> selectKanfangjilu(Map<String, Object> map);
  
  void updateFyxx(Map<String, Object> map);
  
  void insertFankui(Map<String, Object> map);
  
  void deleteFankui(Map<String, Object> map);
  
  void deleteFytp(String bianhao);
  
  int getFyxxByUpdateByCount(Map<String, Object> map);
  
  Fangyuanxinxi getFyxxByUpdate(Map<String, Object> map);
  
  Guanzhu Findguanzhu(Map<String, Object> map);
  
  Fangyuanxinxi selectByBianhao(String bianhao);
  
  List<Fangyuantupian> selectTupianByBihao(String bianhao);
  
  Jingjiren selectJingjirenByBihao(String bianhao);
  
  List<Fkjj> selectFkByBh(String bianhao);
  
  List<String> getFytpByUpdate(String bianhao);
  
  List<Kfjj> selectKfByBh(String bianhao);
  
  List<Fangyuanxinxi> getFyxxByKeyword(Map<String, Object> map);
  
  List<Fangyuanxinxi> getFyxxByKeywordOrderTime(Map<String, Object> map);
  
  List<Fangyuanxinxi> getFyxxByTime(Map<String, Object> map);
  
  List<Fabu> selectUncheckFy(Map<String, Object> map);
  
  int selectCountUncheckFy();
  
  List<Fangyuanxinxi> getFangyuanxinxiByPage(Map<String, Object> map);
  
  List<Fangyuanxinxi> FindShaixuanFyxx(Map<String, Object> map);
  
  List<Fangyuanxinxi> FindShaixuanFyxxByTime(Map<String, Object> map);

  public List<Fangyuanxinxi> getByPage(Map<String, Object> map);
  
  public List<Fangyuanxinxi> select(Map<String, Object> map);
}
//	所有List
