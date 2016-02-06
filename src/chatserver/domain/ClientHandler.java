
package chatserver.domain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler {
     
    private static ConcurrentHashMap<String, Client> clientList;

    public  ClientHandler() throws IOException
	{
            
                System.out.println(" ClientHandler waiting");

		Integer clientNumber = 0;
		
		ServerSocket listener = new ServerSocket(8008);
		Socket socketConnection;


		while(true)
		{
			System.out.println("waiting");
			socketConnection= listener.accept();
			
			clientNumber++;
				
				Client newClient= new Client(socketConnection, Integer.toString(clientNumber));
				System.out.println("x "+ clientNumber);
	
				newClient.threadsStarter();
				addClientToList(Integer.toString(clientNumber), newClient);
				System.out.println("clientlist " +clientList.toString());

		}
	}
	
    
	public static synchronized ConcurrentHashMap<String, Client> getClientListInstance()
	{
		if(clientList == null)
		{
			clientList = new ConcurrentHashMap<String, Client>();;
		}
		return clientList;
	}

	public synchronized boolean doesClientNameExits(String clientName)
	{
		if (clientList.containsKey(clientName))
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	@SuppressWarnings("unchecked")
	public  synchronized void replaceClientKey(String oldKey, String newKey)
	{
		Client tempClientObject = (Client) clientList.get(oldKey);
		clientList.remove(oldKey);
		clientList.put(newKey, tempClientObject);
		
	}
	@SuppressWarnings("unchecked")
	
	public static synchronized void addClientToList(String clientName, Client clientObject)
	{
		getClientListInstance();
		clientList.put(clientName, clientObject);
	}

	
}

    
   
