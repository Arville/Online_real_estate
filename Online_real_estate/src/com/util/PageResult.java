package com.util;

import java.util.List;

import com.entity.Fangyuanxinxi;

public class PageResult {
//分页的结果对象
	private List listData;//结果集对象：通过SQL查询
	private Integer totalCount;//结果总条数：通过SQL查询
	
	private Integer currentPage=1;//当前页：用户传入
	private Integer pageSize=5;//每页条数：用户传入
	
	private Integer beginPage=1;//首页
	private Integer prevPage;//上页：计算出来
	private Integer nextPage;//下页：计算出来
	private Integer totalPage;//末页or总页数：计算出来
	private Fangyuanxinxi fy;
	
	public PageResult(Integer currentPage,Integer pageSize,List listData,Integer totalCount) {
		this.listData=listData;
		this.totalCount=totalCount;
		this.currentPage=currentPage;
		this.pageSize=pageSize;
		//--------------------------------
		this.totalPage=totalCount%pageSize==0 ? totalCount/pageSize : totalCount/pageSize+1;
		this.prevPage=currentPage-1>=1 ? currentPage-1 : 1;
		this.nextPage=currentPage+1<=totalPage ? currentPage+1 : totalPage;
	}
	
	public PageResult(Integer currentPage,Integer pageSize,Fangyuanxinxi fy,Integer totalCount) {
		this.fy=fy;
		this.totalCount=totalCount;
		this.currentPage=currentPage;
		this.pageSize=pageSize;
		//--------------------------------
		this.totalPage=totalCount%pageSize==0 ? totalCount/pageSize : totalCount/pageSize+1;
		this.prevPage=currentPage-1>=1 ? currentPage-1 : 1;
		this.nextPage=currentPage+1<=totalPage ? currentPage+1 : totalPage;
	}

	public List getListData() {
		return listData;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getBeginPage() {
		return beginPage;
	}

	public Integer getPrevPage() {
		return prevPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public Fangyuanxinxi getFy() {
		return fy;
	}

	
	
	
	
}
