package com.example.demo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteGUI extends JFrame {
    private Orden orden;
    private JComboBox<String> tipoSandwich;
    private JComboBox<String> tamañoSandwich;
    private JCheckBox[] adicionales;
    private JTextArea detalleOrden;
    private JLabel totalLabel;
    private Sandwich sandwichActual;
    
    private String[] tiposSandwich = {"Pavo", "Beef", "Pollo"};
    private String[] tamaños = {"15 cm", "30 cm"};
    private String[] nombresAdicionales = {"Aguacate", "Doble Proteína", "Hongos", "Refresco", "Sopa", "Postre"};
    
    public RestauranteGUI() {
        orden = new Orden();
        initializeComponents();
        setupLayout();
        setupEventListeners();
    }
    
    private void initializeComponents() {
        setTitle("Restaurante - Sistema de Pedidos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        tipoSandwich = new JComboBox<>(tiposSandwich);
        tamañoSandwich = new JComboBox<>(tamaños);
        
        adicionales = new JCheckBox[nombresAdicionales.length];
        for (int i = 0; i < nombresAdicionales.length; i++) {
            adicionales[i] = new JCheckBox(nombresAdicionales[i]);
        }
        
        detalleOrden = new JTextArea(15, 40);
        detalleOrden.setEditable(false);
        detalleOrden.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        totalLabel = new JLabel("Total: $0.0");
        totalLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Panel superior - Configuración del sándwich
        JPanel configPanel = new JPanel(new GridBagLayout());
        configPanel.setBorder(BorderFactory.createTitledBorder("Configurar Sándwich"));
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.insets = new Insets(5, 5, 5, 5);
        configPanel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        configPanel.add(tipoSandwich, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        configPanel.add(new JLabel("Tamaño:"), gbc);
        gbc.gridx = 1;
        configPanel.add(tamañoSandwich, gbc);
        
        // Panel de adicionales
        JPanel adicionalesPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        adicionalesPanel.setBorder(BorderFactory.createTitledBorder("Adicionales"));
        for (JCheckBox adicional : adicionales) {
            adicionalesPanel.add(adicional);
        }
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        configPanel.add(adicionalesPanel, gbc);
        
        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton agregarButton = new JButton("Agregar Sándwich");
        JButton nuevaOrdenButton = new JButton("Nueva Orden");
        JButton salirButton = new JButton("Salir");
        
        buttonPanel.add(agregarButton);
        buttonPanel.add(nuevaOrdenButton);
        buttonPanel.add(salirButton);
        
        gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        configPanel.add(buttonPanel, gbc);
        
        // Panel derecho - Detalle de la orden
        JPanel detallePanel = new JPanel(new BorderLayout());
        detallePanel.setBorder(BorderFactory.createTitledBorder("Detalle de la Orden"));
        detallePanel.add(new JScrollPane(detalleOrden), BorderLayout.CENTER);
        detallePanel.add(totalLabel, BorderLayout.SOUTH);
        
        add(configPanel, BorderLayout.WEST);
        add(detallePanel, BorderLayout.CENTER);
        
        // Setup event listeners
        agregarButton.addActionListener(e -> agregarSandwich());
        nuevaOrdenButton.addActionListener(e -> nuevaOrden());
        salirButton.addActionListener(e -> System.exit(0));
    }
    
    private void setupEventListeners() {
        // Actualizar vista previa cuando cambie la configuración
        ActionListener actualizarVista = e -> actualizarVistaPrevia();
        tipoSandwich.addActionListener(actualizarVista);
        tamañoSandwich.addActionListener(actualizarVista);
        
        for (JCheckBox adicional : adicionales) {
            adicional.addActionListener(actualizarVista);
        }
        
        actualizarVistaPrevia(); // Inicializar vista
    }
    
    private void actualizarVistaPrevia() {
        // Crear sándwich base
        String tipo = (String) tipoSandwich.getSelectedItem();
        int tamaño = tamañoSandwich.getSelectedIndex() == 0 ? 15 : 30;
        
        sandwichActual = crearSandwichBase(tipo, tamaño);
        
        // Agregar adicionales seleccionados
        for (int i = 0; i < adicionales.length; i++) {
            if (adicionales[i].isSelected()) {
                sandwichActual = aplicarAdicional(sandwichActual, i);
            }
        }
        
        actualizarDisplay();
    }
    
    private Sandwich crearSandwichBase(String tipo, int tamaño) {
        switch (tipo) {
            case "Pavo": return new SandwichPavo(tamaño);
            case "Beef": return new SandwichBeef(tamaño);
            case "Pollo": return new SandwichPollo(tamaño);
            default: return new SandwichPavo(tamaño);
        }
    }
    
    private Sandwich aplicarAdicional(Sandwich sandwich, int indiceAdicional) {
        switch (indiceAdicional) {
            case 0: return new Aguacate(sandwich);
            case 1: return new DobleProteina(sandwich);
            case 2: return new Hongos(sandwich);
            case 3: return new Refresco(sandwich);
            case 4: return new Sopa(sandwich);
            case 5: return new Postre(sandwich);
            default: return sandwich;
        }
    }
    
    private void agregarSandwich() {
        if (sandwichActual != null) {
            orden.agregarSandwich(sandwichActual);
            actualizarDisplay();
            
            // Limpiar selecciones para el próximo sándwich
            for (JCheckBox adicional : adicionales) {
                adicional.setSelected(false);
            }
            actualizarVistaPrevia();
        }
    }
    
    private void nuevaOrden() {
        orden.limpiar();
        for (JCheckBox adicional : adicionales) {
            adicional.setSelected(false);
        }
        actualizarVistaPrevia();
        actualizarDisplay();
    }
    
    private void actualizarDisplay() {
        detalleOrden.setText(orden.getDetalle());
        totalLabel.setText("Total: $" + String.format("%.1f", orden.getTotal()));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new RestauranteGUI().setVisible(true);
        });
    }
}