package CochesDAO.model;

public class Car {
    private String marca;
    private String modelo;
    private int anoFabricacion;

    public Car(){};

    public Car(String marca, String modelo, int anoFabricacion){
        this.marca=marca;
        this.modelo=modelo;
        this.anoFabricacion=anoFabricacion;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnoFabricacion() { return anoFabricacion; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAnoFabricacion(int anoFabricacion) {this.anoFabricacion = anoFabricacion; }
    
    @Override
    public String toString() {
        return "[Car] " + this.marca + " - " + this.modelo + " - " + this.anoFabricacion;
    }
}
