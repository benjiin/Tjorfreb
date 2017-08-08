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

//	public void init(ServletConfig config) throws ServletException
//	{
//
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		/**
		 * @author tristan
		 */
		//Get Cookie Informations
		response.setContentType("text/html");
		RequestDispatcher rd3=getServletContext().getRequestDispatcher("/Hee1");
		rd3.include(request, response);
		ResourceBundle textBundle = (ResourceBundle)request.getAttribute("textBundle");
		PrintWriter out = response.getWriter();
		
		
		// Translations
		String 	name=textBundle.getString("name"),
				entname=textBundle.getString("entname"),
				lastname=textBundle.getString("lastname"),
				entlastname=textBundle.getString("entlastname"),
				email=textBundle.getString("email"),
				entemail=textBundle.getString("entemail"),
				password=textBundle.getString("password"),
				entpassword=textBundle.getString("entpassword"),
				passwordcheck=textBundle.getString("passwordcheck"),
				entpasswordcheck=textBundle.getString("entpasswordcheck"),
				submitbutton=textBundle.getString("submitbutton"),
				backbutton=textBundle.getString("backbutton");
				

				

		/**
		 * @author benjaminr
		 */
		out.println("<br/>");
		out.println("<table style=\"text-align: left; width: 100px;\" border=\"0\">");
		out.println("<tbody>");
		out.println("<form action=\"Validate\" method=\"post\">");
		//Vorname
		out.println("<tr>");
		out.println("<td>"+name+":</td>");
		out.println("<td><input type=\"text\" placeholder=\""+entname+"\" required name=\"firstName\"></td>");
		out.println("</tr>");
		//Nachname
		out.println("<tr>");
		out.println("<td>"+lastname+":</td>");
		out.println("<td><input type=\"text\" placeholder=\""+entlastname+"\" required name=\"lastName\"></td>");
		out.println("</tr>");
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
		//Passwort wiederholen
		out.println("<td>"+passwordcheck+"</td>");
		out.println("<td><input type=\"password\" placeholder=\""+entpasswordcheck+"\" required name=\"passwordCheck\"></td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("<br/>");
		out.println("<input type=\"submit\" method=\"post\" value=\""+submitbutton+"\"/>");
		out.println("<input type=\"button\" value=\""+backbutton+"\" onclick=\"history.back()\"/>");
		out.println(); 
		out.println("</form>");
		
		// Language selecter
		
		String className="Registration";
		request.setAttribute("className", className);
		RequestDispatcher rd2=getServletContext().getRequestDispatcher("/Footer");
		rd2.include(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
	
	}
}