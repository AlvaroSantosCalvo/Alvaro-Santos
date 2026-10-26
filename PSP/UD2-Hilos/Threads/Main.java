package Threads;

public class Main {

    public static void main(String[] args) throws Exception {
        Miner m1 = new Miner("+++++++");
        Miner m2 = new Miner("-------");

        long time1 = System.currentTimeMillis();
        // Lanzo los hilos en paralelo
        m1.start();
        m2.start();
        // El código (la ejecución ) se bloquea hasta que terminan los hilos.
        m1.join();
        m2.join();
        long time2 = System.currentTimeMillis();
        long timeTotal = time1 + time2;
        System.out.println("Han tardado " + timeTotal + " ms.");
    }

}