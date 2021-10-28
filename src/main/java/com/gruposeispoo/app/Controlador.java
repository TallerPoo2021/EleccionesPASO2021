package com.gruposeispoo.app;

import java.util.List;

import com.gruposeispoo.clases.Admin;
import com.gruposeispoo.clases.Elector;
import com.gruposeispoo.clases.ListaPolitica;
import com.gruposeispoo.clases.Voto;
import java.util.ArrayList;

public class Controlador {

    private static int idVotante = 0;
    private static int numeroListaVotadaUno = 0;
    private static int numeroListaVotadaDos = 0;
    private static List<ListaPolitica> listas;
    private static List<Elector> electores;
    private static List<Voto> votos;

    private Admin admin;

    /**
     * CONSTRUCTOR
     *
     */
    public Controlador() {
        admin = new Admin();
        listas = Admin.generaListas();
        votos = new ArrayList<>();
        electores = Admin.generarElectores();
    }

    public static int getIdVotante() {
        return idVotante;
    }

    public static void setIdVotante(int idDelVotante) {
        idVotante = idDelVotante;
    }

    public static int getNumeroListaVotadaUno() {
        return numeroListaVotadaUno;
    }

    public static int getNumeroListaVotadaDos() {
        return numeroListaVotadaDos;
    }

    public static void setNumeroListaVotadaUno(int numeroListaVotadaUno) {
        Controlador.numeroListaVotadaUno = numeroListaVotadaUno;
    }

    public static void setNumeroListaVotadaDos(int numeroListaVotadaDos) {
        Controlador.numeroListaVotadaDos = numeroListaVotadaDos;
    }

    /**
     * Encuentra una lista politica dentro de una lista de listas polticas
     * pasado un numero de lista
     *
     * @param numeroDeLista
     * @return
     */
    private static Elector buscarElectorPorId(List<Elector> electores, int idElector) {
        Elector electorEncontrado = null;

        for (Elector elector : electores) {
            if (elector.getId() == idElector) {
                electorEncontrado = elector;
                break;
            }
        }

        return electorEncontrado;
    }

    /**
     * Metodo para verificar la existencia o no de un elector
     *
     * @param id
     * @return
     */
    public static boolean existeElector(int id) {
        for (Elector elector : electores) {
            if (elector.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Crea un nuevo voto y lo almacena en la lista de votos
     *
     * @return Voto, el voto creado listo para ser seteado
     */
    public static void nuevoVoto() {
        Voto voto = new Voto();
        ListaPolitica listaAuxiliar;

        if (idVotante == 0) {
            throw new NullPointerException("Ningun votando a iniciado el proceso de votacion");
        }

        if (numeroListaVotadaDos == numeroListaVotadaUno || numeroListaVotadaDos == 0) {
            voto.setElector(buscarElectorPorId(electores, idVotante));
            voto.agregarListaVotada(buscarListaPorNumero(listas, numeroListaVotadaUno));
        }else{
            voto.setElector(buscarElectorPorId(electores, idVotante));
            listaAuxiliar = buscarListaPorNumero(listas, numeroListaVotadaUno);
            voto.agregarListaVotada(listaAuxiliar);
            listaAuxiliar = buscarListaPorNumero(listas, numeroListaVotadaDos);
            voto.agregarListaVotada(listaAuxiliar);
        }

        votos.add(voto);
    }

    /**
     * Encuentra una lista politica dentro de una lista de listas polticas
     * pasado un numero de lista
     *
     * @param numeroDeLista
     * @return
     */
    private static ListaPolitica buscarListaPorNumero(List<ListaPolitica> listas, int numeroDeLista) {
        ListaPolitica listaEncontrada = null;

        Integer numeroLista = numeroDeLista;
        if (numeroDeLista != 0) {
            for (ListaPolitica lista : listas) {
                if (lista.getNumero() == numeroLista) {
                    listaEncontrada = lista;
                    break;
                }
            }
        }
        return listaEncontrada;
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
        if (usuario.isBlank() || contrasenia.isBlank() || contrasenia.isEmpty()) {
            return false;
        }
        /*
            IMPLEMENTAR ESTE MÉTODO. POSIBLE ALTERNATIVA: CREAR UNA CLASE USUARIO QUE DE ATRIBUTOS TENGA USUARIO Y CONTRA.
                (PARA EL SISTEMA TENER UNA SOLA INSTANCIA DE USUARIO Y QUIZAS CONTRASENIA IGUAL QUE USUARIO TIPO ADMIN ADMIN)
         */
        //RETORNO DE PRUEBA
        return usuario.equals("admin") && contrasenia.equals("admin");
    }

    /**
     * Otorga todas las listas politicas al cliente
     *
     * @return
     */
    public static List<ListaPolitica> getListasPolticas() {
        return listas;
    }
}
