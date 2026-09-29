import java.util.List;

import dao.ProductoDAOTexto;
import model.Producto;

public class Main {
    public static void main(String[] args) throws Exception {
       
        ProductoDAOTexto dao = new ProductoDAOTexto("src\\bbdd.txt");
        boolean ok = true;

        while (ok) {
            System.out.println("=======================");
            System.out.println("    GESTOR DE STOCK    ");
            System.out.println("=======================");
            System.out.println("1. Ver todos los productos");
            System.out.println("2. Añadir producto");
            System.out.println("3. Salir");
            System.out.println("=======================");

            String opc = IO.readln();
            switch (opc) {
                case "1":
                    List<Producto> productos = dao.readAll();
                    for (Producto p : productos){
                        System.out.println(p.getId() + " - " + p.getNombre() + " - " + p.getPrecio());
                    }
                break;
                case "2":
                    int id = Integer.parseInt(IO.readln("Introduce el ID: "));
                    String nombre = IO.readln("Introduce el nombre: ");
                    double precio = Double.parseDouble(IO.readln("Introduce el precio: "));
                    Producto p = new Producto(id, nombre, precio);
                    dao.create(p);
                break;
                default:ok=false;break;
            }
        }
        
    }
}
