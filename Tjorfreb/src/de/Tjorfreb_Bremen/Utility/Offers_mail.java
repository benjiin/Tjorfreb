package de.Tjorfreb_Bremen.Utility;
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


//@WebServlet("/Angebote_mail")
public class Offers_mail extends HttpServlet
{
	
	private String angebote;
	private int preis;
	
	private static final long serialVersionUID = 1L;

	public Offers_mail()
	{
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String resourcename = "java:comp/env/jdbc/Tjorfreb";
		DataSource ds = null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

			
		try
		{						
			InitialContext jndiCntx = new InitialContext();
			ds = (DataSource) jndiCntx.lookup(resourcename);
			conn = ds.getConnection();
			String SQL = "SELECT * FROM item";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			out.println("<html><head><title>Shop 24.de</title></head><body>");

			while (rs.next())
			{																		
				angebote = "Wir haben für Sie dieses Angebot: </br></br>"+ rs.getString(3)+"</br></br>"+rs.getString(4)+"</br></br>"+" Angebot: "+rs.getString(5)+" Euro!"+"</br>-----------------------------------------</br></br>";				
				out.println(angebote);	
				
				this.preis = rs.getInt(5);
				out.println(preis);				
			}
			
		
			
			out.println("</body></html>");
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

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	
	
		
}
