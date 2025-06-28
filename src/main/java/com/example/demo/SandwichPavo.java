package com.example.demo;
public class SandwichPavo extends Sandwich {
    public SandwichPavo(int tamaño) {
        this.nombre = "Pavo";
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