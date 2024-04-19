package Controlador;

import Modelo.Barra;
import Modelo.Cocteles_menu;
import Modelo.Mesa;
import Vista.VistaGestionDePedidos;
import Controlador.Controlador;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear instancia del menú de cócteles
        Cocteles_menu menu = new Cocteles_menu();

        // Crear instancia del controlador y pasar el menú
        Controlador controlador = new Controlador(menu);

        // Crear instancia de la vista y pasar el controlador
        VistaGestionDePedidos vista = new VistaGestionDePedidos(menu.getCocteles(), controlador);
    }

}

