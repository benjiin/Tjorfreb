package trist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.codec.binary.Base64;
/**
 * Servlet implementation class CurlTry
 */
//@WebServlet("/CurlTry")
public class CurlTry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurlTry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String stringUrl = "https://qualysapi.qualys.eu/api/2.0/fo/report/?action=list";
	        URL url = new URL(stringUrl);
	        URLConnection uc = url.openConnection();

	        uc.setRequestProperty("X-Requested-With", "Curl");

	        String userpass = "username" + ":" + "password";
	        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
	        uc.setRequestProperty("Authorization", basicAuth);

	        InputStreamReader inputStreamReader = new InputStreamReader(uc.getInputStream());
	        // read this input
		
		response.getWriter().append("Ausgelesen: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
