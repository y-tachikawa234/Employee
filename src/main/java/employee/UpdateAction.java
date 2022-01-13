package employee;

import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import bean.ErrorMessage;
import dao.EmployeeDAO;
import tool.Action;

public class UpdateAction extends Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ErrorMessage errorMessage = new ErrorMessage();
        try {

            String employeeId = request.getParameter("employeeId");
            String affiliationCd = request.getParameter("affiliationCd");
            String positionCd = request.getParameter("positionCd");
            String employeeNm = request.getParameter("employeeNm");
            String gender = request.getParameter("gender");
            String foreignNationality = request.getParameter("foreignNationality");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            BigDecimal baseSalary = new BigDecimal(request.getParameter("baseSalary"));
            String memo = request.getParameter("memo");
            Boolean deleteFlag = false;
            String hiddenEmployeeId = request.getParameter("hiddenEmployeeId");

            if (employeeId.length() != 8) {
                errorMessage.setCheckDigitOfId("社員IDは数字8桁で入力してください。");
                request.setAttribute("errorMessage", errorMessage);
                return "SCR0003.jsp";
            }

            if (employeeNm == null || employeeNm.isEmpty()) {
                errorMessage.setCheckNullOfName("氏名は必須です。");
                request.setAttribute("errorMessage", errorMessage);
                return "SCR0003.jsp";
            }

            if (String.valueOf(baseSalary).length() != 8) {
                errorMessage.setCheckDigitOfBaseSalary("基本給料は*****.**(千円)の形式で入力してください。");
                request.setAttribute("errorMessage", errorMessage);
                return "SCR0003.jsp";
            }

            EmployeeData ed = new EmployeeData();
            ed.setEmployeeId(employeeId);
            ed.setAffiliationCd(affiliationCd);
            ed.setPositionCd(positionCd);
            ed.setEmployeeNm(employeeNm);
            ed.setGender(gender);
            ed.setForeignNationality(foreignNationality);
            ed.setBirthday(birthday);
            ed.setBaseSalary(baseSalary);
            ed.setMemo(memo);
            ed.setDeleteFlag(deleteFlag);
            ed.setHiddenEmployeeId(hiddenEmployeeId);

            EmployeeDAO dao = new EmployeeDAO();
            int line = dao.update(ed);

            if (line > 0) {
                return "SCR0004.jsp";
            }

        } catch (NumberFormatException e) {
            errorMessage.setCheckNullOfId("社員ID・氏名・生年月日・基本給料は必須です。");
            errorMessage.setCheckFormatOfId("社員ID・基本給料は数字で入力してください。");
            request.setAttribute("errorMessage", errorMessage);
            return "SCR0003.jsp";
        } catch (IllegalArgumentException p) {
            errorMessage.setCheckDigitOfBirthday("社員ID・氏名・生年月日・基本給料は必須です。");
            request.setAttribute("errorMessage", errorMessage);
            return "SCR0003.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SCR0003.jsp";
    }
}
