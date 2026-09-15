package PSP.UD1;

public class ProcesoEjemplo2 {
    void main() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        pb.start();

        Thread.sleep(30000);
    }
}
