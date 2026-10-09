package Ejercicios_nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solucion {
    public static void main(String[] args) {
        String nombreRaiz = IO.readln("Nombre del directorio raiz: ");
        Path rutaRaiz = Paths.get(nombreRaiz);

        creaCarpeta(rutaRaiz);

        int nSubcarpetas = Integer.parseInt(IO.readln("Número de subcarpetas: "));

        for (int i = 0; i < nSubcarpetas; i++) {
            String name = IO.readln("Nombre de la subcarpeta " + (i + 1) + ":");
            Path rutaSubcarpeta = rutaRaiz.resolve(name);
            creaCarpeta(rutaSubcarpeta);
        }

        Path rutaReadme = rutaRaiz.resolve("README.md");
        crearFichero(rutaReadme);
    }

    public static void creaCarpeta(Path ruta) {
        if (Files.exists(ruta)) {
            System.out.println("[AVISO] : El directorio " + ruta + " ya existe, no se creará");
        } else {
            try {
                Files.createDirectory(ruta);
                System.out.println("[OK] : El directorio " + ruta + " se ha creado");
            } catch (Exception err) {
                System.out.println("[ERROR] : Error creando el directorio " + ruta + ".");
            }
        }
    }

    public static void crearFichero(Path ruta) {
        if (Files.exists(ruta)) {
            System.out.println("[AVISO] : El fichero " + ruta + " ya existe, no se creará");
        } else {
            try {
                Files.createFile(ruta);
                System.out.println("[OK] : El fichero " + ruta + " se ha creado");
            } catch (Exception err) {
                System.out.println("[ERROR] : Error creando el fichero " + ruta + ".");
            }
        }
    }

}
