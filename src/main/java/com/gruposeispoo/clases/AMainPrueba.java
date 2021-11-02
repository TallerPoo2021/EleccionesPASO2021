package com.gruposeispoo.clases;

import com.gruposeispoo.app.Controlador;
import com.gruposeispoo.clases.ListaPolitica;
import java.util.List;

/*

    CLASE CREADA UNICAMENTE CON EL OBJETIVO DE TESTEAR OBJETOS QUE DEVUELVEN REGISTROS DE OTROS OBJETOS

 */
public class AMainPrueba {

    public static void main(String[] args) {
        Controlador controlador = Controlador.getInstancia();

        //PRUEBA REGISTRO ELECTORES
        List<Elector> padron = controlador.getPadronElectores();
        //PRUEBA REGISTRO LISTAS POLITICAS
        List<ListaPolitica> listas = controlador.getListasPolticas();

        /*
                listas.forEach(lista -> {
                    System.out.println(lista);
                });
         */
        
        /*
                padron.forEach(elector -> {
                    System.out.println(elector);
            });
         */
    }
}
