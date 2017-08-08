package de.Tjorfreb_Bremen.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author benjaminr
 */
/**
 * Servlet implementation class Anmelden
 */
//@WebServlet("/Anmelden")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }
//sds
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Get Cookie Informations
		response.setContentType("text/html");
		RequestDispatcher rd3=getServletContext().getRequestDispatcher("/Header1");
		rd3.include(request, response);
		ResourceBundle textBundle = (ResourceBundle)request.getAttribute("textBundle");
		PrintWriter out = response.getWriter();
		
		// Translations
		String srch=textBundle.getString("srch");
		String entrSrch=textBundle.getString("entrSrch");
		
		out.println("<table style=\"text-align: left; width: 100px;\" border=\"0\">");
		out.println("<tbody>");
		out.println("<form action=\"Startseite\" method=\"post\">");
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
		out.println("</tbody>");
		out.println("</table>");
		out.println("<br/>");
		out.println("<input type=\"submit\" method=\"post\" value=\"Abschicken\"/>");
		out.println("</form>");

		// Language selecter
		String className="Search";
		request.setAttribute("className", className);
		RequestDispatcher rd2=getServletContext().getRequestDispatcher("/Footer");
		rd2.include(request, response);
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
