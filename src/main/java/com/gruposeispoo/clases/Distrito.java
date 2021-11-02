package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Distrito implements IContadorVoto {
	private int MAX_SENADORES;
	private int MAX_DIPUTADOS;
	private String nombre;
	private List<Seccion> secciones;
	private List<Elector> padron;
	private List<ListaPolitica> listasPoliticas;

	/**
	 * Constructor del distrito.
	 * Se debe agregar las secciones aparte via agregarSeccion(Seccion seccion)
	 * Se debe agregar las listas politicas aparte via agregarListaPolitica(ListaPolitica listaPolitica)
	 *
	 * @param MAX_SENADORES
	 * @param MAX_DIPUTADOS
	 * @param nombre
	 * @param padron
	 */
	public Distrito(int MAX_SENADORES, int MAX_DIPUTADOS, String nombre, List<Elector> padron) {
		this.MAX_SENADORES = MAX_SENADORES;
		this.MAX_DIPUTADOS = MAX_DIPUTADOS;
		this.nombre = nombre;
		this.secciones = new ArrayList<>();
		this.padron = padron;
		this.listasPoliticas = new ArrayList<>();
	}

	/**
	 * Se agrega una nueva seccion al distrito.
	 * @param seccion, la seccion a agregar.
	 */
	public void agregarSeccion(Seccion seccion) {
		secciones.add(seccion);
	}

	/**
	 * Se agrega una nueva lista politica al distrito.
	 * @param listaPolitica, lista politica a agregar.
	 */
	public void agregarListaPolitica(ListaPolitica listaPolitica){
		listasPoliticas.add(listaPolitica);
	}

	/**
	 * Cuenta la cantidad de votos en blanco.
	 * @return cantidad de votos en blancos totales.
	 */
	@Override
	public int contarVotosBlanco() {
		int contador = 0;
		for (Seccion seccion : secciones) {
			contador += seccion.contarVotosBlanco();
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
		for (Seccion seccion : secciones) {
			contador += seccion.contarVotosBlanco(tipoCandidato);
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
		for (Seccion seccion : secciones) {
			contador += seccion.contarVotos(candidato);
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
		for (Seccion seccion : secciones) {
			contador += seccion.contarVotos(listaPolitica);
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
		for (Seccion seccion : secciones) {
			contador += seccion.contarVotos();
		}
		return contador;
	}

	/**
	 * Devuelve la cantidad de senadores maxima del distrito.
	 * @return la cantidad maxima de senadores.
	 */
	public int getMAX_SENADORES() {
		return MAX_SENADORES;
	}

	/**
	 * Devuelve la cantidad de diputados maxima del distrito.
	 * @return la cantidad maxima de diputados.
	 */
	public int getMAX_DIPUTADOS() {
		return MAX_DIPUTADOS;
	}

	/**
	 * Devuelve el nombre del distrito.
	 * @return el nombre del distrito.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve la cantidad de senadores maxima del distrito.
	 * @return la cantidad maxima de senadores.
	 */
	public List<Seccion> getSecciones() {
		return secciones;
	}

	/**
	 * Devuelve la cantidad de senadores maxima del distrito.
	 * @return la cantidad maxima de senadores.
	 */
	public List<Elector> getPadron() {
		return padron;
	}

	/**
	 * Devuelve las .
	 * @return las listas politicas del distrito.
	 */
	public List<ListaPolitica> getListasPoliticas() {
		return listasPoliticas;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
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
        final Distrito other = (Distrito) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

        
    @Override
    public String toString() {
        return "\n\t\t\tDistrito: " + "\n\t\t\t\tnombre=" + nombre + "\n\t\t\t\tsecciones=" + secciones;
    }
        
        
}
