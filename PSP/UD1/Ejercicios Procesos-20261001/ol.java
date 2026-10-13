import java.io.File;
import java.io.IOException;
import java.util.List;

import Ejercicio5.Trabajo;

public class ol {
private static File resolveExerciseFile(String fileName) {
        File exerciseDir = new File("Ejercicio5");
        if (!exerciseDir.isDirectory()) {
            exerciseDir = new File(".");
        }
        return new File(exerciseDir, fileName);
    }

    public static void main(String[] args) {
        String language = (args.length > 0) ? args[0] : "en";
        language = language.startsWith("-") ? language.substring(1) : language;

        File exerciseDir = new File("Ejercicio5");
        if (!exerciseDir.isDirectory()) {
            exerciseDir = new File(".");
        }

        Trabajo trabajo = new Trabajo(
                resolveExerciseFile("textoInicial.txt"),
                resolveExerciseFile("textoFinal.txt"),
                language
        );

        ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "check.bat");
        pb1.directory(exerciseDir);
        pb1.redirectInput(trabajo.getSourcePath());

        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "translate.bat", "-" + trabajo.getLanguage());
        pb2.directory(exerciseDir);
        pb2.redirectOutput(trabajo.getDestinationPath());

        try {
            List<Process> processes = ProcessBuilder.startPipeline(List.of(pb1, pb2));
            Process last = processes.getLast();
            last.waitFor();
            System.out.println("Texto traducido guardado en: " + trabajo.getDestinationPath().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
