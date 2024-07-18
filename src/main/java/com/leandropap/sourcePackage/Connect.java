package com.leandropap.sourcePackage;
import java.sql.*;

public class Connect {

	private static final String URL = "jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC";
	private static final String user = "root";
	private static final String pass = "catalina";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, user, pass);
	}
	
	public static void cerrar (ResultSet rs) throws SQLException {
		rs.close();
	}
	
	public static void cerrar (PreparedStatement ps) throws SQLException {
		ps.close();
	}
	
	public static void cerrar (Connection con) throws SQLException {
		con.close();
	}
}
