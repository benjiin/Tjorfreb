package trist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//out.append(SelectItemX("*", "Benutzer"));
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Willkommen bei Shop24.de</h1>");
		out.println("<text>Suche</text>");
		out.println("</br>");
		out.println("</br>");
		out.println("<img src=\"bild.png\">");	
		out.println("</br>");
		out.println("</br>");
		
		out.println("<tr>");
		out.println("<td>Suche:</td>");

		out.println("</tr>");
				
		out.println("<form action=\"/Tjorfreb/Searching\" method=\"post\">");
		out.println("<td><input type=\"text\" placeholder=\"Suchbegriff hier eingeben...\" required name=\"spattern\"></td>");
		out.println("<input type=\"submit\" name=\"submit\" value=Go!> <br />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	

}