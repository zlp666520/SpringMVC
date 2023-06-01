<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" import="model.*,java.util.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>教师体检信息列表</title>
  </head>
  <body>
  <form action="update.do" method="post">
  编号：<input type="text" name="no" value="${info.no}" readonly><br>
  创建时间:<input type="text" name="date" value="${info.date}"><br>
    姓名：<input type="text" name="name" value="${info.name}" ><br>
    性别： <c:if test="${info.sex eq '男'}">
     <input type="radio" name="sex" value="${info.sex}" checked >${info.sex}
    <input type="radio" name="sex" value="女" >女<br>
      </c:if>
    <c:if test="${info.sex eq '女'}">
     <input type="radio" name="sex" value="${info.sex}" checked >${info.sex}
    <input type="radio" name="sex" value="男" >男<br>
      </c:if>
    年龄：<input type="number" name="age" value="${info.age}"><br>
    <input type="submit" value="修改">
     <button><a href=list.do>返回</a></button>
  </form>
  </body>
</html>