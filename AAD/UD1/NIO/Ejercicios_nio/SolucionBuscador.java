package Ejercicios_nio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SolucionBuscador {
    public static void main(String[] args) {
        String nombreRaiz = IO.readln("Nombre del directorio raiz a buscar: ");
        Path rutaRaiz = Paths.get(nombreRaiz);

        while (Files.isDirectory(rutaRaiz) == false) {
            System.out.println("No has introducido un dir");
            nombreRaiz = IO.readln("Nombre del directorio raiz a buscar: ");
            rutaRaiz = Paths.get(nombreRaiz);
        }

        System.out.println("----------------------------");

        recorrerDirectorio(rutaRaiz);

        boolean ok = true;
        while (ok) {

            System.out.println("-----------");
            System.out.println("(c)rear");
            System.out.println("(m)over");
            System.out.println("(b)borrar");
            System.out.println("-----------");

            String opcion = IO.readln("Opcion: ");

            switch (opcion) {
                case "c":
                    crearArchivo(rutaRaiz);
                    break;
                case "m":
                    mover(rutaRaiz);
                    break;
                case "b":

                    break;

                default:
                    ok = false;
                    break;
            }
        }

    }

    public static void recorrerDirectorio(Path rutaRaiz) {
        if (Files.exists(rutaRaiz)) {
            try (Stream<Path> archivos = Files.walk(rutaRaiz);) {

                archivos.forEach(archivo -> System.out.println(archivo));

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("[ERROR] : El directorio no se encontró.");
        }
    }

    public static void crearArchivo(Path rutaRaiz) {
        System.out.println("-----------");
        System.out.println("(D)ir ");
        System.out.println("(F)ile");
        System.out.println("-----------");

        String opcion = IO.readln("(D o F): ");
        String nombre = IO.readln("Introduce el nombre: ");
        Path ruta = rutaRaiz.resolve(nombre);
        switch (opcion) {
            case "f":
                if (Files.exists(ruta)) {
                    System.out.println("Ya existe");
                } else {
                    try {
                        Files.createFile(ruta);
                        System.out.println("[OK] : Fichero creado.");
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
                break;
            case "d":
                if (Files.exists(ruta)) {
                    System.out.println("Ya existe");
                } else {
                    try {
                        Files.createDirectory(ruta);
                        System.out.println("[OK] : Fichero creado.");
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
                break;
            default:
                break;
        }
    }

    public static void mover(Path rutaRaiz) {
        System.out.println("Introduce el nombre: ");
        String nombre = IO.readln();
        Path origen = rutaRaiz.resolve(nombre);

        System.out.println("Introduce a donde lo quiertes mover: ");
        String nombre2 = IO.readln();
        Path destino = rutaRaiz.resolve(nombre2).resolve(nombre);

        if (Files.exists(origen) && Files.exists(destino) && Files.isDirectory(destino)) {
            try {
                Files.move(origen, destino);
                System.out.println();

            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
