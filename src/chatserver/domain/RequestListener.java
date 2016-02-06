package chatserver.domain;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map.Entry;

public class RequestListener implements Runnable
{
	Client clientObject;
	public RequestListener(Client clientObject)
	{
	this.clientObject= clientObject;
		
	}
	public void run()
	{
		while(true)
		{

			//	System.out.println(Controller.getPrefixHandlerInstance().newRequest());

			if(Controller.getPrefixHandlerInstance().newRequest())
			{
				try
				{
					
					/*for(Client clientObject : Server.getClientListInstance().values())
					{
						clientObject.sendToClient();
						System.out.println("clientNumber" + clientObject.getClientNumber());

					}*/
					System.out.println("inside new request");
					
					
					clientObject.sendToClient();
			} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}


}
