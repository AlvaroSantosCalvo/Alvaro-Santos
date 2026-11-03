import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {
    public static void main(String[] args) throws Exception {
                System.out.println("Prueba imágenes!");

                JFrame ventana = new JFrame();
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana.setSize(400, 800);

                JLabel iconoApp = new JLabel("Aplicaciones");
                iconoApp.setSize(64, 64); //no funciona
                //iconoApp.setIcon(new ImageIcon(App.class.getResource("/images/ic-app.png")));
                ImageIcon imagen = new ImageIcon(App.class.getResource("/images/ic-app.png"));
                iconoApp.setIcon(imagen);

                ventana.add(iconoApp);
                ventana.setVisible(true);
    }
}
