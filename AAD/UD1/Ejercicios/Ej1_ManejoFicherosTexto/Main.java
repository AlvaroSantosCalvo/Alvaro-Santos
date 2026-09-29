import java.util.List;

import dao.ProductoDAO;
import dao.ProductoDAOTexto;
import model.Producto;

public class Main {
    public static void main(String[] args) throws Exception {
        ProductoDAO dao = new ProductoDAOTexto("Productos.txt", null);
        List<Producto> productos = dao.listarTodos();
        boolean ok = true;

        while (ok) {
            System.out.println("======================");
            System.out.println("   GESTOR DE STOCK    ");
            System.out.println("======================");
            System.out.println("1. Ver todos los productos");
            System.out.println("2. Añadir producto");
            System.out.println("3. Salir");
            System.out.println("======================");

            String opc = IO.readln();
            switch (opc) {
                case "1":
                    for (Producto p : productos){
                        
                    }
                break;
                case "2":
                    
                 break;
                case "3":
                    
                break;
                default:
                    break;
            }

        }
    }
}
