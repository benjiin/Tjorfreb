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
		String 	email=textBundle.getString("email"),
				entemail=textBundle.getString("entemail"),
				password=textBundle.getString("password"),
				entpassword=textBundle.getString("entpassword"),
				loginbutton=textBundle.getString("loginbutton"),
				backbutton=textBundle.getString("backbutton");

		
		out.println("<table style=\"text-align: left; width: 100px;\" border=\"0\">");
		out.println("<tbody>");
		out.println("<form action=\"Startseite\" method=\"post\">");
		//E-Mail
		out.println("<tr>");
		out.println("<td>"+email+":</td>");
		out.println("<td><input type=\"text\" placeholder=\""+entemail+"\" required name=\"eMail\"></td>");
		out.println("</tr>");
		//Passwort
		out.println("<tr>");
		out.println("<td>"+password+"</td>");
		out.println("<td><input type=\"password\" placeholder=\""+entpassword+"\" required name=\"password\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("<br/>");
		out.println("<input type=\"submit\" method=\"post\" value=\""+loginbutton+"\"/>");
		out.println("<input type=\"button\" value=\""+backbutton+"\" onclick=\"history.back()\"/>");
		out.println("</form>");

		// Language selecter
		String className="SignIn";
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
