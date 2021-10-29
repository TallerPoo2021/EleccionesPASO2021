package com.gruposeispoo.clases;

import java.util.*;

public class CamaraElectoral {

	private static final PadronElectoral padronOficial = new PadronElectoral(2021, Admin.generarElectores());
	private static final Distrito[] distritos = crearDistritos();
	private static final List<PartidoPolitico> partidosPoliticos = crearPartidosPoliticos();


	private static List<PartidoPolitico> crearPartidosPoliticos(){
		List<ListaPolitica> listasPoliticas = new ArrayList<>(Admin.generaListas());
		List<PartidoPolitico> partidosPoliticos = new ArrayList<>();
		for (ListaPolitica listaPolitica : listasPoliticas) {
			if (!partidosPoliticos.contains(listaPolitica.getPartidoPolitico())) partidosPoliticos.add(listaPolitica.getPartidoPolitico());
		}
		return null;
	}

	private static Distrito[] crearDistritos(){
		/*
		Distrito entreRios = new Distrito(5,4,"Entre Rios", repartirPadron("Entre Rios"));
		Distrito corrientes = new Distrito(3, 3, "Corrientes", repartirPadron("Corrientes"));
		Distrito santaFe = new Distrito(5, 4, "Santa Fe", repartirPadron("Santa Fe"));
		Distrito mendoza = new Distrito(8, 3, "Mendoza", repartirPadron("Mendoza"));
		Distrito salta = new Distrito(7, 9, "Salta", repartirPadron("Salta"));
		Distrito cordoba = new Distrito(4, 3, "Cordoba", repartirPadron("Cordoba"));
		 */
		return new Distrito[]{ new Distrito(5,4,"Entre Rios", repartirPadron("Entre Rios")), new Distrito(3, 3, "Corrientes", repartirPadron("Corrientes")), new Distrito(5, 4, "Santa Fe", repartirPadron("Santa Fe")), new Distrito(8, 3, "Mendoza", repartirPadron("Mendoza")), new Distrito(7, 9, "Salta", repartirPadron("Salta")), new Distrito(4, 3, "Cordoba", repartirPadron("Cordoba"))};
	}

	private static List<Elector> repartirPadron (String distrito){
		List<Elector> padronDistrito = new ArrayList<>();
		for (Elector elector : padronOficial.getElectores()) {
			if (elector.getDomicilio().getProvincia().equalsIgnoreCase(distrito)){
				padronDistrito.add(elector);
			}
		}
		return padronDistrito;
	}

	public static Distrito encontrarDistrito(String nombreDistrito){
		for (Distrito distrito : distritos) {
			System.out.println(distrito.getNombre());
			if (distrito.getNombre().equalsIgnoreCase(nombreDistrito)) return distrito;
		}
		return null;
	}

	protected static Distrito[] getDistritos() {
		return distritos;
	}

	protected static List<PartidoPolitico> getPartidosPoliticos() {
		return partidosPoliticos;
	}

	protected static PadronElectoral getPadronOficial() {
		return padronOficial;
	}

	public static MesaElectoral encontrarMesa(int codigoMesa){
		for (Distrito distrito : distritos) {
			for (Seccion seccion : distrito.getSecciones()) {
				for (Circuito circuito : seccion.getCircuitos()) {
					for (MesaElectoral mesaElectoral : circuito.getListaMesas()) {
						if (mesaElectoral.getNumero() == codigoMesa) return mesaElectoral;
					}
				}
			}
		}
		return null;
	}
	
	public boolean verificarLista(List<Candidato> candidatos, ListaPolitica listaPolitica) {
		for (Candidato candidato : candidatos) {
			if (candidato.getTipoCandidato() == TipoCandidato.DIPUTADO){
				for (Candidato diputado : listaPolitica.getDiputados()) {
					if (diputado.equals(candidato)) return true;
				}
			}else{
				for (Candidato senador : listaPolitica.getSenadores()) {
					if(senador.equals(candidato)) return true;
				}
			}
		}
		return false;
	}

	public List<Elector> getPadronPersona(Distrito distrito) {
		List <Elector> listaElectores = new ArrayList<>(padronOficial.getElectores());
		listaElectores.removeIf(elector -> !elector.getDomicilio().getProvincia().equalsIgnoreCase(distrito.getNombre()));
		return listaElectores;
	}

	public double getPorcentajeElectores(Distrito distrito) {
		return ((double) distrito.getPadron().size()*100)/((double) padronOficial.getElectores().size());
	}

	public Map <ListaPolitica, Double> getPorcentajeGeneral() {
		Map <ListaPolitica, Double> porcentajesListaPolticas = new HashMap<>();
		List <ListaPolitica> listasPoliticas = new ArrayList<>();
		for (Distrito distrito : distritos) {
			listasPoliticas.addAll(distrito.getListasPoliticas());
		}
		for (ListaPolitica listaPolitica : listasPoliticas) {
			porcentajesListaPolticas.put(listaPolitica, listaPolitica.getDistrito().contarVotos(listaPolitica) * 100.0 / listaPolitica.getDistrito().contarVotos());
		}

		return porcentajesListaPolticas;
	}

	public Queue <ListaPolitica> getListasGanadoras(Distrito distrito) {
		Queue <ListaPolitica> resultado = new PriorityQueue<>();
		List <ListaPolitica> listasPoliticas = new ArrayList<>(distrito.getListasPoliticas());
		listasPoliticas.removeIf(listaPolitica -> !((distrito.contarVotos(listaPolitica) * 100.0 / distrito.contarVotos()) < 1.5));
		for (ListaPolitica listaPolitica : listasPoliticas) {
			Optional<ListaPolitica> optional = listasPoliticas.stream().max((o1, o2) -> Integer.compare(distrito.contarVotos(o1), distrito.contarVotos(o2)));
			if (optional.isPresent()){
				resultado.add(optional.get());
				listasPoliticas.remove(optional.get());
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "CamaraElectoral [partidosPoliticos=" + partidosPoliticos + ", padronOficial="
				+ padronOficial + "]";
	}
}
