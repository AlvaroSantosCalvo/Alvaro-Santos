package com.alvaro.navegacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

		//Para recuperar parámetros
        String parametroString = getIntent().getStringExtra("nombre");
		//int parametroInt = getIntent().getIntExtra("nombre_parametro");

        TextView texto_second = findViewById(R.id.textoSecond);
        //texto_second.setText(parametroString);

        Button buttonBack = findViewById(R.id.btn_volver);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Finaliza la actividad actual y vuelve a la anterior
            }
        });
    }
}