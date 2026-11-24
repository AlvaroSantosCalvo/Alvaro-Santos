import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class pantalla extends JPanel {
    private MediaPlayer reproductor;

    public pantalla() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JFXPanel panelJavaFX = new JFXPanel();
        add(panelJavaFX, BorderLayout.CENTER);

        Platform.runLater(() -> {
            File archivoVideo = new File("images", "mario_compatible.mp4");
            if (!archivoVideo.isFile()) {
                throw new IllegalStateException("No se encuentra el video: " + archivoVideo.getAbsolutePath());
            }

            Media video = new Media(archivoVideo.toURI().toString());
            video.setOnError(() -> System.err.println("Error al cargar el video: " + video.getError()));

            reproductor = new MediaPlayer(video);
            reproductor.setOnError(() -> System.err.println("Error al reproducir el video: " + reproductor.getError()));

            MediaView vista = new MediaView(reproductor);
            vista.setPreserveRatio(true);

            StackPane contenedor = new StackPane(vista);
            contenedor.setStyle("-fx-background-color: black;");
            vista.fitWidthProperty().bind(contenedor.widthProperty());
            vista.fitHeightProperty().bind(contenedor.heightProperty());
            panelJavaFX.setScene(new Scene(contenedor));

            reproductor.play();
        });
    }
}
