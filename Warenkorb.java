package controller;

/**
*
* @author Afrooz Akbari
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Artikel;
import model.WarenkorbSE;

/**
 * Servlet implementation class Warenkorb
 */
@WebServlet("/Warenkorb")
public class Warenkorb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Warenkorb() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count=0;
		int admin=0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center>");
		out.print("<a href='Startseite'>Startseite</a> | ");
		out.print("<a href='ArtikelListe'>Artikelliste</a> |");
		out.print("<a href='Warenkorb'>Warenkorb</a> | ");
		if((request.getSession().getAttribute("user_status")!=null)){
			admin=(int)request.getSession().getAttribute("user_status");
		}
		System.out.println(admin);
		if(admin==1)
		out.print("<a href='AlleWarenkoerbe'>Alle Warenkörbe</a> |");
		out.print("<br><br>");
		if(request.getSession().getAttribute("user_vorname")!=null)
		out.println(" <table border=3 bgcolor='#CCCCFF' width=800 height=50><tr ><th>Warenkorb von " +((String)request.getSession().getAttribute("user_vorname")).toUpperCase()+" "+((String)request.getSession().getAttribute("user_name")).toUpperCase()+"</th></tr> </table>");
		else out.println(" <table border=3 bgcolor='#CCCCFF' width=800 height=50><tr ><th>Warenkorb von GAST</th></tr> </table>");
		out.println("<table border=3 bgcolor='#CCCCFF' width=800 height=300>");
		out.println("<tr ><th>ID</th><th>Artikelbezeichnung</th><th>Preis</th><th>Gesamtpreis</th><th>Aktion</th></tr>");
		HttpSession session = request.getSession();
	    WarenkorbSE warenkorb = (WarenkorbSE) session.getAttribute("warenkorb");
	    if(!warenkorb.getArtikelListe().isEmpty()){
		for (Artikel art : warenkorb.getArtikelListe()) {

			out.println("<tr >");
			out.print("<td>" + art.getId() + "</td>" + "<td>" + art.getName() + "</td>" + "<td>" + art.getPrice()
					+ "</td>" +"<td></td>"+ "<td>" + "<a href='AddArtikel?id=" + art.getId()
					+"&status=2&count=" + count
					+ "'> von Warenkorb entfernen!</a> </td>");
			out.println("</tr>");
			count++;

		}
	    }
	    else request.getSession().setAttribute("info", "Keine Arikel im Warenkorb");

		out.println("<tr >");
		out.print("<td></td><td></td><td></td><td>" + warenkorb.getGesamtPreis()+ "</td><td></td>");
		out.println("</tr>");
		out.println("</table>");
		if (request.getSession().getAttribute("info") != null) {
			out.println("<table border=3 bgcolor='#CCCCFF' width=800 height=50>");
			out.println("<tr >");
			out.print("<td>" + request.getSession().getAttribute("info") + "</td>");
			out.println("</tr>");
			out.println("</table>");
			request.getSession().removeAttribute("info");
		}
		out.println("</center>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}