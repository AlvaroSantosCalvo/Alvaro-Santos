import java.util.List;

import dao.ProductoDAO;
import dao.ProductoDAOTexto;
import dao.ProductoDAOBinario;
import model.Producto;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("=======================");
        System.out.println("    Elige la BDD    ");
        System.out.println("=======================");
        System.out.println("1. Texto");
        System.out.println("2. Binario");
        System.out.println("=======================");

        int opcion = Integer.parseInt(IO.readln());
            ProductoDAO dao;
            switch (opcion) {
                case 1:
                    dao = new ProductoDAOTexto("src\\bbdd.txt");
                break;
                default:
                    dao = new ProductoDAOBinario("src\\bbdd.bin1");
                break;
            }


        List<Producto> productos = dao.listarTodos();
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
                    for (Producto p : productos){
                        System.out.println(p.getId() + " - " + p.getNombre() + " - " + p.getPrecio());
                    }
                break;
                case "2":
                    int id = Integer.parseInt(IO.readln("Introduce el ID: "));
                    String nombre = IO.readln("Introduce el nombre: ");
                    double precio = Double.parseDouble(IO.readln("Introduce el precio: "));
                    Producto p = new Producto(id, nombre, precio);
                    productos.add(p);
                break;
                default:ok=false;break;
            }
        }
        
        dao.guardarTodos(productos);
    }
}
