package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;

public class Circuito implements IContadorVoto {
    private String nombre;
    private int numeracion;
    private List<MesaElectoral> listaMesas;
    private Seccion seccion;
    private List<Voto> votosCircuito;

    public Circuito(String nombre, int numeracion, List<MesaElectoral> listaMesas, Seccion seccion) throws Exception {
        if (listaMesas.isEmpty()) throw new Exception("Debe haber al menos una mesa.");
        this.nombre = nombre;
        this.numeracion = numeracion;
        this.listaMesas = listaMesas;
        this.seccion = seccion;
        this.votosCircuito = new ArrayList<>();
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void agregarVoto(Voto voto) throws Exception {
        if(voto == null) throw new NullPointerException();
        if (votosCircuito.contains(voto)) throw new Exception("La persona DNI Nº " + voto.getElector().getDNI() + " ya votó.");
        votosCircuito.add(voto);
    }

    public List<Voto> getVotosCircuito() {
        return votosCircuito;
    }

    public List<MesaElectoral> getListaMesas() {
        return listaMesas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    @Override
    public int contarVotos() {
        return votosCircuito.size();
    }

    @Override
    public int contarVotos(ListaPolitica listaPolitica) {
        int contador = 0;
        for (Voto voto : votosCircuito) {
            if (voto.getListasVotadas().contains(listaPolitica)) contador++;
        }
        return contador;
    }
}
