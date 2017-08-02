package de.Tjorfreb_Bremen.Benjamin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 * @author benjaminr
 */
public class DBConnect
{
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;


	String resourcename = "java:comp/env/jdbc/dozent";
	DataSource ds = null;

	public void connect(String SQL)
	{
		try
		{
			InitialContext jndiCntx = new InitialContext();
			ds = (DataSource) jndiCntx.lookup(resourcename);
			
			conn = ds.getConnection();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
	public void close()
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			}
			catch (Exception e)
			{
			}				
		}
		if (stmt != null)
		{
			try
			{
				stmt.close();
			}
			catch (Exception e)
			{
			}				
		}
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch (Exception e)
			{
			}				
		}		
	}
}
