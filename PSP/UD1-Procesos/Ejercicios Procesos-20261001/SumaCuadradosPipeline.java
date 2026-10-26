import java.io.File;
import java.io.IOException;
import java.util.List;

public class SumaCuadradosPipeline {
    public static void main(String[] args) {

        ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "cuadrados.bat");
        pb1.redirectInput(new File("numeros.txt"));
        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "suma.bat");
        pb2.redirectOutput(new File("solucion.txt"));

        List<ProcessBuilder> processList = List.of(pb1,pb2);

        try {
           List<Process> processes = ProcessBuilder.startPipeline(processList); 
            Process last = processes.getLast();
            last.waitFor();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
