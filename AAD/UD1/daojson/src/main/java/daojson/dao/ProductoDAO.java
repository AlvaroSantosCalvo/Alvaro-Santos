package daojson.dao;
import java.util.List;
import daojson.model.Producto;

public interface ProductoDAO {
    
    void guardarTodos(List<Producto> productos);
    List<Producto> listarTodos();

}
