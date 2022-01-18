package employee;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import dao.EmployeeDAO;
import tool.Action;

public class UpdateAction extends Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<String> error = new ArrayList<>();
        try {

            String employeeId = request.getParameter("employeeId");
            
            if (employeeId==null || employeeId.isEmpty()) {
                error.add("社員IDは必須です。");
            }else if(employeeId.length() != 8) {
                error.add("社員IDは数字8桁で入力してください。");
            }
            String affiliationCd = request.getParameter("affiliationCd");
            String positionCd = request.getParameter("positionCd");
            String employeeNm = request.getParameter("employeeNm");
            
            if (employeeNm == null || employeeNm.isEmpty()) {
                error.add("氏名は必須です。");
            }
            
            String gender = request.getParameter("gender");
            String foreignNationality = request.getParameter("foreignNationality");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            BigDecimal baseSalary = new BigDecimal(request.getParameter("baseSalary"));
            
            if (String.valueOf(baseSalary).length() != 8) {
                error.add("基本給料は*****.**の形式で入力してください。");
            }
            
            String memo = request.getParameter("memo");
            Boolean deleteFlag = false;
            String hiddenEmployeeId = request.getParameter("hiddenEmployeeId");
            
            if(error.size() > 0){
                request.setAttribute("error", error);
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
            error.add("基本給料は必須です。");
            error.add("基本給料は*****.**の形式で入力してください。");
            
            if(error.size() > 0){
                request.setAttribute("error", error);
                return "SCR0003.jsp";
            }
            
        } catch (IllegalArgumentException p) {
            error.add("生年月日は必須です。");
            
            try {
                BigDecimal baseSalary = new BigDecimal(request.getParameter("baseSalary"));
                
                if(String.valueOf(baseSalary).length() != 8) {
                    error.add("基本給料は*****.**の形式で入力してください。");
                }
                
            }catch(NumberFormatException e) {
                error.add("基本給料は必須です。");
                error.add("基本給料は*****.**の形式で入力してください。");
            }
            
            if(error.size() > 0){
                request.setAttribute("error", error);
                return "SCR0003.jsp";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SCR0003.jsp";
    }
}
