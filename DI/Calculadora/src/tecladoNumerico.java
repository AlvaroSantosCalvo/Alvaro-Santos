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

    public tecladoNumerico() {
        setLayout(new GridLayout(4, 3, 10, 10));
        setBorder(new EmptyBorder(0, 10, 0, 5));
        for (int c = 1; c <= 9; c++) {
            String caracter = c + "";
            char tecla = (char) (c + '0');
            JButton boton = new JButton(caracter);
            add(boton);
            setBinding(tecla, boton);
            boton.setBackground(Color.LIGHT_GRAY);
            boton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            boton.setFocusPainted(true);// false
        }
        // Añadimos botones "0", "." y "+/-" y los asociamos a la tecla correspondiente
        boton0 = new JButton("0");
        add(boton0);
        char tecla = '0';
        setBinding(tecla, boton0);

        JButton botonP = new JButton(".");
        add(botonP);
        char teclaP = '.';
        setBinding(teclaP, botonP);

        JButton botonCS = new JButton("+/-");
        add(botonCS);
        char teclaCS = 'ç';
        setBinding(teclaCS, botonCS);

        boton0.setBackground(Color.LIGHT_GRAY);
        botonP.setBackground(Color.LIGHT_GRAY);
        botonCS.setBackground(Color.LIGHT_GRAY);
        boton0.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonP.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonCS.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        /* for (int i = 0; i < getComponentCount(); i++) {
            JButton boton = (JButton) getComponent(i);
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    boton.setBackground(Color.CYAN);
                }
            });
        } */
    }

    public void getPantalla(pantallaLcd displayPantalla) {
        boton0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPantalla.setDigito("0");
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

    /*
     * private void setBindings(char tecla, JButton boton) {
     * String nombreAccion = String.valueOf(tecla);
     * mapaEntrada.put(KeyStroke.getKeyStroke(tecla), nombreAccion);
     * mapaAcciones.put(nombreAccion, new AbstractAction() {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * boton.doClick();
     * }
     * });
     * }
     */
}
