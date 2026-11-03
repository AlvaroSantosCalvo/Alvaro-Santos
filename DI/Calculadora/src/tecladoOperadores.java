import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class tecladoOperadores extends JPanel {
    private InputMap mapaEntrada = getInputMap(WHEN_IN_FOCUSED_WINDOW);
    private ActionMap mapaAcciones = getActionMap();
    private JButton botonBorrar;
    private JButton botonDiv;
    private JButton botonMult;
    private JButton botonMenos;
    private JButton botonMas;
    private JButton botonIgual;
    

    public tecladoOperadores() {
        setLayout(new GridLayout(6, 1, 10, 10));
        setBorder(new EmptyBorder(0, 10, 0, 5));
        setPreferredSize(new java.awt.Dimension(120, 0));
        
        botonBorrar = new JButton("C");
        botonDiv = new JButton("/");
        botonMult = new JButton("X");
        botonMenos = new JButton("-");
        botonMas = new JButton("+");
        botonIgual = new JButton("=");

        add(botonBorrar);
        char teclaBorrar = 'c';
        setBinding(teclaBorrar, botonBorrar);
        
        add(botonDiv);
        char tecla = '/';
        setBinding(tecla, botonDiv);
        
        add(botonMult);
        char teclaM = '*';
        setBinding(teclaM, botonMult);
        
        add(botonMenos);
        char teclaMen = '-';
        setBinding(teclaMen, botonMenos);
        
        add(botonMas);
        char teclaMas = '+';
        setBinding(teclaMas, botonMas);
        
        add(botonIgual);
        char teclaIgual = '=';
        setBinding(teclaIgual, botonIgual);


        botonBorrar.setBackground(Color.GRAY);
        botonDiv.setBackground(Color.BLUE);
        botonMult.setBackground(Color.BLUE);
        botonMenos.setBackground(Color.BLUE);
        botonMas.setBackground(Color.BLUE);
        botonIgual.setBackground(Color.RED);

        botonBorrar.setForeground(Color.BLACK);
        botonDiv.setForeground(Color.WHITE);
        botonMult.setForeground(Color.WHITE);
        botonMenos.setForeground(Color.WHITE);
        botonMas.setForeground(Color.WHITE);
        botonIgual.setForeground(Color.WHITE);
        
        botonBorrar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonDiv.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonMult.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonMenos.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonMas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonIgual.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        
    }

    public void getOperadores(pantallaLcd displayPantalla) {
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.clearPantalla();
            }
        });
        botonDiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("/");
            }
        });
        botonMult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("*");
            }
        });
        botonMenos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("-");
            }
        });
        botonMas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("+");
            }
        });
        botonIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("=");
            }
        });
    }

    private void setBinding(char c, final JButton boton) {
        KeyStroke teclaPres = KeyStroke.getKeyStroke(Character.toLowerCase(c));
        mapaEntrada.put(teclaPres, teclaPres.toString());
        mapaAcciones.put(teclaPres.toString(), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton.doClick();
            }
        });
    }
}
