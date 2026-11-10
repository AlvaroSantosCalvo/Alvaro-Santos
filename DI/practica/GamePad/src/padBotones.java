import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class padBotones extends JPanel {
    private JButton triangulo;
    private JButton cuadrado;
    private JButton circulo;
    private JButton cruz;

    public padBotones() throws Exception {
        // Creamos los botones
        triangulo = new JButton();
        cuadrado = new JButton();
        circulo = new JButton();
        cruz = new JButton();

        // Cargamos las imágenes para los botones y las redimensionamos
        ImageIcon trianguloIcon = new ImageIcon("images\\triangleButton.png");
        Image trianguloResize = trianguloIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        triangulo.setIcon(new ImageIcon(trianguloResize));
        // ImageIcon trianguloIconFin = new ImageIcon(trianguloResize);

        ImageIcon cuadradoIcon = new ImageIcon("images\\squareButton.png");
        Image cuadradoResize = cuadradoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        cuadrado.setIcon(new ImageIcon(cuadradoResize));

        ImageIcon circuloIcon = new ImageIcon("images\\circleButton.png");
        Image circuloResize = circuloIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        circulo.setIcon(new ImageIcon(circuloResize));

        ImageIcon cruzIcon = new ImageIcon("images\\crossButton.png");
        Image cruzResize = cruzIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        cruz.setIcon(new ImageIcon(cruzResize));
    }
}
