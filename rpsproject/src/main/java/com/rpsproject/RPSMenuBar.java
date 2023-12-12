package com.rpsproject;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class RPSMenuBar extends JMenuBar {
    RPSMenuBar(){
        //Menus
        JMenu game = new JMenu("Game");
        JMenu settings = new JMenu("Settings");
        JMenu about = new JMenu("About");

        //Game menu Items
        JMenuItem newGame = new JMenuItem("New game");
        JMenuItem lookForGame = new JMenuItem("Look for game");
        JMenuItem exitGame = new JMenuItem("Exit game");

        game.add(newGame);
        game.add(lookForGame);
        game.add(exitGame);

        //Setting menu Items
        JMenuItem windowSize = new JMenuItem("Change window Size");

        settings.add(windowSize);

        //About Menu Items
        JMenuItem info = new JMenuItem("Info");

        about.add(info);


        add(game);
        add(settings);
        add(about);
    }
}   
