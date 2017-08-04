package trist;

import java.io.IOException;
import java.util.*;
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

    public Searching() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("Served at: ").append(request.getContextPath());
		//selectItemX("name","item","Mobile",out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spattern=request.getParameter("spattern");
		PrintWriter out = response.getWriter();
		//out.append("Suchwort:"+spattern);
		ArrayList<String> erg = new ArrayList<String>();
		selectItemX("name","item",spattern,out);
	}
	
	
	public ArrayList selectItemX(String field, String table,String spattern, PrintWriter out)
	{
		ArrayList<String> erg = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String resourcename = "java:comp/env/jdbc/Tjorfreb";
		DataSource ds = null;
		try
		{
			InitialContext jndiCntx = new InitialContext();
			ds = (DataSource) jndiCntx.lookup(resourcename);
			conn = ds.getConnection();
			String SQL = "SELECT "+field+" FROM "+table+" where name like '%"+spattern+"%'";
			System.out.println("xx"+SQL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()){ 
				System.out.println(rs.getString("name"));
				erg.add(rs.getString("name")); }
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
