package employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import bean.ErrorMessage;
import dao.EmployeeDAO;
import tool.Action;

public class DeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ErrorMessage errorMessage = new ErrorMessage();
        try {
            String employeeId = request.getParameter("employeeId");

            EmployeeData ed = new EmployeeData();
            ed.setDeleteFlag(true);
            ed.setEmployeeId(employeeId);

            EmployeeDAO dao = new EmployeeDAO();
            String exceptionMessage = dao.delete(ed);
            
            errorMessage.setCheckClass(exceptionMessage);
            request.setAttribute("errorMessage", errorMessage);
            return "SCR0003.jsp";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SCR0004.jsp";
    }
}
