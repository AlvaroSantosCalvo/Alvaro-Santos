package dao;

import java.util.List;

public interface ProductoDAO<Producto, Integer> {
    // Create
    public void guardarTodos(List<Producto> productos);
    // ReadAll
    public List<Producto> listarTodos();
}
