package imagenes;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class panelGrafico extends JPanel {

    public panelGrafico() {
        this.setSize(400,800);
        this.setLayout(new GridBagLayout());
    }

    public void paintComponent (Graphics g) {
        Dimension dimensiones = getSize();
        ImageIcon imagenFondo = new ImageIcon("C:\\Users\\Profesor\\jorgemassa\\interfaces\\interfazimg\\interfazimg\\src\\imagenes\\bubblesBackground.jpg");
        g.drawImage(imagenFondo.getImage(), 0, 0, dimensiones.width, dimensiones.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
}
