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
		String 	ID = request.getParameter("ID"),
				email = request.getParameter("eMail");
		
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
				if(rs.getString(5).equals(ID) && rs.getString(10).equals(email))
				{
					SQL = "UPDATE user SET is_activated = 1 WHERE e_mail = '"+email+"' AND reg_key = '"+ID+"'";
					stmt.executeUpdate(SQL);
				}
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Shop24.de</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(email);
		out.println(ID);
		out.println("<h1>Aktiviert</h1>");	
		out.println("Herzlichen Glückwunsch Sie sind nun registiert.");
		out.println("<form action=\"Startseite\">");
		out.println("<input type=\"submit\" value=\"Startseite\"/>");
		out.println("</body>");
		out.println("</html>");	

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
