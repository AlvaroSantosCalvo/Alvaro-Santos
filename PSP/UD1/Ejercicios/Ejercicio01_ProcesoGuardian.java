import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Ejercicio01_ProcesoGuardian
 */
public class Ejercicio01_ProcesoGuardian {

    public static void main() throws Exception {
        System.out.println("Introduce una dirección: ");
        String dir = IO.readln();

        ProcessBuilder pb = new ProcessBuilder("tasklist");
        Process p = pb.start();

        InputStream in = p.getInputStream();
        InputStreamReader input = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(input);

        String linea;
        boolean firefox = false;
        while ((linea = br.readLine()) != null) {
            if (linea.contains("firefox")) {
                firefox = true;
                break;                
            }
        }

        if (firefox) {
            IO.print("FIREFOX abierto");
        } else {
            IO.print("FIREFOX no");
        }
    }
}

// start firefox youtube.com
// tasklist para ver los procesos en ejecución