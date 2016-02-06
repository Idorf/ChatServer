/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver.domain;

import chatserver.gui.ServerGui;
import java.io.IOException;

/**
 *
 * @author Idorf
 */
public class Server {
      
    public Server() throws IOException
    {
        new ServerGui();
        
        System.out.println("waiting");

    }

    
}
