<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>
<form method="post"  action="register.do">
用户名:<input type="text" name="username"><br>
密码:<input type="text" name="password"><br>
角色:<input type="radio" name="role" value="1" checked>普通用户<br>
<input type="submit" value="注册">
</form>
</body>
</html>