import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Interfaz calculadora");

        JFrame ventana = new JFrame("Calculadora simple");
        ventana.setLayout(new BorderLayout());
        ventana.setSize(600, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // La ventana se divide en pantalla, teclado y pie.
        JPanel pantalla = new JPanel(new BorderLayout());
        pantalla.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JPanel teclado = new JPanel(new BorderLayout());
        JPanel tecladoNum = new JPanel(new GridLayout(4, 3));

        JPanel operadores = new JPanel(new GridLayout(5, 1, 0, 10));
        operadores.setBorder(javax.swing.BorderFactory.createEmptyBorder(35, 10, 30, 15));
        operadores.setPreferredSize(new Dimension(110, 0));

        JPanel copyright = new JPanel(new BorderLayout());
        copyright.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 25, 0));

        ventana.add(pantalla, BorderLayout.NORTH);
        teclado.add(tecladoNum, BorderLayout.CENTER);
        teclado.add(operadores, BorderLayout.EAST);
        ventana.add(teclado, BorderLayout.CENTER);
        ventana.add(copyright, BorderLayout.SOUTH);

        JTextField lcdDisplay = new JTextField("0.");
        lcdDisplay.setHorizontalAlignment(JTextField.RIGHT);
        lcdDisplay.setPreferredSize(new Dimension(0, 70));
        lcdDisplay.setBackground(Color.BLACK);
        lcdDisplay.setForeground(Color.WHITE);
        lcdDisplay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
        lcdDisplay.setCaretColor(Color.WHITE);
        pantalla.add(lcdDisplay, BorderLayout.CENTER);

        JButton boton1 = new JButton("1");
        JButton boton2 = new JButton("2");
        JButton boton3 = new JButton("3");
        JButton boton4 = new JButton("4");
        JButton boton5 = new JButton("5");
        JButton boton6 = new JButton("6");
        JButton boton7 = new JButton("7");
        JButton boton8 = new JButton("8");
        JButton boton9 = new JButton("9");
        JButton boton0 = new JButton("0");
        JButton botonPunto = new JButton(".");
        tecladoNum.add(boton1);
        tecladoNum.add(boton2);
        tecladoNum.add(boton3);
        tecladoNum.add(boton4);
        tecladoNum.add(boton5);
        tecladoNum.add(boton6);
        tecladoNum.add(boton7);
        tecladoNum.add(boton8);
        tecladoNum.add(boton9);
        tecladoNum.add(boton0);
        tecladoNum.add(botonPunto);
        tecladoNum.add(new JPanel());

        JButton botonSuma = new JButton("+");
        JButton botonResta = new JButton("-");
        JButton botonMultiplicacion = new JButton("X");
        JButton botonDivision = new JButton("/");
        JButton botonIgual = new JButton("=");
        Color amarillo = new Color(255, 190, 0);
        Color naranja = new Color(235, 120, 45);
        Color azul = new Color(70, 115, 190);
        JButton[] botonesNumericos = {
            boton1, boton2, boton3, boton4, boton5, boton6,
            boton7, boton8, boton9, boton0, botonPunto
        };
        for (JButton boton : botonesNumericos) {
            boton.setBackground(amarillo);
            boton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            boton.setFocusPainted(false);
        }

        operadores.add(botonSuma);
        operadores.add(botonResta);
        operadores.add(botonMultiplicacion);
        operadores.add(botonDivision);
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

        JTextField textoCopyright = new JTextField("Calculadora by DAM2");
        textoCopyright.setHorizontalAlignment(JTextField.CENTER);
        textoCopyright.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        textoCopyright.setEditable(false);
        textoCopyright.setBorder(null);
        ventana.setLocationRelativeTo(null);
        copyright.add(textoCopyright);

        ventana.setVisible(true);
    }
}
