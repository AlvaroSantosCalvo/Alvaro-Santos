package Ejercicio1;

public class CalculadoraMedia extends Thread {

    private int[] miPorcion;
    private double miResultado;

    public CalculadoraMedia(int[] miPorcion) {
        this.miPorcion = miPorcion;
        this.miResultado = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.miPorcion.length; i++) {
            this.miResultado += this.miPorcion[i];
        }
        this.miResultado = this.miResultado / this.miPorcion.length;
    }

    public double getMiResultado() {
        return miResultado;
    }
}
