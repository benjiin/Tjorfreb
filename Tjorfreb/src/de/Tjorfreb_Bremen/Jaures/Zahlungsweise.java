package de.Tjorfreb_Bremen.Jaures;

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

import help.WhichIP;

/**
 * Servlet implementation class Bestellung
 */
@WebServlet("/Zahlungsweise")
public class Zahlungsweise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zahlungsweise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
//			String SQL = "SELECT * FROM shoppingcart";
			stmt = conn.createStatement();
//			rs = stmt.executeQuery(SQL);						
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
		out.println("<h1><center>Unsere mögliche Zahlungsweise</center></h1>");
		out.println("</br>");
		out.println("Wählen Sie Ihre Zahlungsweise aus:");
		out.println("</br>");
		out.println("</br>");
		out.println("1- <a href=\"http://" + WhichIP.IP + ":8080/Tjorfreb/de.Tjorfreb_Bremen.Jaures/Kreditkarte\" method=\"post\">Kreditkarte</a>");
		out.println("</br>");
		out.println("</br>");
		out.println("2- <a href=\"http://" + WhichIP.IP + ":8080/Tjorfreb/de.Tjorfreb_Bremen.Jaures/Bankeinzug\" method=\"post\">Bankeinzug</a>");
		out.println("</br>");
		out.println("</br>");
		out.println("3- <a href=\"http://" + WhichIP.IP + ":8080/Tjorfreb/de.Tjorfreb_Bremen.Jaures/Vorkasse\" method=\"post\">Vorkasse</a>");
		out.println("</br>");
		out.println("</br>");
		out.println("4- <a href=\"http://" + WhichIP.IP + ":8080/Tjorfreb/de.Tjorfreb_Bremen.Jaures/Nachnahme\" method=\"post\">Nachnahme</a>");
		out.println("</br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
