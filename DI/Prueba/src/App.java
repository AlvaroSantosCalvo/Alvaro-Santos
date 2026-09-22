import javax.swing.*;
import java.awt.*;
/* import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; */

public class App {
    public static void main(String[] args) throws Exception {

        // AWT--------------------------------------------------------------
        /*
         * // Crear ventana
         * Frame windowAWT = new Frame("Ventana de prueba AWT");
         * 
         * // Cerrar ventana
         * windowAWT.addWindowListener(new WindowAdapter() {
         * 
         * @Override
         * public void windowClosing(WindowEvent event) {
         * windowAWT.dispose();
         * System.exit(0);
         * }
         * });
         * // Tamaño de la ventana
         * windowAWT.setSize(400, 300);
         * 
         * // Activar la visibilidad
         * windowAWT.setVisible(true);
         * 
         * // Mensaje por consola
         * System.out.println("Hello, AWT!");
         * 
         * // Crear contenedor
         * Panel panelAWT = new Panel();
         * 
         * // Crear componente botón
         * Button btnAWT = new Button("Botón AWT");
         * 
         * // Asignar componente a contenedor
         * panelAWT.add(btnAWT);
         * 
         * // Asignar contenedor a ventana
         * windowAWT.add(panelAWT);
         */

        // SWING--------------------------------------------------------------
        // Crear ventana
        JFrame windowSWING = new JFrame("Ventana de prueba Swing");

        // Cerrar ventana
        windowSWING.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tamaño de la ventana
        windowSWING.setSize(400, 300);

        // Activar la visibilidad
        windowSWING.setVisible(true);

        // Mensaje por consola
        System.out.println("Hello, SWING!");

        // Crear contenedor
        Panel panelSWING = new Panel();

        // Crear componente botón
        Button btnSWING = new Button("Botón SWING");

        // Asignar componente a contenedor
        panelSWING.add(btnSWING);

        // Asignar contenedor a ventana
        windowSWING.add(panelSWING);

        // Creación de una ventana con un contenedor aplicando una distribución concreta
        // Con SWING
        JFrame ventana = new JFrame("Ventana con Border Layout"); // Creamos la ventana
        ventana.setLayout(new BorderLayout()); // Asignamos la distribución a la ventana
        ventana.setSize(900, 600); // Definimos el tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definimos cerrar ventana
        // Creamos 5 paneles para cada una de las áreas
        JPanel norte = new JPanel();
        JPanel sur = new JPanel();
        JPanel centro = new JPanel();
        JPanel este = new JPanel();
        JPanel oeste = new JPanel();
        // Añadimos cada panel a su área de la distribución dentro de la ventana
        ventana.add(norte, BorderLayout.NORTH);
        ventana.add(sur, BorderLayout.SOUTH);
        ventana.add(centro, BorderLayout.CENTER);
        ventana.add(este, BorderLayout.EAST);
        ventana.add(oeste, BorderLayout.WEST);
        // Hacemos visible la ventana
        ventana.setVisible(true);
    }

}
