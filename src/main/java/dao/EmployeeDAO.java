package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeData;

/**
 * 社員情報DAO.
 *
 * @author yuta.tachikawa
 */
public class EmployeeDAO {

    // フィールド変数
    private Connection con = null;
    private PreparedStatement ps = null;

    // 定数
    private static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Employee;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    /**
     * 社員IDから社員情報照会する。
     *
     * @param employeeId 社員ID
     * @return 社員情報リスト
     */
    public List<EmployeeData> search(int employeeId) {

        List<EmployeeData> resultList = new ArrayList<>();
        try {
            Class.forName(DRIVER_NAME);

            con = DriverManager.getConnection(URL);

            ps = con.prepareStatement("select * from employee_db where employee_id=? and delete_flag='0'");
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeeData employeeData = new EmployeeData();
                employeeData.setEmployeeId(rs.getInt("employee_id"));
                employeeData.setAffiliationCd(rs.getString("affiliation_cd"));
                employeeData.setPositionCd(rs.getString("position_cd"));
                employeeData.setEmployeeNm(rs.getString("employee_nm"));
                employeeData.setGender(rs.getString("gender"));
                employeeData.setForeignNationality(rs.getString("foreign_nationality"));
                employeeData.setBirthday(rs.getString("birthday"));
                employeeData.setBaseSalary(rs.getBigDecimal("base_salary"));
                employeeData.setMemo(rs.getString("memo"));
                employeeData.setDeleteFlag(rs.getString("delete_flag"));
                resultList.add(employeeData);
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        } finally {

            close();
        }

        return resultList;
    }

    /**
     * 社員情報を登録する。
     *
     * @param employeeData 社員情報
     * @return 登録件数
     */
    public int insert(EmployeeData employeeData) {

        try {

            Class.forName(DRIVER_NAME);

            con = DriverManager.getConnection(URL);

            ps = con.prepareStatement("insert into employee_db values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, employeeData.getEmployeeId());
            ps.setString(2, employeeData.getAffiliationCd());
            ps.setString(3, employeeData.getPositionCd());
            ps.setString(4, employeeData.getEmployeeNm());
            ps.setString(5, employeeData.getGender());
            ps.setString(6, employeeData.getForeignNationality() == null ? "0" : employeeData.getForeignNationality());
            ps.setString(7, employeeData.getBirthday());
            ps.setBigDecimal(8, employeeData.getBaseSalary());
            ps.setString(9, employeeData.getMemo());
            ps.setString(10, "0");

            return ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        } finally {

            close();
        }

        return 0;
    }

    /**
     * 社員情報の更新を行う
     *
     * @param employeeData 社員情報
     * @return 更新件数
     */
    public int update(EmployeeData employeeData) {

        try {

            Class.forName(DRIVER_NAME);

            con = DriverManager.getConnection(URL);

            ps = con.prepareStatement(
                    "update employee_db set employee_id=?, affiliation_cd=?, position_cd=?, employee_nm=?, gender=?, foreign_nationality=?, birthday=?, base_salary=?, memo=?, delete_flag=? where employee_id=?;");
            ps.setInt(1, employeeData.getEmployeeId());
            ps.setString(2, employeeData.getAffiliationCd());
            ps.setString(3, employeeData.getPositionCd());
            ps.setString(4, employeeData.getEmployeeNm());
            ps.setString(5, employeeData.getGender());
            ps.setString(6, employeeData.getForeignNationality() == null ? "0" : employeeData.getForeignNationality());
            ps.setString(7, employeeData.getBirthday());
            ps.setBigDecimal(8, employeeData.getBaseSalary());
            ps.setString(9, employeeData.getMemo());
            ps.setString(10, employeeData.getDeleteFlag());
            ps.setInt(11, employeeData.getHiddenEmployeeId());

            return ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        } finally {

            close();
        }

        return 0;
    }

    /**
     * 社員情報を削除する。
     *
     * @param employeeData 社員情報
     * @return 実行件数
     */
    public int delete(EmployeeData employeeData) {

        try {
            Class.forName(DRIVER_NAME);

            con = DriverManager.getConnection(URL);

            ps = con.prepareStatement("update employee_db set delete_flag=? where employee_id=?;");
            ps.setString(1, employeeData.getDeleteFlag());
            ps.setInt(2, employeeData.getHiddenEmployeeId());

            return ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        } finally {

            close();
        }

        return 0;
    }

    /**
     * データベース接続を切断
     */
    private void close() {

        try {

            // データベースとの接続を切断
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException se) {

            // データベースからの切断に失敗した場合
            se.printStackTrace();
        }
    }
}
