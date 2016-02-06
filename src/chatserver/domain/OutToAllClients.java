package chatserver.domain;

import java.io.IOException;

public class OutToAllClients
{
	public void sendToAllClients() throws IOException
	{
		for(Client clientObject : ClientHandler.getClientListInstance().values())
		{
			clientObject.sendToClient();
			System.out.println("clientNumber" + clientObject.getClientNumber());

		}
	}
}
