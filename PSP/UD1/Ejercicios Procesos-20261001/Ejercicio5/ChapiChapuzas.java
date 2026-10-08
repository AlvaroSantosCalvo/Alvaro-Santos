package Ejercicio5;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ChapiChapuzas {
    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "check.bat");
        pb1.redirectInput(new File("textoInicial.txt"));
        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "translate.bat");
        pb2.redirectOutput(new File("textoFinal.txt"));

        List<ProcessBuilder> processList = List.of(pb1, pb2);

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
