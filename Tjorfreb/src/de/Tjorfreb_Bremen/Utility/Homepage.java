package de.Tjorfreb_Bremen.Utility;


/**
*
* @author Afrooz Akbari
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Startseite
 */
//@WebServlet("/Startseite")
public class Homepage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Homepage()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String regis = request.getParameter("regis");
		String anm = request.getParameter("anm");
		int admin = 0;
		// DatenBank db = new DatenBank("group2db");
		HttpSession session = request.getSession();
		// System.out.println("start " + session.getId());
		// session.setAttribute("db", db);

		// Hiemit sage ich den Browser dass mein Antwort text und html
		// beinhaltet.
		response.setContentType("text/html");
		// Hiermit hole ich ein writer damit ich in die antwort rein schreiben
		// kann.
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.print("<a href='Startseite'>Startseite</a> | ");
		out.print("<a href='ArtikelListe'>Artikelliste</a> |");
		out.print("<a href='Warenkorb'>Warenkorb</a> | ");
		if ((request.getSession().getAttribute("user_status") != null))
		{
			admin = (int) request.getSession().getAttribute("user_status");
		}

		if (admin == 1)
			out.print("<a href='AlleWarenkoerbe'>Alle Warenkörbe</a> |");

		if (regis != null)
		{
			request.getRequestDispatcher("Datenbank").include(request, response);
			// System.out.println((int)request.getSession().getAttribute("user_id"));
		}

		if (anm != null)
		{
			request.getRequestDispatcher("Datenbank").include(request, response);
		}
		/**
		 * @author benjaminr
		 * Registrierung und Anmeldung hinzufügen
		 */
		out.print("<a href='Registration'>Registrieren</a> |");
		out.print("<a href='SignIn'>Anmelden</a> |");

		out.print("</center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}