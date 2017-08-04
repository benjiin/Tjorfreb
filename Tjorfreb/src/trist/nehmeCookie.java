package trist;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class nehmeCookie
 */

public class nehmeCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nehmeCookie() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		Cookie[] cookie = request.getCookies();
		pw.println("All Cookies in your browsers");
		
		for(Cookie obj : cookie){
		/*	if(obj.getName().equals("url")){
				pw.println(obj.getName() + " : " + obj.getValue());
				break;
			}*/
			if(obj.getName().equals("lang_co")){
				pw.println(obj.getName() + " : " + obj.getValue());
				break;
			}
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
