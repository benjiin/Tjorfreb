package de.Tjorfreb_Bremen.Benjamin;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

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
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * @author benjaminr
		 */
		String 	resourcename = "java:comp/env/jdbc/Tjorfreb",
				firstname = request.getParameter("firstName"),
				lastname = request.getParameter("lastName"),
				email = request.getParameter("eMail"),
				password = request.getParameter("password"),
				passwordcheck = request.getParameter("passwordCheck"),
				possibleEMail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
				chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",
				salt = new String(),
				generatedPassword = new String();
		
		boolean invalidEmail = email.matches(possibleEMail),
				bfirstname = false,
				blastname = false,
				bemail = false,
				bpassword = false;
		
		Random 	r = new Random();			
		
		PrintWriter out = response.getWriter();
		/**
		 * @author benjaminr
		 * 
		 * Der Vorname wird �berpr�ft ob keine Sonderzeichen oder Zahlen drin sind, andernfalls wird es eine Fehelermeldung geben.
		 * Ausserdem wird der Name, wenn klein geschrieben, am Anfang gross geschrieben
		 */
		if (firstname.matches("[a-zA-Z-]+$")) 
		{
			firstname = firstname.substring(0,1).toUpperCase() + firstname.substring(1).toLowerCase();	
			bfirstname = true;
		}
		if(lastname.matches("[a-zA-Z]+$"))
		{
			lastname = lastname.substring(0,1).toUpperCase() + lastname.substring(1).toLowerCase();	
			blastname = true;
		}
		if(invalidEmail == true)
		{
			bemail = true;
		}
		if(password.equals(passwordcheck)) 
		{
			bpassword = true;
		}
		
		if(bfirstname == false || blastname == false || bemail == false || bpassword == false)
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
			out.println("<title>Shop24.de</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Ooops...</h1>");
			if(bfirstname == false || blastname == false)
			{
				out.println("Keine Zahlen im Namen");
			}
			else if(bemail == false)
			{
				out.println("G�ltige E-Mail eingeben");
			}
			else if(bpassword == false)
			{
				out.println("Passwort muss �bereinstimmen");
			}
			out.println("<form>");
			out.println("<input type=\"button\" value=\"Zur�ck\" onclick=\"history.back()\"/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");				
		}
		else 
		{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			DataSource ds = null;

			/**
			 * @author benjaminr
			 * 
			 * Saltwert ermitteln und in die Datenbank speichern
			 */
			for(int i = 0; i<39; i++)
			{
				salt += chars.charAt(r.nextInt(chars.length()));
			}		
			/**
			 * @author benjaminr
			 * 
			 * Hashwert ermitteln
			 */				
			try {
				String passwordToHash = password + salt;
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(passwordToHash.getBytes());
				byte[] bytes = md.digest();
				StringBuilder sb = new StringBuilder();
				for(int i=0; i< bytes.length ;i++)
				{
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}
				generatedPassword = sb.toString();
				} 
				catch (NoSuchAlgorithmException e) 
				{
					e.printStackTrace();
				}			
			try
			{
				InitialContext jndiCntx = new InitialContext();
				ds = (DataSource) jndiCntx.lookup(resourcename);

				conn = ds.getConnection();

				String SQL = "INSERT INTO User (name, lastname, e_mail, salt_value, password) VALUES ('"+firstname+"', '"+lastname+"', '"+email+"', '"+salt+"', '"+generatedPassword+"')";
				stmt = conn.createStatement();
				stmt.executeUpdate(SQL);
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
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
			out.println("<title>Shop24.de</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Validierung</h1>");
			out.println("Eine Mail zur Aktivierung ist nun unterwegs.");
			out.println("Eine Mail zur Aktivierung ist nun unterwegs.");
			out.println("<form action=\"Startseite\">");
			out.println("<input type=\"submit\"  value=\"Startseite\"/>");
			out.println("</body>");
			out.println("</html>");					
		}
	}


	
}
