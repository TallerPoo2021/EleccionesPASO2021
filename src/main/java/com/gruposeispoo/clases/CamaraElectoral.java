package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
	
	public boolean verificarLista(List<Candidato> candidatos, ListaPolitica lsitaPolitica) {
		return false;
	}

	public List<Elector> getPadronPersona(Distrito distrito) {
		return null;
	}

	public double getPorcentajeElectores(Distrito distrito) {
		return padronOficial.getElectores().size();
	}

//	public Map<PartidoPolitico, Double> getPorcentajeVotos(Distrito distrito) {
//
//	}

	public Map<PartidoPolitico, Double> getPorcentajeGeneral() {
		return null;
	}

	public List<PartidoPolitico> getPartidosGanadores(Distrito distrito) {
		return null;
	}

	// -----

	@Override
	public String toString() {
		return "CamaraElectoral [partidosPoliticos=" + partidosPoliticos + ", padronOficial="
				+ padronOficial + "]";
	}
}
