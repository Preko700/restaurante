package com.example.demo;
public class DobleProteina extends AdicionalDecorator {
    public DobleProteina(Sandwich sandwich) {
        super(sandwich);
    }
    
    @Override
    public double getPrecio() {
        double precioAdicional = tamaño == 15 ? 4.5 : 8.0;
        return sandwich.getPrecio() + precioAdicional;
    }
    
    @Override
    public String getDescripcion() {
        double precioAdicional = tamaño == 15 ? 4.5 : 8.0;
        return sandwich.getDescripcion() + " + Doble Proteína ($" + precioAdicional + ")";
    }
}