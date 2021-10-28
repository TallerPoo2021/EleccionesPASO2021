package com.gruposeispoo.clases;


import java.util.List;

public class Seccion implements IContadorVoto {
    private String nombre;
    private List<Circuito> circuitos;
    private Distrito distrito;
    private List<MesaElectoral> mesasElectorales;
    private List<Elector> padron;

    public Seccion(String nombre, List<Circuito> circuitos, Distrito distrito, List<MesaElectoral> mesasElectorales, List<Elector> padron) {
        this.nombre = nombre;
        this.circuitos = circuitos;
        this.distrito = distrito;
        this.mesasElectorales = mesasElectorales;
        this.padron = padron;
    }

    public List<Voto> getTotalVotos(){
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Circuito> getCircuitos() {
        return circuitos;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    @Override
    public int contarVotosBlanco() {
        return 0;
    }

    @Override
    public int contarVotosBlanco(TipoCandidato tipoCandidato) {
        return 0;
    }

    @Override
    public int contarVotos(Candidato candidato) {
        int contador = 0;
        for (Circuito circuito : circuitos) {
            contador += circuito.contarVotos(candidato);
        }
        return contador;
    }

    @Override
    public int contarVotos(ListaPolitica listaPolitica) {
        int contador = 0;
        for (Circuito circuito : circuitos) {
            contador += circuito.contarVotos(listaPolitica);
        }
        return contador;
    }

    /**
     * @return cantidad de votos generales.
     */
    @Override
    public int contarVotos() {
        int contador = 0;
        for (Circuito circuito : circuitos) {
            contador += circuito.contarVotos();
        }
        return contador;
    }
}
