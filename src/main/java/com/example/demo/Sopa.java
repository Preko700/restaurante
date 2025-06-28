package com.example.demo;
public class Sopa extends AdicionalDecorator {
    public Sopa(Sandwich sandwich) {
        super(sandwich);
    }
    
    @Override
    public double getPrecio() {
        return sandwich.getPrecio() + 4.2; // mismo precio para ambos tamaños
    }
    
    @Override
    public String getDescripcion() {
        return sandwich.getDescripcion() + " + Sopa ($4.2)";
    }
}