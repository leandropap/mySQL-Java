package com.leandropap.sourcePackage;

import java.sql.*;
import java.util.*;
import static com.leandropap.sourcePackage.Connect.*;

public class MensajeDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Mensaje message;
	
	public List<Mensaje> select() throws ClassNotFoundException{
		String sql = "SELECT * FROM mensajes";
		List<Mensaje> mensajes = new ArrayList<>();

		try {
			this.conn = getConnection();	
			this.ps = this.conn.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			
			while(this.rs.next()) {
				int id = this.rs.getInt("id_mensaje");
				String mensaje = this.rs.getString("mensaje");
				String autor = this.rs.getString("autor");
				String destinatario = this.rs.getString("destinatario");
				String fecha = this.rs.getString("fecha");
				
				this.message = new Mensaje(id, mensaje, autor, destinatario, fecha);
				mensajes.add(this.message);
				}
		} catch(SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			try {
				cerrar(this.rs);
				cerrar(this.ps);
				cerrar(conn);
			} catch (SQLException ex) {
				ex.printStackTrace(System.out);
			}
		}
		
		return mensajes;
	}
	
	public int insert(Mensaje mensaje) throws ClassNotFoundException {
		String sql="INSERT INTO mensajes(mensaje, autor,destinatario,fecha) VALUES (?,?,?,CURTIME())";
		int registros = 0;
		
		try {
			this.conn = getConnection();	
			this.ps = this.conn.prepareStatement(sql);
			
			this.ps.setString(1,  mensaje.getMensaje());
			this.ps.setString(2, mensaje.getAutor());
			this.ps.setString(3, mensaje.getDestinatario());
			registros = this.ps.executeUpdate();
			
		} catch(SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			try {
				cerrar(this.ps);
				cerrar(conn);
			} catch (SQLException ex) {
				ex.printStackTrace(System.out);
			}
		}
		
		return registros;
	}

	public int update(Mensaje mensaje) throws ClassNotFoundException {
		String sql="UPDATE mensajes SET mensaje=?, autor=?, destinatario=?,fecha=CURTIME() WHERE id_mensaje=?";
		int registros = 0;
		
		try {
			this.conn = getConnection();	
			this.ps = this.conn.prepareStatement(sql);
			
			this.ps.setString(1,  mensaje.getMensaje());
			this.ps.setString(2, mensaje.getAutor());
			this.ps.setString(3, mensaje.getDestinatario());
			this.ps.setInt(4, mensaje.getId());
			registros = this.ps.executeUpdate();
			
		} catch(SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			try {
				cerrar(this.ps);
				cerrar(conn);
			} catch (SQLException ex) {
				ex.printStackTrace(System.out);
			}
		}
		
		return registros;
	}
	
	
	public int delete(Mensaje mensaje) throws ClassNotFoundException {
		String sql = "DELETE FROM mensajes WHERE id_mensaje=?";
		int registros = 0;
		
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(sql);
			
			ps.setInt(1, mensaje.getId());
			registros = this.ps.executeUpdate();
			
		} catch(SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			try {
				cerrar(this.ps);
				cerrar(conn);
			} catch (SQLException ex) {
				ex.printStackTrace(System.out);
			}
		}
		
		return registros;
	}
	
}
