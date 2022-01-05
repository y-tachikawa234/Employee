package employee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import dao.EmployeeDAO;

@WebServlet(urlPatterns = { "/employee/delete" })
public class Delete extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			String delete_flag = "1";//削除フラグをtrueにする。
			Integer hidden_employee_id = Integer.parseInt(request.getParameter("hidden_employee_id"));
			

			EmployeeData ed = new EmployeeData(); 
			ed.setDelete_flag(delete_flag);
			ed.setHidden_employee_id(hidden_employee_id);
			
			EmployeeDAO dao = new EmployeeDAO(); 
			int line = dao.delete(ed);

			if (line > 0) {
				request.getRequestDispatcher("SCR0004.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
