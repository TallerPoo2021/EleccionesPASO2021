package com.gruposeispoo.clases;


import java.util.ArrayList;
import java.util.List;

public class Seccion implements IContadorVoto {
    private String nombre;
    private List<Circuito> circuitos;
    private Distrito distrito;
    private List<Elector> padron;

    /**
     * Constructor de seccion.
     * @param nombre
     * @param distrito
     * @param padron
     */
    public Seccion(String nombre, Distrito distrito, List<Elector> padron) {
        this.nombre = nombre;
        this.circuitos = new ArrayList<>();
        this.distrito = distrito;
        this.padron = padron;
        distrito.agregarSeccion(this);
    }

    public void agregarCircuito(Circuito circuito){
        circuitos.add(circuito);
    }

    /**
     * Devuelve el nombre de la seccion.
     * @return nombre de la seccion.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre de la seccion.
     * @param nombre, el nuevo nombre de la seccion.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve los circuitos de la seccion.
     * @return los circuitos que pertenecen a esta seccion.
     */
    public List<Circuito> getCircuitos() {
        return circuitos;
    }

    /**
     * Devuelve el distrito de la seccion.
     * @return el distrito al que pertenece.
     */
    public Distrito getDistrito() {
        return distrito;
    }

    /**
     * Cuenta la cantidad de votos en blanco.
     * @return cantidad de votos en blancos totales.
     */
    @Override
    public int contarVotosBlanco() {
        int contador = 0;
        for (Circuito circuito : circuitos) {
            contador += circuito.contarVotosBlanco();
        }
        return contador;
    }

    /**
     * Cuenta la cantidad de votos en blanco del tipo de candidato que se le pase.
     * @param tipoCandidato, El tipo de candidato que es (senador o diputado).
     * @return devuelve la cantidad de votos en blanco de este tipo de candidato.
     */
    @Override
    public int contarVotosBlanco(TipoCandidato tipoCandidato) {
        int contador = 0;
        for (Circuito circuito : circuitos) {
            contador += circuito.contarVotosBlanco(tipoCandidato);
        }
        return contador;
    }

    /**
     * Cuenta los votos de este candidato.
     * @param candidato, referencia de la persona postulada a un cargo.
     * @return cantidad de votos hacia la persona enviada.
     */
    @Override
    public int contarVotos(Candidato candidato) {
        int contador = 0;
        for (Circuito circuito : circuitos) {
            contador += circuito.contarVotos(candidato);
        }
        return contador;
    }

    /**
     * Cuenta los votos de esta lista politica.
     * @param listaPolitica, lista politica de la cual se quiere saber los votos que obtuvo.
     * @return la cantidad de votos que recibió la lista.
     */
    @Override
    public int contarVotos(ListaPolitica listaPolitica) {
        int contador = 0;
        for (Circuito circuito : circuitos) {
            contador += circuito.contarVotos(listaPolitica);
        }
        return contador;
    }

    /**
     * Cuenta los votos totales.
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
