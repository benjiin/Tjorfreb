package trist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * Servlet implementation class whosThere
 */
@WebServlet("/whosThere")
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		checkCookie(request,response);
		request.setAttribute("pattern", checkCookie(request,response));
	}

	
	public String checkCookie(HttpServletRequest request, HttpServletResponse response)
	{
		String lang = "uknown";
		//Locale locale = new Locale("en", "EN");
		try
		{
			Cookie[] cookie = request.getCookies();
			for (Cookie obj : cookie)
			{
				if (obj.getName().equals("lang_co"))
				{
					lang = obj.getValue();
					break;
				}
			}
		} catch (Exception e)
		{
			lang="uknown";
			System.out.println("es gab einen fehler");
		}
		
		if(lang=="uknown") {

			lang=createCookie(request,response);
		}
		return lang;
	}
	
	public String createCookie(HttpServletRequest request, HttpServletResponse response) {
		Locale 	locale= request.getLocale();
		System.out.println("wurde erstellt:"+locale.toString());
		Cookie cookie = new Cookie("lang_co",locale.toString());
		cookie.setMaxAge(60*60); //1 hour
		response.addCookie(cookie);
		return locale.toString();
}

}
