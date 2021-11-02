package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;

public class Circuito implements IContadorVoto {
    private String nombre;
    private int numeracion;
    private List<MesaElectoral> listaMesas;
    private Seccion seccion;
    private List<Voto> votosCircuito;

    /**
     * Constructor de Circuito.
     *
     * @param nombre, nombre del circuito.
     * @param numeracion, numero del circuito.
     * @param seccion, referencia a la seccion que pertenece el circuito.
     * @throws Exception Ocurre cuando no le envian ninguna mesa para poner a su cargo.
     */
    public Circuito(String nombre, int numeracion, Seccion seccion) throws Exception {
        if (listaMesas.isEmpty()) throw new Exception("Debe haber al menos una mesa.");
        this.nombre = nombre;
        this.numeracion = numeracion;
        this.listaMesas = new ArrayList<>();
        this.seccion = seccion;
        this.votosCircuito = new ArrayList<>();
        seccion.agregarCircuito(this);
    }

    /**
     * Agrega una mesa electoral.
     * @param mesaElectoral, agrega una mesa electoral.
     */
    public void agregarMesa(MesaElectoral mesaElectoral){
        listaMesas.add(mesaElectoral);
    }

    /**
     * Devuelve la seccion a la que pertenece el circuito.
     * @return la seccion del circuito.
     */
    public Seccion getSeccion() {
        return seccion;
    }

    /**
     * Metodo para procesar un voto.
     * @param voto, ingresa la referencia del voto que se creó a la hora que lo emite el Elector.
     * @throws Exception Ocurre cuando la referencia es nula, cuando el elector no debe votar en la mesa o cuando esta persona ya votó.
     */
    public void agregarVoto(Voto voto) throws Exception {
        if (voto == null) throw new NullPointerException();
        if (!listaMesas.contains(voto.getElector().getMesaElectoral())) throw new Exception("Este elector no vota en esta mesa.");
        if (votosCircuito.contains(voto)) throw new Exception("La persona DNI Nº " + voto.getElector().getId() + " ya votó.");
        votosCircuito.add(voto);
    }

    /**
     * Devuelve la lista de votos del circuito.
     * @return Una lista con los votos en el circuito.
     */
    public List<Voto> getVotosCircuito() {
        return votosCircuito;
    }

    /**
     * Devuelve las mesas electorales del circuito.
     * @return Una lista del tipo MesaElectoral, la cuales pertencecen al circuito.
     */
    public List<MesaElectoral> getListaMesas() {
        return listaMesas;
    }

    /**
     * Devuelve el nombre del circuito.
     * @return el nombre del circuito.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del circuito.
     * @param nombre, nuevo nombre del circuito.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el numero del circuito.
     * @return numero del circuito.
     */
    public int getNumeracion() {
        return numeracion;
    }

    /**
     * Cambia el numero del circuito.
     * @param numeracion, nuevo numero del circuito.
     */
    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    /**
     * Cuenta la cantidad de votos en blanco.
     * @return cantidad de votos en blancos totales.
     */
    @Override
    public int contarVotosBlanco(){
        int contador = 0;
        for (Voto voto : votosCircuito) {
            if (voto.getSenadores() == null && voto.getDiputados() == null) contador++;
        }
        return contador;
    }

    /**
     * Cuenta la cantidad de votos en blanco del tipo de candidato que se le pase.
     * @param tipoCandidato, El tipo de candidato que es (senador o diputado).
     * @return devuelve la cantidad de votos en blanco de este tipo de candidato.
     */
    @Override
    public int contarVotosBlanco(TipoCandidato tipoCandidato){
        int contador = 0;
        for (Voto voto : votosCircuito) {
            if (tipoCandidato == TipoCandidato.SENADOR && voto.getSenadores() == null) contador++;
            if (tipoCandidato == TipoCandidato.DIPUTADO && voto.getDiputados() == null) contador++;
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
        for (Voto voto : votosCircuito) {
            if ((voto.getSenadores() != null && voto.getSenadores().contains(candidato)) || (voto.getDiputados() != null && voto.getDiputados().contains(candidato))) contador++;
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
        for (Voto voto : votosCircuito) {
            if (voto.obtenerListasPoliticas().contains(listaPolitica)){
                contador++;
            }
        }
        return contador;
    }

    /**
     * Cuenta los votos totales.
     * @return cantidad de votos generales.
     */
    @Override
    public int contarVotos() {
        return votosCircuito.size();
    }
}