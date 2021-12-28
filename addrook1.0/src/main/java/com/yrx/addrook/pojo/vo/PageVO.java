package com.yrx.addrook.pojo.vo;

import cn.hutool.core.util.StrUtil;

import java.io.Serializable;
import java.util.List;

/**
 * <b>个人通讯录——分页视图对象</b>
 *
 * @author
 * @date
 * @since
 */
public class PageVO<E> implements Serializable {
	private static final long serialVersionUID = 8208303939562254077L;
	private Integer pageNum; 	//当前页码
	private Integer pageSize; 	//每页显示的条数
	private List<E> list;     	 //分页列表
	private Integer totalPage;  //总页码
	private Integer totalSize;   //总条数

	public PageVO() {
	}

	public PageVO(Integer pageNum, Integer pageSize, List<E> list, Integer totalPage, Integer totalSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.list = list;
		this.totalPage = totalPage;
		this.totalSize = totalSize;
	}

	public PageVO(String pageNum, String pageSize) {
		if(StrUtil.isNumeric(pageNum) && Integer.parseInt(pageNum)>0){
			this.pageNum = Integer.parseInt(pageNum);
		}else{
			this.pageNum = 1;
		}

		if(StrUtil.isNumeric(pageSize) && Integer.parseInt(pageSize)>0){
			this.pageSize = Integer.parseInt(pageSize);
		}else{
			this.pageSize = 10;
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
}
