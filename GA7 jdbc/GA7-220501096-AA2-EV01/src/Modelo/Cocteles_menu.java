package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Cocteles_menu {
    private Map<String, Double> cocteles;

    public Cocteles_menu() {
        cocteles = new HashMap<>();
        cargarCoctelesDesdeBD();
    }

    private void cargarCoctelesDesdeBD() {
        // Configuración de la conexión JDBC
        String url = "jdbc:postgresql://localhost:5432/Cocteleria";
        String user = "postgres";
        String password = "Aforismo24";

        // Consulta SQL para seleccionar los cócteles y sus precios desde la tabla "Pedido"
        String sql = "SELECT coctel, precio_unitario FROM \"Pedido\"";



        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Iterar sobre los resultados y agregar los cócteles al mapa
            while (rs.next()) {
                String coctel = rs.getString("coctel");
                double precio = rs.getDouble("precio_unitario");
                cocteles.put(coctel, precio);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los cócteles desde la base de datos: " + e.getMessage());
        }
    }

    // Métodos para agregar, eliminar cócteles, etc.

    public Map<String, Double> getCocteles() {
        return cocteles;
    }

    public void setCocteles(Map<String, Double> cocteles) {
        this.cocteles = cocteles;
    }
}

