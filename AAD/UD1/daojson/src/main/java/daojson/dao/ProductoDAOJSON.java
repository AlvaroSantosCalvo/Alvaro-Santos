package daojson.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import daojson.model.Producto;

public class ProductoDAOJSON implements ProductoDAO {

    private File fichero;

    public ProductoDAOJSON(String ruta) {
        this.fichero = new File(ruta);
    }

    @Override
    public void guardarTodos(List<Producto> productos) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(this.fichero, productos);
            System.out.println("[OK] Base de datos JSON actualizados.");
        } catch (Exception e) {
            System.out.println("[ERROR] Error al serializar la base de datos JSON.");
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            productos = mapper.readValue(this.fichero, new TypeReference<List<Producto>>() {
            });
            System.out.println("[OK] Base de datos JSON cargada.");
        } catch (Exception e) {
            System.out.println("[ERROR] Error al leer la base de datos JSON");
        }
        return productos;

    }

}
