import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DosProcesos {

    public static void main(String[] args) {

        // Primer proceso: tasklist
        ProcessBuilder pb = new ProcessBuilder("tasklist");
        String salida_p1 = "";
        try (
                Process p = pb.start();
                InputStream in = p.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                // para leer (salida) del proceso
                BufferedReader br = new BufferedReader(reader);

        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                salida_p1 += linea + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Segundo proceso: findstr
        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "findstr java");
        String linea2;
        try (
                Process p2 = pb2.start();
                OutputStream os2 = p2.getOutputStream();
                // para escribir la (entrada) en el proceso
                PrintWriter writer = new PrintWriter(os2, true);

                InputStream in2 = p2.getInputStream();
                InputStreamReader reader2 = new InputStreamReader(in2);
                // para leer la (salida) del proceso
                BufferedReader br2 = new BufferedReader(reader2);

        ) {
            writer.println(salida_p1);
            // tengo que cerrar la entrada del proceso porque si no se queda esperando por
            // si recibe más información
            writer.close();

            while ((linea2 = br2.readLine()) != null) {
                System.out.println(linea2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
