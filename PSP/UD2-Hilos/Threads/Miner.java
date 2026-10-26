package Threads;

public class Miner extends Thread {
    String name;

    public Miner(String name) {
        this.name = name;
    }

    @Override 
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println(this.name + " lleva picando " + i + " dias.");
        }
    }
}
