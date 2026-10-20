import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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

    public tecladoNumerico() {
        setLayout(new GridLayout(4,3,10,10));
        setBorder(new EmptyBorder(0,10,0,5));
        for(int c=1; c<=9; c++) {
            String caracter = c + "";
            char tecla = (char) (c + '0');
            JButton boton = new JButton(caracter);
            add(boton);
            setBinding(tecla, boton);
        }
    }

    private void setBinding(char c, JButton boton) {
        KeyStroke teclaPres = KeyStroke.getKeyStroke(Character.toLowerCase(c));
        mapaEntrada.put(teclaPres, teclaPres.toString());
        mapaAcciones.put(teclaPres.toString(), new AbstractAction() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                boton.doClick();
            }
        });
    }



    /* private void setBindings(char tecla, JButton boton) {
        String nombreAccion = String.valueOf(tecla);
        mapaEntrada.put(KeyStroke.getKeyStroke(tecla), nombreAccion);
        mapaAcciones.put(nombreAccion, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton.doClick();
            }
        });
    } */
}
