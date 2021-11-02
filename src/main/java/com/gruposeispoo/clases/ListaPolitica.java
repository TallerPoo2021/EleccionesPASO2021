package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaPolitica {

    private String nombre;
    private int numero;
    private List<Candidato> diputados;
    private List<Candidato> senadores;
    private Distrito distrito; // tiene
    private PartidoPolitico partidoPolitico; // representa

    /**
     * CONSTRUCTOR
     * 
     */
    public ListaPolitica() {
        nombre = "";
        numero = 0;
        diputados = new ArrayList<>();
        senadores = new ArrayList<>();
        distrito = null;
        partidoPolitico = null;
    }

    
    /**
     * CONSTRUCTOR
     *
     *
     * @param nombre
     * @param numero
     * @param diputados
     * @param senadores
     * @param distrito
     * @param partidoPolitico
     */
    public ListaPolitica(String nombre, int numero, List<Candidato> diputados,
            List<Candidato> senadores, Distrito distrito, PartidoPolitico partidoPolitico) {
        this();
        
        if (nombre == null || nombre.isBlank() || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre Ingresado No Valido");
        }
        
        this.nombre = nombre;
        this.numero = numero;
        this.diputados = diputados;
        this.senadores = senadores;
        this.distrito = distrito;
        this.partidoPolitico = partidoPolitico;
        this.distrito.agregarListaPolitica(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Candidato> getDiputados() {
        return diputados;
    }

    public void setDiputados(List<Candidato> diputados) {
        this.diputados = diputados;
    }

    public List<Candidato> getSenadores() {
        return senadores;
    }

    public void setSenadores(List<Candidato> senadores) {
        this.senadores = senadores;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ListaPolitica other = (ListaPolitica) obj;
        return Objects.equals(nombre, other.nombre) && numero == other.numero;
    }

    @Override
    public String toString() {
        return "\n\tListaPolitica: " + "\n\t\tnombre=" + nombre + "\n\t\tnumero=" + numero + "\n\t\tdiputados=" + diputados + "\n\t\tsenadores=" + senadores + "\n\t\tdistrito=" + distrito + "\n\t\tpartidoPolitico=" + partidoPolitico;
    }

    
}
