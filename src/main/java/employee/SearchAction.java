package employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import bean.ErrorMessage;
import dao.EmployeeDAO;
import tool.Action;

//@WebServlet(urlPatterns = { "/employee/search" })
public class SearchAction extends Action {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ErrorMessage errormessage = new ErrorMessage();
        try {
//			response.setContentType("text/html; charset=UTF-8");
//			request.setCharacterEncoding("UTF-8");

            String employee_id = request.getParameter("employee_id");
            
            if(String.valueOf(employee_id).length()!=8) {
                errormessage.setCheckDigitOfId("社員IDは8桁で入力してください。");
                request.setAttribute("errormessage", errormessage);
                return "SCR0001.jsp";
            }

            EmployeeDAO dao = new EmployeeDAO();
            EmployeeData employeedata = dao.search(employee_id);			
            
            if(employeedata.getAffiliation_cd()==null) {
                errormessage.setCheckNullOfEmployeedata("指定した社員IDでは社員情報を照会できませんでした。");
                request.setAttribute("errormessage", errormessage);
                return "SCR0001.jsp";
            }else {
            request.setAttribute("employeedata", employeedata);
            }

        } catch (NumberFormatException e) {
            errormessage.setCheckNullOfId("社員IDは必須です。");
            errormessage.setCheckFormatOfId("社員IDは数字で入力してください。");
            request.setAttribute("errormessage", errormessage);
            return "SCR0001.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SCR0003.jsp";
    }
}