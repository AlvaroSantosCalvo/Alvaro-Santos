public class Ejercicio00_PingAlive {

    public static void main() throws Exception {

        System.out.println("Introduce una dirección: ");
        String dir = IO.readln();

        ProcessBuilder pb = new ProcessBuilder("ping", dir);
        Process ping = pb.start();

        long i = 0;
        while (ping.isAlive()) {
            // IO.println("Trabajando");
            IO.println(i++);
            Thread.sleep(1000);
        }
        int code = ping.exitValue();
        if (code == 0) {
            IO.println("Proceso OK");
        } else {
            IO.println("Error");
        }

    }

}
/*
 * 1. Pido una dirección por teclado (Google)
 * 2. Le hago ping
 * 3. Mientras el proceso siga vivo, imprimo "Trabajando..."
 * 4. Cuando termine muestro ("Proceso OK" o "Error";)
 */
