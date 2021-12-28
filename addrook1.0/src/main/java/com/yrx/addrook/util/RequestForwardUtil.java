package com.yrx.addrook.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <b>个人通讯录——请求转发工具类</b>
 *
 * @author
 * @date
 * @since
 */
public class RequestForwardUtil {
	/**
	 * 根据用户所给的路径，进行请求转发
	 * @param path
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void forward(String path, HttpServletRequest request,
	                           HttpServletResponse response) throws ServletException, IOException {
		path = ContantsUtil.REQUEST_FORWARD_PREFIX + path + ContantsUtil.REQUEST_FORWARD_SUFFIX;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}
