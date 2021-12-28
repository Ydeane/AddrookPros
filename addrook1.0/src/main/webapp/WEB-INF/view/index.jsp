<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>用户信息列表</title>
<link rel="stylesheet" type="text/css"
	href="../static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="../static/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../static/css/userInfo.css">
<script type="application/javascript"
	src="../static/js/jquery-3.6.0.min.js"></script>
<script type="application/javascript"
	src="../static/js/bootstrap.min.js"></script>
<script type="application/javascript">
		function getSearchName(){
			var searchName = $("#searchName").val();
		}
		function getCurrentDate() {
			// 获得当前时间
			var currentDate = new Date();
			// 分别获得时间的各个部分
			var year = currentDate.getFullYear();
			var month = currentDate.getMonth() + 1;
			var date = currentDate.getDate();
			var hour = currentDate.getHours();
			var minute = currentDate.getMinutes();
			var second = currentDate.getSeconds();
			// 将各个部分组成的完整字符信息
			currentDate = year + "-" + month + "-" + date + "&nbsp;" + hour + ":" + minute + ":" + second;
			$("#currentDate").html(currentDate);
		}

		$(function() {
			window.setInterval(getCurrentDate, 1000);
		});
	</script>
	<style type="text/css">
		th{
		text-align: center;
		}
		#button_1{
		background-color: #33BEEF;
		color: white;
		}
		#button_2{
		background-color: #33BEEF;
		}
		#back{
		color: white;
		}
		.input-group-addon{
		background-color: #CDCDCD;
		}
		a:hover{
		text-decoration: none;
		}
	</style>
</head>
<body>
	<div class="container" style="background:#FFF">
		<div class="row">
			<div class="col-xs-12" id="title">
				<img src="../static/img/logo.jpg" width="95px" height="80px">
				用户信息列表
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<nav class="navbar navbar-default" role="navigation">
					<div class="container-fluid">
						<div>
							<!--向左对齐-->
							<ul class="nav navbar-nav navbar-left">
								<li><a href="#"> <i class="fa fa-calendar"></i>&nbsp; 
								<span id="currentDate"></span>
								</a></li>
							</ul>
							<!--向右对齐-->
							<ul class="nav navbar-nav navbar-right">
								<li><a href="personInfo?id=${user.id }&target=PERSONINFO">
										欢迎： <i class="fa fa-user"></i>&nbsp; 
										<span> 
											${sessionScope.user.name }
										</span>
								</a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"> <i class="fa fa-cog fa-spin"></i>&nbsp;
										<span>设置</span> <b class="caret"></b>
								</a>
									<ul class="dropdown-menu">
										<li><a
											href="updatePassword"> <i
												class="fa fa-lock"></i>&nbsp; 修改密码
										</a></li>
										<li><a href="logout"> <i class="fa fa-close"></i>&nbsp; 注销
										</a></li>
									</ul></li>
								<li><a href="login">
								 <i class="fa fa-sign-out"></i>&nbsp;
										<span>退出</span>
								</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<a href="javascript:location.reload();" class="btn btn-info btn-ml">
						<i class="fa fa-refresh"></i>&nbsp;
						点击刷新
				</a>
			</div>
			<div class="col-md-4">
				<form role="form" >
					<div class="input-group" >
					
						<input type="text" id="searchName"name="searchName" class="form-control" placeholder="请输入您要搜索的用户姓名" />
						
						<span class="input-group-addon"> 
								<button type="submit" id="button_1"> 
								<i class="fa fa-search"></i>&nbsp; 搜索
								</button>
								
								<button type="submit" id="button_2">
								 <a href="info" id="back"><i class="fa fa-undo"></i>&nbsp;返回</a>
								 </button>
						</span>
					</div>
				</form>
			</div>
		</div>
		<div id="main" >
			<div class="row" style="margin-top: 16px;">
				<div class="col-xs-12">
					<table class="table table-bordered table-hover">
						<thead>
							<tr style="font-size: 16px">
								<th><i class="fa fa-list">&nbsp;&nbsp;</i>序号</th>
								<th><i class="fa fa-user">&nbsp;&nbsp;</i>姓名</th>
								<th><i class="fa fa-mobile-phone">&nbsp;&nbsp;</i>手机号码</th>
								<th><i class="fa fa-transgender">&nbsp;&nbsp;</i>性别</th>
								<th><i class="fa fa-birthday-cake">&nbsp;&nbsp;</i>出生日期</th>
								<th><i class="fa fa-envelope">&nbsp;&nbsp;</i>电子邮件</th>
								<th><i class="fa fa-home">&nbsp;&nbsp;</i>联系地址</th>
								<!-- <th><i class="fa fa-picture-o">&nbsp;&nbsp;</i>头像</th> -->
								<th><i class="fa fa-power-off">&nbsp;&nbsp;</i>状态</th>
								<th><i class="fa fa-wrench">&nbsp;&nbsp;</i>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${pageVO.list }" varStatus="s">
								<tr>
								<td>${s.count + (pageVO.pageNum - 1)*pageVO.pageSize }</td>
								<td>${user.name }</td>
								<td>${user.cellphone }</td>
								<td>
									<c:if test="${user.gender eq 2 }">女</c:if>
									<c:if test="${user.gender eq 1 }">男</c:if>
								</td>
								<td>${user.birthday }</td>
								<td>${user.email }</td>
								<td>${user.address }</td>
								<!-- <td>${user.avatar }</td> -->
								<td>
									<c:if test="${user.status eq 0 }">禁用</c:if>
									<c:if test="${user.status eq 1 }">启用</c:if>
								</td>
								<td><a href="personInfo?id=${user.id }&target=UPDATEPERSONINFO"
									class="btn btn-success btn-xs"> <i
										class="fa fa-info-circle"></i>&nbsp; 详情
								</a></td>
							    </tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12" style="text-align: center;">
					<ul class="pagination">
						<li>
							<a href="info?page=1">
								首页
							</a>
						</li>
					    <li>
					    	<c:choose>
					    		<c:when test="${pageVO.pageNum eq 1 }">
					    			<a href="#">
						    		&laquo;&nbsp;上一页
					    			</a>
					    		</c:when>
					    		<c:otherwise>
						    		<a href="info?page=${pageVO.pageNum - 1 }">
					    		&laquo;&nbsp;上一页
				    		</a>
				    			</c:otherwise>
					    	</c:choose>
				    	</li>
				    	<li>
				    		<a href="#">
				    			共查询${pageVO.totalSize }条数据，
				    			每页显示${pageVO.pageSize }条，
				    			共${pageVO.totalPage }页显示，
				    			当前是第${pageVO.pageNum }页
				    		</a>
				    	</li>
					    <li>
					    	<c:choose>
					    		<c:when test="${pageVO.pageNum eq pageVO.totalPage }">
					    			<a href="#">
							    		下一页&nbsp;&raquo;
						    		</a>
					    		</c:when>
					    		<c:otherwise>
					    			<a href="info?page=${pageVO.pageNum + 1 }">
							    		下一页&nbsp;&raquo;
						    		</a>
					    		</c:otherwise>
					    	</c:choose>
				    	</li>
				    	<li>
							<a href="info?page=${pageVO.totalPage }">
								尾页
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>