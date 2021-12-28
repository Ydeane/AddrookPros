package com.yrx.addrook.dao.impl;

import com.yrx.addrook.dao.AddrookDao;
import com.yrx.addrook.pojo.entity.Addrook;
import com.yrx.addrook.util.ConnectionUtil;

import java.nio.file.attribute.UserPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>个人通讯录——数据持久层实现类</b>
 *
 * @author
 * @date
 * @since
 */
public class AddrookDaoImpl implements AddrookDao {
	private  Connection connection = ConnectionUtil.getConnection();
	/**
	 * 分页查询
	 * @param query
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Addrook> findUserListByQueryAndPage(Addrook query, Integer pageNum, Integer pageSize) {
		//创建集合
		List<Addrook> addrookList = new ArrayList<Addrook>();
		//设定所需要查询的sql语句
		String sql = "select id,name,cellphone,gender,email, address,createTime,updateTime from sys_user where";
		//创建集合才存储占位符的值
		List<Object> paramValueList = new ArrayList<Object>();
		//判断查询对象
		//id
		if(query != null &&  query.getId() != null){
			sql = sql + "id = ? and";
			paramValueList.add(query.getId());
		}
		//name
		if(query != null &&  query.getName() != null){
			sql = sql + "name like concat('%',?,'%') and";
			paramValueList.add(query.getName());
		}
		//cellphone
		if(query != null && query.getCellphone() != null) {
			sql =sql +"cellphone=? and";
			paramValueList.add(query.getCellphone());
		}
		//gender
		if(query != null && query.getGender() != null) {
			sql =sql +"gender=? and";
			paramValueList.add(query.getGender());
		}
		//email
		if(query != null && query.getEmail() != null) {
			sql =sql +"email=? and";
			paramValueList.add(query.getEmail());
		}
		//address
		if(query != null && query.getAddress() != null) {
			sql =sql +"address like concat('%',?,'%') and";
			paramValueList.add(query.getAddress());
		}
		//为了去除最后的where
		sql = sql + "1=1";
		//进行分页
		if(pageNum != null && pageNum >0 && pageSize != null && pageSize > 0){
			sql = sql +"limit ? , ?";
			//当前页码
			paramValueList.add((pageNum-1)*pageSize);
			//每页显示的条数
			paramValueList.add(pageSize);
		}
		try {
			//使用PrepareStatement对象进行预编译
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//为占位符进行赋值
			for (int i = 0; i<paramValueList.size();i++){
				preparedStatement.setObject(i+1, paramValueList.get(i));
			}
			//进行查询
			ResultSet resultSet = preparedStatement.executeQuery();
			//循环结果集
			while (resultSet.next()){
				//将取出来的信息赋值给每一个Addrook对象
				Addrook addrook = new Addrook(
						resultSet.getLong("id"),
						resultSet.getString("name"),
						resultSet.getInt("gender"),
						resultSet.getString("cellphone"),
						resultSet.getString("email"),
						resultSet.getString("address"),
						resultSet.getDate("createTime"),
						resultSet.getDate("updateTime"));
				//将addrook对象添加到集合中
				addrookList.add(addrook);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return addrookList;
	}
}
