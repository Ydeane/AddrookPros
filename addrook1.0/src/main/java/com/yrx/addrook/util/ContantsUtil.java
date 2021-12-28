package com.yrx.addrook.util;

import java.util.Properties;

/**
 * <b>个人通讯录——系统常量类</b>
 *
 * @author
 * @date
 * @since
 */
public class ContantsUtil {
	private static Properties properties = new Properties();
	static {
		//获得forward.properties配置文件
		try {
			properties.load(ContantsUtil.class.getClassLoader().getResourceAsStream("props/forward.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 请求路径前缀
	 */
	public static final String REQUEST_FORWARD_PREFIX = properties.getProperty("request.forward.prefix");
	/**
	 * 请求路径后缀
	 */
  public static final String REQUEST_FORWARD_SUFFIX = properties.getProperty("request.forward.suffix");
}