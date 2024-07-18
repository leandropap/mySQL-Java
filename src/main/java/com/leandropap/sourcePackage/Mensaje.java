package com.leandropap.sourcePackage;

public class Mensaje {
	private int id;
	private String mensaje;
	private String autor;
	private String destinatario;
	private String fecha;
	
	
	public Mensaje() {
	}
	
	public Mensaje(int id) {
		super();
		this.id = id;
	}

	public Mensaje(String mensaje, String autor, String destinatario) {
		super();
		this.mensaje = mensaje;
		this.autor = autor;
		this.destinatario = destinatario;
	}

	public Mensaje(int id, String mensaje, String autor, String destinatario) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.autor = autor;
		this.destinatario = destinatario;
	}

	public Mensaje(int id, String mensaje, String autor, String destinatario, String fecha) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.autor = autor;
		this.destinatario = destinatario;
		this.fecha = fecha;
	}

	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return this.mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Mensaje [id=").append(id);
		sb.append(", mensaje=").append(mensaje);
		sb.append(", autor=").append(autor);
		sb.append(", destinatario=").append(destinatario);
		sb.append(", fecha=").append(fecha);
		sb.append("]");
		return sb.toString();
	}

	
}
