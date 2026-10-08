import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
                
    }

    public static void recorrerDirectorio(){
        Path carpeta = Paths.get("C:\\Users\\Profesor\\Desktop\\DANI\\AAD\\UD1\\nio");
        
        try (Stream<Path> rutas = Files.walk(carpeta);) {
            
            rutas.forEach(ruta -> System.out.println(ruta));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void leerFiles(){
        File f = new File("texto.txt");
        Path archivo1 = Paths.get("texto.txt");
        Path archivo2 = Paths.get(f.toURI());
        Path archivo = Path.of("texto.txt");

        try {
            List<String> lineas = Files.readAllLines(archivo);
            for (String linea : lineas){
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
            BufferedReader reader = Files.newBufferedReader(archivo);
        ) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            List<String> lineas = reader.readAllLines();
            for(String linea2 : lineas){
                System.out.println(linea2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try (
            Stream<String> lineas = Files.lines(archivo);
        ) {
            lineas.forEach(linea -> System.out.println(linea));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void escribirFiles(){
        Path archivo = Paths.get("texto2.txt");

        try {
            Files.writeString(archivo, "Hola Mundo");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void encadenarFiles(){
        Path archivo = Paths.get("texto2.txt");

        List<String> lista_palabras = List.of(
            "Programación de servicios y procesos", 
            "Acceso a datos", 
            "Tutor");

        try {
            Files.write(archivo, lista_palabras, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
