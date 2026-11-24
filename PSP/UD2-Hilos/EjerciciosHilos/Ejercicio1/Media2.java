package Ejercicio1;
public class Media2 extends Thread {
    private static int[] array;
    private int inicio, fin;
    private double miResultado;

    public Media2(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.miResultado = 0;
    }

    @Override
    public void run() {
        for (int i = 0; this.inicio < this.fin; i++) {
            this.miResultado += this.array[i];
        }
        this.miResultado = this.miResultado / (fin - inicio + 1);
    }

    public double getMiResultado() {
        return miResultado;
    }

    public static void setArray(int[] array) {
        Media2.array = array;
    }
}
