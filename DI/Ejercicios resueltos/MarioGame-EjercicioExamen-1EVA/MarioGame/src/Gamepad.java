import javax.swing.*;
import java.awt.*;

public class Gamepad extends JPanel {
    public Gamepad() {
        setLayout(new GridLayout(4,1));
        JButton botonX = new JButton("X");
        JButton botonO = new JButton("O");
        JButton botonY = new JButton("Y");
        JButton botonP = new JButton("P");
        add(botonX);
        add(botonO);
        add(botonY);
        add(botonP);
    }

}
