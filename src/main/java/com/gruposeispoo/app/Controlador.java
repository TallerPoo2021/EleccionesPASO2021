package com.gruposeispoo.app;

import java.util.ArrayList;
import java.util.List;

import com.gruposeispoo.clases.Admin;
import com.gruposeispoo.clases.ListaPolitica;

public class Controlador {

    private static List<ListaPolitica> listaDePrueba;

    /**
     * Constructor
     *
     */
    public Controlador() {
//        listaDePrueba = new ArrayList<>();
    	listaDePrueba = Admin.generaListas();
    }

    /**
     * Verifica que el inputs se correspondan con un usuario
     *
     * @param nombreDeUsuario
     * @return
     */
    public static boolean existeUsuario(String nombreDeUsuario) {
        /*
            IMPLEMENTAR ESTE METODO
         */
        //RETORNO DE PRUEBA
        return nombreDeUsuario.equals("admin");
    }

    /**
     * Verifica que los inputs usuario
     *
     * @param usuario
     * @param contrasenia
     * @return
     */
    public static boolean verificadorDeUsuario(String usuario, String contrasenia) {
        if (usuario.isBlank()|| contrasenia.isBlank() || contrasenia.isEmpty()) {
            return false;
        }
        /*
            IMPLEMENTAR ESTE MÉTODO. POSIBLE ALTERNATIVA: CREAR UNA CLASE USUARIO QUE DE ATRIBUTOS TENGA USUARIO Y CONTRA.
                (PARA EL SISTEMA TENER UNA SOLA INSTANCIA DE USUARIO Y QUIZAS CONTRASENIA IGUAL QUE USUARIO TIPO ADMIN ADMIN)
         */
        //RETORNO DE PRUEBA
        return usuario.equals("admin")&&contrasenia.equals("admin");
    }

    /**
     * Otorga todas las listas politicas al cliente
     *
     * @return
     */
    public static List<ListaPoliticaPruebaBorrar> getListasPolticas() {

        /*
            IMPLEMENTAR ESTE MÉTODO
        */
        for (int i = 0; i < 10; i++) {
            listaDePrueba.add(new ListaPoliticaPruebaBorrar(495, "Entrerrianos por la riqueza y el legado"));
        }
        return listaDePrueba;
    }
}
