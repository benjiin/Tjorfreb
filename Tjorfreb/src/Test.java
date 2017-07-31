

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http2.StreamStateMachine;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		MysqlConnect mysqlConnect = new MysqlConnect();
		
		String sql = "SELECT * FROM `stackoverflow`";
		try {
		    PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
		    
		    PrintWriter out = response.getWriter();
		    out.print(statement);
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    mysqlConnect.disconnect();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public class MysqlConnect {
	    // init database constants
	    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/tjorfreb";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "";
	    private static final String MAX_POOL = "250";

	    // init connection object
	    private Connection connection;
	    // init properties object
	    private Properties properties;

	    // create properties
	    private Properties getProperties() {
	        if (properties == null) {
	            properties = new Properties();
	            properties.setProperty("user", USERNAME);
	            properties.setProperty("password", PASSWORD);
	            properties.setProperty("MaxPooledStatements", MAX_POOL);
	        }
	        return properties;
	    }

	    // connect database
	    public Connection connect() {
	        if (connection == null) {
	            try {
	                Class.forName(DATABASE_DRIVER);
	                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
	            } catch (ClassNotFoundException | SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return connection;
	    }

	    // disconnect database
	    public void disconnect() {
	        if (connection != null) {
	            try {
	                connection.close();
	                connection = null;
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
