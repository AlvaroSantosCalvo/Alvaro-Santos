import java.awt.*;
import javax.swing.*;

public class PanelFondo extends JPanel {
    private int celdax;
    private int celday;

    public PanelFondo() {
        this.setSize(480,960);
        this.setLayout(new GridBagLayout());
        GridBagConstraints rejilla = new GridBagConstraints();
        rejilla.gridwidth = 2;
        rejilla.weightx = 1;
        rejilla.weighty = 1;
        //Definimos la primera celda de la rejilla para añadir componentes;
        rejilla.gridx = this.celdax;
        rejilla.gridy = this.celday;
    }

    public void paintComponent (Graphics g) {
        Dimension tamanyo = getSize();
        ImageIcon imagenFondo = new ImageIcon("fondo-3000x2000.jpg");
        g.drawImage(imagenFondo.getImage(), 0, 0, tamanyo.width, tamanyo.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
