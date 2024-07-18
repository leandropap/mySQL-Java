package com.leandropap.sourcePackage;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		MensajeDao mensajeDao = new MensajeDao();
		

		List<Mensaje> mensajes = mensajeDao.select();
		
		for(Mensaje mensaje: mensajes) {
			System.out.println(mensaje);
		}
;	}

}
