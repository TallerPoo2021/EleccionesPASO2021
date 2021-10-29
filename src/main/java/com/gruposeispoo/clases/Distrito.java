package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;

public class Distrito implements IContadorVoto {
	private int MAX_SENADORES;
	private int MAX_DIPUTADOS;
	private String nombre;
	private List<Seccion> secciones;
	private List<Elector> padron;
	private List<ListaPolitica> listasPoliticas;

	/**
	 * Constructor parametrizado
	 * 
	 * @param MAX_SENADORES
	 * @param MAX_DIPUTADOS
	 * @param nombre
	 * @param listasPoliticas
	 * 
	 * @author Kevin
	 */
	/*
	public Distrito(int MAX_SENADORES, int MAX_DIPUTADOS, String nombre,
			List<ListaPolitica> listasPoliticas) {
		this.MAX_SENADORES = MAX_SENADORES;
		this.MAX_DIPUTADOS = MAX_DIPUTADOS;
		this.nombre = nombre;
		this.secciones = new ArrayList<>();
		for (ListaPolitica listaPolitica : listasPoliticas) {
			if (listaPolitica.getDiputados().size() > MAX_DIPUTADOS
					|| listaPolitica.getSenadores().size() > MAX_SENADORES) {
				listasPoliticas.remove(listaPolitica);
				System.out.println("La lista " + listaPolitica.getNombre()
						+ " excede la cantidad de senadores y/o diputados posibles para este distrito por lo tanto fue removido.");
			}
		}
		this.listasPoliticas = listasPoliticas;
	}*/

	/**
	 * Se debe agregar las secciones aparte via agregarSeccion(Seccion seccion)
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
		for (ListaPolitica listaPolitica : listasPoliticas) {
			if (listaPolitica.getDiputados().size() > MAX_DIPUTADOS
					|| listaPolitica.getSenadores().size() > MAX_SENADORES) {
				listasPoliticas.remove(listaPolitica);
				System.out.println("La lista " + listaPolitica.getNombre()
						+ " excede la cantidad de senadores y/o diputados posibles para este distrito por lo tanto fue removido.");
			}
		}
		this.listasPoliticas = listasPoliticas;
	}

	public void agregarSeccion(Seccion seccion) {
		secciones.add(seccion);
	}

	public void agregarListaPolitica(ListaPolitica listaPolitica){
		listasPoliticas.add(listaPolitica);
	}

	@Override
	public int contarVotosBlanco() {
		int contador = 0;
		for (Seccion seccion : secciones) {
			contador += seccion.contarVotosBlanco();
		}
		return contador;
	}

	@Override
	public int contarVotosBlanco(TipoCandidato tipoCandidato) {
		int contador = 0;
		for (Seccion seccion : secciones) {
			contador += seccion.contarVotosBlanco(tipoCandidato);
		}
		return contador;
	}

	@Override
	public int contarVotos(Candidato candidato) {
		int contador = 0;
		for (Seccion seccion : secciones) {
			contador += seccion.contarVotos(candidato);
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

	/**
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

	public int getMAX_SENADORES() {
		return MAX_SENADORES;
	}

	public int getMAX_DIPUTADOS() {
		return MAX_DIPUTADOS;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Seccion> getSecciones() {
		return secciones;
	}

	public List<Elector> getPadron() {
		return padron;
	}

	public List<ListaPolitica> getListasPoliticas() {
		return listasPoliticas;
	}
}
