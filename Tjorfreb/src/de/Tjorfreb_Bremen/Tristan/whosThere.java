package de.Tjorfreb_Bremen.Tristan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class whosThere
 */
//@WebServlet("/whosThere")
public class whosThere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final char[] test = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public whosThere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setAttribute("textBundle", checkCookie(request,response));

	}
		
	protected ResourceBundle checkCookie(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("checkCookie");
		String lang = "uknown";
		try
		{
			Cookie[] cookie = request.getCookies();
			for (Cookie obj : cookie)
			{
				
				if (obj.getName().equals("lang_co")){ lang = obj.getValue();System.out.println("Sprache gefunden:"+lang); break;	}
			}
		} 
		catch (Exception e)		{
			lang="uknown";
			System.out.println("kein cookie");
		}
		if(lang=="uknown") { lang=createCookie(request,response); }
		Locale locale = new Locale("en", "EN");
		switch (lang)
		{
		case "de_DE":	locale = new Locale("de", "DE"); break;
		case "en_EN":	locale = new Locale("en", "EN"); break;
		default:		locale = request.getLocale();
		}
		
		ResourceBundle textBundle = PropertyResourceBundle.getBundle("translations.Translation", locale);
		return textBundle;
	}
		
	protected String createCookie(HttpServletRequest request, HttpServletResponse response) {
		Locale 	locale= request.getLocale();
		Cookie cookie = new Cookie("lang_co",locale.toString());
		cookie.setMaxAge(24*7*60*60); // Eine Woche
		response.addCookie(cookie);
		return locale.toString();
}
		

}
