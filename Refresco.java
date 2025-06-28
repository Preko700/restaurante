public class Refresco extends AdicionalDecorator {
    public Refresco(Sandwich sandwich) {
        super(sandwich);
    }
    
    @Override
    public double getPrecio() {
        return sandwich.getPrecio() + 1.0; // mismo precio para ambos tamaños
    }
    
    @Override
    public String getDescripcion() {
        return sandwich.getDescripcion() + " + Refresco ($1)";
    }
}