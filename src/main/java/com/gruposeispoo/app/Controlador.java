package com.gruposeispoo.app;


import java.util.ArrayList;
import java.util.List;

public class Controlador {

    private static List<ListaPoliticaPruebaBorrar> listaDePrueba;

    public Controlador() {
        listaDePrueba = new ArrayList<>();
    }

    /**
     * Otorga todas las listas politicas al cliente
     *
     * @return
     */
    public static List<ListaPoliticaPruebaBorrar> getListasPolticas() {
        
        for (int i = 0; i < 10; i++) {
            listaDePrueba.add(new ListaPoliticaPruebaBorrar(495, "Entrerrianos por la riqueza y el legado"));
        }
        return listaDePrueba;
    }
}
