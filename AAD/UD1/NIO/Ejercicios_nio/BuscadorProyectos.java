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

        switch (opcion) {
            case "c":
                String crear = IO.readln("(D)irectorio o (F)ichero");
                if (crear=="d"|crear=="D") {
                    String nombreDCrear = IO.readln("Nombre del directorio a crear: ");
                }else{
                    String nombreFCrear = IO.readln("Nombre del fichero a crear: ");
                }
                break;
            case "b":
                String borrar = IO.readln("(D)irectorio o (F)ichero");
                if (borrar=="d"|borrar=="D") {
                    String nombreDCrear = IO.readln("Nombre del directorio a borrar: ");
                }else{
                    String nombreFCrear = IO.readln("Nombre del fichero a borrar: ");
                }
                break;
            case "m":
                String mover = IO.readln("(D)irectorio o (F)ichero");
                if (mover=="d"|mover=="D") {
                    String nombreDCrear = IO.readln("Nombre del directorio a mover: ");
                }else{
                    String nombreFCrear = IO.readln("Nombre del fichero a mover: ");
                }
                break;
            default:
                break;
        }
    }
}
