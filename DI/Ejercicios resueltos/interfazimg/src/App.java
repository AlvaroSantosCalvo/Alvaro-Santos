
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import imagenes.panelGrafico;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Prueba imágenes!");
        JFrame ventana = new JFrame("Mi Iphone");
        ventana.setSize(400, 800);
        panelGrafico panelG = new panelGrafico();
        ventana.add(panelG);
        
        GridBagConstraints ajustesRejilla = new GridBagConstraints();
        //ajustesRejilla.gridwidth = 4;
        ajustesRejilla.weightx = 0.25;
        ajustesRejilla.weighty = 0.0;

        //Botón aplicaciones
        JButton aplicaciones = new JButton();
        aplicaciones.setSize(96, 96);
        aplicaciones.setBorderPainted(false);
        aplicaciones.setContentAreaFilled(false);
        aplicaciones.setFocusPainted(false);
        ImageIcon imagenApp = new ImageIcon("C:\\Users\\Profesor\\jorgemassa\\interfaces\\interfazimg\\interfazimg\\src\\imagenes\\ajustes.png");
        Image imagenAppRes = imagenApp.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon imagenAppFin = new ImageIcon(imagenAppRes);        
        aplicaciones.setIcon(imagenAppFin);
        ajustesRejilla.gridx = 0;
        ajustesRejilla.gridy = 0;
        panelG.add(aplicaciones, ajustesRejilla);

        //Botón calculadora
        JButton calculadora = new JButton();
        calculadora.setSize(96, 96);
        calculadora.setBorderPainted(false);
        calculadora.setContentAreaFilled(false);
        calculadora.setFocusPainted(false);
        ImageIcon imagenCal = new ImageIcon("C:\\Users\\Profesor\\jorgemassa\\interfaces\\interfazimg\\interfazimg\\src\\imagenes\\calculadora.png");
        Image imagenCalRes = imagenCal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon imagenCalFin = new ImageIcon(imagenCalRes);
        calculadora.setIcon(imagenCalFin);
        ajustesRejilla.gridx = 1;
        ajustesRejilla.gridy = 0;
        panelG.add(calculadora, ajustesRejilla);

        //Botón calendario
        JButton calendario = new JButton();
        calendario.setBorderPainted(false);
        calendario.setContentAreaFilled(false);
        calendario.setFocusPainted(false);

        ImageIcon imagenCa = new ImageIcon("C:\\Users\\Profesor\\jorgemassa\\interfaces\\interfazimg\\interfazimg\\src\\imagenes\\calendario.png");
        Image imagenCaRes = imagenCa.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon imagenCaFin = new ImageIcon(imagenCaRes);
        calendario.setIcon(imagenCaFin);
        ajustesRejilla.gridx = 2;
        ajustesRejilla.gridy = 0;
        panelG.add(calendario, ajustesRejilla);

        //Botón camara
        JButton camara = new JButton();
        ImageIcon imagenCam = new ImageIcon("src/imagenes/ajustes.png");
        camara.setIcon(imagenCam);
        ajustesRejilla.gridx = 3;
        ajustesRejilla.gridy = 0;
        panelG.add(camara, ajustesRejilla);

        //Botón musica
        JButton musica = new JButton();
        musica.setBorderPainted(false);
        musica.setContentAreaFilled(false);
        musica.setFocusPainted(false);
        ImageIcon imagenMus = new ImageIcon("src/imagenes/ajustes.png");
        Image imagenMusRes = imagenMus.getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH);
        ImageIcon imagenMusFin = new ImageIcon(imagenMusRes);
        musica.setIcon(imagenMusFin);
        ajustesRejilla.gridx = 0;
        ajustesRejilla.gridy = 1;
        panelG.add(musica, ajustesRejilla);

        //Botón telefono
        JButton telefono = new JButton();
        telefono.setBorderPainted(false);
        telefono.setContentAreaFilled(false);
        telefono.setFocusPainted(false);
        ImageIcon imagenTel = new ImageIcon("src/imagenes/ajustes.png");
        Image imagenTelRes = imagenTel.getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH);
        ImageIcon imagenTelFin = new ImageIcon(imagenTelRes);
        telefono.setIcon(imagenTelFin);
        ajustesRejilla.gridx = 1;
        ajustesRejilla.gridy = 1;
        panelG.add(telefono, ajustesRejilla);

        //Botón correo
        JButton correo = new JButton();
        ImageIcon imagenCor = new ImageIcon("src/imagenes/ajustes.png");
        correo.setIcon(imagenCor);
        ajustesRejilla.gridx = 2;
        ajustesRejilla.gridy = 1;
        panelG.add(correo, ajustesRejilla);

        //Botón ajustes
        JButton ajustes = new JButton();
        ImageIcon imagenAju = new ImageIcon("src/imagenes/ajustes.png");
        ajustes.setIcon(imagenAju);
        ajustesRejilla.gridx = 3;
        ajustesRejilla.gridy = 1;
        panelG.add(ajustes, ajustesRejilla);

        //JLabel iconoApp = new JLabel("Aplicaciones");
        //iconoApp.setSize(32, 32);
        //ImageIcon imagen = new ImageIcon(App.class.getResource("/imagenes/ajustes.png"));
        //iconoApp.setIcon(imagen);
        //ventana.add(iconoApp);
        ventana.setVisible(true);

        //Action Listener para sacar una ventana modal con un mensaje
         aplicaciones.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null,"¿Deseas abrir la aplicación?", "Aviso", JOptionPane.YES_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Has pulsado Sí.");
                }
            }
        });


    }

}
