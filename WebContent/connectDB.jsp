<%@ page language="java" pageEncoding="UTF-8" import="java.sql.*"%>

<h1>教师体检信息列表</h1>
<table class="table table-hover">
<thead>
 <tr>
  <th>编号</th>
  <th>创建时间</th>
  <th>姓名</th>
  <th>性别</th>
  <th>年龄</th>
  <th>操作</th>
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
   <td><a href=del.do?no=${info.no}>删除</a><a href=update.do>修改</a>
   </tr>
 </c:forEach>
</tbody>
</table>
<a href="infoAdd.html">添加</a>