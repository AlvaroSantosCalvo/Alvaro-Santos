import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        JFrame ventana = new JFrame();
        ventana.setSize(640,480);
        ventana.setLayout(new BorderLayout());

        //Creamos el panel central, el JLabel y la imagen de fondo
        JPanel panelCentral = new JPanel();
        JLabel startGame = new JLabel("START GAME");
        //Establece la posición del texto en el centro de la etiqueta
        startGame.setHorizontalTextPosition(0);
        //Establece el color del texto
        startGame.setForeground(Color.YELLOW);
        //Establece el tipo de fuente y el tamaño
        startGame.setFont(new Font("Arial", Font.BOLD, 32));
        ImageIcon fondoMario = new ImageIcon("mario.jpg");
        startGame.setIcon(fondoMario);
        startGame.setSize(275,183);
        panelCentral.add(startGame);

        //Creamos objetos de la clase Gamepad
        Gamepad padLeft = new Gamepad();
        Gamepad padRight = new Gamepad();
        
        //Añadimos el panel central y los paneles de Gamepad al BorderLayout
        ventana.add(panelCentral, BorderLayout.CENTER);
        ventana.add(padLeft, BorderLayout.WEST);
        ventana.add(padRight, BorderLayout.EAST);

        //Hacemos visible la ventana
        ventana.setVisible(true);
    }
}
