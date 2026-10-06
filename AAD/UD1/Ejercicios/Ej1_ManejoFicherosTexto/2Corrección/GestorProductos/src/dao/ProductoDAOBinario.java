package dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
            FileOutputStream outputStream = new FileOutputStream(fichero);
            ObjectOutputStream writer = new ObjectOutputStream(outputStream);
        ) {
            for (Producto p : productos) {
                writer.writeObject(p);
            }            
            System.out.println("Datos exportados correctamente al fichero BINARIO.");
        } catch (Exception e) {
            System.err.println("[ERROR] : Fallo al escribir en la base de datos binaria.");
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> lista_Productos = new ArrayList<>();
        try (
            FileInputStream inputStream = new FileInputStream(fichero);
            ObjectInputStream reader = new ObjectInputStream(inputStream);
        ) {
            while (true) {
                Producto p = (Producto) reader.readObject();
                lista_Productos.add(p);
            }
        }
        catch (EOFException e){
            System.out.println("[OK] : Se ha cargado correctamente la base de datos.");
        }
        catch (Exception e) {
            System.out.println("[ERROR] : Fallo al leer en la base de datos binaria.");
        }
        return lista_Productos;
    }

}