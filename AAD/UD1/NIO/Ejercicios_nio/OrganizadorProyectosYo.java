package Ejercicios_nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OrganizadorProyectosYo {
    public static void main(String[] args) {

        System.out.println("Nombre de la carpeta a crear: ");
        Path carpeta = Paths.get(IO.readln());

        if (Files.notExists(carpeta)) {
            try {
                Files.createDirectories(carpeta);
                System.out.println("Carpeta creada: " + carpeta);
                if (Files.notExists(Paths.get(carpeta.toString(), "README.txt"))) {
                    Files.createFile(Paths.get(carpeta.toString(), "README.txt"));
                }
                /* if (Files.notExists(carpeta.resolve("README.txt"))) {
                    Files.createFile(carpeta.resolve("README.txt"));
                } */
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La carpeta ya existe: " + carpeta);
        }
        System.out.println("Número de subcarpetas: ");
        int numSubcarpetas = Integer.parseInt(IO.readln());
        for (int i = 0; i < numSubcarpetas; i++) {
            System.out.println("Nombre de la subcarpeta " + (i + 1) + ": ");
            /* Path subcarpeta = carpeta.resolve(IO.readln()); */
            Path subcarpeta = Paths.get(carpeta.toString(), IO.readln());
            if (Files.notExists(subcarpeta)) {
                try {
                    Files.createDirectories(subcarpeta);
                    System.out.println("Subcarpeta creada: " + subcarpeta);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("La subcarpeta ya existe: " + subcarpeta);
            }
        }
    }
}
