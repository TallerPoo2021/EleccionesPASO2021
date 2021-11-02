package com.gruposeispoo.clases;

import java.util.List;
import java.util.Objects;

public class PadronElectoral {
	private int anioActual;
	private List<Elector> electores; // habilitados

	public PadronElectoral(int anioActual,
			List<Elector> electores) {
		this.anioActual = anioActual;
		this.electores = electores;
	}

	protected int getAnioActual() {
		return anioActual;
	}

	protected void setAnioActual(int anioActual) {
		this.anioActual = anioActual;
	}

	protected List<Elector> getElectores() {
		return electores;
	}

	protected void setElectores(List<Elector> electores) {
		this.electores = electores;
	}

	//-------
	
	public MesaElectoral mesaDondeVoto(Elector elector) {
		return null;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(anioActual);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PadronElectoral other = (PadronElectoral) obj;
		return anioActual == other.anioActual;
	}

	@Override
	public String toString() {
		return "PadronElectoral [anioActual=" + anioActual + "]";
	}
}
