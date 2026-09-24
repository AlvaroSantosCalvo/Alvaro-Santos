import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Tuberia {
    public static void main(String[] args) {

        // Primer proceso: tasklist
        ProcessBuilder prep_proceso1 = new ProcessBuilder("tasklist");
        // Segundo proceso: findstr
        ProcessBuilder prep_proceso2 = new ProcessBuilder("cmd", "/c", "findstr java");
        String out1, out2;

        try (
            Process proceso1 = prep_proceso1.start();
            Process proceso2 = prep_proceso2.start();
            BufferedReader salida1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
            BufferedReader salida2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
            PrintWriter entrada2 = new PrintWriter(proceso2.getOutputStream(), true);
        ) {
            while ((out1 = salida1.readLine()) != null) {
                entrada2.println(out1);
            }
            entrada2.close();
            while ((out2 = salida2.readLine()) != null) {
                System.out.println(out2);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Algo salio mal, " + e);
        }
    }
}
