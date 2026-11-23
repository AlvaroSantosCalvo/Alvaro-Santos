import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
//import java.javax.xml.parsers;
import java.io.*;

import java.awt.BorderLayout;
import java.awt.Color;

public class App {
    public static void main(String[] args) throws Exception, IOException, ParserConfigurationException {

        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbfactory.newDocumentBuilder();

        // Fetch XML File
        Document document = builder.parse(new File("practica\\GamePad\\src\\datos.xml"));
        document.getDocumentElement().normalize();

        // Obtener el nodo raiz
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        // Obtener todos los jugadores
        NodeList nList = document.getElementsByTagName("jugador");
        System.out.println("---------------------------------");
        System.out.println(nList);

        JFrame ventana = new JFrame("Nintendo Game Pad");
        ventana.setLayout(new BorderLayout());
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titulo = new JPanel();
        JTextField nombre = new JTextField();
        nombre.setForeground(Color.RED);
        titulo.add(nombre);

        padBotones padIzq = new padBotones();
        pantalla pantallaJuego = new pantalla();
        padBotones padDer = new padBotones();
        controlBotones botonesCtl = new controlBotones();

        ventana.add(titulo, BorderLayout.NORTH);
        ventana.add(padIzq, BorderLayout.WEST);
        ventana.add(pantallaJuego, BorderLayout.CENTER);
        ventana.add(padDer, BorderLayout.EAST);
        ventana.add(botonesCtl, BorderLayout.SOUTH);

        ventana.setVisible(true);

    }
}
