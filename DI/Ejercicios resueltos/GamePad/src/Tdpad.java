import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;

public class Tdpad extends JPanel {
    private JButton botonA;
    private JButton botonS;
    private JButton botonW;
    private JButton botonD;

    public Tdpad() {

        setLayout(new FlowLayout());
        botonA = new JButton("A");
        botonS = new JButton("S");
        botonW = new JButton("W");
        botonD = new JButton("D");
        add(botonA);
        add(botonS);
        add(botonW);
        add(botonD);
    }

    public void getPantalla (Pantalla pantalla) {
         botonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setTexto("A");
            }
         });
         botonS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setTexto("S");
            }
         });
         botonW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setTexto("W");
            }
         });
         botonD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setTexto("D");
            }
         });
        }


}
