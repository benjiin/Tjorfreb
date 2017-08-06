
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HTMLMail")
public class HTMLMail extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public HTMLMail()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "localhost");
		props.setProperty("mail.transport.protocol", "smtp");
		
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		
		try
		{
			message.setFrom(new InternetAddress("benutzer@tjorfreb.de"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"benutzer@tjorfreb.de"));
			message.setSubject("Testmail 325");
			message.setSentDate(new Date());
			message.setContent(
					"<h1>Registrierungslink</h1><br/><a href='http://www.heise.de'>Bitte hier registrieren...</a>",
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}
