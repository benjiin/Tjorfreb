package de.Tjorfreb_Bremen.Benjamin;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
 * @author benjaminr
 */
/**
 * Servlet implementation class Database_Test
 */
@WebServlet("/Database_Test")
public class Database_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//kommentar
    public Database_Test() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String resourcename = "java:comp/env/jdbc/Tjorfreb";
		DataSource ds = null;
		
		
		

		try
		{
			InitialContext jndiCntx = new InitialContext();
			ds = (DataSource) jndiCntx.lookup(resourcename);

			conn = ds.getConnection();
			
//			String SQL = "SELECT registration_date from user where name = 'Hans'";
			String SQL = "SELECT * from user ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			


			
			
			

			
			

			out.println("<html><head><title>Connection Pooling</title></head>");

			
	
		      
			
			while (rs.next())
			{
				out.println("Name: " + rs.getString("name"));
				out.println("|||||| salz: " + rs.getString("salt_value"));
				out.println("|||||| password: " + rs.getString("password"));
				out.println("|||||| Timestamp: " + rs.getTimestamp("registration_date"));
				out.println("<br>");
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
			{
				try
				{
					rs.close();
				}
				catch (Exception e)
				{
				}				
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (Exception e)
				{
				}				
			}
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch (Exception e)
				{
				}				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	
}