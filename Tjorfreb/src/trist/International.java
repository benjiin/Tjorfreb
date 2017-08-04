package trist;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import java.net.InetAddress;
import 	java.net.Socket;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class International extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public International(){ super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// Vom Browser gesendete Informationen
        String browserDetails  =   request.getHeader("User-Agent");
        //Vom Client gesendete Informationen
		String host = request.getRemoteHost();
		InetAddress www = InetAddress.getByName(host);
    	String ipOwner = www.getHostName(); 
		String HostAdress = www.getHostAddress();
		String HostName = www.getHostName();
		Locale locale=request.getLocale();
	//	locale=locale.ENGLISH;
		ResourceBundle textBundle=PropertyResourceBundle.getBundle("translations.Translation",locale);
		
		// Translations
		String multi_ipscan=textBundle.getString("ipscan");
		String multi_ipadress=textBundle.getString("ipadress");
		String multi_brsdet=textBundle.getString("brsdet");

		
		//HTML Ausgabe
		out.println("<html><head><title>International</title></head>");
		out.println("<body><h1>"+multi_ipscan+"</h1>");
		out.println("<text>"+multi_ipadress+" :"+HostAdress+"</text></br></br>");
		out.println("Hostname :"+HostName+"</br></br>");
		out.println(multi_brsdet+" : "+browserDetails+"</br></br>");
		out.println("Locale: "+locale.getDisplayLanguage()+"</br>");
		out.println("Host: "+host);
		out.println("</body></html>");
		/*		
		<form action="select.html"> <label>Künstler(in): <select name="top5" size="5">
		<option>Heino</option> <option>Michael Jackson</option> <option>Tom Waits</option>
		<option>Nina Hagen</option> <option>Marianne Rosenberg</option> </select> </label> </form>*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
