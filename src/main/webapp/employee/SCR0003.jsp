<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/CSS/SCR0003.css">

<div class="all">
  <h1>社員情報照会・更新</h1>

  <div class="error">
    <p>
      ${errorMessage.checkNullOfId }<br>
      ${errorMessage.checkFormatOfId } ${errorMessage.checkDigitOfId }
      ${errorMessage.checkNullOfName } ${errorMessage.checkDigitOfBirthday }
      ${errorMessage.checkDigitOfBaseSalary}
    </p>
  </div>

  <form action="Update.action" method="post">
    <div class="table">
      <table>
        <tr>
          <th>社員ID</th>
          <td><input type="text" name="employeeId" class="box"
            value="${employeeData.employeeId }"></td>
          <input type="hidden" name="hiddenEmployeeId" value="${employeeData.employeeId }">
        </tr>

        <tr>
          <th>所属部署</th>
          <td><select name="affiliationCd" class="box">
              <option value="00"
                ${employeeData.affiliationCd==00?"selected":"" }>人事部</option>
              <option value="01"
                ${employeeData.affiliationCd==01?"selected":"" }>総務部</option>
              <option value="02"
                ${employeeData.affiliationCd==02?"selected":"" }>開発本部</option>
              </select>
          </td>
        </tr>

        <tr>
          <th>役職</th>
          <td><select name="positionCd" class="box">
              <option value="00" ${employeeData.positionCd==00?"selected":"" }>初級職</option>
              <option value="01" ${employeeData.positionCd==01?"selected":"" }>中級職</option>
              <option value="02" ${employeeData.positionCd==02?"selected":"" }>部長</option>
          </select></td>
        </tr>

        <tr>
          <th>氏名</th>
          <td><input type="text" name="employeeNm" class="box"
            value="${employeeData.employeeNm }"></td>
        </tr>

        <tr>
          <th>性別</th>
          <td><input type="radio" name="gender" value="1" ${employeeData.gender==1? "checked":""}>男性
              <input type="radio" name="gender" value="2" ${employeeData.gender==2? "checked":""}>女性
              <input type="checkbox" name="foreignNationality" value="1" ${employeeData.foreignNationality==1? "checked":""}>外国籍
          </td>
        </tr>

        <tr>
          <th>生年月日</th>
          <td><input type="text" name="birthday" class="box" value="${employeeData.birthday }">
          </td>
        </tr>

        <tr>
          <th>基本給料</th>
          <td><input type="text" name="baseSalary" class="box" value="${employeeData.baseSalary }">
          </td>
        </tr>

        <tr>
          <th>メモ</th>
          <td><textarea name="memo" class="box">${employeeData.memo }</textarea></td>
        </tr>
      </table>
    </div>
          <div class="update">
            <input type="submit" value="更新" class="button" data-action="update">
          </div>
  </form>
    
      <div class="delete">
        <form action="Delete.action" method="post">
          <input type="hidden" name="employeeId" value="${employeeData.employeeId }">
          <input type="submit" value="削除" class="button" data-action="delete">
        </form>
      </div>
    
      <div class="return">
        <form action="SCR0001.jsp" method="post">
          <input type="submit" value="戻る" class="button">
        </form>
      </div>

</div>
<%@include file="../footer.html"%>