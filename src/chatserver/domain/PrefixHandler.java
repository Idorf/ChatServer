package chatserver.domain;

import java.io.IOException;

public class PrefixHandler
{
	String [] splitFullClientMessage;
	String prefixType;
	String clientName;
	String clientSentence;
	String fullClientMessage;
	
	boolean newRequest = false;
	
	public void readPrefixFromClient(String fullClientMessage) throws IOException
	{
		this.fullClientMessage = fullClientMessage;
		
		splitFullClientMessage = fullClientMessage.split("\\s", 2);
		
		prefixType = splitFullClientMessage[0];


		if(prefixType.equals("JOIN"))
		{
			splitFullClientMessage = fullClientMessage.split("\\s", 2);
			clientName = splitFullClientMessage[1];

			fullClientMessage =  prefixType + " " + canClientJoin(clientName);
			//Controller.getOutToAllClientInstance().sendToAllClients();

			newRequest = true;

		}
		
		else if(prefixType.equals("MSG"))
		{	
			splitFullClientMessage = fullClientMessage.split("\\s", 3);
			clientName = splitFullClientMessage[1];
			clientSentence =  splitFullClientMessage[2];
			
			System.out.println("IN FROM clientMSG: " + fullClientMessage);
			Controller.getOutToAllClientInstance().sendToAllClients();
			newRequest = true;
		}
		else if(prefixType.equals("QUIT"))
		{
			splitFullClientMessage = fullClientMessage.split("\\s", 2);

		//	clientName = splitFullClientMessage[1];
		//	clientSentence =  prefixType+ " " + clientName;
			newRequest = true;

		}
		else if(prefixType.equals("PING"))
		{	
			splitFullClientMessage = fullClientMessage.split("\\s", 2);
			clientName = splitFullClientMessage[1];
			newRequest = true;

			//		pingServerFromClient(clientName);
		}
	}
	
	public String getPrefixType()
	{
		return prefixType;
	}
	public String getClientName()
	{
		return clientName;
	}
	public String getClientSentence()
	{
		return clientSentence;
	}
	public String getFullClienMessage()
	{
		return fullClientMessage;
	}

	public boolean newRequest()
	{
		boolean temp = newRequest;
		newRequest = false;
	//	System.out.println("newRequest " + newRequest +" Temp " +temp );
		return temp;	
	}
	
	public String canClientJoin(String clientName) throws IOException
	{
		if (Controller.getClientHandlerInstance().doesClientNameExits(clientName))
		{
			return "TAKEN";
		}
		else
		{
			return "FREE";
		}	
	}

}
