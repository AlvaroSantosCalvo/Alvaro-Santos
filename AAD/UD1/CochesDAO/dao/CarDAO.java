package CochesDAO.dao;

import java.io.File;
import java.util.List;

import CochesDAO.model.Car;

public interface CarDAO {
    
    public void insertar(Car coche);

    List<Car> obtenerTodos();

    public List<Car> obtenerMarca(String marca);
}

