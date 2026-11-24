package miPrimerHilo;

public class Main {
    void main() {
        HiloPropio hilo = new HiloPropio();
        hilo.start();
        // con start se crea un proceso paralelo.
        // con run se ejecutaría en la linea principal y no para hasta que termine.
        HiloPropio hilo2 = new HiloPropio();
        hilo2.start();

        try {
            hilo.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Han acabado los hilos");
    }
}
