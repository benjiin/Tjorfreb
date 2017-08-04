package trist;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.InetAddress;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


public class International extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public International()	{	super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd;
		rd=getServletContext().getRequestDispatcher("/whosThere");
		rd.include(request, response);
		String lang=(String) request.getAttribute("pattern");		
		Locale locale = new Locale("en", "EN");
		switch (lang)
		{
		case "de_DE":
			locale = new Locale("de", "DE");
			break;
		case "en_EN":
			locale = new Locale("en", "EN");
			break;
		default:
			locale = request.getLocale();
		}
			
		String browserDetails = request.getHeader("User-Agent");
		PrintWriter out = response.getWriter();
		ResourceBundle textBundle = PropertyResourceBundle.getBundle("translations.Translation", locale);
		// Locale swedishLocale = new Locale("sv", "SE");
		// Locale englishLocale = new Locale("en", "EN");

		String host = request.getRemoteHost();
		InetAddress www = InetAddress.getByName(host);
		String ipOwner = www.getHostName();
		String HostAdress = www.getHostAddress();
		String HostName = www.getHostName();

		// Translations
		String multi_ipscan = textBundle.getString("ipscan");
		String multi_ipadress = textBundle.getString("ipadress");
		String multi_brsdet = textBundle.getString("brsdet");

		// HTML Ausgabe
		out.println("<html><head><title>International</title></head>");
		out.println("<body><h1>" + multi_ipscan + "</h1>");
		out.println("<text>" + multi_ipadress + " :" + HostAdress + "</text></br></br>");
		out.println("Hostname :" + HostName + "</br></br>");
		out.println(multi_brsdet + " : " + browserDetails + "</br></br>");
		out.println("Locale: " + locale.getDisplayLanguage() + "</br>");
		out.println("Host: " + host);

		// Sprachauswahl
		out.println("<form action=\"/Tjorfreb/International\" method=\"post\">");
		out.println("<select name=\"lang\">");
		out.println("<option value=\"de_DE\">DE</option>");
		out.println("<option value=\"en_EN\">EN</option>");
		out.println("<option value=\"-\">Other</option></select>");
		out.println("<input type=\"submit\" name=\"submit\" value=Go!> <br />");
		out.println("</form></body></html>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		updateLang(request,response);
		doGet(request,response);
	}

	public void updateLang(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String lang=request.getParameter("lang");
		System.out.println("x: "+lang);
		Cookie cookie = new Cookie("lang_co",lang);
		cookie.setMaxAge(60*60); //1 hour
		response.addCookie(cookie);
		response.setHeader( "Refresh", "1" );
	}
}
