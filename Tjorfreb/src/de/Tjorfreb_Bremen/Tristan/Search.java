package de.Tjorfreb_Bremen.Tristan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */

public class Search extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Get Cookie Informations
		response.setContentType("text/html");
		RequestDispatcher rd3=getServletContext().getRequestDispatcher("/Header");
		rd3.include(request, response);
		ResourceBundle textBundle = (ResourceBundle)request.getAttribute("textBundle");
		PrintWriter out = response.getWriter();
		
		// Translations
		String srch=textBundle.getString("srch");
		String entrSrch=textBundle.getString("entrSrch");
		

		out.println("<td>"+srch+" :</td></tr>");
		out.println("<form action=\"/Tjorfreb/Searching\" method=\"post\">");
		out.println("<td><input type=\"text\" placeholder=\""+entrSrch+"\" required name=\"spattern\"> style=\"width:123px</td>");
		out.println("<input type=\"submit\" name=\"searchBTN\" value=Go!> <br />");
		out.println("</form>");
		
		
		// Language selecter
		String className="Search";
		request.setAttribute("className", className);
		RequestDispatcher rd2=getServletContext().getRequestDispatcher("/Footer");
		rd2.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	

}