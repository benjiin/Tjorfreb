package trist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Willkommen Shop24.de</h1>");
		out.println("<text>Login</text>");
		out.println("</br>");
		out.println("</br>");
		out.println("<img src=\"bild.png\">");	
		out.println("</br>");
		out.println("</br>");
	
		out.println("<form action=\"/Shop24/Index\" method=\"get\">");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Index\"> <br />");
		
		out.println("<form action=\"http://127.0.0.1:8080/Shop24_de/Search\" method=\"get\">");
		out.println("<input type=\"submit\" name=\"abschicken\" value=\"Search\"> <br />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
