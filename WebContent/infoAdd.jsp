<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <%@ include file="sys_menu.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<form method="post" action="add.do">
编号:<input type="text" name="no"><br>
创建时间：<input type="date" name="date"><br>
姓名：<input type="text" name="name"><br>
性别：<input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女<br>
年龄：<input type="number" name="age"><br>
<input type="submit" value="保存">
</form>
</body>
</html>