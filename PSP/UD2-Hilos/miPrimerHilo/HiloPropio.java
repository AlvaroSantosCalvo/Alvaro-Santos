package miPrimerHilo;

public class HiloPropio extends Thread {
    
    @Override 
    public void run(){

        int contador = 10;
        while (contador>0) {
            System.out.println("Estoy gastando CPU." + this.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contador--;
        }
    }
}
