import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class tecladoNumerico extends JPanel {
    private InputMap mapaEntrada = getInputMap(WHEN_IN_FOCUSED_WINDOW);
    private ActionMap mapaAcciones = getActionMap();
    private JButton boton0;
    private JButton botonP;
    private JButton botonCS;
    private JButton botonesNum[] = new JButton[10];

    public tecladoNumerico() {
        setLayout(new GridLayout(4, 3, 10, 10));
        setBorder(new EmptyBorder(0, 10, 0, 5));
        for (int c = 1; c <= 9; c++) {
            String caracter = c + "";
            char tecla = (char) (c + '0');
            botonesNum[c] = new JButton(caracter);
            // boton.setName("boton" + c);

            botonesNum[c].setBackground(Color.ORANGE);
            botonesNum[c].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            botonesNum[c].setFocusPainted(false); // para que no se marque el texto al pulsar el boton

            add(botonesNum[c]);
            setBinding(tecla, botonesNum[c]);
        }
        // Añadimos botones "0", "." y "+/-" y los asociamos a la tecla correspondiente
        boton0 = new JButton("0");
        add(boton0);
        char tecla = '0';
        setBinding(tecla, boton0);

        botonP = new JButton(".");
        add(botonP);
        char teclaP = '.';
        setBinding(teclaP, botonP);

        botonCS = new JButton("+/-");
        add(botonCS);
        char teclaCS = 's';
        setBinding(teclaCS, botonCS);

        boton0.setBackground(Color.ORANGE);
        botonP.setBackground(Color.ORANGE);
        botonCS.setBackground(Color.ORANGE);
        boton0.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonP.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonCS.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    }

    public void getPantalla(pantallaLcd displayPantalla) {
        boton0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("0");
            }
        });
        botonP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito(".");
            }
        });
        botonCS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("+/-");
            }
        });
        botonesNum[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("1");
            }
        });
        botonesNum[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("2");
            }
        });
        botonesNum[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("3");
            }
        });
        botonesNum[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("4");
            }
        });
        botonesNum[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("5");
            }
        });
        botonesNum[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("6");
            }
        });
        botonesNum[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("7");
            }
        });
        botonesNum[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("8");
            }
        });
        botonesNum[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("9");
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
