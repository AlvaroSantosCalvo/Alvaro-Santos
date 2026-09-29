import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Interfaz calculadora");

        // Creamos ventana aplicación con distribución BorderLayout
        JFrame ventana = new JFrame("Calculadora simple");       
        ventana.setLayout(new BorderLayout());
        ventana.setSize(600, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos los paneles para la calculadora
        JPanel pantalla = new JPanel();
        pantalla.setLayout(new FlowLayout());
        pantalla.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JPanel tecladoNum = new JPanel();
        tecladoNum.setLayout(new GridLayout(4, 3, 10, 10));

        JPanel operadores = new JPanel();
        operadores.setLayout(new GridLayout(5, 1, 0, 10));
        operadores.setBackground(Color.LIGHT_GRAY);
        operadores.setBorder(javax.swing.BorderFactory.createEmptyBorder(35, 10, 30, 15));
        operadores.setPreferredSize(new java.awt.Dimension(110, 0));

        JPanel copyright = new JPanel();
        copyright.setLayout(new FlowLayout());
        copyright.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 25, 0));

        ventana.add(pantalla, BorderLayout.NORTH);
        ventana.add(tecladoNum, BorderLayout.CENTER);
        ventana.add(operadores, BorderLayout.EAST);
        ventana.add(copyright, BorderLayout.SOUTH);

        // Creamos componentes para el panel pantalla
        JTextField lcdDisplay = new JTextField("0.", 18);
        lcdDisplay.setHorizontalAlignment(JTextField.RIGHT);
        lcdDisplay.setPreferredSize(new Dimension(0, 70));
        lcdDisplay.setBackground(Color.BLACK);
        lcdDisplay.setForeground(Color.WHITE);
        lcdDisplay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));

        JComboBox<String> modCalc = new JComboBox<String>();
        modCalc.addItem("Estándar"); 
        modCalc.addItem("Científica");

        // Añadimos componentes al panel pantalla
        pantalla.add(modCalc);
        pantalla.add(lcdDisplay);


        // Creamos componentes para el panel teclado numérico
        JButton boton1 = new JButton("1");
        JButton boton2 = new JButton("2");
        JButton boton3 = new JButton("3");
        JButton boton4 = new JButton("4");
        JButton boton5 = new JButton("5");
        JButton boton6 = new JButton("6");
        JButton boton7 = new JButton("7");
        JButton boton8 = new JButton("8");
        JButton boton9 = new JButton("9");
        JButton botonClear = new JButton("C");
        JButton boton0 = new JButton("0");
        JButton botonPunto = new JButton(".");
        tecladoNum.add(boton7);
        tecladoNum.add(boton8);
        tecladoNum.add(boton9);
        tecladoNum.add(boton4);
        tecladoNum.add(boton5);
        tecladoNum.add(boton6);
        tecladoNum.add(boton1);
        tecladoNum.add(boton2);
        tecladoNum.add(boton3);
        tecladoNum.add(botonClear);
        tecladoNum.add(boton0);
        tecladoNum.add(botonPunto);

        // Creamos componentes para el panel operadores
        JButton botonSuma = new JButton("+");
        JButton botonResta = new JButton("-");
        JButton botonMultiplicacion = new JButton("*");
        JButton botonDivision = new JButton("/");
        JButton botonIgual = new JButton("=");
        Color blanco = new Color(255, 255, 255);
        Color azul = new Color(107, 220, 255);
        Color naranja = new Color(255, 180, 38);
        Color rojo = new Color(217, 43, 43);
        JButton[] botonesNumericos = {
                boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton0, botonPunto
        };
        for (JButton boton : botonesNumericos) {
            boton.setBackground(blanco);
            boton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            boton.setFocusPainted(false);
        }
        botonClear.setBackground(rojo);
        botonClear.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonClear.setFocusPainted(false);
        botonClear.setForeground(Color.WHITE);


        operadores.add(botonDivision);
        operadores.add(botonMultiplicacion);
        operadores.add(botonResta);
        operadores.add(botonSuma);
        operadores.add(botonIgual);
        JButton[] botonesOperadores = { botonSuma, botonResta, botonMultiplicacion, botonDivision };
        for (JButton boton : botonesOperadores) {
            boton.setBackground(naranja);
            boton.setForeground(Color.WHITE);
            boton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            boton.setFocusPainted(false);
        }
        botonIgual.setBackground(azul);
        botonIgual.setForeground(Color.WHITE);
        botonIgual.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        botonIgual.setFocusPainted(false);

        // Creamos componentes para el panel copyright
        JTextField textoCopyright = new JTextField("Calculadora by DAM2");
        textoCopyright.setHorizontalAlignment(JTextField.CENTER);
        textoCopyright.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        textoCopyright.setEditable(false);
        textoCopyright.setBorder(null);
        copyright.add(textoCopyright);

        ventana.setVisible(true);

        // Creamos listeners para detectar eventos
        for (JButton boton : botonesNumericos) {
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    boton.setBackground(Color.CYAN);
                }
            });
        }

        // Para la selección de elementos del comboBox modCalc
        modCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (modCalc.getSelectedItem() == "Científica") {
                    operadores.setVisible(false);
                } else {
                    operadores.setVisible(true);
                }
            }
        });

        // Para detectar que se ha pulsado la tecla M para cambio de modo de la calculadora
        /* String tecla = "m";
        tecla.addKeyListener(new KeyListener() {
           public void keyPressed(KeyEvent e){
            operadores.setVisible(false);
           } 
        }); */

    }
}
