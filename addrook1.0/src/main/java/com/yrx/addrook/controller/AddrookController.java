package com.yrx.addrook.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Page;
import com.yrx.addrook.pojo.entity.Addrook;
import com.yrx.addrook.pojo.vo.PageVO;
import com.yrx.addrook.service.AddrookService;
import com.yrx.addrook.service.impl.AddrookServiceImpl;
import com.yrx.addrook.util.RequestForwardUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <b>个人通讯录——控制层</b>
 *
 * @author
 * @date
 * @since
 */
public class AddrookController extends HttpServlet {
	private static final long serialVersionUID = -4679669758430216201L;
	AddrookService addrookService = new AddrookServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得绑定到HttpServletRequest中的requestURI
		String requestURI = (String) request.getAttribute("requestURI");
		//根据截取的URI信息进行请求分发
		//进行分页查询
		if("index".equals(requestURI)){
			//获得用户分页查询信息：当前页码和每页显示的数量
			String page = request.getParameter("page");
			String size = request.getParameter("size");

			//初始化页码和每页显示的条数
			Integer pageNum = 1;
			Integer pageSize =10;
			//判断用户所给的page参数是否合格
			if(StrUtil.isNotBlank(page)){
				//判断page是否大于0
				if(Integer.parseInt(page) > 0){
					pageNum = Integer.parseInt(page);
				}
			}
			//判断用户所给的size是否合格
			if(StrUtil.isNotBlank(size)){
				//判断size是否大于0
				if(Integer.parseInt(size) > 0){
					pageSize = Integer.parseInt(size);
				}
			}
			//进行分页查询
			PageVO<Addrook> pageVO = addrookService.getListByPage(pageNum,pageSize);
			request.setAttribute("pageVO", pageVO);
			//进行列表信息页面转发
			RequestForwardUtil.forward("index", request, response);
		}
	}
}
