package employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import dao.EmployeeDAO;
import tool.Action;

//@WebServlet(urlPatterns = { "/employee/delete" })
public class DeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        try {
//			response.setContentType("text/html; charset=UTF-8");
//			request.setCharacterEncoding("UTF-8");
            
            final boolean DELETE_FLAG = true;
            String hidden_employee_id = request.getParameter("hidden_employee_id");
            

            EmployeeData ed = new EmployeeData(); 
            ed.setDelete_flag(DELETE_FLAG);
            ed.setHidden_employee_id(hidden_employee_id);
            
            EmployeeDAO dao = new EmployeeDAO(); 
            int line = dao.delete(ed);

            if (line > 0) {
                return "SCR0004.jsp";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SCR0004.jsp";
    }
}
