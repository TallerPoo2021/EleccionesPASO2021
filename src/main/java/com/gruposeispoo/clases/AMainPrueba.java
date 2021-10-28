package com.gruposeispoo.clases;

import java.util.List;


public class AMainPrueba {
	public static void main(String[] args) {
		LeerArchivos la = new LeerArchivos();
		List<Elector> padron = la.cargaElectores("csv\\Padron.csv");
		for (Elector elector : padron) {
			System.out.println(elector);
		}
	}
}
