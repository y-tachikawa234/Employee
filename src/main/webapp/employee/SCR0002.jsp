<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/CSS/SCR0002.css">

<div class="all">
  <h1>新規社員登録</h1>

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
    
    ${errorMessage.checkClass }
    </p>
  </div>

  <form action="Insert.action" method="post">

    <div class="table">
      <table>
        <tr>
          <th>社員ID</th>
          <td><input type="text" name="employeeId" class="box"></td>
        </tr>

        <tr>
          <th>所属部署</th>
          <td><select name="affiliationCd" class="box">
              <option value="00">人事部</option>
              <option value="01">総務部</option>
              <option value="02">開発本部</option>
          </select></td>
        </tr>

        <tr>
          <th>役職</th>
          <td><select name="positionCd" class="box">
              <option value="00">初級職</option>
              <option value="01">中級職</option>
              <option value="02">部長</option>
          </select></td>
        </tr>

        <tr>
          <th>氏名</th>
          <td><input type="text" name="employeeNm" class="box"></td>
        </tr>

        <tr>
          <th>性別</th>
          <td><input type="radio" name="gender" value="1" checked>男性
            <input type="radio" name="gender" value="2">女性 <input
            type="checkbox" name="foreignNationality" value="1">外国籍</td>
        </tr>

        <tr>
          <th>生年月日</th>
          <td><input type="date" name="birthday" class="box"></td>
        </tr>

        <tr>
          <th>基本給料</th>
          <td><input type="text" name="baseSalary" class="box"></td>
        </tr>

        <tr>
          <th>メモ</th>
          <td><textarea name="memo" class="box"></textarea></td>
        </tr>
      </table>
    </div>
  
    <div class="insert">
        <input type="submit" value="新規登録" class="button">
    </div>
    
 </form>
 
    <div class="return">
      <form action="SCR0001.jsp" method="post">
        <input type="submit" value="戻る" class="button">
      </form>
    </div>
    

</div>

<%@include file="../footer.html"%>
