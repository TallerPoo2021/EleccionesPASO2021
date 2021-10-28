package com.gruposeispoo.clases;

import java.time.LocalDate;

/**
 *
 * Representa a un candidato ( senador o diputado ), que a su vez es un elector
 * y que pertenece a un partido politico ( o alianza ) y es representado
 * mediante una lista
 *
 */
public class Candidato extends Elector {

    private TipoCandidato tipoCandidato;
    private ListaPolitica listaPolitica;

    /**
     * Contructor parametrizado
     *
     * @author Kevin
     *
     */
    public Candidato(String nombre, String apellido, TipoCandidato tipoCandidato) {
        super(nombre, apellido, null);
        this.tipoCandidato = tipoCandidato;
    }

    /**
     * Constructor parametrizado
     *
     *
     * @param tipoCandidato, el tipo de candidato de este candidato
     */
    public Candidato(TipoCandidato tipoCandidato) {
        super();
        if (tipoCandidato == null) {
            throw new IllegalArgumentException("Tipo de Candidato inv�lido");
        }
        this.tipoCandidato = tipoCandidato;
    }

    /**
     * Constructor parametrizado
     *
     *
     * @param tipoCandidato, el tipo de candidato de este candidato
     * @param listaPolitica, la lista donde esta representado el candidato
     * @param nombre, el nombre de este candidato
     * @param apellido, el apellido de este candidato
     * @param fechaNac, la fecha de nacimiento de este candidato
     */
    public Candidato(TipoCandidato tipoCandidato, ListaPolitica listaPolitica, String nombre,
            String apellido, LocalDate fechaNac) {
        super(nombre, apellido, fechaNac);
        this.tipoCandidato = tipoCandidato;
        this.listaPolitica = listaPolitica;
    }

    /**
     * Constructor parametrizado
     *
     *
     * @param tipoCandidato, el tipo de candidato de este candidato
     * @param listaPolitica, la lista donde esta representado el candidato
     * @param nombre, el nombre de este candidato
     * @param apellido, el apellido de este candidato
     * @param DNI, el tipo de dni del candidato
     * @param fechaNac, la fecha de nacimiento de este candidato
     * @param domicilio, el domicilio del candidato
     */
    public Candidato(TipoCandidato tipoCandidato, ListaPolitica listaPolitica, String nombre,
            String apellido, TipoDocumento DNI, LocalDate fechaNac, Domicilio domicilio) {
        super(nombre, apellido, fechaNac, DNI, domicilio);
        this.tipoCandidato = tipoCandidato;
        this.listaPolitica = listaPolitica;
    }

    /**
     *
     * @return TipoCandidato, el tipo de este candidato
     */
    public TipoCandidato getTipoCandidato() {
        return tipoCandidato;
    }

    /**
     *
     * @param tipoCandidato, el tipo de candidato a setear
     */
    public void setTipoCandidato(TipoCandidato tipoCandidato) {
        this.tipoCandidato = tipoCandidato;
    }

    /**
     *
     * @return ListaPolitica, lista politica donde esta representado este
     * candidato
     */
    public ListaPolitica getListaPolitica() {
        return listaPolitica;
    }

    /**
     *
     * @param listaPolitica, la lista politica a setear
     */
    public void setListaPolitica(ListaPolitica listaPolitica) {
        this.listaPolitica = listaPolitica;
    }

    @Override
    public String toString() {
        return "Candidato a " + tipoCandidato + " " + super.toString();
    }

}
