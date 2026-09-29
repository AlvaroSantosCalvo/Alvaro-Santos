package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

public class ProductoDAOTexto implements DAO<Producto, Integer> {

    private File fichero;
    private String patron;

    public ProductoDAOTexto(String ruta, String patron){
        this.fichero = new File(ruta);
        this.patron = patron;
    }

    public ProductoDAOTexto(String ruta){
        this.fichero = new File(ruta);
        this.patron = ";";
    }

    @Override
    public void create(Producto p) {
        try (
            FileWriter fWriter = new FileWriter(fichero, true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
        ) {
            bWriter.write(p.getId() + patron + p.getNombre() + patron + p.getPrecio());
            bWriter.newLine();
            System.out.println("Datos exportados correctamente al fichero TXT.");
        } catch (Exception e) {
            System.err.println("Error al escribir el fichero TXT.");
        }
    }

    @Override
    public List<Producto> readAll() {
        List<Producto> productos = new ArrayList<>();
        try (
            FileReader fReader = new FileReader(fichero);
            BufferedReader bReader = new BufferedReader(fReader);
        ) {
            String linea;
            while ((linea = bReader.readLine()) != null) {
                String [] atributos = linea.split(patron);
                if (atributos.length == 3){
                    Producto p = new Producto(
                        Integer.parseInt(atributos[0]), 
                        atributos[1],
                        Double.parseDouble(atributos[2]) 
                    );
                    productos.add(p);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el fichero TXT.");
        }
        return productos;
    }

    @Override
    public Producto readById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(Producto e) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
