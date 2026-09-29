package dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductoDAOTexto implements ProductoDAO {

    private File fichero;
    private String patron;

    public ProductoDAOTexto(String ruta, String patron) {
        this.fichero = new File(ruta);
        this.patron = "; ";
    }

    public ProductoDAOTexto(String ruta) {
        this.fichero = new File(ruta);
        this.patron = "; ";
    }

    @Override
    public void guardarTodos(List<Producto> productos) {
        try (
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (Producto p : productos) {
                bw.write(p.getId() + patron + p.getNombre() + patron + p.getPrecio());
                bw.newLine();
            }
            System.out.println("atributos exportados correctamente al fichero .txt");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero .txt");
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        try (
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr)
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] atributos = linea.split(patron);
                if (atributos.length == 3) {
                    //Producto p = new Producto();
                    int id = Integer.parseInt(atributos[0].trim());
                    String nombre = atributos[1].trim();
                    int precio = Integer.parseInt(atributos[2].trim());
                    productos.add(new Producto(id, nombre, precio));
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return productos;
    }
}
