package com.gruposeispoo.clases;
import java.util.List;

public class Distrito implements IContadorVoto {
    private int MAX_SENADORES;
    private int MAX_DIPUTADOS;
    private String nombre;
    private List<Seccion> secciones;
    private List<Elector> padron;
    private List<ListaPolitica> listasPoliticas;

    public Distrito(int MAX_SENADORES, int MAX_DIPUTADOS, String nombre, List<Seccion> secciones, List<Elector> padron, List<ListaPolitica> listasPoliticas) {
        this.MAX_SENADORES = MAX_SENADORES;
        this.MAX_DIPUTADOS = MAX_DIPUTADOS;
        this.nombre = nombre;
        this.secciones = secciones;
        this.padron = padron;
        this.listasPoliticas = listasPoliticas;
    }

    @Override
    public int contarVotos() {
        int contador = 0;
        for (Seccion seccion : secciones) {
            contador += seccion.contarVotos();
        }
        return contador;
    }

    @Override
    public int contarVotos(ListaPolitica listaPolitica) {
        int contador = 0;
        for (Seccion seccion : secciones) {
            contador += seccion.contarVotos(listaPolitica);
        }
        return contador;
    }
}
