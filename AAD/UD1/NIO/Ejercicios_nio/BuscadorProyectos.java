package Ejercicios_nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class BuscadorProyectos {
    public static void main(String[] args) {
        String nombreRaiz = IO.readln("Nombre del directorio raiz a buscar: ");
        Path rutaRaiz = Paths.get(nombreRaiz);

        if (Files.exists(rutaRaiz)) {
            try (Stream<Path> rutas = Files.walk(rutaRaiz);) {

                rutas.forEach(ruta -> System.out.println(ruta));

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("[ERROR] : El directorio no se encontró.");
        }

        System.out.println("--------------------------");
        String opcion = IO.readln("(C)rear\n(B)orrar\n(M)over\n");

        switch (opcion.toLowerCase()) {
            case "c":
                String doF = IO.readln("Dir o File: ");
                if ("d".equalsIgnoreCase(doF)) {
                    String newName = IO.readln("Nombre del directorio a crear: ");
                    Path newDir = Paths.get(newName);
                    try {
                        Files.createDirectory(newDir);
                        System.out.println("Carpeta creada: " + newDir);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if ("f".equalsIgnoreCase(doF)) {
                    String newName = IO.readln("Nombre del fichero a crear: ");
                    Path newFile = Paths.get(newName);
                    try {
                        Files.createFile(newFile);
                        System.out.println("Fichero creado: " + newFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "b":
                break;
            case "m":
                break;
            default:
                break;
        }
    }
}
