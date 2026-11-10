package com.alvaro.navegacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText texto_main = findViewById(R.id.textoMain);

        Button buttonNavigate = findViewById(R.id.btn_enviar);
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent para navegar a SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //para pasar parámetros
                intent.putExtra("nombre", texto_main.getText());

                startActivity(intent);
            }
        });
    }
}