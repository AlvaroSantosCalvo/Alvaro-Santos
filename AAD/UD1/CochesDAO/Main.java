package CochesDAO;

import java.util.List;
import java.util.Scanner;

import CochesDAO.dao.CarDAO;
import CochesDAO.dao.LocalCarDAO;
import CochesDAO.dao.RemoteCarDAO;
import CochesDAO.model.Car;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------");
        System.out.println("Lope Cars");
        System.out.println("----------");

        RemoteCarDAO remoto = new RemoteCarDAO("Cars.txt");
        List<Car> automoviles = remoto.obtenerTodos();
        CarDAO local = new LocalCarDAO(automoviles);

        boolean ok = true;
        while (ok) {
            System.out.println("----------------------------");
            System.out.println("1 - Insertar coche");
            System.out.println("2 - Ver todos los coches");
            System.out.println("3 - Filtrar por marca");
            System.out.println("----------------------------");

            int in = Integer.parseInt(IO.readln("Opcion: "));

            switch (in) {
                case 1:
                    String marca = IO.readln("Marca: ");
                    String modelo = IO.readln("Modelo: ");
                    int ano = Integer.parseInt(IO.readln("Año: "));
                    Car c = new Car(marca, modelo, ano);
                    local.insertar(c);
                    remoto.insertar(c);
                    break;
                case 2:
                    List<Car> coches = local.obtenerTodos();
                    for (Car coche : coches){
                        System.out.println(coche.getMarca() + " - " + coche.getModelo());
                    }                    
                    break;
                case 3:
                    String m2 = IO.readln("Introduce la marca");
                    List<Car> porMarca = local.obtenerMarca(m2);
                    for (Car coche : porMarca){
                        System.out.println(coche.getModelo());
                    }   
                    break;
            
                default:
                    ok=false;
                    break;
            }

        }

    }
}
