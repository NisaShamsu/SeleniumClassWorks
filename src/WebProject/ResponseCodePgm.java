package WebProject;

import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.Test;

public class ResponseCodePgm 
{
	String link="https://www.facebook.com";

	@Test
	public void responseFb()
	{
		try
		{
			URL u= new URL(link);
			HttpURLConnection con=(HttpURLConnection)u.openConnection();
			int code=con.getResponseCode();
			System.out.println(code);
			if(code==200)
				System.out.println("Succefull connection");
			else
				System.out.println("Unsuccessfull connection");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Link");
			
		}
	}

}
