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
 * Servlet implementation class Startseite
 */
@WebServlet("/Startseite")
public class Startseite extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Startseite() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			// Hiemit sage ich den Browser dass mein Antwort text und html beinhaltet.
			response.setContentType("text/html");
			// Hiermit hole ich ein writer damit ich in die antwort rein schreiben kann.
			PrintWriter out =response.getWriter();
			out.print("<a href='Startseite'>Startseite</a> | ");
			out.print("<a href='ArtikelListe'>Artikelliste</a> |");
			out.print("<a href='Warenkorb'>Warenkorb</a> | ");
			out.print("<a href='AlleWarenkoerbe'>Alle Warenkörbe</a> |");
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