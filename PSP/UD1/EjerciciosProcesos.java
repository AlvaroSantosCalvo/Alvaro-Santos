
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjerciciosProcesos {

    public void main() throws Exception {
        
        ProcessBuilder pb = new ProcessBuilder("tasklist ");
        Process p = pb.start();

        InputStream in = p.getInputStream();
        InputStreamReader input = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(input);
        String linea;
        boolean fireFox = false;
        while ((linea = br.readLine()) != null) {
            if (linea.contains("firefox")){
                fireFox = true;
                break;
            }
        }
        
        if (fireFox) {
            IO.print("FIREFOX abierto !!!!!");
        }
        else{
            IO.print("FIREFOX NO :(");
        }
    }
}