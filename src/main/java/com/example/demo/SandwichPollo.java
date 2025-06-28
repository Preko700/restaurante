package com.example.demo;
public class SandwichPollo extends Sandwich {
    public SandwichPollo(int tamaño) {
        this.nombre = "Pollo";
        this.tamaño = tamaño;
    }
    
    @Override
    public double getPrecio() {
        return tamaño == 15 ? 12.0 : 16.0;
    }
    
    @Override
    public String getDescripcion() {
        return nombre + " de " + tamaño + " cm";
    }
}