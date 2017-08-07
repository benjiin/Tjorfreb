package de.Tjorfreb_Bremen.Benjamin;

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

/**
 * Servlet implementation class Emailverify
 */
@WebServlet("/Emailverify")
public class Emailverify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Emailverify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String someName = (String)request.getAttribute("attributeName");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DataSource ds = null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String resourcename = "java:comp/env/jdbc/Tjorfreb";

		try
		{
			InitialContext jndiCntx = new InitialContext();
			ds = (DataSource) jndiCntx.lookup(resourcename);
			conn = ds.getConnection();

			String SQL = "SELECT * FROM `user`";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next())
			{
				if(rs.getString(5).equals(someName))
				{
					SQL = "INSERT INTO User (is_activated) VALUES ('1')";
					stmt.executeUpdate(SQL);
				}
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
