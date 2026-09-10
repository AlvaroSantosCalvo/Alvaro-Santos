package PSP.UD1;

public class ProcesoEjemplo {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start calc");
        Process p = pb.start();
        p.waitFor();
    }
}
