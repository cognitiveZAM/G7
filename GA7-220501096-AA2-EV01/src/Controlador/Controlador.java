package Controlador;

import Modelo.Cocteles_menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Controlador {
    private Cocteles_menu menu;
    private Connection conexion;
    public Controlador(Cocteles_menu menu) {
        this.menu = menu;
        establecerConexion();
    }
    private void establecerConexion() {
        String url = "jdbc:postgresql://localhost:5432/Cocteleria";
        String usuario = "postgres";
        String contraseña = "Aforismo24";
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión establecida correctamente");
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión con la base de datos");
            e.printStackTrace();
        }
    }

    public Cocteles_menu getMenu() {
        return menu;
    }

    public void agregarPedido(String coctel, int cantidad, double total) {
        // Implementar lógica para agregar el pedido al sistema
        System.out.println("Pedido agregado: " + cantidad + " " + coctel + " Total: " + total);
    }

    public void eliminarPedido(String coctel) {
        // Implementar lógica para eliminar un pedido específico
        System.out.println("Pedido eliminado: " + coctel);
    }

    public void eliminarTodosLosPedidos() {
        // Implementar lógica para eliminar todos los pedidos
        System.out.println("Todos los pedidos eliminados");
    }

    public void enviarPedido(List<String> pedidos) {
        // Implementar lógica para enviar el pedido a la base de datos
        // Aquí se podría llamar a un método de la capa de acceso a datos (DAO) para guardar los pedidos
        System.out.println("Pedido enviado a la base de datos");
    }
}
