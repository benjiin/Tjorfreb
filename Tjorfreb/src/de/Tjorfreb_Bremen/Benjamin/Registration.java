package de.Tjorfreb_Bremen.Benjamin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import help.WhichIP;

@WebServlet("/Registration")
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
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String resourcename = "java:comp/env/jdbc/dozent";
		DataSource ds = null;

		try
		{
			InitialContext jndiCntx = new InitialContext();
			ds = (DataSource) jndiCntx.lookup(resourcename);
			conn = ds.getConnection();
			String SQL = "SELECT * FROM user";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);						
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			if (rs != null)
				try
				{
					rs.close();
				} catch (Exception e)
				{
				}
			if (stmt != null)
				try
				{
					stmt.close();
				} catch (Exception e)
				{
				}
			if (conn != null)
				try
				{
					conn.close();
				} catch (Exception e)
				{
				}
		}
				
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		out.println("<title>Shop24.de</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Registration</h1>");
		out.println("</br>");
		out.println("</br>");		
		out.println("<img src=\"bild.png\">");
		out.println("<br/>");
		out.println("<table style=\"text-align: left; width: 100px;\" border=\"0\">");
		out.println("<tbody>");
		out.println("<tr>");
		out.println("<td>Vorname:</td>");
		out.println("<td><input type=\"text\" placeholder=\"Ihr Vorname\" name=\"vorname\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>E-Mail:</td>");
		out.println("<td><input type=\"text\" placeholder=\"Ihre E-Mail Adresse\"  name=\"name\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Passwort</td>");
		out.println("<td><input type=\"text\" placeholder=\"******\" name=\"mail\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Passwort Wiederholen</td>");
		out.println("<td><input type=\"text\" placeholder=\"******\" name=\"mail\"></td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("<br/>");
		out.println("<form action=\"http://" + WhichIP.IP + ":8080/Tjorfreb/de.Tjorfreb_Bremen.Benjamin.Registration/Registration\" method=\"post\">");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Erstellen Sie ihr Konto\"> <br />");		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}