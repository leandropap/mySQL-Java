package com.mysqlJava.leandropap;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		insertaRegistros("Hola desde Java de nuevo!", "Leandro");
		listaRegistros();
		borraRegistros(6);
		listaRegistros();
	}

	static void listaRegistros() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
				"root",
				"catalina"
				);
	
		System.out.println("Conexion exitosa");
		
		String sql = "SELECT * FROM mensajes";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			int id = rs.getInt("id_mensajes");
			String mensaje = rs.getString("mensaje");
			String autor = rs.getString("autor");
			String fecha = rs.getString("fecha");
			
			System.out.printf("ID = %d, Mensaje = %s, Autor = %s, Fecha = %s \n", id, mensaje, autor, fecha);
		}
		
		rs.close();
		ps.close();
		connection.close();
	}
	
	
	static void insertaRegistros(String mensaje, String autor) throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
				"root",
				"catalina"
				);
	
		System.out.println("Conexion exitosa");
		
		String sql = "INSERT INTO mensajes(mensaje,autor,fecha) VALUES (?, ?, CURRENT_TIME())";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, mensaje);
		ps.setString(2, autor);
		ps.executeUpdate();
		
		ps.close();
		connection.close();
	}


	static void editaRegistros(String mensaje, String autor, int id) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
				"root",
				"catalina"
				);
	
		System.out.println("Conexion exitosa");
		
		String sql = "UPDATE mensajes SET mensaje=?, autor=? WHERE id_mensajes=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, mensaje);
		ps.setString(2, autor);
		ps.setInt(3, id);
		ps.executeUpdate();
		
		ps.close();
		connection.close();
	}
	
	static void borraRegistros(int id) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
				"root",
				"catalina"
				);
	
		System.out.println("Conexion exitosa");
		
		String sql = "DELETE FROM mensajes WHERE id_mensajes=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		
		ps.close();
		connection.close();
	}
	
	
	
}
