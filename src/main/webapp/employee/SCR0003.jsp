<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<link rel="stylesheet" type="text/css"
  href="<%=request.getContextPath()%>/CSS/SCR0003.css">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="all">
  <h1>社員情報照会・更新</h1>

  <div class="error">
    <p>
      ${errormessage.checkNullOfId }<br>
      ${errormessage.checkFormatOfId } ${errormessage.checkDigitOfId }
      ${errormessage.checkNullOfName } ${errormessage.checkDigitOfBirthday }
      ${errormessage.checkDigitOfBase_salary}
    </p>
  </div>

  <form action="Update.action" method="post">
    <div class="table">
      <table>
        <tr>
          <th>社員ID</th>
          <td><input type="text" name="employee_id" class="box"
            value="${employeedata.employee_id }"></td>
          <input type="hidden" name="hidden_employee_id" value="${employeedata.employee_id }">
        </tr>

        <tr>
          <th>所属部署</th>
          <td><select name="affiliation_cd" class="box">
              <option value="00"
                ${employeedata.affiliation_cd==00?"selected":"" }>人事部</option>
              <option value="01"
                ${employeedata.affiliation_cd==01?"selected":"" }>総務部</option>
              <option value="02"
                ${employeedata.affiliation_cd==02?"selected":"" }>開発本部</option>
              </select>
          </td>
        </tr>

        <tr>
          <th>役職</th>
          <td><select name="position_cd" class="box">
              <option value="00" ${employeedata.position_cd==00?"selected":"" }>初級職</option>
              <option value="01" ${employeedata.position_cd==01?"selected":"" }>中級職</option>
              <option value="02" ${employeedata.position_cd==02?"selected":"" }>部長</option>
          </select></td>
        </tr>

        <tr>
          <th>氏名</th>
          <td><input type="text" name="employee_nm" class="box"
            value="${employeedata.employee_nm }"></td>
        </tr>

        <tr>
          <th>性別</th>
          <td><input type="radio" name="gender" value="1" ${employeedata.gender==1? "checked":""}>男性
              <input type="radio" name="gender" value="2" ${employeedata.gender==2? "checked":""}>女性
              <input type="checkbox" name="foreign_nationality" value="1" ${employeedata.foreign_nationality==1? "checked":""}>外国籍
          </td>
        </tr>

        <tr>
          <th>生年月日</th>
          <td><input type="text" name="birthday" class="box" value="${employeedata.birthday }">
          </td>
        </tr>

        <tr>
          <th>基本給料</th>
          <td><input type="text" name="base_salary" class="box" value="${employeedata.base_salary }">
          </td>
        </tr>

        <tr>
          <th>メモ</th>
          <td><textarea name="memo" class="box">${employeedata.memo }</textarea></td>
        </tr>
      </table>
    </div>
          <div class="update">
            <input type="submit" value="更新" class="button" data-action="update">
          </div>
  </form>
    
      <div class="delete">
        <form action="Delete.action" method="post">
          <input type="hidden" name="hidden_employee_id" value="${employeedata.employee_id }">
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