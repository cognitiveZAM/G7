package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VistaGestionDePedidos extends JFrame {
    private JComboBox<String> comboBoxCocteles;
    private JTextField txtCantidad;
    private JTextArea txtPedidos;
    private JTextField txtEliminarPedido;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnEliminarTodo;
    private JButton btnEnviarPedido;
    private JTextField txtTotal;
    private Controlador controlador;
    private Map<String, Double> cocteles; // Mapa de cocteles
    private Map<Integer, String> indicePedidos; // Mapa de índices de pedidos

    private int indiceActual = 1; // Índice actual para los pedidos

    public VistaGestionDePedidos(Map<String, Double> cocteles, Controlador controlador) {
        this.cocteles = cocteles; // Asignar el mapa de cocteles
        this.controlador = controlador;
        setTitle("Gestión de Pedidos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 350); // Cambiar el tamaño de la ventana

        indicePedidos = new HashMap<>(); // Inicializar el mapa de índices de pedidos

        initComponents(); // Inicializar componentes

        // Usar BorderLayout para organizar los componentes
        setLayout(new BorderLayout());

        // Panel para colocar los componentes en el centro con espaciado
        JPanel panelCenter = new JPanel(new GridLayout(7, 2, 5, 5)); // Espacio entre filas y columnas
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacio alrededor del panel
        add(panelCenter, BorderLayout.CENTER);

        panelCenter.add(new JLabel("Coctel:"));
        panelCenter.add(comboBoxCocteles);
        panelCenter.add(new JLabel("Cantidad:"));
        panelCenter.add(txtCantidad);
        panelCenter.add(btnAgregar);
        panelCenter.add(btnEliminar);
        panelCenter.add(btnEliminarTodo);
        panelCenter.add(btnEnviarPedido);
        panelCenter.add(new JLabel("Pedidos:"));
        panelCenter.add(new JScrollPane(txtPedidos)); // Agregar área de texto en un JScrollPane
        panelCenter.add(new JLabel("Número de pedido a eliminar:"));
        panelCenter.add(txtEliminarPedido);
        panelCenter.add(new JLabel("Total:"));
        panelCenter.add(txtTotal);

        setVisible(true);
    }

    private void initComponents() {
        comboBoxCocteles = new JComboBox<>();
        for (String coctel : cocteles.keySet()) { // Iterar sobre las claves del mapa de cocteles
            comboBoxCocteles.addItem(coctel);
        }
        txtCantidad = new JTextField(5);
        txtPedidos = new JTextArea(5, 20); // Área de texto para mostrar los pedidos
        txtPedidos.setEditable(false); // Hacer el área de texto no editable
        txtEliminarPedido = new JTextField(5); // Caja de texto para ingresar el número de pedido a eliminar
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnEliminarTodo = new JButton("Eliminar Todo");
        btnEnviarPedido = new JButton("Enviar Pedido");
        txtTotal = new JTextField(10);
        txtTotal.setEditable(false);

        btnAgregar.addActionListener(e -> agregarPedido());
        btnEliminar.addActionListener(e -> eliminarPedido());
        btnEliminarTodo.addActionListener(e -> eliminarTodosLosPedidos());
        btnEnviarPedido.addActionListener(e -> enviarPedido());
    }

    private void agregarPedido() {
        String coctel = comboBoxCocteles.getSelectedItem().toString();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        double precioUnitario = cocteles.get(coctel); // Obtener precio del mapa de cocteles

        // Agregar el pedido al mapa de índices de pedidos
        indicePedidos.put(indiceActual, coctel);

        // Actualizar el área de texto con los pedidos actuales
        actualizarPedidos();

        // Calcular el total y mostrarlo
        calcularTotal();

        indiceActual++; // Incrementar el índice para el próximo pedido
    }

    private void eliminarPedido() {
        int numeroPedido = Integer.parseInt(txtEliminarPedido.getText()); // Obtener el número de pedido a eliminar
        if (indicePedidos.containsKey(numeroPedido)) {
            indicePedidos.remove(numeroPedido); // Eliminar el pedido del mapa de índices de pedidos
            // Actualizar el área de texto con los pedidos actuales
            actualizarPedidos();
            // Calcular el total y mostrarlo
            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(this, "El número de pedido ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarTodosLosPedidos() {
        indicePedidos.clear(); // Limpiar todos los pedidos del mapa de índices
        txtPedidos.setText(""); // Limpiar el área de texto

        // Calcular el total y mostrarlo
        calcularTotal();
    }

    private void actualizarPedidos() {
        // Construir una cadena con los pedidos para mostrar en el área de texto
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : indicePedidos.entrySet()) {
            int numeroPedido = entry.getKey();
            String coctel = entry.getValue();
            double precioUnitario = cocteles.get(coctel);
            builder.append(numeroPedido).append(": ").append(coctel).append(" (Precio unitario: $").append(precioUnitario).append(")\n");
        }
        txtPedidos.setText(builder.toString()); // Mostrar los pedidos en el área de texto
    }

    private void calcularTotal() {
        double total = 0;
        for (Map.Entry<Integer, String> entry : indicePedidos.entrySet()) {
            String coctel = entry.getValue();
            double precioUnitario = cocteles.get(coctel);
            total += precioUnitario;
        }
        txtTotal.setText(String.valueOf(total)); // Mostrar el total en el campo de texto
    }

    private void enviarPedido() {
        // Implementar lógica para enviar el pedido a la base de datos
        // Aquí se podría llamar al método del controlador para enviar el pedido
        // y luego limpiar la interfaz o mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(this, "Pedido enviado a la base de datos", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
