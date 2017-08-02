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
/**
 * Servlet implementation class User_Informations
 */
//@WebServlet("/International")
public class International extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public International()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
	

		//getInetAddress;


		// hallo du da
		out.println("<html>");
		out.println("<head>");
		out.println("<title>International</title>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Ihre IP wird gescannt</h1>");
		out.println("<img src=\"bild.png\">");
		out.println("</br>");
		out.println("</br>");
		out.println("<form action=\"http://127.0.0.1:8080/Shop24_de/Startseite\" method=\"get\">");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Registrieren\"> <br />");
		out.println("</form>");
		out.println("<text> Hier könnte ihre Ip stehen!</text>");

		out.println(
				"<P>IP-Adresse:<!--#echo var=\"REMOTE_ADDR\"--></P><P>Browser:<!--#echo var=\"HTTP_USER_AGENT\"--></P>");

		String host = request.getRemoteHost();
        String  browserDetails  =   request.getHeader("User-Agent");

        String os = "";
        String browser = "";
        
		InetAddress www = InetAddress.getByName(host);
		String ipOwner = www.getHostName(); 
	
		String HostAdress = www.getHostAddress();
		String HostName = www.getHostName();

		
		out.println("HostAdress :"+HostAdress);
		out.println("</br>");
		out.println("HostNamä :"+HostName);
		

		
		
		/*out.println("Browser: "+browser);
		out.println("</br>");
		out.println("Browser-Details :"+ browserDetails);
		out.println("</br>");

		out.println("Hosst :"+host);
		out.println("</br>");
		out.println("Os :"+os);
		
		out.println("www :"+www);
		out.println("</br>");
		
		out.println("Hosst :"+www);
		out.println("</br>");
		
		out.println("Hosst :"+www);
		out.println("</br>");
		
		
		
		out.println("</body>");
		out.println("</html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
