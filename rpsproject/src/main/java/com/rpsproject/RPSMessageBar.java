package com.rpsproject;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class RPSMessageBar extends JPanel{

    JLabel mensaje;

    RPSMessageBar(int height){
        setPreferredSize(new Dimension(this.getWidth(), height/100 * 5));
        System.out.println(height + " " + this.getWidth());
        setBackground(Color.yellow);

        mensaje = new JLabel("test");
        add(mensaje);
    }

    public void changeMensage(String m){
        mensaje.setText(m);
    }

}
