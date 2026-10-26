import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * --Ejercicio 1: Proceso Guardian--
 * 
 * Desarrolla un programa en Java para lanzar el navegador Firefox abriendo la
 * canción
 * "Never Gonna Give You Up" en YouTube. Cada vez que el proceso de Firefox
 * termine (es
 * decir, cada vez que el navegador sea cerrado por el usuario), el programa
 * debe lanzar
 * nuevamente el proceso de Firefox con la misma URL. El objetivo es que el
 * navegador
 * siempre esté ejecutándose con la canción abierta, a menos que el programa de
 * Java sea
 * detenido manualmente.
 * 
 * https://youtu.be/dQw4w9WgXcQ?si=dAumJnzTjyVx47nR
 */
public class Ejercicio01_ProcesoGuardian {

    public static void main(String[] args) throws Exception {

        String url = "https://youtu.be/dQw4w9WgXcQ?si=dAumJnzTjyVx47nR";

        // tasklist
        ProcessBuilder prep_proceso1 = new ProcessBuilder("tasklist");
        // findstr
        ProcessBuilder prep_proceso2 = new ProcessBuilder("cmd", "/c", "findstr firefox");
        String out1, out2;
        while (true) {

            // Never Gonna
            Process proceso = new ProcessBuilder("firefox", url).start();
            int exit = proceso.waitFor(); // Espera a que Firefox se cierre
            System.out.println("Firefox terminó con código: " + exit);

            try (
                    Process proceso1 = prep_proceso1.start();
                    Process proceso2 = prep_proceso2.start();
                    BufferedReader salida1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
                    BufferedReader salida2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
                    PrintWriter entrada2 = new PrintWriter(proceso2.getOutputStream(), true);) {
                while ((out1 = salida1.readLine()) != null) {
                    entrada2.println(out1);
                }
                entrada2.close();
                while ((out2 = salida2.readLine()) != null) {
                    if (!out2.equals("firefox")) {
                    }
                }
            } catch (Exception e) {
                System.out.println("Algo salio mal, " + e);
            }
        }
    }
}
