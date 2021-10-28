package com.gruposeispoo.clases;

import java.util.List;


public class AMainPrueba {
	public static void main(String[] args) {
		LeerArchivos la = new LeerArchivos();
                
                
		List<Elector> padron = la.leerPadronElectores("csv\\Padron.csv");
                
                
                padron.forEach(elector -> {
                    System.out.println(elector);
            });
	}
}
