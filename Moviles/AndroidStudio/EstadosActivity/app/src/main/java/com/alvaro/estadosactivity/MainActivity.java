package com.alvaro.estadosactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Log.d(TAG, "onSCreate: La actividad acaba de crearse.");
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: La actividad va a hacerse visible.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: La actividad ha pasado a primer plano (ahora es interactiva).");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Otra actividad ocupa el primer plano (a punto de detenerse o dejar de ser visible).");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: La actividad ya no es visible para el usuario.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: La actividad vuelve a ser reiniciada tras de haber sido detenida.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: La actividad está siendo destruida.");
    }
}