package chatserver.domain;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	protected static Socket socketConnection;
	String readInFromUser="";
	//	private SharedData sharedData = SharedData.getSharedDataInstance();
	protected String clientName;
	protected static String clientNumber;

	public Client(Socket connection, String clientNumber)
	{
		Client.socketConnection = connection;
		Client.clientNumber = clientNumber;
	}

	public void setClientName(String clientName)
	{
		this.clientName = clientName;
	}
	public String getClientNumber()
	{
		return clientNumber;
	}
	public void threadsStarter() throws UnknownHostException, IOException
	{
		Thread clientListener = new Thread(new InFromClientListener());
		clientListener.start();
		Thread serverListener = new Thread(new RequestListener(this));
		serverListener.start();
	}

	public void sendToClient() throws IOException
	{
		
		DataOutputStream outToClient = new DataOutputStream(socketConnection.getOutputStream());
		String prefixType = Controller.getPrefixHandlerInstance().getPrefixType();
		String clientName = Controller.getPrefixHandlerInstance().getClientName();
		String clientSentence = Controller.getPrefixHandlerInstance().getClientSentence();
		String fullClientMessage = Controller.getPrefixHandlerInstance().getFullClienMessage();
		
		System.out.println("inside sendToClient prefix "+prefixType);

	//	System.out.println("inside sendToClient "+fullClientMessage);
	
		if(prefixType.equals("MSG"))
		{
			System.out.println(fullClientMessage);

			outToClient.writeBytes(fullClientMessage +"\n");
			System.out.println("MSG IP "+ socketConnection.getInetAddress()+ " Port " + socketConnection.getPort());

		}
		else if(prefixType.equals("JOIN"))
		{
			if(canClientJoin(clientName).equals("FREE")) 
			{
			Controller.getClientHandlerInstance().replaceClientKey(clientNumber, clientName);		
                        
			}
			System.out.println("inside JOIN sendToClient "+prefixType+ " FREE "+ clientName);
		
			outToClient.writeBytes(prefixType+ " FREE " + clientName +"\n");
			System.out.println("JOIN IP "+ socketConnection.getInetAddress()+ " Port " + socketConnection.getPort());

		}

	}	

	public void addClientToList(String clientName) throws IOException
	{
		Controller.getClientHandlerInstance().replaceClientKey(clientNumber, clientName);
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

	public Client getClientObject()
	{
		return this;
	}
}
