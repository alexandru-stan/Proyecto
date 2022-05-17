package com.ies.baroja;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.model.Jugadores;

import com.bbdd.ConexionBBDD;
public class Controller {
	
	private static String sConsultaJugadores="SELECT Nombre,Procedencia,Altura,Peso,Posicion,Nombre_equipo FROM jugadores;";

	public static LinkedList<Jugadores> getJugadores() throws SQLException{
		
		//OBJETO CON LA LISTA DE JUGADORES
		
			LinkedList<Jugadores> listaJugadores = new LinkedList<Jugadores>();
			
			//CONECTAMOS A LA BBDD
			
			ConexionBBDD miConexion = new ConexionBBDD();
			
		try {
			miConexion.conectar();
				
			//LANZAMOS LA CONSULTA
				
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaJugadores);
				
			if (rsResultado != null) {
				
			//SI HAY RESULTADO RECUPERAMOS LOS DATOS (COMO UN FETCH DE UN CURSOR)
				
			while (rsResultado.next()) {
				
			//CREAMOS UN OBJETO JUGADOR POR CADA FILA DE LA TABLA (CADA JUGADOR)
				
			Jugadores jugador = new Jugadores(rsResultado.getString("Nombre"),
					rsResultado.getString("Procedencia"),
					rsResultado.getString("Altura"),
					String.valueOf(rsResultado.getString("Peso")),
					rsResultado.getString("Posicion"),
					rsResultado.getString("Nombre_equipo"));
			
			//LO INSERTAMOS EN LA LISTA 
			listaJugadores.add(jugador);
			
			
			}
			
			
				
			} else {
				
				System.out.println("LA CONSULTA NO DEVUELVE RESULTADOS");
			}
				System.out.println("NÚMERO DE JUGADORES="+listaJugadores.size());
				
		}catch (SQLException sqlex) {
			
			System.out.println("Error: "+ sqlex.getMessage());
			sqlex.printStackTrace();
			
		}
				
				finally {
					miConexion.desconectar();
				}
				
				return listaJugadores;
			
		
		
	}
	
	public static boolean insertarJugador(Jugadores jugador) {
		boolean bRes = true;
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
		miConexion.conectar();
		int iRes = miConexion.insertar(jugador);
		System.out.println("Resultado de insertar el jugador="+iRes);
		} catch (SQLException sqlex) {
		System.out.println("Error: " + sqlex.getMessage());
		sqlex.printStackTrace();
		bRes = false;
		} finally {
		miConexion.desconectar();
		}
		return bRes;
		}
	
	
	
}
