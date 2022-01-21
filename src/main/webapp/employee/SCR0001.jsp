<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>
<%@ page import = "java.util.List" %>
<%@ page import ="java.util.ArrayList" %>

<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/CSS/SCR0001.css">

<div class="all">
  <h1>社員管理システム</h1>

  <div class="error">
    <p>
    <%
    List<String> list=(List<String>)request.getAttribute("error");
    if(list == null){
        list =  new ArrayList<>();
    }
    %>
    
    <% for(int i=0; i<list.size(); i++){ %>
        <%= list.get(i) %><br/>
    <% } %>
    
    </p>
  </div>

  <form action="SCR0002.jsp" method="get">
    <input type="submit" value="社員登録" class="button"><br>
  </form>

  <div class="search">
    <form action="Search.action" method="post">
      社員ID<br> <input type="text" name="employeeId" class="box"><br>
      <input type="submit" value="社員照会・更新" class="button">
    </form>
  </div>

</div>

<%@include file="../footer.html"%>
