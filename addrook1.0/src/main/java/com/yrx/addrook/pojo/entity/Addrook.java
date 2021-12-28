package com.yrx.addrook.pojo.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * <b>个人通讯录——用户实体类</b>
 *
 * @author
 * @date
 * @since
 */
public class Addrook implements Serializable {
	private static final long serialVersionUID = -2747152647969912821L;
	private Long id ;           //主键
	private String name;        //用户姓名
	private Integer gender;     //性别：0-女性，1-男性
	private String cellphone;   //手机号码，登录凭证
	private String email;       //电子邮件
	private String address;     //联系地址
	private Date createTime;    //创建时间，系统默认
	private Date updateTime;    //修改时间，系统默认，修改默认

	public Addrook() {
	}

	public Addrook(Long id, String name, Integer gender, String cellphone, String email, String address, Date createTime, Date updateTime) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.cellphone = cellphone;
		this.email = email;
		this.address = address;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
