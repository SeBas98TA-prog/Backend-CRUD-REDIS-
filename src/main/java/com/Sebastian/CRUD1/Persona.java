package com.Sebastian.CRUD1;

import java.io.Serializable;

public class Persona implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private String apellidos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
