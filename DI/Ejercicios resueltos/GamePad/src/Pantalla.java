import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Pantalla extends JPanel{
    private String texto;
    private JTextArea pantallaEd;

    public Pantalla() {
        pantallaEd = new JTextArea(48,75);
        add(pantallaEd);
    }

    public void setTexto (String textEd) {
        pantallaEd.append(textEd);
    }
    public String getTexto () {
        return this.texto;
    }
}
