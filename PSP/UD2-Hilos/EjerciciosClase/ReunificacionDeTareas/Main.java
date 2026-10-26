package EjerciciosClase.ReunificacionDeTareas;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = List.of(1, 2, 3, 4, 5, 6, 7);
        Sumar s = new Sumar(lista);
        Multiplicar m = new Multiplicar(lista);

        s.start();
        m.start();

        try {
            s.join();
            m.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int suma = s.getResultado();
        int multiplicacion = m.getResultado();

        int resta = multiplicacion - suma;
        System.out.println(resta);

    }
}
