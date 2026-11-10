package com.example.calculadora;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textResultado;
    TextView caja2; // Este se refiere a la caja pequeña de arriba
    int valorAnterior;
    boolean pulsadoSumar;
    boolean pulsadoRestar;
    boolean sumaActiva=false;
    boolean restaActiva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        textResultado = findViewById(R.id.texto);
        textResultado.setText("0");

        caja2 = findViewById(R.id.texto2);
        valorAnterior = 0;
        pulsadoSumar = false;
        pulsadoRestar = false;

    }

    public void sumar (View boton) {
        caja2.setText(textResultado.getText() + " + ");
        valorAnterior = Integer.parseInt(textResultado.getText().toString());
        pulsadoSumar = true;

    }

    public void restar (View boton) {
        caja2.setText(textResultado.getText() + " - ");
        valorAnterior = Integer.parseInt(textResultado.getText().toString());
        pulsadoRestar = true;

    }

    public void resultado (View boton) {
        caja2.setText(caja2.getText().toString() + textResultado.getText().toString() + " = ");
        if (sumaActiva) {
            textResultado.setText(Integer.toString(valorAnterior + Integer.parseInt(textResultado.getText().toString())));
            sumaActiva=false;
        }
        if (restaActiva){
            textResultado.setText(Integer.toString(valorAnterior - Integer.parseInt(textResultado.getText().toString())));
            restaActiva=false;
        }
//        if (caja2.getText().toString().contains("=")) {
//            textResultado.setText("hola");
//        }
    }

    public void reset (View boton) {

        textResultado.setText("0");
        caja2.setText("");
        valorAnterior = 0;
        pulsadoSumar = false;
    }

    public void numero (View boton) {
        Button btn_numero = (Button) boton;
        if (pulsadoSumar == true) {
            textResultado.setText("");
            pulsadoSumar=false;
            sumaActiva=true;

        }
        if (pulsadoRestar == true) {
            textResultado.setText("");
            pulsadoRestar=false;
            restaActiva=true;
        }
        if (textResultado.getText().equals("0")) {
            textResultado.setText("");
        }

        //if length es mayor que x, que no lo añada
        if (textResultado.length()<6){
            textResultado.setText(textResultado.getText() + btn_numero.getText().toString());
        }
    }
}

