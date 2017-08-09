package de.Tjorfreb_Bremen.Utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPass
{
/**
 * @author benjaminr
 */
	public static String Hashpass(String password, String salt)
	{		
		String  passwordToHash = password + salt,
				generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(passwordToHash.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}	
		
		return generatedPassword;
	}	
	public boolean Checkpass(String hash, String salt, String password)
	{		
		return true;
	}
}