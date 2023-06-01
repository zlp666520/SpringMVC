<%@ page import="model.Info" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String no = request.getParameter("no");
  Info info = new Info().findById(no);
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>修改</title>
  </head>
  <body>
  <form action="infoUpdate.do" method="post">
    编号：<input type="text" name="no" value=<%= info.getNo() %> readonly><br>
    创建时间：<input type="date" name="date" value=<%= info.getDate() %>><br>
    姓名：<input type="text" name="name" value=<%= info.getName() %>><br>
    性别：<input type="radio" name="sex" value="男"checked >男
    <input type="radio" name="sex" value="女" >女<br>
    年龄：<input type="number" name="age" value=<%= info.getAge() %>><br>
    <input type="submit" value="保存">
  </form>
  </body>
</html>
