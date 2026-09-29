package model;

public class Producto {
    
    Integer id;
    String nombre;
    Double precio;

    public Producto(Integer id, String nombre, Double precio){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {return id;}
    public String getNombre() {return nombre;}
    public Double getPrecio() {return precio;}
}
