import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
    public static void main(String[] args) throws Exception {

        // AWT--------------------------------------------------------------
        // Crear ventana 
        Frame windowAWT = new Frame("Ventana de prueba AWT");
        
        /* // Cerrar ventana
        windowAWT.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                windowAWT.dispose();
                System.exit(0);
            }
        });
        // Tamaño de la ventana
        windowAWT.setSize(400, 300);
        
        // Activar la visibilidad
        windowAWT.setVisible(true);
        
        // Mensaje por consola
        System.out.println("Hello, AWT!");
        
        // Crear contenedor
        Panel panelAWT = new Panel();
        
        // Crear componente botón
        Button btnAWT = new Button("Botón AWT");

        // Asignar componente a contenedor
        panelAWT.add(btnAWT);

        // Asignar contenedor a ventana
        windowAWT.add(panelAWT); */


        //SWING--------------------------------------------------------------
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


    }
}
