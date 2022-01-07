package employee;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import bean.ErrorMessage;
import dao.EmployeeDAO;
import tool.Action;

//@WebServlet(urlPatterns = { "/employee/insert" })
public class InsertAction extends Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ErrorMessage errormessage = new ErrorMessage();
		try {
//			response.setContentType("text/html; charset=UTF-8");
//			request.setCharacterEncoding("UTF-8");

			Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
			String affiliation_cd = request.getParameter("affiliation_cd");
			String position_cd = request.getParameter("position_cd");
			String employee_nm = request.getParameter("employee_nm");
			String gender = request.getParameter("gender");
			String foreign_nationality = request.getParameter("foreign_nationality");
			String birthday = request.getParameter("birthday");
			BigDecimal base_salary = new BigDecimal(request.getParameter("base_salary"));
			String memo = request.getParameter("memo");

			if (String.valueOf(employee_id).length() != 8) {// 社員IDの桁数チェック。catch文でnullとフォーマットのチェック。
				errormessage.setCheckDigitOfId("社員IDは数字8桁で入力してください。");
				request.setAttribute("errormessage", errormessage);
				return "SCR0002.jsp";
			}

			if (employee_nm == null || employee_nm.isEmpty()) {// 氏名入力チェック。nullとemptyのチェック。
				errormessage.setCheckNullOfName("氏名は必須です。");
				request.setAttribute("errormessage", errormessage);
				return "SCR0002.jsp";
			}

			if (birthday == null || birthday.isEmpty()) {// 誕生日入力チェック。nullとemptyのチェック。
				errormessage.setCheckNullOfBirthday("生年月日は必須です。");
				request.setAttribute("errormessage", errormessage);
				return "SCR0002.jsp";
			} else if (birthday.length() == 10) {// 有効な日付かチェック。
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				df.setLenient(false);
				df.format(df.parse(birthday));
			} else if (birthday.length() != 10) {// 桁数のチェック。
				errormessage.setCheckDigitOfBirthday("生年月日はyyyy/mm/ddの形式で入力してください。");
				request.setAttribute("errormessage", errormessage);
				return "SCR0002.jsp";
			}

			if (String.valueOf(base_salary).length() != 6) {
				errormessage.setCheckDigitOfBase_salary("基本給料は***.**の形式で入力してください。");
				request.setAttribute("errormessage", errormessage);
				return "SCR0002.jsp";
			}

			EmployeeData ed = new EmployeeData();
			ed.setEmployee_id(employee_id);
			ed.setAffiliation_cd(affiliation_cd);
			ed.setPosition_cd(position_cd);
			ed.setEmployee_nm(employee_nm);
			ed.setGender(gender);
			ed.setForeign_nationality(foreign_nationality);
			ed.setBirthday(birthday);
			ed.setBase_salary(base_salary);
			ed.setMemo(memo);

			EmployeeDAO dao = new EmployeeDAO();
			int line = dao.insert(ed);
			
			if(line==0) {
				errormessage.setCheckNullOfEmployeedata("既に登録済みの社員番号です。");
				request.setAttribute("errormessage", errormessage);
				return "SCR0002.jsp";
			}else if (line > 0) {
				return "SCR0004.jsp";
			}

		} catch (NumberFormatException e) {
			errormessage.setCheckNullOfId("社員ID・氏名・生年月日・基本給料は必須です。");
			errormessage.setCheckFormatOfId("社員ID・基本給料は数字で入力してください。");
			request.setAttribute("errormessage", errormessage);
			return "SCR0002.jsp";
		} catch (ParseException p) {
			errormessage.setCheckDigitOfBirthday("存在する日付(yyyy/mm/dd)で入力してください。");
			request.setAttribute("errormessage", errormessage);
			return "SCR0002.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SCR0004.jsp";
	}
}