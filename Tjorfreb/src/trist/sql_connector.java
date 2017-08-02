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

/**
 * Servlet implementation class sql_connector
 */
@WebServlet("/sql_connector")
public class sql_connector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//kommentar
    public sql_connector() {
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

			out.println("<html><head><title>Connection Pooling</title></head><body>");

			while (rs.next())
			{
				out.println(rs.getString(1) + " " + rs.getString(2));
			}

			out.println("</body></html>");
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
//f
		finally
		{
			if (rs != null)
				try
				{
					rs.close();
				}
				catch (Exception e)
				{
				}
			if (stmt != null)
				try
				{
					stmt.close();
				}
				catch (Exception e)
				{
				}
			if (conn != null)
				try
				{
					conn.close();
				}
				catch (Exception e)
				{
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