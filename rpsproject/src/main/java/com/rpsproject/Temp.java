package com.rpsproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Temp implements Runnable{

    @Override
    public void run() {
        //serch for someone hosting
        Socket socket = null;
        boolean foundConnection = false;
        try{
            System.out.println("Looking for an opponenet");
            GameLogic.changeLoggerText("Looking for an opponenet");
            socket = new Socket("localhost", 9806);
            foundConnection = true;
            
        }catch(IOException e){
            System.out.println("Couldn't find one, switching to hosting");
            GameLogic.changeLoggerText("Couldn't find one, switching to hosting");
        }
        if(!foundConnection){
            //if not host
            try {
                ServerSocket server = new ServerSocket(9806);
                OnlinePlay.socket = server.accept();
                server.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        OnlinePlay.startListenner();
        OnlinePlay.con(socket);
        foundConnection = false;
       
        
    }
    
}
