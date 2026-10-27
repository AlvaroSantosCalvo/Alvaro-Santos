package daojson.model;

import java.io.Serializable;

//Esperar al ejercicio subido

public class Producto implements Serializable {
    
    static final long serialVersionUID = 1L;
    Integer id;
    String nombre;
    Double precio;

    public Producto(){}

    public Producto(Integer id, String nombre, Double precio){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {return id;}
    public String getNombre() {return nombre;}
    public Double getPrecio() {return precio;}

    public void setId(Integer id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre; }
    public void setPrecio(Double precio) {this.precio = precio;}
}
