package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index.html")
public class Index extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public Index()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Willkommen Shop24.de</h1>");
		out.println("<text>Index</text>");
		out.println("</br>");
		out.println("</br>");
		out.println("<img src=\"bild.png\">");	
		out.println("</br>");
		out.println("</br>");
	
		out.println("<form action=\"http://127.0.0.1:8080/Shop24_de/Registration\" method=\"get\">");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Registration\"> <br />");
		
		out.println("<form action=\"http://127.0.0.1:8080/Shop24_de/Login\" method=\"get\">");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Login\"> <br />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
			
	}

}
