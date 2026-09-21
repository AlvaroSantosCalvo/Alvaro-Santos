import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ListaTareas {

     public static void main() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("tasklist");
        Process proceso = pb.start();

        InputStream in = proceso.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        
        int contador = 0;
        List<String> lineas = br.readAllLines();
        int contador2 = lineas.size();

        while ((br.readLine()) != null) {
            contador++ ;
        }

        reader.close();
        br.close();
        
        IO.println("\nProcesos en ejecución: " + (contador - 4));
        IO.println("\nProcesos en ejecución: " + (contador2 - 4));
        IO.println(ProcessHandle.allProcesses().count());
     }
}
/*
 * Lanza el proceso "tasklist"
 * e imprime por pantalla únicamente
 * el nº de procesos actuales
 */