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
	//社員情報照会。
	public EmployeeData search(Integer employee_id) {
		EmployeeData employeedata = new EmployeeData();
		Connection con = null;
		PreparedStatement st = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(URL);

			st = con.prepareStatement("select * from employee_db where employee_id=? and delete_flag='0'");
			st.setInt(1, employee_id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				employeedata.setEmployee_id(rs.getInt("employee_id"));
				employeedata.setAffiliation_cd(rs.getString("affiliation_cd"));
				employeedata.setPosition_cd(rs.getString("position_cd"));
				employeedata.setEmployee_nm(rs.getString("employee_nm"));
				employeedata.setGender(rs.getString("gender"));
				employeedata.setForeign_nationality(rs.getString("foreign_nationality"));
				employeedata.setBirthday(rs.getString("birthday"));
				employeedata.setBase_salary(rs.getBigDecimal("base_salary"));
				employeedata.setMemo(rs.getString("memo"));
				employeedata.setDelete_flag(rs.getString("delete_flag"));
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
		
		return employeedata;
	}

	// 社員登録を行う
	public int insert(EmployeeData employeeData) {

		Connection con = null;
		PreparedStatement st = null;
		int line = 0;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(URL);

			st = con.prepareStatement("insert into employee_db values(?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, employeeData.getEmployee_id());
			st.setString(2, employeeData.getAffiliation_cd());
			st.setString(3, employeeData.getPosition_cd());
			st.setString(4, employeeData.getEmployee_nm());
			st.setString(5, employeeData.getGender());
			st.setString(6, employeeData.getForeign_nationality());
			st.setString(7, employeeData.getBirthday());
			st.setBigDecimal(8, employeeData.getBase_salary());
			st.setString(9, employeeData.getMemo());
			st.setString(10, "0");
			
			if(employeeData.getForeign_nationality()==null) {
				st.setString(6, "0");
			}
			
			line = st.executeUpdate();// アップデートを実行して行数を返す。

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
	
	//情報更新を行う。
	public int update(EmployeeData employeeData) {

		Connection con = null;
		PreparedStatement st = null;
		int line = 0;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(URL);

			st = con.prepareStatement("update employee_db set employee_id=?, affiliation_cd=?, position_cd=?, employee_nm=?, gender=?, foreign_nationality=?, birthday=?, base_salary=?, memo=?, delete_flag=? where employee_id=?;");
			st.setInt(1, employeeData.getEmployee_id());
			st.setString(2, employeeData.getAffiliation_cd());
			st.setString(3, employeeData.getPosition_cd());
			st.setString(4, employeeData.getEmployee_nm());
			st.setString(5, employeeData.getGender());
			st.setString(6, employeeData.getForeign_nationality());
			st.setString(7, employeeData.getBirthday());
			st.setBigDecimal(8, employeeData.getBase_salary());
			st.setString(9, employeeData.getMemo());
			st.setString(10, employeeData.getDelete_flag());
			st.setInt(11, employeeData.getHidden_employee_id());
			
			if(employeeData.getForeign_nationality()==null) {
				st.setString(6, "0");
			}

			line = st.executeUpdate();// アップデートを実行して行数を返す。

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
	
	//社員情報の削除を行う。
		public int delete(EmployeeData employeeData) {

			Connection con = null;
			PreparedStatement st = null;
			int line = 0;

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

				con = DriverManager.getConnection(URL);

				st = con.prepareStatement("update employee_db set delete_flag=? where employee_id=?;");
				st.setString(1, employeeData.getDelete_flag());
				st.setInt(2, employeeData.getHidden_employee_id());

				line = st.executeUpdate();// アップデートを実行して行数を返す。

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
