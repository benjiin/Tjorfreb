package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Startseite")
public class Startseite extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	


	public Startseite()
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
		out.println("<title>Shop24.de</title>");
		out.println("<h1>Willkommen Shop24.de</h1>");
		out.println("<img src=\"bild.png\">");	
		out.println("</br>");
		out.println("</br>");
		//IP des Server eingeben unter localhsot
		out.println("<form action=\"http://localhost:8080/Tjorfreb/Registration\" method=\"get\">");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Registrieren\"> <br />");
		out.println("</form>");
		//IP des Server eingeben unter localhsot
		out.println("<form action=\"http://localhost:8080/Tjorfreb/Anmelden\" method=\"get\">");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Anmelden\"> <br />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
			
	}

}
