package model;

public class Producto {
    int id;
    String nombre;
    double precio;

    public Producto(){};

    public Producto(int id, String nombre, double precio){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(int precio) {this.precio = precio; }
    
    @Override
    public String toString() {
        return "[Producto] " + this.id + " - " + this.nombre + " - " + this.precio;
    }
    
}