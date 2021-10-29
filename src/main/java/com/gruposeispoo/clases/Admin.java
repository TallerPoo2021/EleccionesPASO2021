package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;

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
//		for (Elector elector : todosLosElectoresDelPadron) {
//			elector.set
//		}

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
		Distrito entreRios = new Distrito(0, 5, "Entre Rios",null);
		Distrito corrientes = new Distrito(3, 3, "Corrientes",null);
		Distrito santaFe = new Distrito(3, 9, "Santa Fe",null);
		Distrito mendoza = new Distrito(3, 5, "Mendoza",null);
		Distrito salta = new Distrito(0, 3, "Salta",null);
		Distrito cordoba = new Distrito(3, 9, "Cordoba",null);

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
		dipuEntreRiosPodemosEntreRios
				.add(new Candidato("Juan Manuel", "Rossi", TipoCandidato.DIPUTADO));
		dipuEntreRiosPodemosEntreRios
				.add(new Candidato("Natalia", "Noacco", TipoCandidato.DIPUTADO));
		dipuEntreRiosPodemosEntreRios.add(new Candidato("Dario", "Baez", TipoCandidato.DIPUTADO));
		dipuEntreRiosPodemosEntreRios
				.add(new Candidato("Fernanda", "Sanzberro", TipoCandidato.DIPUTADO));
		dipuEntreRiosPodemosEntreRios.add(new Candidato("Gaston", "Buet", TipoCandidato.DIPUTADO));
		List<Candidato> dipuEntreRiosJuntoPorER = new ArrayList<Candidato>();
		dipuEntreRiosJuntoPorER
				.add(new Candidato("Rogelio", "Frigerio", TipoCandidato.DIPUTADO));
		dipuEntreRiosJuntoPorER
				.add(new Candidato("Marcela", "Antola", TipoCandidato.DIPUTADO));
		dipuEntreRiosJuntoPorER
				.add(new Candidato("Atilio", "Benedetti", TipoCandidato.DIPUTADO));
		dipuEntreRiosJuntoPorER
				.add(new Candidato("Nancy", "Ballejos", TipoCandidato.DIPUTADO));
		dipuEntreRiosJuntoPorER
				.add(new Candidato("Mauricio", "Davico", TipoCandidato.DIPUTADO));

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

		List<Candidato> dipuSaltaFelicidad = new ArrayList<Candidato>();
		dipuSaltaFelicidad.add(new Candidato("Tane", "Da Souza Correa", TipoCandidato.DIPUTADO));
		dipuSaltaFelicidad.add(new Candidato("Maria Laura", "Thomas", TipoCandidato.DIPUTADO));
		dipuSaltaFelicidad.add(new Candidato("Guido", "Giacosa", TipoCandidato.DIPUTADO));

//		CREACION DE PARTIDOS/COALICIONES POLITICAS
		PartidoPolitico accionCorrentina = new PartidoPolitico("Accion Correntina");
		PartidoPolitico frenteDeTodos = new PartidoPolitico("Frente de Todos");
		PartidoPolitico partidoSocialista = new PartidoPolitico("Partido Socialista");
		PartidoPolitico juntos = new PartidoPolitico("Juntos");
		PartidoPolitico felicidadParaTodos = new PartidoPolitico("Felicidadd Para Todos");

//		CREACION DE LISTAS POLITICAS
		ListaPolitica podemosEntreRios = new ListaPolitica("Podemos Entre Rios", 50,
				dipuEntreRiosPodemosEntreRios, null, entreRios, partidoSocialista);
		ListaPolitica juntosPorEntreRios = new ListaPolitica("Juntos Por Entre Rios", 502,
				dipuEntreRiosJuntoPorER, null, entreRios, juntos);
		ListaPolitica compromisoFederal = new ListaPolitica("Compromiso Federal", 82,
				dipuCorrientesAccionCorriente, senCorrienteAccionCorriente, corrientes,
				accionCorrentina);
		ListaPolitica todos = new ListaPolitica("Todos", 501, dipuCorrientesfrenteDeTodos,
				senCorrienteFrenteDeTodos, corrientes, frenteDeTodos);
		ListaPolitica felicidad = new ListaPolitica("Felicidad", 227, dipuSaltaFelicidad, null,
				CamaraElectoral.encontrarDistrito("Salta"), felicidadParaTodos);

		System.out.println(felicidad);
		
		todasLasListasPoliticas.add(podemosEntreRios);
		todasLasListasPoliticas.add(juntosPorEntreRios);
		todasLasListasPoliticas.add(compromisoFederal);
		todasLasListasPoliticas.add(todos);
		todasLasListasPoliticas.add(felicidad);
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

		List<ListaPolitica> listasPoliticas = generaListas();
		List<List<Candidato>> listDelistaDeSenadores = new ArrayList<>();

		for (ListaPolitica listaPolitica : listasPoliticas) {
			listDelistaDeSenadores.add(listaPolitica.getSenadores());
		}

		return listDelistaDeSenadores;
	}

	public static void main(String[] args) {
		Admin ad = new Admin();
		ad.generaListas();
//		List<List<Candidato>> asdf = ad.generarListaSenadoresTotales();
//		for (List<Candidato> listq : asdf) {
//			System.out.println("###");
//			System.out.println(listq);
//		}
	}
}
