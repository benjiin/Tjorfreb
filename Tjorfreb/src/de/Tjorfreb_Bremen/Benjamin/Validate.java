package de.Tjorfreb_Bremen.Benjamin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
//		out.println("<title>Shop24.de</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>Validate</h1>");
//		out.println("</br>");
//		out.println("</br>");		
//		out.println("<img src=\"bild.png\">");
//		out.println("<input type=\"button\" value=\"Startseite\" onclick=\"Startseite\">");
//		out.println("<br/>");
//		out.println("<table style=\"text-align: left; width: 100px;\" border=\"0\">");
//		out.println("<tbody>");
//		out.println("</body>");
//		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String 	firstname = request.getParameter("firstName"),
				lastname = request.getParameter("lastName"),
				email = request.getParameter("eMail"),
				password = request.getParameter("password"),
				passwordcheck = request.getParameter("passwordCheck"),
				possibleEMail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		boolean invalidEmail = email.matches(possibleEMail),
				bfirstname = false,
				blastname = false,
				bemail = false,
				bpassword = false;
				
		
		PrintWriter out = response.getWriter();
			
			/*
			 * Der Vorname wird überprüft ob keine Sonderzeichen oder Zahlen drin sind, andernfalls wird es eine Fehelermeldung geben.
			 * Ausserdem wird der Name, wenn klein geschrieben, am Anfang gross geschrieben
			 */
			if (firstname.matches("[a-zA-Z-]+$")) 
			{
				firstname = firstname.substring(0,1).toUpperCase() + firstname.substring(1).toLowerCase();	
				bfirstname = true;
			}
			/*
			 * Der Nachname wird überprüft ob keine Sonderzeichen oder Zahlen drin sind, andernfalls wird es eine Fehelermeldung geben.
			 * Ausserdem wird der Name, wenn klein geschrieben, am Anfang gross geschrieben
			 */
			if(lastname.matches("[a-zA-Z]+$"))
			{
				lastname = lastname.substring(0,1).toUpperCase() + lastname.substring(1).toLowerCase();	
				blastname = true;
			}
			/*
			 * Email Validierung 
			 */
			if(invalidEmail == true)
			{
				bemail = true;
			}
			/*
			 * Passwort Überprüfung
			 */
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
					out.println("Gültige E-Mail eingeben");
				}
				else if(bpassword == false)
				{
					out.println("Passwort muss übereinstimmen");
				}
				out.println("<form>");
				out.println("<input type=\"button\" value=\"Zurück\" onclick=\"history.back()\"/>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");				
			}
			else 
			{
				out.println("<html>");
				out.println("<head>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
				out.println("<title>Shop24.de</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Validierung</h1>");
				out.println("Eine Mail zur Aktivierung ist nun unterwegs.");
				out.println("<form action=\"Startseite\">");
				out.println("<input type=\"submit\"  value=\"Startseite\"/>");
				out.println("</body>");
				out.println("</html>");					
			}
	}
}
