public class SandwichBeef extends Sandwich {
    public SandwichBeef(int tamaño) {
        this.nombre = "Beef";
        this.tamaño = tamaño;
    }
    
    @Override
    public double getPrecio() {
        return tamaño == 15 ? 14.0 : 18.0;
    }
    
    @Override
    public String getDescripcion() {
        return nombre + " de " + tamaño + " cm";
    }
}