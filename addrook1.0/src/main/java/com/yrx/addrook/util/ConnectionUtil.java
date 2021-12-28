package com.yrx.addrook.util;

import java.io.IOException;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <b>连接JDBC获取的Connection对象</b>
 *
 * @author
 * @date
 * @since
 */
public class ConnectionUtil {
	//声明属性用来存储连接数据库的四个基本信息
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	//创建一个properties文件来解析jdbc.properties文件
	private static Properties properties = new Properties();
	//借助ThreadLocal实现Connection的单例模式
	private  static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	//使用static静态代码块实现加载文件信息
	static{
		try {
			properties.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("props/jdbc.properties"));
			driverClass = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.user");
			password = properties.getProperty("jdbc.password");
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		//通过ThreadLocal对象获得COnnection对象
		Connection connection = threadLocal.get();
		//判断用户是否访问过数据库
		if(connection == null ){
			try {
				//用户没有访问过数据库，创建COnnection对象
				connection = DriverManager.getConnection(url, username, password);
				//将创建好的Connection对象给ThreadLocal对象
				threadLocal.set(connection);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return connection;
	}
}
