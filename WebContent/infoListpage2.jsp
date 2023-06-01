<%@ page language="java" pageEncoding="UTF-8" import="model.*,java.util.* "%>
<%@ include file="sys_menu.jsp" %>

<%
  int pageNo; //当前页
  if(request.getParameter("pageNo")==null) //第一次访问未指定pageNo
      pageNo=1;
  else
      pageNo=Integer.parseInt(request.getParameter("pageNo"));
  int totalRow=Info.getTotalRow(); //记录数
  int pageSize=2; //每页显示多少条，自定义
  int totalPage=totalRow%pageSize==0?totalRow/pageSize:totalRow/pageSize+1; //页数
  ArrayList<Info> list=Info.listByPage(pageNo,pageSize);
%>
<h1>教师体检信息</h1>
<table class="table table-bordered">
<thead>
 <tr>
  <th>编号</th>
  <th>创建时间</th>
  <th>姓名</th>
  <th>性别</th>
  <th>年龄</th>
  <th>操作</th>
  <th>操作</th>
 </tr>
 </thead>
 <tbody>
<%
 for(Info info:list){
	 out.print("<tr>");
     out.print("<td>"+info.getNo()+"</td>");
     out.print("<td>"+info.getDate()+"</td>");
     out.print("<td>"+info.getName()+"</td>");
     out.print("<td>"+info.getSex()+"</td>");
     out.print("<td>"+info.getAge()+"</td>");
     out.print("<td><a href='infoUpdate.jsp?no="+info.getNo()+"'>修改</a></td>");
     out.print("<td><a href='infoDel.do?no="+info.getNo()+"'>删除</a></td>");
     out.print("</tr>");
 }
%>
 </tbody>
</table>
<a href="infoListpage2.jsp?pageNo=1">第一页</a>
<%if(pageNo>1){ %>
  <a href="infoListpage2.jsp?pageNo=<%=pageNo-1%>">上一页</a>
<% }
if(pageNo<totalPage){ %>
  <a href="infoListpage2.jsp?pageNo=<%=pageNo+1%>">下一页</a>
<% } %>
<a href="infoListpage2.jsp?pageNo=<%=totalPage%>">尾页</a>
共<%=totalRow%>条记录，每页显示<%=pageSize%>条,
页码<%=pageNo%>/<%=totalPage%>