package chatserver.domain;

import java.io.IOException;

public class Controller
{
	private static Controller controller;
	private static Server server;


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
}
