package com.ies.baroja;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Jugadores;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Error: la llamadas GET no están permitidas").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("username")!=null) {
			
			try {
				loginUsuario(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (request.getParameter("nombre")!=null) {
			
			altaJugador(request,response);
			
		}
		
		
		
}
	
	
	private static void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			//CREAMOS EL OBJETO SESIÓN Y GUARDAMOS LA SESIÓN ACTUAL DEL USUARIO
			
			HttpSession sesion = request.getSession();
			String sUsername = request.getParameter("username");
			String sPwd = request.getParameter("password");
			
			//VALIDACIÓN DE CREDENCIALES (POR AHORA NO SE ACCEDE A BASE DE DATOS, MÁS ADELANTE SI
			
			 //IF COINCIDE USERNAME PASSWORD Y ADEMAS NO HAY SESIÓN INICIADA
			if (sUsername.equals("alexstan22") && sPwd.equals("alexontime") && sesion.getAttribute("nombreusu") == null) {
				
			//REDIRIJO A PÁGINA CON INFORMACIÓN DE LOGIN EXITOSO
				sesion.setAttribute("username",sUsername);
				response.sendRedirect("..//JSP//loginExito.jsp");
				
				
				
			} else {
				
				//CREDENCIALES INVÁLIDAS
				mostrarError(response);
				
			}
		}
		
		
		
		
		
	
	
	public void altaJugador(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			/** 1-RECOGIDA DE DATOS */
		
		Jugadores jugador = new Jugadores(request.getParameter("nombre"),
				request.getParameter("procedencia"),
				request.getParameter("altura"),
				request.getParameter("peso"),
				request.getParameter("posicion"),
				request.getParameter("nombre_equipo"));
		
		/** 2- INSERTAR JUGADOR EN LA BASE DE DATOS */
		
			boolean bRes = Controller.insertarJugador(jugador);
		
		/** 3- MOSTRAR RESULTADOS POR PANTALLA */
			
			if (bRes) {
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<HTML>\n" + "<HEAD><TITLE>Página de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
						+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
						+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
						+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
						+ "<h2 class=\"text-success\">Jugador insertado correctamente<h2>\n"
						+ "<ul class=\"list-group\"> \n" + "  <LI class=\"list-group-item\">nombre: " + jugador.getNombre()
						+ "</li>\n" + "  <LI class=\"list-group-item\">procedencia: " + jugador.getProcedencia() + "</li>\n"
						+ "  <LI class=\"list-group-item\">altura: " + jugador.getAltura() + "</li>\n"
						+ "  <LI class=\"list-group-item\">peso: " + jugador.getPeso() + "</li>\n"
						+ "  <LI class=\"list-group-item\">posicion: " + jugador.getPosicion() + "</li>\n"
						+ "  <LI class=\"list-group-item\">nombre_equipo: " + jugador.getNombre_equipo() + "</li>\n"
						+ "</UL>\n" + "</div></BODY></HTML>");
				
				out.close();
				
				
				
			} else {
				
				// MOSTRAMOS QUE SE HA PRODUCIDO UN ERROR
				
				mostrarError(response);
				
			} 
		
		}catch (IOException ex) {
			
			System.out.println("ERROR EN SERVLET");
			ex.printStackTrace();
			mostrarError(response);
			
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	private static void mostrarError(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>Página de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error interno<h1>\n"
				+ "<img src=\"img/error.jpg\" class=\"rounded\" alt=\"error interno\">" + "</div></BODY></HTML>");
		out.close();
	}
	
	
	
	
}

	
