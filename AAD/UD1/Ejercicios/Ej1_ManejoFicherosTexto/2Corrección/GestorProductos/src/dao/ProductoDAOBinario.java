package dao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductoDAOBinario implements ProductoDAO {

    private File fichero;

    public ProductoDAOBinario(String ruta) {
        this.fichero = new File(ruta);
    }

    @Override 
    public void guardarTodos(List<Producto> productos) {
        
        try (
            FileOutputStream fStream = new FileOutputStream(fichero);
            ObjectOutputStream writer = new ObjectOutputStream(fStream);
        ) {
            for(Producto p : productos){
                writer.writeObject(p);
            }
            writer.close();
            System.out.println("Datos exportados correctamente al fichero BINARIO.");            
        }
        catch (Exception e) {
            System.err.println("[ERROR] : Fallo al escribir en la base de datos binaria.");
        }
    }
    

    @Override 
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        try (
            FileInputStream fStream = new FileInputStream(fichero);
            ObjectInputStream writer = new ObjectInputStream(fStream);
        ) {
            
        } catch (Exception e) {
            System.err.println("[ERROR] : Fallo al leer en la base de datos binaria.");
        }
        return productos;
    }
    
}