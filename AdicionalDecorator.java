// Decorator base
public abstract class AdicionalDecorator extends Sandwich {
    protected Sandwich sandwich;
    
    public AdicionalDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
        this.tamaño = sandwich.getTamaño();
    }
    
    @Override
    public String getNombre() {
        return sandwich.getNombre();
    }
}