package employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import bean.ErrorMessage;
import dao.EmployeeDAO;

@WebServlet(urlPatterns = { "/employee/search" })
public class Search extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		ErrorMessage errormessage = new ErrorMessage();
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");

			Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
			
			if(String.valueOf(employee_id).length()!=8) {
				errormessage.setCheckDigitOfId("社員IDは8桁で入力してください。");
				request.setAttribute("errormessage", errormessage);
				request.getRequestDispatcher("SCR0001.jsp").forward(request, response);
				return;
			}

			EmployeeDAO dao = new EmployeeDAO();
			EmployeeData employeedata = dao.search(employee_id);

			request.setAttribute("employeedata", employeedata);

			request.getRequestDispatcher("SCR0003.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			errormessage.setCheckNullOfId("社員IDは必須です。");
			errormessage.setCheckFormatOfId("社員IDは数字で入力してください。");
			request.setAttribute("errormessage", errormessage);
			try {
				request.getRequestDispatcher("SCR0001.jsp").forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//	public void checkId(Integer employee_id) {
//		if(employee_id.equals(null)) {
//			 messageOfIdCheck = "社員IDは必須です。";
//		}
//	}
