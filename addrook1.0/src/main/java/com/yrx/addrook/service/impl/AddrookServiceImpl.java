package com.yrx.addrook.service.impl;

import com.yrx.addrook.dao.AddrookDao;
import com.yrx.addrook.dao.impl.AddrookDaoImpl;
import com.yrx.addrook.pojo.entity.Addrook;
import com.yrx.addrook.pojo.vo.PageVO;
import com.yrx.addrook.service.AddrookService;

import java.util.List;

/**
 * <b>个人通讯录——业务层接口实现类</b>
 *
 * @author
 * @date
 * @since
 */
public class AddrookServiceImpl implements AddrookService {
	AddrookDao addrookDao = new AddrookDaoImpl();
	/**
	 * 分页查询列表信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageVO<Addrook> getListByPage(Integer pageNum, Integer pageSize) {
		//为了能够确定分页所需要的条件，首先进行分页查询
		List<Addrook> addrookList = addrookDao.findUserListByQueryAndPage(null, pageNum, pageSize);
		// 为了获得总条数，可以不分页进行查询，获得列表之后，查看该列表的长度
		Integer totalSize = addrookDao.findUserListByQueryAndPage(null, null, null).size();
		// 根据总条数计算总页数，将总条数和每页显示数量进行取余运算，如果值等于零的就是整除的结果
		// 如果不等于零，在整除的结果上加1
		Integer totalPage = (totalSize % pageSize == 0) ? (totalSize / pageSize) : (totalSize / pageSize + 1);
		// 创建 PageVO 对象
		PageVO<Addrook> pageVO = new PageVO<Addrook>(pageNum, pageSize, addrookList, totalPage, totalSize);
		return pageVO;
	}
}
