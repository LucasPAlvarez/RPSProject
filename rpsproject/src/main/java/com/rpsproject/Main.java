package com.rpsproject;

public class Main {
    public static void main(String[] args) {
        //RPSFrame game = new RPSFrame();
        GameJFrame frame = new GameJFrame();
        GameLogic.getUI(frame);
        frame.setVisible(true);
    }
}