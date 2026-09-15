package PSP.UD1;

import java.util.Scanner;

public class CrearCarpetaCrearFichero {
    Scanner sc = new Scanner(System.in);

    void main() throws Exception {

        boolean ok = true;

        while (ok) {
            IO.println("************\n" +
                    "(d) Crear directorio\n" +
                    "(f) Crear fichero\n" +
                    "************");
            String option = sc.nextLine();

            switch (option) {
                case "d":
                    IO.println("Introduce el nombre del directorio a crear");
                    String dir = sc.nextLine();
                    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "mkdir " + dir);
                    Process p = pb.start();
                    long pid = p.pid();
                    IO.println("[Proceso] pid: " + pid);
                    // Esperar a que acabe el proceso
                    int exitCode = p.waitFor();
                    if (exitCode == 0) {
                        IO.println("[Proceso] pid: " + pid + " finalizado correctamente");
                    }else {
                        IO.println("[Proceso] pid: " + pid + " finalizado con errores");
                    }
                    break;
                case "f":
                    IO.println("Introduce el nombre del fichero a crear");
                    String file = sc.nextLine();
                    ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "type nul > " + file);
                    Process p2 = pb2.start();
                    long pid2 = p2.pid();
                    IO.println("[Proceso] pid: " + pid2);
                    // Esperar a que acabe el proceso
                    int exitCode2 = p2.waitFor();
                    if (exitCode2 == 0) {
                        IO.println("[Proceso] pid: " + pid2 + " finalizado correctamente");
                    }else {
                        IO.println("[Proceso] pid: " + pid2 + " finalizado con errores");
                    }
                    break;
                default:
                    ok = false;
            }
        }
    }
}