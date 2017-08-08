package de.Tjorfreb_Bremen.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author benjaminr
 */
//@WebServlet("/Registration")
public class Registration extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public Registration()
	{
		super();
	}

	public void init(ServletConfig config) throws ServletException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		/**
		 * @author tristan
		 */
		//Get Cookie Informations
		response.setContentType("text/html");
		System.out.println("wsdes");
		RequestDispatcher rd3=getServletContext().getRequestDispatcher("/Header");
		rd3.include(request, response);
		ResourceBundle textBundle = (ResourceBundle)request.getAttribute("textBundle");
		PrintWriter out = response.getWriter();
		// Translations
		String srch=textBundle.getString("srch");
		String entrSrch=textBundle.getString("entrSrch");

		/**
		 * @author benjaminr
		 */
//		out.println("<head>Registrierung</head>");
		out.println("<br/>");
		out.println("<table style=\"text-align: left; width: 100px;\" border=\"0\">");
		out.println("<tbody>");
		out.println("<form action=\"Validate\" method=\"post\">");
		//Vorname
		out.println("<tr>");
		out.println("<td>Vorname:</td>");
		out.println("<td><input type=\"text\" placeholder=\"Ihr Vorname\" required name=\"firstName\"></td>");
		out.println("</tr>");
		//Nachname
		out.println("<tr>");
		out.println("<td>Nachname:</td>");
		out.println("<td><input type=\"text\" placeholder=\"Ihr Nachname\" required name=\"lastName\"></td>");
		out.println("</tr>");
		//E-Mail
		out.println("<tr>");
		out.println("<td>E-Mail:</td>");
		out.println("<td><input type=\"text\" placeholder=\"Ihre E-Mail Adresse\" required name=\"eMail\"></td>");
		out.println("</tr>");
		//Passwort
		out.println("<tr>");
		out.println("<td>Passwort</td>");
		out.println("<td><input type=\"password\" placeholder=\"Geben Sie Ihr Passwort ein\" required name=\"password\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		//Passwort wiederholen
		out.println("<td>Passwort Wiederholen</td>");
		out.println("<td><input type=\"password\" placeholder=\"Geben Sie Ihr Passwort noch einmal ein\" required name=\"passwordCheck\"></td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("<br/>");
		out.println("<input type=\"submit\" method=\"post\" value=\"Erstellen Sie ihr Konto\"/>");
		out.println(); 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
	
	}
}