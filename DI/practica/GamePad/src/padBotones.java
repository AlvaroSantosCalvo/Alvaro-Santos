import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class padBotones extends JPanel {
    public padBotones() {
        setLayout(new GridBagLayout());

        GridBagConstraints posicion = new GridBagConstraints();
        posicion.insets = new Insets(3, 3, 3, 3);

        agregarBoton("images\\triangleButton.png", 1, 0, posicion);
        agregarBoton("images\\squareButton.png", 0, 1, posicion);
        agregarBoton("images\\circleButton.png", 2, 1, posicion);
        agregarBoton("images\\crossButton.png", 1, 2, posicion);
    }

    private void agregarBoton(String rutaImagen, int columna, int fila, GridBagConstraints posicion) {
        ImageIcon icono = new ImageIcon(rutaImagen);
        if (icono.getIconWidth() < 0) {
            throw new IllegalStateException("No se pudo cargar la imagen: " + rutaImagen);
        }

        Image imagenRedimensionada = icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton boton = new JButton(new ImageIcon(imagenRedimensionada));
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setFocusable(false);

        posicion.gridx = columna;
        posicion.gridy = fila;
        add(boton, posicion);
    }
}
/* private JButton triangulo;
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
        cruz.setIcon(new ImageIcon(cruzResize)); */