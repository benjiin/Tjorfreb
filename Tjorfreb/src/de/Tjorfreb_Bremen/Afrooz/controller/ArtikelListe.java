package de.Tjorfreb_Bremen.Afrooz.controller;

/**
*
* @author Afrooz Akbari
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArtikelListe
 */
@WebServlet("/ArtikelListe")
public class ArtikelListe extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtikelListe() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			response.setContentType("text/html");
			PrintWriter out =response.getWriter();
			out.print("<a href='Startseite'>Startseite</a> | ");
			out.print("<a href='ArtikelListe'>Artikelliste</a> |");
			out.print("<a href='Warenkorb'>Warenkorb</a> | ");
			out.print("<a href='AlleWarenkoerbe'>Alle Warenkörbe</a> |");
			out.print("<br><br>");
			out.print("Alle Artikel aus de Datenbank holen und anzeigen");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			// TODO Auto-generated method stub
			doGet(request, response);
		}
}