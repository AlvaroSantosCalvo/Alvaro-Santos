import java.awt.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {

        JFrame ventana = new JFrame();
        ventana.setSize(480,960);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelFondo panelGrafico = new PanelFondo();
        ventana.add(panelGrafico);
        //Imagen de fondo de la ventana
        
        

        




        //Botones e iconos de las aplicaciones
        ImageIcon icono01 = new ImageIcon("avogato.jpg");
        Image imagen = icono01.getImage();
        
        //Define el nuevo tamaño deseado
        int nuevoAncho = 100;
        int nuevoAlto = 100;

        // 4. Reescalar la imagen
        Image imagenEscalada = imagen.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_DEFAULT);

        // 5. Crea un nuevos ImageIcon con las imagen reescaladas
        ImageIcon iconoEscalado01 = new ImageIcon(imagenEscalada);
        //ImageIcon iconoEscalado02 = new ImageIcon(imagenEscalada);
        //ImageIcon iconoEscalado03 = new ImageIcon(imagenEscalada);
        //ImageIcon iconoEscalado04 = new ImageIcon(imagenEscalada);
        
        
        JButton app01 = new JButton(iconoEscalado01);
        //app01.setSize(100,100);
        //app01.setBounds(0,0,100,100);
        JButton app02 = new JButton(iconoEscalado01);
        JButton app03 = new JButton(iconoEscalado01);
        JButton app04 = new JButton(iconoEscalado01);
        //JButton app05 = new JButton(iconoEscalado01);
        //JButton app06 = new JButton(iconoEscalado01);
        //JButton app07 = new JButton(iconoEscalado01);
        //JButton app08 = new JButton(iconoEscalado01);
        //GridBagConstraints rejilla = new GridBagConstraints();
        //rejilla.gridwidth = 2;
        //rejilla.weightx = 1;
        //rejilla.weighty = 1;
         

        //Añadimos los botones a cada posición de la rejilla
        //rejilla.gridx = 0;
        //rejilla.gridy = 0;
        panelGrafico.add(app01);
        //rejilla.gridx = 2;
        //rejilla.gridy = 0;
        panelGrafico.add(app02);
        //rejilla.gridx = 0;
        //rejilla.gridy = 1;
        panelGrafico.add(app03);
        //rejilla.gridx = 2;
        //rejilla.gridy = 1;
        panelGrafico.add(app04);
        //rejilla.gridx = 0;
        //rejilla.gridy = 2;
        //ventana.add(app05, rejilla);
        //rejilla.gridx = 2;
        //rejilla.gridy = 2;
        //ventana.add(app06, rejilla);
        //rejilla.gridx = 0;
        //rejilla.gridy = 3;
        //ventana.add(app07, rejilla);
        //rejilla.gridx = 2;
        //rejilla.gridy = 3;
        //ventana.add(app08, rejilla);

        ventana.setVisible(true);
    }

}
