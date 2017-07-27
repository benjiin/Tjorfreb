package servlets;
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

@WebServlet("/Registrierung")
public class Registrierung extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public Registrierung()
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
			String SQL = "SELECT * FROM artikel";
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
		out.println("<h1>Willkommen Shop24.de</h1>");
		out.println("<img src=\"bild.png\">");
		out.println("<form action=\"http://127.0.0.1:8080/Shop24_de/Registrierung\" method=\"get\">");
		out.println("<br/>");
		out.println("<table style=\"text-align: left; width: 100px;\" border=\"0\">");
		out.println("<tbody>");
		out.println("<tr>");
		out.println("<td>Vorname:</td>");
		out.println("<td><input type=\"text\" name=\"vorname\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Name:</td>");
		out.println("<td><input type=\"text\" name=\"name\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>E-Mail</td>");
		out.println("<td><input type=\"text\" name=\"mail\"></td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("<br/>");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Regestrieren\"> <br />");		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}