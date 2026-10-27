import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Interfaz calculadora");

        // Creamos ventana aplicación con distribución BorderLayout
        // JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana = new JFrame("Calculadora simple");
        ventana.setLayout(new BorderLayout());
        ventana.setSize(600, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos un JPanel para colocar todos los componentes de la parte superior
        JPanel topFrame = new JPanel();
        topFrame.setLayout(new FlowLayout());

        // Creamos el menu desplegable para seleccionar el modo de la calculadora
        JComboBox<String> modCalc = new JComboBox<String>();
        modCalc.addItem("Estándar");
        modCalc.addItem("Científica");

        // Creamos los paneles para la calculadora
        pantallaLcd pantalla = new pantallaLcd();

        // Añadimos componentes al panel topFrame
        topFrame.add(modCalc);
        topFrame.add(pantalla);
        // add(pantalla);

        // Creamos un objeto del tipo teclado de numérico
        tecladoNumerico tecladoNumerico = new tecladoNumerico();
        tecladoNumerico.requestFocusInWindow();

        // Creamos un objeto del tipo teclado de operadores
        tecladoOperadores tecladoOperadores = new tecladoOperadores();
        tecladoOperadores.requestFocusInWindow();

        JPanel copyright = new JPanel();
        copyright.setLayout(new FlowLayout());
        copyright.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 25, 0));

        ventana.add(topFrame, BorderLayout.NORTH);
        ventana.add(tecladoNumerico, BorderLayout.CENTER);
        ventana.add(tecladoOperadores, BorderLayout.EAST);
        ventana.add(copyright, BorderLayout.SOUTH);

        // Para la selección de elementos del comboBox modCalc
        modCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (modCalc.getSelectedItem() == "Científica") {
                    tecladoOperadores.setVisible(false);
                } else {
                    tecladoOperadores.setVisible(true);
                }
            }
        });

        /*
         * // Creamos componentes para el panel pantalla
         * JTextField lcdDisplay = new JTextField("0.", 18);
         * lcdDisplay.setHorizontalAlignment(JTextField.RIGHT);
         * lcdDisplay.setPreferredSize(new Dimension(0, 70));
         * lcdDisplay.setBackground(Color.BLACK);
         * lcdDisplay.setForeground(Color.WHITE);
         * lcdDisplay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
         * 
         * lcdDisplay.setFocusable(false);
         */

        /*
         * JComboBox<String> modCalc = new JComboBox<String>();
         * modCalc.addItem("Estándar");
         * modCalc.addItem("Científica");
         */

        /*
         * // Añadimos componentes al panel pantalla
         * pantalla.add(modCalc);
         * pantalla.add(lcdDisplay);
         */

        // Creamos componentes para el panel copyright
        JTextField textoCopyright = new JTextField("Calculadora by DAM2");
        textoCopyright.setHorizontalAlignment(JTextField.CENTER);
        textoCopyright.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        textoCopyright.setEditable(false);
        textoCopyright.setBorder(null);
        copyright.add(textoCopyright);

        ventana.setVisible(true);

        tecladoNumerico.getPantalla(pantalla);

        /* // Para la selección de elementos del comboBox modCalc
        modCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (modCalc.getSelectedItem() == "Científica") {
                    tecladoOperadores.setVisible(false);
                } else {
                    tecladoOperadores.setVisible(true);
                }
            }
        }); */

    }
}
