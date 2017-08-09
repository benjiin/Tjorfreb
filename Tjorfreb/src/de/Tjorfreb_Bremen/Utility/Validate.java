package de.Tjorfreb_Bremen.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
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
//@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
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
		/**
		 * @author benjaminr
		 * Mit UUID (Universally Unique Identifier) wird eine einzigartige ID erstellt, die dem User nach dem registrieren mitgesendet wird.
		 */
		UUID ID = UUID.randomUUID();
		
		boolean invalidEmail = email.matches(possibleEMail),
				bfirstname = false,
				blastname = false,
				bemail = false,
				bpassword = false,
				emailNotAvaiable = true;
		
		Random 	r = new Random();			
		
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DataSource ds = null;
		/**
		 * @author benjaminr
		 * 
		 * Der Vorname wird überprüft ob keine Sonderzeichen oder Zahlen drin sind, andernfalls wird es eine Fehelermeldung geben.
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
		/**
		 * @author benjaminr
		 * Überprüfen ob die E-Mail Adresse schon vorhanden ist
		 */
		try
			{
			InitialContext jndiCntx = new InitialContext();
			ds = (DataSource) jndiCntx.lookup(resourcename);
			conn = ds.getConnection();
	
			String SQL = "SELECT `e_mail` FROM `user` WHERE e_mail= '"+email+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			while (rs.next()) 
			{
				emailNotAvaiable = false;
			}
			
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		if(invalidEmail == true)
		{
			bemail = true;
		}
		if(password.equals(passwordcheck)) 
		{
			bpassword = true;
		}
		/**
		 * @author benjaminr
		 * Wenn alle abfragen als falsch gewertert werden, kommt eine entsprechende Meldung an den USer zurück. Andernfalls wird die Datenbank geöffnet und der USer wird in die Datenbank gespeichert.
		 */
		if(bfirstname == false || blastname == false || bemail == false || bpassword == false || emailNotAvaiable == false)
		{
			response.setContentType("text/html");

			out.println("<html>");
			out.println("<head>");
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
				out.println("Gültige E-Mail eingeben");
			}
			else if(bpassword == false)
			{
				out.println("Passwort muss übereinstimmen");
			}
			else if(emailNotAvaiable == false)
			{
				out.println("E-Mail schon vorhanden");
			}
			out.println("<form>");
			out.println("<input type=\"button\" value=\"Zurück\" onclick=\"history.back()\"/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");				
		}
		else 
		{
			/**
			 * @author benjaminr
			 * Die aktuelle IP Adresse wird ausgelesen und an die Bestätigungsmail geschickt 
			 */
			response.setContentType("text/html");			
			String ip = request.getRemoteAddr();
			if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
				InetAddress inetAddress = InetAddress.getLocalHost();
				String ipAddress = inetAddress.getHostAddress();
				ip = ipAddress;
			}
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

				String SQL = "INSERT INTO User (name, lastname, e_mail, salt_value, password, reg_key) VALUES ('"+firstname+"', '"+lastname+"', '"+email+"', '"+salt+"', '"+generatedPassword+"', '"+ID+"')";
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
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Shop24.de</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Validierung</h1>");	
			out.println("Eine Mail zur Aktivierung ist nun unterwegs.");
			out.println("<form action=\"Header1\">");
			out.println("<input type=\"submit\" value=\"Startseite\"/>");
			out.println("</body>");
			out.println("</html>");			
			/**
			 * @author benjaminr
			 * Nachdem alle Daten richtig sind wird eine Mail (mit der angegebenen Mail) verschickt. Der Absender ist in diesem Fall "admin@tjorfreb.de.
			 */
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", "localhost");
			props.setProperty("mail.transport.protocol", "smtp");			
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			
			try
			{				
				message.setFrom(new InternetAddress("admin@tjorfreb.de"));
				message.addRecipients(Message.RecipientType.TO, email);
				message.setSubject("Registrierung als User für Shop24.de");
				message.setSentDate(new Date());
				message.setContent(
						"<h1>Registrierungslink</h1><br/>"
						+"Ein User mit der IP:"+ip+" hat versucht über Ihre E-Mail einen Account zu erstellen. Sollte dies nicht der Fall sein ignorieren Sie diese"
								+ " Mail. Ansonsten klicken Sie auf den unten liegenden Link<br/>"
						+ "<a href='http://localhost:8080/Tjorfreb/Emailverify?eMail="+email+"&ID="+ID+"'>Bitte hier registrieren...</a>",
						"text/html");
				Transport.send(message);
			} 
			catch (AddressException e)
			{
				e.printStackTrace();
			}
			catch (MessagingException e)
			{
				e.printStackTrace();
			}
		}
	}	
}