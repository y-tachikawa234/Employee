package employee;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import bean.ErrorMessage;
import dao.EmployeeDAO;

@WebServlet(urlPatterns = { "/employee/update" })
public class Update extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		ErrorMessage errormessage = new ErrorMessage();
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
			String affiliation_cd = request.getParameter("affiliation_cd");
			String position_cd = request.getParameter("position_cd");
			String employee_nm = request.getParameter("employee_nm");
			String gender = request.getParameter("gender");
			String foreign_nationality = request.getParameter("foreign_nationality");
			String birthday = request.getParameter("birthday");
			BigDecimal base_salary = new BigDecimal(request.getParameter("base_salary"));
			String memo = request.getParameter("memo");
			String delete_flag = "0";
			Integer hidden_employee_id = Integer.parseInt(request.getParameter("hidden_employee_id"));
			
			if (String.valueOf(employee_id).length() != 8) {// 社員IDの桁数チェック。catch文でnullとフォーマットのチェック。
				errormessage.setCheckDigitOfId("社員IDは数字8桁で入力してください。");
				request.setAttribute("errormessage", errormessage);
				request.getRequestDispatcher("SCR0003.jsp").forward(request, response);
				return;
			}

			if (employee_nm == null || employee_nm.isEmpty()) {// 氏名入力チェック。nullとemptyのチェック。
				errormessage.setCheckNullOfName("氏名は必須です。");
				request.setAttribute("errormessage", errormessage);
				request.getRequestDispatcher("SCR0003.jsp").forward(request, response);
				return;
			}

			if (birthday == null || birthday.isEmpty()) {// 誕生日入力チェック。nullとemptyのチェック。
				errormessage.setCheckNullOfBirthday("生年月日は必須です。");
				request.setAttribute("errormessage", errormessage);
				request.getRequestDispatcher("SCR0003.jsp").forward(request, response);
				return;
			} else if (birthday.length() == 10) {// 有効な日付かチェック。
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				df.setLenient(false);
				df.format(df.parse(birthday));
			} else if (birthday.length() != 10) {// 桁数のチェック。
				errormessage.setCheckDigitOfBirthday("生年月日はyyyy/mm/ddの形式で入力してください。");
				request.setAttribute("errormessage", errormessage);
				request.getRequestDispatcher("SCR0003.jsp").forward(request, response);
				return;
			}

			if (String.valueOf(base_salary).length() != 6) {
				errormessage.setCheckDigitOfBase_salary("基本給料は***.**の形式で入力してください。");
				request.setAttribute("errormessage", errormessage);
				request.getRequestDispatcher("SCR0003.jsp").forward(request, response);
				return;
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
			ed.setDelete_flag(delete_flag);
			ed.setHidden_employee_id(hidden_employee_id);

			EmployeeDAO dao = new EmployeeDAO(); 
			int line = dao.update(ed);

			if (line > 0) {
				request.getRequestDispatcher("SCR0004.jsp").forward(request, response);
			}
			
		}catch (NumberFormatException e) {
			errormessage.setCheckNullOfId("社員ID・氏名・生年月日・基本給料は必須です。");
			errormessage.setCheckFormatOfId("社員ID・基本給料は数字で入力してください。");
			request.setAttribute("errormessage", errormessage);
			try {
				request.getRequestDispatcher("SCR0003.jsp").forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		} catch (ParseException p) {
			errormessage.setCheckDigitOfBirthday("存在する日付で入力してください。");
			request.setAttribute("errormessage", errormessage);
			try {
				request.getRequestDispatcher("SCR0003.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
