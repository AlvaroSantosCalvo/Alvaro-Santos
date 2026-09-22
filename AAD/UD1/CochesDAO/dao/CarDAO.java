package CochesDAO.dao;

import java.util.List;

import CochesDAO.model.Car;

public class CarDAO {
    
    public void insertar(Car car);

    public List<Car> obtenerTodos();

    public List<Car> obtenerMarca(String marca);
}
