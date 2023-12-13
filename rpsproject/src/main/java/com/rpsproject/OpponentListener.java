package com.rpsproject;

import java.io.BufferedReader;
import java.io.IOException;

public class OpponentListener implements Runnable{

    BufferedReader in;

    OpponentListener(BufferedReader in){
        this.in = in;
    }

    @Override
    public void run() {
        String input;
        try {
            while((input = in.readLine()) != null){
                if(input.equals("exit")){
                    break;
                }   
                GameLogic.onlineOpponentPick(input);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
