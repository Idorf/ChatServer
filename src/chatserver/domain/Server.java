/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver.domain;

import chatserver.gui.ServerGui;
import java.io.IOException;
import java.awt.EventQueue;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    

    public Server() throws IOException 
    {
        
        runGui();
        
        runClientHandler();
                
    }
   	
    public void runGui() throws IOException
    {

        Controller.getServerGuiInstance();
    }
    
    public void runClientHandler() throws IOException
    {

        Controller.getClientHandlerInstance();
        System.out.println(" getClientHandlerInstancee");

    }
}