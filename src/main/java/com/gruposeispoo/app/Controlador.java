package com.gruposeispoo.app;

import java.util.ArrayList;
import java.util.List;

import com.gruposeispoo.clases.Admin;
import com.gruposeispoo.clases.ListaPolitica;

public class Controlador {
    
    private static List<ListaPolitica> listas;
    
    private Admin admin;
    /**
     * CONSTRUCTOR
     *
     */
    public Controlador() {
        listas = new ArrayList<>();
        admin = new Admin();
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
    public static List<ListaPolitica> getListasPolticas() {

        listas = Admin.generaListas();
        return listas;
    }
}
