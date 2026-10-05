import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

public class MenuInteractivo {
    
    static List<Process> background_process = new ArrayList<>();

    public static void main(String[] args) {
        boolean ok = true;
        while (ok) {
            System.out.println("------------------");
            System.out.println("--> Primer plano");
            System.out.println("--> Segundo plano");
            System.out.println("--> PIDs");
            System.out.println("--> Salir");
            System.out.println("------------------");

            String opc = IO.readln();
            switch (opc) {
                case "1":
                    primerPlano();
                break;
                case "2":
                    segundoPlano();
                break;
                case "3":
                    verPIDs();
                break;
                case "4":
                    salir();
                    ok = false;
                break;
            }
        }
    }

    public static void primerPlano(){
        ProcessBuilder pBuilder = new ProcessBuilder("ping", "www.google.es");
        pBuilder.inheritIO();
        try {
            Process p = pBuilder.start(); 
            System.out.println("[PID] : " + p.pid()); 
            p.waitFor();
            System.out.println("He terminado de dormir");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     public static void segundoPlano(){
        ProcessBuilder pBuilder = new ProcessBuilder("ping", "www.google.es");
        try {
            Process p = pBuilder.start();  
            System.out.println("Iniciando -> [PID] : " + p.pid() + " status : " + p.isAlive());
            background_process.add(p);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void verPIDs(){

        for (Process p : background_process){
            System.out.println("[PID] : " + p.pid() + " status : " + p.isAlive()); 
        }

    }

    public static void salir(){
        for (Process p : background_process){
            while (p.isAlive()){
                try {
                    System.out.println("Esperando a que termine " + p.pid());
                    p.waitFor();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* public static void salirIterator(){

        List<Process> p2 = 

        Iterator<Process> p2 = background_process.iterator();

        while (iterator.hasNext()) {
            Process p = iterator.next();
            if (p.isAlive()) {
                p.destroy();
            }
        }
    } */

}
