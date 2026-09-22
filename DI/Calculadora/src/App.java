import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Interfaz calculadora");

        // Creamos ventana aplicación con distribución BorderLayout
        JFrame ventana = new JFrame("Calculadora simple");
        ventana.setLayout(new BorderLayout());
        ventana.setSize(400, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos los paneles para la calculadora
        JPanel pantalla = new JPanel();
        pantalla.setLayout(new FlowLayout());

        JPanel tecladoNum = new JPanel();
        tecladoNum.setLayout(new GridLayout(4, 3, 10, 10));

        JPanel operadores = new JPanel();
        operadores.setLayout(new GridLayout(5, 1, 10, 10));
        operadores.setBackground(Color.LIGHT_GRAY);
        operadores.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        operadores.setPreferredSize(new java.awt.Dimension(100, 100));

        ventana.add(pantalla, BorderLayout.NORTH);
        ventana.add(tecladoNum, BorderLayout.CENTER);
        ventana.add(operadores, BorderLayout.EAST);

        // Creamos componentes para el panel pantalla
        JTextField lcdDisplay = new JTextField("0", 20);
        /* lcdDisplay.setColumns(20); */
        lcdDisplay.setBackground(Color.BLACK);
        lcdDisplay.setForeground(Color.GREEN);
        lcdDisplay.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
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
            botonIgual.setBackground(Color.BLUE);
            botonIgual.setForeground(Color.WHITE);

        operadores.add(botonDivision);
        operadores.add(botonMultiplicacion);
        operadores.add(botonResta);
        operadores.add(botonSuma);
        operadores.add(botonIgual);

        ventana.setVisible(true);
    }
}
