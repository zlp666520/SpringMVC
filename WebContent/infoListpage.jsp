<%@ page language="java" pageEncoding="UTF-8" import="model.*"%>
<%@ include file="sys_menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>教师体检信息列表</h1>
<table class="table table-hover">
<thead>
 <tr>
  <th>编号</th>
  <th>创建时间</th>
  <th>姓名</th>
  <th>性别</th>
  <th>年龄</th>
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
   </tr>
 </c:forEach>
</tbody>
</table>
<ul class="pagination">
 <li><a href=listByPage.do?pageNo=1>第一页</a></li>
<c:if test="${begin gt 1}">
 <li><a href=listByPage.do?pageNo=${begin-1}>上一页</a></li>
</c:if>
<c:if test="${begin lt totalPage}">
  <li><a href=listByPage.do?pageNo=${begin+1}>下一页</a></li>
</c:if>
  <li><a href=listByPage.do?pageNo=${totalPage}>最后一页</a></li>
 <li> 共${totalRow}条记录，每页显示${pageSize}条,
页码${begin}/${totalPage}</li>
</ul>