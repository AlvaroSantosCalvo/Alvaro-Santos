import java.awt.*;
import javax.swing.*;


public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        JFrame ventana = new JFrame();
        ventana.setSize(640,480);
        ventana.setLayout(new BorderLayout());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Lrpad padR = new Lrpad();
        ventana.add(padR, BorderLayout.EAST);

        Lrpad padL = new Lrpad();
        ventana.add(padL, BorderLayout.WEST);

        Tdpad padD = new Tdpad();
        ventana.add(padD, BorderLayout.SOUTH);

        Pantalla pantallaE = new Pantalla();
        pantallaE.setTexto("XOIIIASWD");
        ventana.add(pantallaE, BorderLayout.CENTER);
        padL.getPantalla(pantallaE);
        padR.getPantalla(pantallaE);
        padD.getPantalla(pantallaE);
        


       

        ventana.setVisible(true);
    }
}
