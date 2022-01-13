package employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import dao.EmployeeDAO;
import tool.Action;

public class DeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            final boolean DELETE_FLAG = true;
            String employeeId = request.getParameter("employeeId");

            EmployeeData ed = new EmployeeData();
            ed.setDeleteFlag(DELETE_FLAG);
            ed.setEmployeeId(employeeId);

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
