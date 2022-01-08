package employee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeData;
import dao.EmployeeDAO;
import tool.Action;

/**
 * 検索Action
 * @author yuta.tachikawa
 */
public class SearchAction extends Action {

    /**
     * SCR0001.jsp
     */
    private static final String SCR0001 = "SCR0001.jsp";

    /**
     *社員情報照会アクションメソッド
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String employeeId = request.getParameter("employee_id");

        //　入力チェック
        List<String> errorMessageList = validationCheck(employeeId);

        if (!errorMessageList.isEmpty()) {
            request.setAttribute("errorMessageList", errorMessageList);
            return SCR0001;
        }

        EmployeeDAO dao = new EmployeeDAO();
        List<EmployeeData> employeeDataList = dao.search(Integer.parseInt(employeeId));

        if (employeeDataList.isEmpty()) {
            errorMessageList.add("指定した社員IDでは社員情報を照会できませんでした。");
            request.setAttribute("errorMessageList", errorMessageList);
            return "SCR0001.jsp";
        }

        request.setAttribute("employeeData", employeeDataList.stream().findFirst().orElse(new EmployeeData()));
        return SCR0001;
    }

    private List<String> validationCheck(String employeeId) {
        List<String> errorMessageList = new ArrayList<>();

        if (employeeId == null) {
            errorMessageList.add("社員IDは必須です。");
        } else if (employeeId.length() != 8) {
            errorMessageList.add("社員IDは数字8桁で入力してください。");
        } else if (!employeeId.chars().allMatch(Character::isDigit)) {
            errorMessageList.add("社員IDは数字で入力してください。");
        }

        return errorMessageList;
    }
}
