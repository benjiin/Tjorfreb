package de.Tjorfreb_Bremen.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Footer
 */
//@WebServlet("/Footer")
public class Footer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Footer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doPost(request,response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/whosThere");
		rd.include(request, response);
		ResourceBundle textBundle = (ResourceBundle)request.getAttribute("textBundle");
		PrintWriter out = response.getWriter();
		String className=(String)request.getAttribute("className");
		String lang="";
		
		lang=(String)request.getParameter("lang");
		Cookie cookie = new Cookie("lang_co",lang);
		cookie.setMaxAge(24*7*60*60); // Eine Woche
		response.addCookie(cookie);
		System.out.println("class: "+className);
		System.out.println("lang: "+lang);
				
		if(lang!=null) {
			className=(String)request.getParameter("className");
			System.out.println("passt:"+className);
			System.out.println("class2: "+className);
			response.sendRedirect("/Tjorfreb/"+className);
		}

		String language=textBundle.getString("language");
		String langvar=textBundle.getString("langvar");
		String altLang="";

		if(langvar.equals("de_DE")) { altLang="<option value=\"en_EN\">English</option>";	}
		else {	altLang="<option value=\"de_DE\">Deutsch</option>"; }
		out.println("<form action=\"/Tjorfreb/Footer\" method=\"post\">");
		out.println("<select name=\"lang\">");
		out.println("<option default=\""+langvar+"\">"+language+"</option>");
		out.println(altLang);
		out.println("</select>");
		//out.println("<input type=\"hidden\" name=\"switcher\" value=\"updateLang\">");
		System.out.println("klasse:"+className);
		out.println("<input type=\"hidden\" name=\"className\" value=\""+(className)+"\">");
		System.out.println("6");
		out.println("<input type=\"submit\" name=\"submit\" value=Go!> <br />");
		out.println("</form></body></html>");
	}

}
