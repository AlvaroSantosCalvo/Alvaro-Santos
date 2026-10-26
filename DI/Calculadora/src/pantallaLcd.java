import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pantallaLcd extends JPanel {

    private String numerosOP;

    public pantallaLcd() {
        JPanel pantalla = new JPanel();
        pantalla.setLayout(new FlowLayout());
        pantalla.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        
        JTextField lcdDisplay = new JTextField("0.", 18);
        lcdDisplay.setHorizontalAlignment(JTextField.RIGHT);
        lcdDisplay.setBackground(Color.BLACK);
        lcdDisplay.setForeground(Color.WHITE);
        lcdDisplay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        lcdDisplay.setFocusable(false);

        JComboBox<String> modCalc = new JComboBox<String>();
        modCalc.addItem("Estándar"); 
        modCalc.addItem("Científica");

        pantalla.add(modCalc);
        pantalla.add(lcdDisplay);
        add(pantalla);

        modCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (modCalc.getSelectedItem() == "Científica") {
                    tecladoOperadores tecladoOperadores = new tecladoOperadores();
                    tecladoOperadores.setVisible(false);
                } else {
                    tecladoOperadores tecladoOperadores2 = new tecladoOperadores();
                    tecladoOperadores2.setVisible(true);
                }
            }
        });
    }
}
