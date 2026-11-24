package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int numThreads = 2;
        double mean = calculateMean(array, numThreads);
        System.out.println("La media: " + mean);
        double media = calcularMedia(array, numThreads);
        System.out.println("La media: " + media);
    }

    public static double calcularMedia(int[] array, int numThreads) {
        double resultado = 0;
        List<Media2> misHilos = new ArrayList<>();
        int porcionIndividual = array.length / numThreads;
        Media2.setArray(array);

        for (int n = 0; n < numThreads; n++) {
            Media2 hilo = new Media2(n * porcionIndividual, (n + 1) * porcionIndividual);
            misHilos.add(hilo);
            hilo.start();
        }

        for (Media2 hilo : misHilos) {
            try {
                hilo.join();
                resultado = resultado + hilo.getMiResultado();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return resultado / numThreads;
    }

    public static double calculateMean(int[] array, int numThreads) {
        double resultado = 0;
        int contador = 0;
        int porcionIndividual = array.length / numThreads;

        List<CalculadoraMedia> misHilos = new ArrayList<>();
        for (int n = 0; n < numThreads; n++) {
            int[] arrayIndividual = new int[porcionIndividual];
            for (int i = 0; i < porcionIndividual; i++) {
                arrayIndividual[i] = array[i + contador];

            }
            contador = contador + porcionIndividual;
            CalculadoraMedia hilo = new CalculadoraMedia(arrayIndividual);
            misHilos.add(hilo);
            hilo.start();
        }
        for (CalculadoraMedia hilo : misHilos) {
            try {
                hilo.join();
                resultado = resultado + hilo.getMiResultado();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return resultado / numThreads;
    }

}