package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.jfree.data.general.AbstractSeriesDataset;

public class Admin {

	private static List<Elector> todosLosElectoresDelPadron;

	/**
	 * CONSTRUCTOR
	 *
	 */
	public Admin() {
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
		List<ListaPolitica> todasLasListasPoliticas = new ArrayList<>();

		// Distritos
		List<ListaPolitica> listasPoliticasEntreRios;
		List<ListaPolitica> listasPoliticasCorrientes;
		List<ListaPolitica> listasPoliticasSantaFe;
		List<ListaPolitica> listasPoliticasMendoza;
		List<ListaPolitica> listasPoliticasSalta;
		List<ListaPolitica> listasPoliticasCordoba;
		Distrito entreRios = new Distrito(0, 0, null, listasPoliticasEntreRios = new ArrayList<>());
		Distrito corrientes = new Distrito(3, 3, "Corrientes",
				listasPoliticasCorrientes = new ArrayList<>());
		Distrito santaFe = new Distrito(0, 0, null, listasPoliticasSantaFe = new ArrayList<>());
		Distrito mendoza = new Distrito(0, 0, null, listasPoliticasMendoza = new ArrayList<>());
		Distrito salta = new Distrito(0, 0, null, listasPoliticasSalta = new ArrayList<>());
		Distrito cordoba = new Distrito(0, 0, null, listasPoliticasCordoba = new ArrayList<>());

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
		List<Candidato> dipuEntreRiosPodemosEntreRios = new ArrayList<Candidato>();
		dipuEntreRiosPodemosEntreRios.add(new Candidato("", "", TipoCandidato.DIPUTADO));
		dipuEntreRiosPodemosEntreRios.add(new Candidato("", "", TipoCandidato.DIPUTADO));
		dipuEntreRiosPodemosEntreRios.add(new Candidato("", "", TipoCandidato.DIPUTADO));

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
		ListaPolitica todos = new ListaPolitica("Todos", 501, dipuCorrientesfrenteDeTodos,
				senCorrienteFrenteDeTodos, corrientes, frenteDeTodos);
		listasPoliticasCorrientes.add(compromisoFederal);
		listasPoliticasCorrientes.add(todos);

		todasLasListasPoliticas.add(compromisoFederal);
		todasLasListasPoliticas.add(todos);

		return todasLasListasPoliticas;
	}

	/**
	 * Metodo que devuelve una lista, que dentro tiene otra lista de candidatos.
	 *
	 */
	public static List<List<Candidato>> generarListaDiputadosTotales() {

		List<ListaPolitica> listasPolitias = generaListas();
		List<List<Candidato>> listDelistaDeDiputados = new ArrayList<>();

		for (ListaPolitica listaPolitica : listasPolitias) {
			listDelistaDeDiputados.add(listaPolitica.getDiputados());
		}

		return listDelistaDeDiputados;
	}

	/**
	 * Metodo que devuelve una lista, que dentro tiene otra lista de candidatos.
	 *
	 */
	public static List<List<Candidato>> generarListaSenadoresTotales() {

		List<ListaPolitica> listasPolitias = generaListas();
		List<List<Candidato>> listDelistaDeSenadores = new ArrayList<>();

		for (ListaPolitica listaPolitica : listasPolitias) {
			listDelistaDeSenadores.add(listaPolitica.getSenadores());
		}

		return listDelistaDeSenadores;
	}
}
