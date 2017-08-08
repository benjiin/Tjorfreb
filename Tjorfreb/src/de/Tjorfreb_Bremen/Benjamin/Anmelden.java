package de.Tjorfreb_Bremen.Benjamin;

import java.io.IOException;
import java.io.PrintWriter;

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
public class Anmelden extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anmelden() {
        super();
        // TODO Auto-generated constructor stub
    }
//sds
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Shop24.de</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Anmelden</h1>");
		out.println("</br>");
		out.println("</br>");		
		out.println("<img src=\"bild.png\">");
		out.println("<br/>");
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
		out.println(); 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
