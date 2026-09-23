package CochesDAO.dao;

import java.util.ArrayList;
import java.util.List;

import CochesDAO.model.Car;

public class LocalCarDAO implements CarDAO {

    private List<Car> base_datos;

    public LocalCarDAO(List<Car> coches) {
        this.base_datos = coches;
    }

    @Override
    public void insertar(Car coche) {
        this.base_datos.add(coche);
    }

    @Override
    public List<Car> obtenerTodos() {
        return new ArrayList<>(this.base_datos);
    }

    @Override
    public List<Car> obtenerMarca(String marca) {
        List<Car> coches_marca = new ArrayList<>();
        for (Car c : this.base_datos) {
            if (c.getMarca().equalsIgnoreCase(marca)) {
                coches_marca.add(c);
            }
        }

        /* return base_datos.stream()
        .filter(coche -> coche.getMarca().equals(marca))
        .toList(); */

        return coches_marca;
    }

}
