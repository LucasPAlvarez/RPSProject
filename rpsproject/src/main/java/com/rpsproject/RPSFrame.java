package com.rpsproject;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


/**This is the main frame of the game */
public class RPSFrame extends JFrame{
    
    int WIDTH = 700;
    int HEIGHT = 400;

    RPSFrame(){
        //setting up the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setLayout(new BorderLayout());
        //setResizable(false);

        //do things here

        //add MenuBar
        
        setJMenuBar(new RPSMenuBar());

        //add game panel
        add(new RPSGamePanel(WIDTH));

        //add new panel
        RPSMessageBar log = new RPSMessageBar(HEIGHT);
        add(log,BorderLayout.SOUTH);
        log.changeMensage("editando mensaje");

        //end things here

        setVisible(true);
    }
}
