package com.ies.baroja;

import java.sql.SQLException;
import java.util.LinkedList;

import com.model.Jugadores;

public class TestModel {

	public static void main(String [] args) throws SQLException {
		
		
		
		System.out.println("Inicio TestModel");
		LinkedList<Jugadores> lista = Controller.getJugadores();
		
		
		
		
		
	}
	
	
}
