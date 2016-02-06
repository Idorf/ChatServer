package chatserver.domain;

import chatserver.gui.ServerGui;
import java.awt.EventQueue;
import java.io.IOException;

public class Controller
{
	private static Controller controller;
	private static Server server;
        private static ClientHandler clientHandler;
        private static ServerGui serverGui;
        private static RequestListener requestListener;
	private static OutToAllClients outToAllClientsObject;
	private static PrefixHandler prefixHandler;

	public static synchronized Controller getControllerInstance()
	{
		if(controller ==null)
		{
			controller = new Controller();
		}
		return controller;	
	}

	public static synchronized Server getServerInstance() throws IOException
	{
		if (server == null)
		{
			server = new Server();
		}
		return server;
	}
       
 
               	public static synchronized ServerGui getServerGuiInstance() throws IOException
	{
		if (serverGui == null)
		{
                      EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
                                        serverGui = new ServerGui();
                                        
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
        
		}
                
		return serverGui;
	}
        	public static synchronized ClientHandler getClientHandlerInstance() throws IOException
	{
		if (clientHandler == null)
		{
                    		System.out.println(" new");

			clientHandler = new ClientHandler();
		}
		return clientHandler;
	}
                
              public static synchronized PrefixHandler getPrefixHandlerInstance()
	{
		if(prefixHandler == null)
		{
			prefixHandler = new PrefixHandler();
		}
		return prefixHandler;
	}
              
              	public static synchronized OutToAllClients getOutToAllClientInstance()
	{
		if(outToAllClientsObject== null)
		{
			outToAllClientsObject = new OutToAllClients();
		}
		return outToAllClientsObject;
	}
		
                
}
