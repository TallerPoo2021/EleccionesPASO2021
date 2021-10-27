package com.gruposeispoo.clases;

import java.util.List;
import java.util.Objects;

public class ListaPolitica {
	private String nombre;
	private int numero;
	private List<Candidato> diputados;
	private List<Candidato> senadores;
	private Distrito distrito; // tiene
	private PartidoPolitico partidoPolitico; // representa

	public ListaPolitica(String nombre, int numero, List<Candidato> diputados,
			List<Candidato> senadores, Distrito distrito, PartidoPolitico partidoPolitico) {
		this.nombre = nombre;
		this.numero = numero;
		this.diputados = diputados;
		this.senadores = senadores;
		this.distrito = distrito;
		this.partidoPolitico = partidoPolitico;
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	protected void setNumero(int numero) {
		this.numero = numero;
	}

	protected List<Candidato> getDiputados() {
		return diputados;
	}

	protected void setDiputados(List<Candidato> diputados) {
		this.diputados = diputados;
	}

	protected List<Candidato> getSenadores() {
		return senadores;
	}

	protected void setSenadores(List<Candidato> senadores) {
		this.senadores = senadores;
	}

	protected Distrito getDistrito() {
		return distrito;
	}

	protected void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	protected PartidoPolitico getPartidoPolitico() {
		return partidoPolitico;
	}

	protected void setPartidoPolitico(PartidoPolitico partidoPolitico) {
		this.partidoPolitico = partidoPolitico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaPolitica other = (ListaPolitica) obj;
		return Objects.equals(nombre, other.nombre) && numero == other.numero;
	}

	@Override
	public String toString() {
		return "ListaPolitica [nombre=" + nombre + ", numero=" + numero + ", partidoPolitico="
				+ partidoPolitico + "]";
	}
}
