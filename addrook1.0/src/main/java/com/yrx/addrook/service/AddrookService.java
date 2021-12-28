package com.yrx.addrook.service;

import com.yrx.addrook.pojo.entity.Addrook;
import com.yrx.addrook.pojo.vo.PageVO;

/**
 * <b>个人通讯录——业务层接口</b>
 *
 * @author
 * @date
 * @since
 */
public interface AddrookService {
	/**
	 * 分页查询列表信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageVO<Addrook> getListByPage(Integer pageNum, Integer pageSize);
}
