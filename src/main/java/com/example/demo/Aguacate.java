package com.example.demo;
// Decoradores concretos - Adicionales
public class Aguacate extends AdicionalDecorator {
    public Aguacate(Sandwich sandwich) {
        super(sandwich);
    }
    
    @Override
    public double getPrecio() {
        double precioAdicional = tamaño == 15 ? 1.5 : 2.5;
        return sandwich.getPrecio() + precioAdicional;
    }
    
    @Override
    public String getDescripcion() {
        double precioAdicional = tamaño == 15 ? 1.5 : 2.5;
        return sandwich.getDescripcion() + " + Aguacate ($" + precioAdicional + ")";
    }
}