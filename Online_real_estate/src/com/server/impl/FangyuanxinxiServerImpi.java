package com.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.FangyuanxinxiMapper;
import com.entity.Fabu;
import com.entity.Fangyuantupian;
import com.entity.Fangyuanxinxi;
import com.entity.Fankui;
import com.entity.Fkjj;
import com.entity.Fyjj;
import com.entity.Guanzhu;
import com.entity.Jingjiren;
import com.entity.Kanfang;
import com.entity.Kfjj;
import com.entity.RecommendGuanzhu;
import com.server.FangyuanxinxiServer;
@Service
public class FangyuanxinxiServerImpi implements FangyuanxinxiServer {
   @Resource
   private FangyuanxinxiMapper gdao;
	@Override
	public int add(Fangyuanxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Fangyuanxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	

	@Override
	public List<Fangyuanxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Fangyuanxinxi> getsyfangyuanxinxi1(Map<String, Object> map) {
		return gdao.getsyfangyuanxinxi1(map);
	}
	public List<Fangyuanxinxi> getsyfangyuanxinxi2(Map<String, Object> map) {
		return gdao.getsyfangyuanxinxi2(map);
	}
	public List<Fangyuanxinxi> getsyfangyuanxinxi3(Map<String, Object> map) {
		return gdao.getsyfangyuanxinxi3(map);
	}
	
	@Override
	public Fangyuanxinxi quchongFangyuanxinxi(Map<String, Object> account) {
		return gdao.quchongFangyuanxinxi(account);
	}

	@Override
	public List<Fangyuanxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount() {
		return gdao.getCount();
	}

	@Override
	public List<Fangyuanxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}


	@Override
	public List<Fangyuanxinxi> getFangyuanxinxiByPage(Map<String, Object> map) {
		return gdao.getFangyuanxinxiByPage(map);
	}


	@Override
	public List<Fangyuantupian> selectTupianByBihao(String bianhao) {
		return gdao.selectTupianByBihao(bianhao);
	}

	@Override
	public Fangyuanxinxi selectByBianhao(String bianhao) {
		return gdao.selectByBianhao(bianhao);
	}

	@Override
	public Jingjiren selectJingjirenByBihao(String bianhao) {
		return gdao.selectJingjirenByBihao(bianhao);
	}

	@Override
	public List<Fkjj> selectFkByBh(String bianhao) {
		return gdao.selectFkByBh(bianhao);
	}

	@Override
	public List<Kfjj> selectKfByBh(String bianhao) {
		return gdao.selectKfByBh(bianhao);
	}

	@Override
	public List<Fangyuanxinxi> getFyxxByTime(Map<String, Object> map) {
		return gdao.getFyxxByTime(map);
	}

	@Override
	public List<Fangyuanxinxi> getFyxxByKeyword(Map<String, Object> map) {
		return gdao.getFyxxByKeyword(map);
	}

	@Override
	public List<Fangyuanxinxi> getFyxxByKeywordOrderTime(Map<String, Object> map) {
		return gdao.getFyxxByKeywordOrderTime(map);
	}

	@Override
	public int getCountByCondition(Map<String, Object> map) {
		return gdao.getCountByCondition(map);
	}

	@Override
	public void insertGuanzhu(Map<String, Object> map) {
		gdao.insertGuanzhu(map);
	}

	@Override
	public void killGuanzhu(Map<String, Object> map) {
		gdao.killGuanzhu(map);
	}

	@Override
	public Guanzhu Findguanzhu(Map<String, Object> map) {
		return gdao.Findguanzhu(map);
	}

	@Override
	public List<Fangyuanxinxi> FindShaixuanFyxx(Map<String, Object> map) {
		return gdao.FindShaixuanFyxx(map);
	}

	@Override
	public int FindShaixuanCount(Map<String, Object> map) {
		return gdao.FindShaixuanCount(map);
	}

	@Override
	public List<Fangyuanxinxi> FindShaixuanFyxxByTime(Map<String, Object> map) {
		return gdao.FindShaixuanFyxxByTime(map);
	}

	@Override
	public int getGuanzhurenshu(String bianhao) {
		return gdao.getGuanzhurenshu(bianhao);
	}

	@Override
	public void insertFyxx(Map<String, Object> map) {
		gdao.insertFyxx(map);
	}

