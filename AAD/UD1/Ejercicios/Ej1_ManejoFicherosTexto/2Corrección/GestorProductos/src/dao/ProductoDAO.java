package dao;
import java.util.List;
import model.Producto;

public interface ProductoDAO {
    
    void guardarTodos(List<Producto> productos);
    List<Producto> listarTodos();

}
