package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.EmployeeData;

public class EmployeeDAO extends ConnectionDAO {

    private static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;"
            + "databaseName=Employee;integratedSecurity=true;" + "encrypt=true;trustServerCertificate=true";

    public EmployeeData search(String employeeId) {
        EmployeeData employeeData = new EmployeeData();
        Connection con = null;
        PreparedStatement st = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(URL);

            st = con.prepareStatement("select * from employee_db where employee_id=? and delete_flag='0'");
            st.setString(1, employeeId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                employeeData.setEmployeeId(rs.getString("employee_id"));
                employeeData.setAffiliationCd(rs.getString("affiliation_cd"));
                employeeData.setPositionCd(rs.getString("position_cd"));
                employeeData.setEmployeeNm(rs.getString("employee_nm"));
                employeeData.setGender(rs.getString("gender"));
                employeeData.setForeignNationality(rs.getString("foreign_nationality"));
                employeeData.setBirthday(rs.getDate("birthday"));
                employeeData.setBaseSalary(rs.getBigDecimal("base_salary"));
                employeeData.setMemo(rs.getString("memo"));
                employeeData.setDeleteFlag(rs.getBoolean("Delete_flag"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return employeeData;
    }

    public String insert(EmployeeData employeeData) {

        Connection con = null;
        PreparedStatement st = null;
        String exceptionMessage = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(URL);

            st = con.prepareStatement("insert into employee_db values(?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, employeeData.getEmployeeId());
            st.setString(2, employeeData.getAffiliationCd());
            st.setString(3, employeeData.getPositionCd());
            st.setString(4, employeeData.getEmployeeNm());
            st.setString(5, employeeData.getGender());
            st.setString(6, employeeData.getForeignNationality());
            st.setDate(7, employeeData.getBirthday());
            st.setBigDecimal(8, employeeData.getBaseSalary());
            st.setString(9, employeeData.getMemo());
            st.setString(10, "0");

            st.executeUpdate();

        } catch (ClassNotFoundException e) {
            exceptionMessage = e.getClass().getName() + ": " + e.getMessage();
            e.printStackTrace();
            return exceptionMessage;
        } catch (SQLException e) {
            exceptionMessage = e.getClass().getName() + ": " + e.getMessage();
            e.printStackTrace();
            return exceptionMessage;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return exceptionMessage;
    }

    public int update(EmployeeData employeeData) {

        Connection con = null;
        PreparedStatement st = null;
        int line = 0;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(URL);

            st = con.prepareStatement(
                    "update employee_db set employee_id=?, affiliation_cd=?, position_cd=?, employee_nm=?, gender=?, foreign_nationality=?, birthday=?, base_salary=?, memo=?, delete_flag=? where employee_id=?;");
            st.setString(1, employeeData.getEmployeeId());
            st.setString(2, employeeData.getAffiliationCd());
            st.setString(3, employeeData.getPositionCd());
            st.setString(4, employeeData.getEmployeeNm());
            st.setString(5, employeeData.getGender());
            st.setString(6, employeeData.getForeignNationality());
            st.setDate(7, employeeData.getBirthday());
            st.setBigDecimal(8, employeeData.getBaseSalary());
            st.setString(9, employeeData.getMemo());
            st.setBoolean(10, employeeData.getDeleteFlag());
            st.setString(11, employeeData.getHiddenEmployeeId());

            line = st.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return line;
    }

    public int delete(EmployeeData employeeData) {

        Connection con = null;
        PreparedStatement st = null;
        int line = 0;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(URL);

            st = con.prepareStatement("update employee_db set delete_flag=? where employee_id=?;");
            st.setBoolean(1, employeeData.getDeleteFlag());
            st.setString(2, employeeData.getEmployeeId());

            line = st.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return line;
    }
}
