<%@ page language="java" pageEncoding="UTF-8" import="model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div align="center">
当前用户:${sessionScope.admin.username},角色:${sessionScope.admin.role},
<a href="logout.do"><font color=red>退出</font></a>
</div>

<ul class="nav nav-pills">
    <li><a href="list.do">教师体检信息</a></li>
    <li><a href="querySex.do">关联查询</a><li>
    <li><a href="queryByNoName.do">组合查询</a></li>
    <li><a href="queryStatisGroup.do">统计查询</a></li>
    <li><a href="listByPage.do?pageNo=1">分页功能</a></li>
    <li><a href="listByPage2.do?pageNo=1">分页功能2</a></li>
</ul>








 
