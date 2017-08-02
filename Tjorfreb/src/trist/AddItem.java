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

//import java.lang.StringBuilder;
/**
 * Servlet implementation class AddItem
 */
// @WebServlet("/AddItem")
public class AddItem extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public AddItem() { super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.append(SelectItemX("*", "Benutzer"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	public StringBuilder SelectItemX(String field, String table)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuilder erg = new StringBuilder();
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
			while (rs.next()){ erg.append(rs.getString(1) + " " + rs.getString(2)); }
		}
		catch (Exception e)	{ e.printStackTrace(); }
		finally
		{
			if (rs != null)
				try	{ rs.close();} 
				catch (Exception e)	{	}
			if (stmt != null)
				try	{ stmt.close();	} 
				catch (Exception e)	{	}
			if (conn != null)
				try	{ conn.close();	} 
				catch (Exception e)	{ }
		}
		return erg;
	}

}
