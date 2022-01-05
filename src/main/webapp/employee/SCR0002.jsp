<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<center>
	<h1>新規社員登録</h1>

	<p>
	${errormessage.checkNullOfId }<br>
	${errormessage.checkFormatOfId }
	${errormessage.checkDigitOfId }
	${errormessage.checkNullOfName }
	${errormessage.checkDigitOfBirthday }
	${errormessage.checkDigitOfBase_salary}
	</p>

	<form action="insert" method="post">
		<table style="border-collapse: separate; border-spacing: 10px;">
			<tr>
				<th>社員ID</th>
				<td><input type="text" name="employee_id"></td>
			</tr>

			<tr>
				<th>所属部署</th>
				<td><select name="affiliation_cd">
						<option value="00">人事部</option>
						<option value="01">総務部</option>
						<option value="02">開発本部</option>
				</select></td>
			</tr>

			<tr>
				<th>役職</th>
				<td><select name="position_cd">
						<option value="00">初級職</option>
						<option value="01">中級職</option>
						<option value="02">部長</option>
				</select></td>
			</tr>

			<tr>
				<th>氏名</th>
				<td><input type="text" name="employee_nm"></td>
			</tr>

			<tr>
				<th>性別</th>
				<td><input type="radio" name="gender" value="1" checked>男性
					<input type="radio" name="gender" value="2">女性
					<input type="checkbox" name="foreign_nationality" value="1">外国籍</td>
			</tr>

			<tr>
				<th>生年月日</th>
				<td><input type="text" name="birthday"></td>

			</tr>

			<tr>
				<th>基本給料</th>
				<td><input type="text" name="base_salary"></td>
			</tr>

			<tr>
				<th>メモ</th>
				<td><textarea name="memo" cols="23" rows="3"></textarea></td>
			</tr>
		</table>

		<p>
			<input type="submit" value="新規登録">
		</p>
	</form>

	<form action="SCR0001.jsp" method="post">
		<p>
			<input type="submit" value="戻る">
		</p>
	</form>
</center>

<%@include file="../footer.html"%>
