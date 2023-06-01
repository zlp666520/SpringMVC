<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ include file="sys_menu.jsp" %>

<form action="queryByNoName.do">
编号：<input name="no">
姓名：<input name="name">
<input type="submit" value="查询">
</form>
<br>
<table class="table table-bordered">
<thead>
<tr>
  <th>编号</th>
  <th>体检时间</th>
  <th>姓名</th>
  <th>性别</th>
  <th>年龄</th>
  <th>健康状况</th>
  </tr>
  </thead>
 <tbody>
 <c:forEach var="info" items="${list}">
   <tr>
   <td>${info.no}</td>
   <td>${info.date}</td>
   <td>${info.name}</td>
   <td>${info.sex}</td>
   <td>${info.age}</td>
   <td>${info.bodyInfo}</td>
 </c:forEach>
</tbody>
</table>
</body>
</html>