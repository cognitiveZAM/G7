package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private int numeroMesa;
    private List<String> pedidos;

    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.pedidos = new ArrayList<>();
    }

    //CRUD
    //CREAR
    public void agregarPedido(String pedido) {
        pedidos.add(pedido);
    }
   //Leer (Obtener pedidos): El método obtenerPedidos devuelve la lista de pedidos actuales de la mesa.
    public void eliminarPedido(String pedido) {
        pedidos.remove(pedido);
    }
    //Actualizar (Eliminar pedido): El método eliminarPedido elimina un pedido específico de la lista de pedidos de la mesa.
    public List<String> obtenerPedidos() {
        return pedidos;
    }
    //Actualizar (Eliminar pedido): El método eliminarPedido elimina un pedido específico de la lista de pedidos de la mesa.
    public void limpiarPedidos() {
        pedidos.clear();
    }

    // Otros métodos según sea necesario

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}




