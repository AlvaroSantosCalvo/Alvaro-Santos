package Moviles.AndroidStudio.Calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        textResultado = findViewById(R.id.texto);
        textResultado.setText("0");

    }

    public void reset (View boton) {
        Button btn_reset = (Button) boton;
        textResultado.setText("0");
    }

    public void numero (View boton) {
        Button btn_numero = (Button) boton;

        if (textResultado.getText().equals("0")) {
            textResultado.setText("");
        }

        //if length es mayor que x, que no lo añada
        textResultado.setText(textResultado.getText() + btn_numero.getText().toString());
    }
}


















