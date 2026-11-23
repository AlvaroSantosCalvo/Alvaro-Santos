import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Lrpad extends JPanel {
    private JButton botonX;
    private JButton botonO;
    private JButton botonI;

    public Lrpad() {
        setLayout(new GridLayout(3,1,3,3));
        botonX = new JButton("X");
        botonO = new JButton("O");
        botonI = new JButton("I");
        add(botonX);
        add(botonO);
        add(botonI);
       
 
    }
    public void getPantalla (Pantalla pantalla) {
         botonX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setTexto("X");
            }
         });
         botonO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setTexto("O");
            }
         });
         botonI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setTexto("I");
            }
         });
        }
    }
    