	@Override
	public void insertFytp(Map<String, Object> map) {
		gdao.insertFytp(map);
	}

	@Override
	public Fangyuanxinxi getFyxxByUpdate(Map<String, Object> map) {
		return gdao.getFyxxByUpdate(map);
	}

	@Override
	public int getFyxxByUpdateByCount(Map<String, Object> map) {
		return gdao.getFyxxByUpdateByCount(map);
	}

	@Override
	public List<String> getFytpByUpdate(String bianhao) {
		return gdao.getFytpByUpdate(bianhao);
	}

	@Override
	public void updateFyxx(Map<String, Object> map) {
		gdao.updateFyxx(map);
	}

	@Override
	public void deleteFytp(String bianhao) {
		gdao.deleteFytp(bianhao);
	}

	@Override
	public void deleteFyxx(Map<String, Object> map) {
		gdao.deleteFyxx(map);
	}

	@Override
	public void insertFankui(Map<String, Object> map) {
		gdao.insertFankui(map);
	}

	@Override
	public Fankui selectupdateFankui(Map<String, Object> map) {
		return gdao.selectupdateFankui(map);
	}

	@Override
	public void updateFankui(Map<String, Object> map) {
		gdao.updateFankui(map);
	}

	@Override
	public void deleteFankui(Map<String, Object> map) {
		gdao.deleteFankui(map);
	}

	@Override
	public void insertKanfangjilu(Map<String, Object> map) {
		gdao.insertKanfangjilu(map);
	}

	@Override
	public void deleteKanfangjilu(Map<String, Object> map) {
		gdao.deleteKanfangjilu(map);
	}

	@Override
	public List<Kanfang> selectKanfangjilu(Map<String, Object> map) {
		return gdao.selectKanfangjilu(map);
	}

	@Override
	public void updateKanfangjilu(Map<String, Object> map) {
		gdao.updateKanfangjilu(map);
	}

	@Override
	public List<String> FindguanzhuByufid(Map<String, Object> map) {
		return gdao.FindguanzhuByufid(map);
	}

	@Override
	public int FindCountguanzhuByufid(Map<String, Object> map) {
		return gdao.FindCountguanzhuByufid(map);
	}

	@Override
	public List<Fangyuanxinxi> getFyxxByGuihuaqi(Map<String, Object> map) {
		return gdao.getFyxxByGuihuaqi(map);
	}

	@Override
	public List<Fangyuanxinxi> RecommendFyxx(Map<String, Object> map) {
		List<Fangyuanxinxi> recommendlist= new ArrayList<Fangyuanxinxi>();
		/**
		 * 输入用户-->物品条目  一个用户对应多个物品
		 * 用户ID	物品ID集合
		 *   A		a b d
		 *   B		a c
		 *   C		b e
		 *   D		c d e
		 */
		Integer N = gdao.recommendGuanzhurenshu();
		String Recommended_person = (String) map.get("ufid");
		//输入用户总量
		//int N = 2;
		//用户总数
		System.out.println("Input the total users number:"+N);
		int[][] sparseMatrix = new int[N][N];//建立用户稀疏矩阵，用于用户相似度计算【相似度矩阵】
		Map<String, Integer> userItemLength = new HashMap<>();//存储每一个用户对应的不同物品总数  eg: A 3
		Map<String, Set<String>> itemUserCollection = new HashMap<>();//建立物品到用户的倒排表 eg: a A B
		Set<String> items = new HashSet<>();//辅助存储物品集合
		Map<String, Integer> userID = new HashMap<>();//辅助存储每一个用户的用户ID映射
		Map<Integer, String> idUser = new HashMap<>();//辅助存储每一个ID对应的用户映射
		System.out.println("Input user--items maping infermation:<eg:A a b d>");
		for(int i = 0; i < N ; i++){//依次处理N个用户 输入数据  以空格间隔
			String[] user_item = recommendGuanzhu_dis().get(i).split(" ");//用户UFID 房源编号1 房源编号2 房源编号3 
			int length = user_item.length;
			userItemLength.put(user_item[0], length-1);//eg: A 3
			userID.put(user_item[0], i);//用户ID与稀疏矩阵建立对应关系
			idUser.put(i, user_item[0]);
			//建立物品--用户倒排表
			for(int j = 1; j < length; j ++){
				if(items.contains(user_item[j])){//如果已经包含对应的物品--用户映射，直接添加对应的用户
					itemUserCollection.get(user_item[j]).add(user_item[0]);
				}else{//否则创建对应物品--用户集合映射
					items.add(user_item[j]);
					itemUserCollection.put(user_item[j], new HashSet<String>());//创建物品--用户倒排关系
					itemUserCollection.get(user_item[j]).add(user_item[0]);
				}
			}
		}
		System.out.println(itemUserCollection.toString());
		//计算相似度矩阵【稀疏】
		Set<Entry<String, Set<String>>> entrySet = itemUserCollection.entrySet();
		Iterator<Entry<String, Set<String>>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Set<String> commonUsers = iterator.next().getValue();
			for (String user_u : commonUsers) {
				for (String user_v : commonUsers) {
					if(user_u.equals(user_v)){
						continue;
					}
					sparseMatrix[userID.get(user_u)][userID.get(user_v)] += 1;//计算用户u与用户v都有正反馈的物品总数
				}
			}
		}
		System.out.println(userItemLength.toString());
		System.out.println("Input the user for recommendation:<eg:A>");
		String recommendUser = Recommended_person;//被推荐用户UFID
		System.out.println(userID.get(recommendUser));
		//计算用户之间的相似度【余弦相似性】
		int recommendUserId = userID.get(recommendUser);
		for (int j = 0;j < sparseMatrix.length; j++) {
				if(j != recommendUserId){
					System.out.println(idUser.get(recommendUserId)+"--"+idUser.get(j)+"相似度:"+sparseMatrix[recommendUserId][j]/Math.sqrt(userItemLength.get(idUser.get(recommendUserId))*userItemLength.get(idUser.get(j))));
				}
		}
		
