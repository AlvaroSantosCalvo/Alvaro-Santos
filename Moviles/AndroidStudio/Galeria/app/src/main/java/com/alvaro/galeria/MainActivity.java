package com.alvaro.galeria;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView foto;
    private Button btnCargar;
    private Button btnGris;
    private Button btnOriginal;
    private Button btnSepia;
    private Button btnGuardar;
    private ActivityResultLauncher<String> seleccionadorFoto;
    private Bitmap imagenOriginal;
    private Bitmap imagenActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        foto = findViewById(R.id.miFoto);
        btnCargar = findViewById(R.id.btnCargar);
        btnGris = findViewById(R.id.bGris);
        btnOriginal = findViewById(R.id.bOriginal);
        btnSepia = findViewById(R.id.bSepia);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnCargar.setText(R.string.txtCarga);
        seleccionadorFoto = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        cargarImagen(uri); }
                });

        btnCargar.setOnClickListener(v -> {
            seleccionadorFoto.launch("image/*");
        });
        btnGuardar.setOnClickListener(v -> {
            if (imagenOriginal != null) {
                guardarImagen(imagenActual);
            }
        });

        btnOriginal.setOnClickListener(v -> {
            if (imagenOriginal != null) {
                imagenActual = imagenOriginal;
                foto.setImageBitmap(imagenActual);
            }
        });
        btnGris.setOnClickListener(v -> {
            if (imagenOriginal != null) {
                imagenActual = convertirGris(imagenOriginal);
                foto.setImageBitmap(imagenActual);
            }
        });
        btnSepia.setOnClickListener(v -> {
            if (imagenOriginal != null) {
                imagenActual = convertirSepia(imagenOriginal);
                foto.setImageBitmap(imagenActual);
            }
        });
    }

    private void guardarImagen(Bitmap bitmap) {
        ContentValues valores = new ContentValues();
        valores.put(
                MediaStore.Images.Media.DISPLAY_NAME,
                "foto_" + System.currentTimeMillis() + ".jpg"
        );
        valores.put(
                MediaStore.Images.Media.MIME_TYPE,
                "image/jpeg"
        );
        valores.put(
                MediaStore.Images.Media.RELATIVE_PATH,
                "Pictures/MiGaleria"
        );
        Uri uri = getContentResolver().insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                valores
        );
        try {
            OutputStream outputStream =
                    getContentResolver().openOutputStream(uri);
            bitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    100,
                    outputStream
            );
            outputStream.close();
            Toast.makeText(
                    this,
                    "Imagen guardada en la galería",
                    Toast.LENGTH_SHORT
            ).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void cargarImagen(Uri uri) {
        try {
            ImageDecoder.Source source =
                    ImageDecoder.createSource(
                            getContentResolver(),
                            uri
                    );

            imagenOriginal = ImageDecoder.decodeBitmap(source);
            foto.setImageBitmap(imagenOriginal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Bitmap convertirGris(Bitmap original) {
        Bitmap resultado = original.copy(Bitmap.Config.ARGB_8888, true);
        for (int x = 0; x < resultado.getWidth(); x++) {
            for (int y = 0; y < resultado.getHeight(); y++) {
                int pixel = resultado.getPixel(x, y);
                int rojo =
                        Color.red
                                (pixel);
                int verde =
                        Color.green
                                (pixel);
                int azul =
                        Color.blue
                                (pixel);

                int gris = (rojo + verde + azul) / 3;
                int nuevoColor = Color.rgb(gris, gris, gris);
                resultado.setPixel(x, y, nuevoColor);
            }
        }
        return resultado;
    }
    private Bitmap convertirSepia (Bitmap original) {
        Bitmap resultado = original.copy(Bitmap.Config.ARGB_8888, true);
        for (int x = 0; x < resultado.getWidth(); x++) {
            for (int y = 0; y < resultado.getHeight(); y++) {
                int pixel = resultado.getPixel(x, y);
                int rojo =
                        Color.red
                                (pixel);
                int verde =
                        Color.green
                                (pixel);
                int azul =
                        Color.blue
                                (pixel);

                int gris = (rojo + verde + azul) / 3;
                int nuevoRojo = Math.min(gris + 40, 255);
                int nuevoVerde = Math.min(gris + 20, 255);
                int nuevoAzul = Math.max(gris - 20, 0);
                int nuevoColor =
                        Color.rgb(nuevoRojo, nuevoVerde, nuevoAzul);
                resultado.setPixel(x, y, nuevoColor);
            }
        }
        return resultado;
    }

}