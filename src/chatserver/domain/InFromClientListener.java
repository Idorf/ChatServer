package chatserver.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

public class InFromClientListener extends Client implements Runnable
{
	public InFromClientListener() throws UnknownHostException, IOException
	{
		super(socketConnection, clientNumber);
	}

	public void run()
	{
		try
		{
			inFromClient();
		} catch ( IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void inFromClient() throws UnknownHostException, IOException
	{
		while(true)
		{

			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
			
			String inFromClientText = inFromServer.readLine();
			
				Controller.getPrefixHandlerInstance().readPrefixFromClient(inFromClientText);

		}

	}
}
