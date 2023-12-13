package com.rpsproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.rpsproject.GameLogic.Picks;

public class OnlinePlay {

    static Socket socket = null;

    static PrintWriter out = null;
    static BufferedReader in = null;

    boolean foundConnection = false;
    boolean continueOneline = true;

    static Thread ol = null;

    public void startConnection(){
        Thread st = new Thread(new Temp());
        st.start();
    }

    public static void con(Socket threadSocket){
        try {
            if((socket = threadSocket) != null){
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void startListenner(){
        ol = new Thread(new OpponentListener(in));
        ol.start();
    }

    public void sendPick(Picks p){
        out.println(p.ordinal());
    }

    public void disconnect(){
        try {
            in.close();
            out.close();
            socket.close();
            continueOneline = false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