		//计算指定用户recommendUser的物品推荐度
		for(String item: items){//遍历每一件物品
			Set<String> users = itemUserCollection.get(item);//得到购买当前物品的所有用户集合
			if(!users.contains(recommendUser)){//如果被推荐用户没有购买当前物品，则进行推荐度计算
				double itemRecommendDegree = 0.0;
				for(String user: users){
					itemRecommendDegree += sparseMatrix[userID.get(recommendUser)][userID.get(user)]/Math.sqrt(userItemLength.get(recommendUser)*userItemLength.get(user));//推荐度计算
				}
				Fangyuanxinxi selectByBianhao = gdao.selectByBianhao(item);
				System.out.println("The item "+item+" for "+recommendUser +"'s recommended degree:"+itemRecommendDegree);
				recommendlist.add(selectByBianhao);
				if(recommendlist.size()==5) {
					return recommendlist;
				}
			}else {
				//当没法推荐的时候随机找除了该房源编号的其他房源
				String bianhao = (String) map.get("bianhao");
				List<Fangyuanxinxi> selectRadom = gdao.selectRadom(bianhao);
				if(selectRadom.size()==5) {
					return selectRadom;
				}
			}
		}
		
		return recommendlist;
		
		
	}

	@Override
	public List<String> recommendGuanzhu_dis() {
		List<String> recoList = new ArrayList<String>();
		List<String> recommendGuanzhu_dis = gdao.recommendGuanzhu_dis();
		for (String string : recommendGuanzhu_dis) {
			
			List<String> recommendGuanzhu_bh = gdao.recommendGuanzhu_bh(string);
			String s=string;
			for (String string2 : recommendGuanzhu_bh) {
				s+=" "+string2;
			}
			recoList.add(s);
		}
		return recoList;
	}

	@Override
	public void deleteFyGuanzhu(String bianhao) {
		gdao.deleteFyGuanzhu(bianhao);
	}

	@Override
	public void insertFabu(Map<String, Object> map) {
		gdao.insertFabu(map);
	}

	@Override
	public List<Fabu> selectUncheckFy(Map<String, Object> map) {
		return gdao.selectUncheckFy(map);
	}

	@Override
	public int selectCountUncheckFy() {
		return gdao.selectCountUncheckFy();
	}

	@Override
	public void updateFabubychuli0(Map<String, Object> map) {
		gdao.updateFabubychuli0(map);
	}

	@Override
	public void insertFyjj(Map<String, Object> map) {
		gdao.insertFyjj(map);
	}

	

	

	

	

	

	

	

	

	

	

	

}

