package com.gruposeispoo.clases;

import java.util.*;

public class CamaraElectoral {

	private static Distrito[] distritos;
	private List<PartidoPolitico> partidosPoliticos;
	private PadronElectoral padronOficial;

	public CamaraElectoral(Distrito[] distritos, List<PartidoPolitico> partidosPoliticos,
			PadronElectoral padronOficial) {
		this.distritos = distritos;
		this.partidosPoliticos = partidosPoliticos;
		this.padronOficial = padronOficial;
	}

	protected Distrito[] getDistritos() {
		return distritos;
	}

	protected void setDistritos(Distrito[] distritos) {
		this.distritos = distritos;
	}

	protected List<PartidoPolitico> getPartidosPoliticos() {
		return partidosPoliticos;
	}

	protected void setPartidosPoliticos(List<PartidoPolitico> partidosPoliticos) {
		this.partidosPoliticos = partidosPoliticos;
	}

	protected PadronElectoral getPadronOficial() {
		return padronOficial;
	}

	protected void setPadronOficial(PadronElectoral padronOficial) {
		this.padronOficial = padronOficial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(partidosPoliticos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CamaraElectoral other = (CamaraElectoral) obj;
		return Objects.equals(partidosPoliticos, other.partidosPoliticos);
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

	// -----
	
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

//	public Map<PartidoPolitico, Double> getPorcentajeVotos(Distrito distrito) {
//
//	}

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

	// -----

	@Override
	public String toString() {
		return "CamaraElectoral [partidosPoliticos=" + partidosPoliticos + ", padronOficial="
				+ padronOficial + "]";
	}
}
