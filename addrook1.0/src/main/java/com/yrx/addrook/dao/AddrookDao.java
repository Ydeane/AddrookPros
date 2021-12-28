package com.yrx.addrook.dao;

import com.yrx.addrook.pojo.entity.Addrook;

import java.util.List;

/**
 * <b>个人通讯录——数据持久层接口</b>
 *
 * @author
 * @date
 * @since
 */
public interface AddrookDao {
	/**
	 * 分页查询
	 * @param query
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<Addrook> findUserListByQueryAndPage(Addrook query, Integer pageNum, Integer pageSize);
}
