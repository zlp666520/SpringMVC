<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>用户登录</h1>
<form method="post" action="login.do">
   用户名:<input type="text" name="username"><br>
   密码:<input type="text" name="password"><br>
   角色:<input type="radio" name="role" value="0">管理员
    <input type="radio" name="role" value="1">普通用户<br>
    <input type="submit" value="登录">
</form>
<a href="adminRegister.jsp">注册</a>

<font color=red>${message}</font>
</body>
</html>