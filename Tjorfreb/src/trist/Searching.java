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


public class Searching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searching() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//out.append("Suchwort:"+spattern);
		out.append("Servedd at: ").append(request.getContextPath());

		out.append(selectItemX("name","item","Mobile"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String spattern=request.getParameter("spattern");
		PrintWriter out = response.getWriter();
		//out.append("Suchwort:"+spattern);
		
		out.append(selectItemX("name","item","Mobile"));
	}
	
	
	public StringBuilder selectItemX(String field, String table,String spattern)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuilder erg = new StringBuilder();
		String resourcename = "java:comp/env/jdbc/dozent";
		DataSource ds = null;
		erg.append("Ergehhhhhhbnis :");
		try
		{
			ds = (DataSource) jndiCntx.lookup(resourcename);
			conn = ds.getConnection();
			String SQL = "SELECT "+field+" FROM "+table+" where name like '%"+spattern+"%'";
			System.out.println("gbbbbbbbbbbbbbbbbbbbbbbb");
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
