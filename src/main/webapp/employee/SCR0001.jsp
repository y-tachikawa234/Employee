<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<center>
<h1>社員管理システム</h1>

<%--
<%@page errorPage="SCR0001.jsp" %>
<p>社員IDには数値を入力してください。</p>
 --%>

<p>
	${errormessage.checkNullOfId }<br>
	${errormessage.checkFormatOfId }
	${errormessage.checkDigitOfId }
</p>

<form action="SCR0002.jsp" method="get">
<p><input type="submit" value="社員登録"></p>
<br>
</form>

<form action="search" method="post">
<p>社員ID<br><input type="text" name="employee_id"></p>

<p><input type="submit" value="社員照会・更新"></p>
</form>

<%@include file="../footer.html" %>
</center>