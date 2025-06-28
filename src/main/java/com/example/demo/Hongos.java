package com.example.demo;
public class Hongos extends AdicionalDecorator {
    public Hongos(Sandwich sandwich) {
        super(sandwich);
    }
    
    @Override
    public double getPrecio() {
        double precioAdicional = tamaño == 15 ? 0.85 : 1.45;
        return sandwich.getPrecio() + precioAdicional;
    }
    
    @Override
    public String getDescripcion() {
        double precioAdicional = tamaño == 15 ? 0.85 : 1.45;
        return sandwich.getDescripcion() + " + Hongos ($" + precioAdicional + ")";
    }
}