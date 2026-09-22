package CochesDAO;

import java.util.Scanner;

import CochesDAO.dao.CarDAO;
import CochesDAO.dao.LocalCarDAO;
import CochesDAO.dao.RemoteCarDAO;

public class Main {
    
    static Scanner sc = new Scanner(System.in);

    public void main() throws Exception {
        IO.println("¿Quieres trabajar en local (1) o en remoto(2)?");
        int work = Integer.parseInt(IO.readln());
        CarDAO dao;
        String ruta = "Cars.txt";
        if(work == 1){
            dao = new LocalCarDAO(ruta);
        }else{
            dao = new RemoteCarDAO(ruta);
        }
        libreria(dao);
    }

    public static void libreria(CarDAO dao) {
        boolean ok = true;

        while (ok) {
            IO.println("----------------");
            IO.println("(C)reate Car");
            IO.println("(R)ead Car");
            IO.println("(U)pdate Car");
            IO.println("(D)elete Car");
            IO.println("----------------");

            String opt = sc.nextLine();
        }
    }
}
