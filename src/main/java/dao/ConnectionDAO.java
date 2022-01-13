package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {

    private static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS; Database=Employee;integratedSecurity=true;";

    public Connection getConnection() throws Exception {

        return DriverManager.getConnection(URL);
    }
}