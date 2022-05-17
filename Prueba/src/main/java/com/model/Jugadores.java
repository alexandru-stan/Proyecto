package com.model;

public class Jugadores {

	private String nombre;
	private String procedencia;
	private String altura;
	private String peso;
	private String posicion;
	private String nombre_equipo;
	
	public Jugadores(String nombre, String procedencia, String altura, String peso, String posicion,
			String nombre_equipo) {
		super();
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.altura = altura;
		this.peso = peso;
		this.posicion = posicion;
		this.nombre_equipo = nombre_equipo;
	}
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getNombre_equipo() {
		return nombre_equipo;
	}
	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}
	
}
