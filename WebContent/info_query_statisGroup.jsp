<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ include file="sys_menu.jsp" %>

<h1>体检信息统计</h1>
<table class="table table-bordered">
<thead>
<tr>
  <th>体检日期</th>
  <th>性别</th>
  <th>体检总人数</th>
  </tr>
  </thead>
  <tbody>
 <c:forEach var="info" items="${list}">
   <tr>
   <td>${info.date}</td>
   <td>${info.sex}</td>
   <td>${info.totals}</td>
 </c:forEach>
</tbody>
</table>
</body>
</html>