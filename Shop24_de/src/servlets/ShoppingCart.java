package servlets;

import java.io.IOException;

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

@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ShoppingCart()
	{
		super();
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

	}
	
}