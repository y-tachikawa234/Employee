package employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import bean.ErrorMessage;
import dao.EmployeeDAO;
import tool.Action;

public class SearchAction extends Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ErrorMessage errorMessage = new ErrorMessage();
        try {
            String employeeId = request.getParameter("employeeId");

            if (employeeId.length() != 8) {
                errorMessage.setCheckDigitOfId("社員IDは8桁で入力してください。");
                request.setAttribute("errorMessage", errorMessage);
                return "SCR0001.jsp";
            }

            EmployeeDAO dao = new EmployeeDAO();
            EmployeeData employeeData = dao.search(employeeId);

            if (employeeData.getAffiliationCd() == null) {
                errorMessage.setCheckNullOfEmployeeData("指定した社員IDでは社員情報を照会できませんでした。");
                request.setAttribute("errorMessage", errorMessage);
                return "SCR0001.jsp";
            } else {
                request.setAttribute("employeeData", employeeData);
            }

        } catch (NumberFormatException e) {
            errorMessage.setCheckNullOfId("社員IDは必須です。");
            errorMessage.setCheckFormatOfId("社員IDは数字で入力してください。");
            request.setAttribute("errorMessage", errorMessage);
            return "SCR0001.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SCR0003.jsp";
    }
}