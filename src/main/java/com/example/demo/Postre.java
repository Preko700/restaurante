package com.example.demo;
public class Postre extends AdicionalDecorator {
    public Postre(Sandwich sandwich) {
        super(sandwich);
    }
    
    @Override
    public double getPrecio() {
        return sandwich.getPrecio() + 3.5; // mismo precio para ambos tamaños
    }
    
    @Override
    public String getDescripcion() {
        return sandwich.getDescripcion() + " + Postre ($3.5)";
    }
}