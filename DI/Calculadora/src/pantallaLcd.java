import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class pantallaLcd extends JPanel {

    private String digitos;
    private JTextArea lcdArea;

    public pantallaLcd() {
        /* JPanel pantalla = new JPanel(); */
        setLayout(new FlowLayout());
        setBorder( new EmptyBorder(12, 12, 12, 12));
        lcdArea = new JTextArea(1, 18);
        lcdArea.setBackground(Color.BLACK);
        lcdArea.setForeground(Color.WHITE);
        lcdArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        lcdArea.setLineWrap(true);
        lcdArea.setWrapStyleWord(false);
        lcdArea.setFocusable(false);
        add(lcdArea);

        /*
         * JTextField lcdDisplay = new JTextField("0.", 18);
         * lcdDisplay.setHorizontalAlignment(JTextField.RIGHT);
         * lcdDisplay.setBackground(Color.BLACK);
         * lcdDisplay.setForeground(Color.WHITE);
         * lcdDisplay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
         * lcdDisplay.setFocusable(false);
         * add(pantalla);
         */

    }

    public String getDigito(String digito) {
        lcdArea.append(digito);
        return lcdArea.getText();
    }

    public void setDigito(String lcd) {
        lcdArea.append(lcd);
    }

    public void clearPantalla(String lcd) {
        this.digitos = "";
        lcdArea.setText("");
    }
    

}
