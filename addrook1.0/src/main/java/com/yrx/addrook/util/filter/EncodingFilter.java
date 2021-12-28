package com.yrx.addrook.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>字符编码过滤器</b>
 * @author Fiona
 * @version 1.0.0
 */
public class EncodingFilter implements Filter {
	private String encoding;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 接收配置文件中的参数
		String value = filterConfig.getInitParameter("encoding");
		if (value != null && !"".equals(value.trim())) {
			encoding = value;
		} else {
			encoding = "UTF-8";
		}
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// ServletRequest 和 ServletResponse 进行类型转换
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// 设置编码格式
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);

		// 后调其他的过滤器或者是 Servlet
		chain.doFilter(request, response);

	}
}
