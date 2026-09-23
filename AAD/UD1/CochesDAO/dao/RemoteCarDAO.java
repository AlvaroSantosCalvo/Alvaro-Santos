package CochesDAO.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import CochesDAO.model.Car;

public class RemoteCarDAO implements CarDAO {

    private File base_datos;

    public RemoteCarDAO(String ruta) {
       this.base_datos = new File(ruta);
    }

    @Override
    public void insertar(Car coche) {
        try (
            FileWriter fw = new FileWriter(this.base_datos, true); 
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write(coche.getMarca() + ";" + coche.getModelo() + ";" + coche.getAnoFabricacion());
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public List<Car> obtenerTodos() {
        List<Car> coches = new ArrayList<>();
        try (
            FileReader fr = new FileReader(this.base_datos); 
            BufferedReader br = new BufferedReader(fr);
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String marca = datos[0];
                String modelo = datos[1];
                int anoFabricacion = Integer.parseInt(datos[2]);
                Car coche = new Car(marca, modelo, anoFabricacion);
                coches.add(coche);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return coches;
    }

    @Override
    public List<Car> obtenerMarca(String marca) {
       List<Car> coches = obtenerTodos();
       List<Car> coches_marca = new ArrayList<>();
         for (Car c : coches) {
                if (c.getMarca().equalsIgnoreCase(marca)) {
                 coches_marca.add(c);
                }
          }
    
          return coches_marca;
    }

}
