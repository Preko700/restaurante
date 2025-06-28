// Componente base
public abstract class Sandwich {
    protected String nombre;
    protected int tamaño; // 15 o 30 cm
    
    public abstract double getPrecio();
    public abstract String getDescripcion();
    
    public int getTamaño() {
        return tamaño;
    }
    
    public String getNombre() {
        return nombre;
    }
}