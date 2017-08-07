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
		//Get Cookie Informations
		response.setContentType("text/html");
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/whosThere");
		rd.include(request, response);
		ResourceBundle textBundle = (ResourceBundle)request.getAttribute("textBundle");
		PrintWriter out = response.getWriter();
		

		// Get Translations
		String language=textBundle.getString("language");
		String langvar=textBundle.getString("langvar");
		String multi_ipscan = textBundle.getString("ipscan");


		// Generate HTML Code
		out.println("<html><head><title>International</title></head>");
		out.println("<body><h1>" + multi_ipscan + "</h1>");

		// Language selecter
		String className="International";
		request.setAttribute("className", className);
		RequestDispatcher rd2=getServletContext().getRequestDispatcher("/changeLang");
		rd2.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}


}
