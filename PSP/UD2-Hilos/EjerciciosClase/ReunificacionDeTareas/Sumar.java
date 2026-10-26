package EjerciciosClase.ReunificacionDeTareas;

import java.util.List;

public class Sumar extends Thread {

    private List<Integer> lista;
    private int resultado = 0;

    public Sumar(List<Integer> lista2) {
        this.lista = lista2;
    }

    @Override
    public void run() {
        int total = 0;
        for (Integer numero : lista) {
            total += numero;
        }
        this.resultado = total;
    }

    public int getResultado() {
        return resultado;
    }
}