package de.Tjorfreb_Bremen.Afrooz.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatenBank 
{

	static Connection con;
	static Statement stmt;
	static ResultSet rs;

	final String hostname = "localhost";
	final String port = "";
	String dbname = "";
	final String user = "root";
	final String password = "";

	public DatenBank(String db) 
	{
		this.dbname = db;
	}

	public void verbindungsaufbau() 
	{

		try 
		{
			System.out.println("* Treiber laden");
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} 
		catch (Exception e) 
		{
			System.err.println(" driver konnte nicht geladen werden.");
		}
		
		try 
		{
			System.out.println("* Verbindung aufbauen");
			String url = "jdbc:mysql://" + hostname + "/" + dbname;
			con = DriverManager.getConnection(url, user, password);
			System.out.println("* Verbindung Erfogreich");
		} 
		catch (SQLException sqle) 
		{
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("SQLState: " + sqle.getSQLState());
			System.out.println("VendorError: " + sqle.getErrorCode());
		}
	}

	public void inDenWarenkorb(String vorname, String nachname, String geburtsdatum, 
							String strasse, String hausnr, int plz, String ort, int telefon,String mail, String passwort) {
		
		try 
		{
			stmt = con.createStatement();
			String sqlCommand = "insert into teilnehmer (vorname, nachname,geburtsdatum,strasse,hausnr, plz, ort, telefon,mail,passwort) "
					+ "values('" + vorname + "','" + nachname + "','" + geburtsdatum + "','" + strasse + "','" + hausnr + "','" + plz + "','" 
					+ ort + "','" + telefon + "','" + mail + "','" + passwort + "' )";
			stmt.executeUpdate(sqlCommand);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}
	
	public ArrayList<Object> warenkorbAnzeigen()
	{
		ArrayList<Object> tabelle = new ArrayList<Object>();
		
		try 
		{
			stmt = con.createStatement();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		try 
		{
			String sqlCommand="SELECT * FROM ";
			ResultSet rs =stmt.executeQuery(sqlCommand);
			
			while(rs.next())
			{	
				tabelle.add(rs.getString("vorname"));		
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return tabelle;	
	}
	
	public ArrayList<Object> alleWarenkoerbeAnzeigen()
	{
		ArrayList<Object> tabelle = new ArrayList<Object>();
		
		try 
		{
			stmt = con.createStatement();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		try 
		{
			String sqlCommand="";
			ResultSet rs =stmt.executeQuery(sqlCommand);
			
			while(rs.next())
			{				
				tabelle.add(rs.getString("vorname"));				
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return tabelle;		
	}
}