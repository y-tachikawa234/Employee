<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>
<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/CSS/SCR0001.css">

<div class="all">
  <h1>社員管理システム</h1>

  <div class="error">
    <p>
      ${errormessage.checkNullOfId }<br>
      ${errormessage.checkFormatOfId } ${errormessage.checkDigitOfId }
      ${errormessage.checkNullOfEmployeedata }
    </p>
  </div>

  <form action="SCR0002.jsp" method="get">
    <input type="submit" value="社員登録" class="button"><br>
  </form>

  <div class="search">
    <form action="Search.action" method="post">
      社員ID<br> <input type="text" name="employee_id" class="box"><br>
      <input type="submit" value="社員照会・更新" class="button">
    </form>
  </div>

</div>

<%@include file="../footer.html"%>
