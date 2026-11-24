import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class reproductorVideo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override 
    public void start(Stage primaryStage) {

        String rutaArchivo = new File("images\\mario.mp4").toURI().toString();

        Media video = new Media(rutaArchivo);
        MediaPlayer reproductor = new MediaPlayer(video);
        MediaView vista = new MediaView(reproductor);

        vista.setFitWidth(640);
        vista.setFitHeight(480);
        vista.setPreserveRatio(true);

        StackPane root = new StackPane(vista);
        Scene escena = new Scene(root, 640, 480);

        primaryStage.setTitle("Super Mario");
        primaryStage.setScene(escena);
        primaryStage.show();
        reproductor.play();
        
    }
     
}
