import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//Libreeias para  lectura/escritura de XML
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class App {
    public static void main(String[] args) throws Exception, IOException, ParserConfigurationException, SAXException {

        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbfactory.newDocumentBuilder();

        // Fetch XML File
        Document document = builder.parse(new File("src\\puntuaciones.xml"));
        document.getDocumentElement().normalize();

        // Obtener el nodo raiz
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName() + "\n");
        // Obtener todos los jugadores
        NodeList nList = document.getElementsByTagName("jugador");
        //System.out.println(nList);
        //Chat-->
        for (int i = 0; i < nList.getLength(); i++) {
            Element jugador = (Element) nList.item(i);
            var nombre = jugador.getElementsByTagName("nombre").item(0).getTextContent();
            var puntos = jugador.getElementsByTagName("puntos").item(0).getTextContent();
            System.out.println("Jugador: " + nombre + " - Puntos: " + puntos + "\n");
            //System.out.println(jugador.getTextContent());
        }//<--

        JFrame ventana = new JFrame("Nintendo Game Pad");
        ventana.setLayout(new BorderLayout());
        ventana.setSize(1450, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titulo = new JPanel();
        JLabel nombre = new JLabel("SUPER MARIO");
        nombre.setForeground(Color.RED);
        nombre.setFont(new Font("Arial", Font.BOLD, 32));
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
