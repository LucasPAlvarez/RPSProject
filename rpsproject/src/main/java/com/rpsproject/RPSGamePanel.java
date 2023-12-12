package com.rpsproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class RPSGamePanel extends JPanel{

    int windowWidth;

    RPSGamePanel(int frameWidth){
        setBackground(Color.BLUE);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //gets the frame width
        windowWidth = frameWidth;

        //player panel
        JPanel playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(windowWidth/100 * 59, this.getHeight()));
        playerPanel.setBackground(Color.CYAN);
        add(playerPanel,BorderLayout.WEST);

        //separator
        
        add(Box.createHorizontalStrut(windowWidth/100 * 2));

        //oponent panel
        JPanel oponentPanel = new JPanel();
        oponentPanel.setPreferredSize(new Dimension(windowWidth/100*39, this.getHeight()));
        oponentPanel.setBackground(Color.PINK);
        add(oponentPanel, BorderLayout.EAST);
        
    }
}
