package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUitl {
	public static Connection getConnection() throws SQLException,
	ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/db_myshop?useUnicode=true&characterEncoding=utf-8";//book是数据库的名字
		String username = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, username,password);
       return conn;
	}
// 
public static void release(Statement stmt, Connection conn) {
	if (stmt != null) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			stmt = null;
	}
	if (conn != null) {
		try {
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		conn = null;
}
}
	public static void release(ResultSet rs, Statement stmt, 
		Connection conn){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				rs = null;
		}
			release(stmt, conn);
	}
	
	}
