package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartidoPolitico {
	private boolean esAlianza;
	private String nombre;
	private List<ListaPolitica> listaPolitica = new ArrayList<ListaPolitica>(); // representa
	private List<PartidoPolitico> partidoPolitico;// tiene

	public PartidoPolitico(boolean esAlianza, String nombre, List<ListaPolitica> listaPolitica) {
		this.esAlianza = esAlianza;
		this.nombre = nombre;
		this.listaPolitica = listaPolitica;
	}

	// Constructor para los partidos que son alianzas
	public PartidoPolitico(boolean esAlianza, String nombre, List<ListaPolitica> listaPolitica,
			List<PartidoPolitico> partidoPolitico) {
		this.esAlianza = esAlianza;
		this.nombre = nombre;
		this.listaPolitica = listaPolitica;
		this.partidoPolitico = partidoPolitico;
	}

	protected boolean isEsAlianza() {
		return esAlianza;
	}

	protected void setEsAlianza(boolean esAlianza) {
		this.esAlianza = esAlianza;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected List<ListaPolitica> getListaPolitica() {
		return listaPolitica;
	}

	protected void setListaPolitica(List<ListaPolitica> listaPolitica) {
		this.listaPolitica = listaPolitica;
	}

	protected List<PartidoPolitico> getPartidoPolitico() {
		return partidoPolitico;
	}

	protected void setPartidoPolitico(List<PartidoPolitico> partidoPolitico) {
		this.partidoPolitico = partidoPolitico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, partidoPolitico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartidoPolitico other = (PartidoPolitico) obj;
		return Objects.equals(nombre, other.nombre)
				&& Objects.equals(partidoPolitico, other.partidoPolitico);
	}

	@Override
	public String toString() {
		return "PartidoPolitico [esAlianza=" + esAlianza + ", nombre=" + nombre + ", listaPolitica="
				+ listaPolitica + ", partidoPolitico=" + partidoPolitico + "]";
	}
}
