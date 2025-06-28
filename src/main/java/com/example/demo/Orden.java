package com.example.demo;
import java.util.ArrayList;
import java.util.List;

// Clase para manejar la orden completa
public class Orden {
    private List<Sandwich> sandwiches;
    
    public Orden() {
        this.sandwiches = new ArrayList<>();
    }
    
    public void agregarSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }
    
    public double getTotal() {
        return sandwiches.stream().mapToDouble(Sandwich::getPrecio).sum();
    }
    
    public String getDetalle() {
        StringBuilder detalle = new StringBuilder();
        detalle.append("==================================================================");
        
        for (Sandwich sandwich : sandwiches) {
            detalle.append(sandwich.getDescripcion())
                   .append(" PRECIO $")
                   .append(String.format("%.1f", sandwich.getPrecio()))
                   .append("");
        }
        
        detalle.append("==================================================================");
        detalle.append("TOTAL $").append(String.format("%.1f", getTotal()));
        
        return detalle.toString();
    }
    
    public List<Sandwich> getSandwiches() {
        return new ArrayList<>(sandwiches);
    }
    
    public void limpiar() {
        sandwiches.clear();
    }
}