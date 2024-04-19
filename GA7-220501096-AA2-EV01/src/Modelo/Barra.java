package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Barra {
    private int personalEncargado;
    private List<String> solicitudesPendientes;
    private double totalVentas;

    public Barra(int personalEncargado) {
        this.personalEncargado = personalEncargado;
        this.solicitudesPendientes = new ArrayList<String>();
        this.totalVentas = totalVentas;
    }

    public void recibirSolicitud(String solicitud) {
        solicitudesPendientes.add(solicitud);
        System.out.println("Solicitud recibida: " + solicitud);
    }

    public void prepararCocktail(SolicitudCocktail solicitud) {
        if (solicitudesPendientes.contains(solicitud)) {
            // Lógica para preparar el cóctel
            System.out.println("Preparando cóctel: " + solicitud.getCocktail());
            completarSolicitud(solicitud);
        } else {
            System.out.println("La solicitud no existe en la lista de pendientes.");
        }
    }

    public void completarSolicitud(SolicitudCocktail solicitud) {
        solicitudesPendientes.remove(solicitud);
        System.out.println("Solicitud completada: " + solicitud);
    }

    // Getters y setters según sea necesario

    public int getPersonalEncargado() {
        return personalEncargado;
    }

    public void setPersonalEncargado(int personalEncargado) {
        this.personalEncargado = personalEncargado;
    }

    public List<String> getSolicitudesPendientes() {
        return solicitudesPendientes;
    }

    public void setSolicitudesPendientes(List<String> solicitudesPendientes) {
        this.solicitudesPendientes = solicitudesPendientes;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }
}

class SolicitudCocktail {
    private String cocktail;

    public SolicitudCocktail(String cocktail) {
        this.cocktail = cocktail;
    }

    public String getCocktail() {
        return cocktail;
    }

    public void setCocktail(String cocktail) {
        this.cocktail = cocktail;
    }

    @Override
    public String toString() {
        return "SolicitudCocktail{" +
                "cocktail='" + cocktail + '\'' +
                '}';
    }
}
