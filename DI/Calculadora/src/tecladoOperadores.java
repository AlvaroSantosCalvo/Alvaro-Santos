import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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

    public tecladoOperadores() {
        setLayout(new GridLayout(5, 1, 10, 10));
        setBorder(new EmptyBorder(0, 10, 0, 5));
        setPreferredSize(new java.awt.Dimension(110, 0));
        
        JButton botonDiv = new JButton("/");
        add(botonDiv);
        char tecla = '/';
        setBinding(tecla, botonDiv);

        JButton botonMult = new JButton("X");
        add(botonMult);
        char teclaM = '*';
        setBinding(teclaM, botonMult);

        JButton botonMenos = new JButton("-");
        add(botonMenos);
        char teclaMen = '-';
        setBinding(teclaMen, botonMenos);

        JButton botonMas = new JButton("+");
        add(botonMas);
        char teclaMas = '+';
        setBinding(teclaMas, botonMas);

        JButton botonIgual = new JButton("=");
        add(botonIgual);
        char teclaIgual = '=';
        setBinding(teclaIgual, botonIgual);

        botonDiv.setBackground(Color.BLUE);
        botonMult.setBackground(Color.BLUE);
        botonMenos.setBackground(Color.BLUE);
        botonMas.setBackground(Color.BLUE);
        botonIgual.setBackground(Color.RED);
        botonDiv.setForeground(Color.WHITE);
        botonMult.setForeground(Color.WHITE);
        botonMenos.setForeground(Color.WHITE);
        botonMas.setForeground(Color.WHITE);
        botonIgual.setForeground(Color.WHITE);
        botonDiv.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonMult.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonMenos.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonMas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonIgual.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
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
