package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;


public class Admin {

	private static List<ListaPolitica> todasLasListasPoliticas;
	private static List<Elector> todosLosElectoresDelPadron;

	/**
	 * CONSTRUCTOR
	 *
	 */
	public Admin() {
		todasLasListasPoliticas = new ArrayList<>();
		todosLosElectoresDelPadron = new ArrayList<>();
	}

	/**
	 * Generador de electores
	 * 
	 * @return List<>, electores generados
	 */
	public static List<Elector> generarElectores() {
		LeerArchivos lector = new LeerArchivos();

		todosLosElectoresDelPadron = lector.leerPadronElectores("csv\\Padron.csv");

		return todosLosElectoresDelPadron;
	}

	/**
	 * Generador de listas politicas
	 *
	 * @return List<>, listas politicas generadas
	 */
	public static List<ListaPolitica> generaListas() {
		List<ListaPolitica> listListasPoliticas;

		Distrito corrientes = new Distrito(3, 3, "Corrientes", null,
				listListasPoliticas = new ArrayList<>());
		/*
		 * 
		 * CREACION DE CANDIDATOS (DIPUTADOS/SENADORES)
		 */
		// Senadores
		List<Candidato> senCorrienteAccionCorriente = new ArrayList<Candidato>();

		senCorrienteAccionCorriente
				.add(new Candidato("Jorge Americo", "Parthimos", TipoCandidato.SENADOR));
		senCorrienteAccionCorriente
				.add(new Candidato("Mirta Teresa", "Toffaleti", TipoCandidato.SENADOR));

		List<Candidato> senCorrienteFrenteDeTodos = new ArrayList<Candidato>();

		senCorrienteFrenteDeTodos.add(new Candidato("Alejandro", "Karlen", TipoCandidato.SENADOR));
		senCorrienteFrenteDeTodos
				.add(new Candidato("Nieve de los Angeles", "Cuenca", TipoCandidato.SENADOR));

		// Diputados
		List<Candidato> dipuCorrientesAccionCorriente = new ArrayList<Candidato>();

		dipuCorrientesAccionCorriente
				.add(new Candidato("Anibal Daniel", "Godoy", TipoCandidato.DIPUTADO));
		dipuCorrientesAccionCorriente
				.add(new Candidato("Leticia Maria", "Caminos", TipoCandidato.DIPUTADO));
		dipuCorrientesAccionCorriente
				.add(new Candidato("Jose Fernando", "Novello", TipoCandidato.DIPUTADO));

		List<Candidato> dipuCorrientesfrenteDeTodos = new ArrayList<Candidato>();
		dipuCorrientesfrenteDeTodos
				.add(new Candidato("Jorge Gustavo", "Silva", TipoCandidato.DIPUTADO));
		dipuCorrientesfrenteDeTodos.add(new Candidato("Lilian", "Caruso", TipoCandidato.DIPUTADO));
		dipuCorrientesfrenteDeTodos
				.add(new Candidato("Alfredo Alejandro", "Moline", TipoCandidato.DIPUTADO));

//		CREACION DE PARTIDOS/COALICIONES POLITICAS
		PartidoPolitico accionCorrentina = new PartidoPolitico("Accion Correntina");
		PartidoPolitico frenteDeTodos = new PartidoPolitico("Frente de Todos");

//		CREACION DE LISTAS POLITICAS
		ListaPolitica compromisoFederal = new ListaPolitica("Compromiso Federal", 82,
				dipuCorrientesAccionCorriente, senCorrienteAccionCorriente, corrientes,
				accionCorrentina);

		listListasPoliticas.add(compromisoFederal);

		ListaPolitica todos = new ListaPolitica("Todos", 501, dipuCorrientesfrenteDeTodos,
				senCorrienteFrenteDeTodos, corrientes, frenteDeTodos);

		listListasPoliticas.add(todos);

		todasLasListasPoliticas.add(compromisoFederal);
		todasLasListasPoliticas.add(todos);
		return todasLasListasPoliticas;
	}

	/**
	 * Metodo que devuelve una lista con todos los diputados de todas las listas.
	 *
	 * @return List<Candidato>, lista de diputados
	 *
	 */
	public static List<Candidato> generarListaDiputadosTotales() {

		List<ListaPolitica> listasPolitias = generaListas();
		List<Candidato> diputadosList = new ArrayList<Candidato>();

		for (ListaPolitica listaPolitica : listasPolitias) {
			for (Candidato dipu : listaPolitica.getDiputados()) {
				diputadosList.add(dipu);
			}
		}

		return diputadosList;
	}

	/**
	 * Metodo que devuelve una lista con todos los senadores de todas las listas.
	 *
	 * @return List<Candidato>, lista de senadores
	 *
	 */
	public static List<Candidato> generarListaSenadoresTotales() {

		List<ListaPolitica> listasPolitias = generaListas();
		List<Candidato> senadoresList = new ArrayList<Candidato>();

		for (ListaPolitica listaPolitica : listasPolitias) {
			for (Candidato senador : listaPolitica.getSenadores()) {
				senadoresList.add(senador);
			}
		}

		return senadoresList;
	}
}
