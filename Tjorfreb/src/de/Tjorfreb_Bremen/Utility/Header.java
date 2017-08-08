package de.Tjorfreb_Bremen.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * 
 * Servlet implementation class Header
 */

public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {  super(); }
	/**
	 * 
	 * 
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get Language
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/whosThere");
		rd.include(request, response);
		ResourceBundle textBundle = (ResourceBundle)request.getAttribute("textBundle");
		PrintWriter out = response.getWriter();	
		
		
		// Translations
		String gratz=textBundle.getString("gratz");
		
		// Start HTML Code
		out.println("<html><body><h1>"+gratz+"</h1>");
		out.print("<center>");
		out.print("<a href='Header'>Startseite</a> | ");
		out.print("<a href='ArtikelListe'>Artikelliste</a> |");
		out.print("<a href='ShoppingCart'>Warenkorb</a> | ");
		out.print("<a href='Registration'>Registrieren</a> |");
		out.print("<a href='SignIn'>Anmelden</a> |");
		out.println("</br>");
		out.print("</center>");
		out.println("<img src=\"bild.png\"></br></br><tr>");
	}

}
