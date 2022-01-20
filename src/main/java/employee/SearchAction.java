package employee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import dao.EmployeeDAO;
import tool.Action;

public class SearchAction extends Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<String> error = new ArrayList<>();

        String employeeId = request.getParameter("employeeId");

        if (employeeId == null || employeeId.isEmpty()) {
            error.add("社員IDは必須です。");
        } else if (employeeId.length() != 8) {
            error.add("社員IDは数字8桁で入力してください。");
        }

        if (error.size() > 0) {
            request.setAttribute("error", error);
            return "SCR0001.jsp";
        }

        EmployeeDAO dao = new EmployeeDAO();
        EmployeeData employeeData = dao.search(employeeId);

        if (employeeData.getAffiliationCd() == null) {
            error.add("指定した社員IDでは社員情報を照会できませんでした。");
        }

        if (error.size() > 0) {
            request.setAttribute("error", error);
            return "SCR0001.jsp";
        }else {		
            return "SCR0003.jsp";
        }
    }
}