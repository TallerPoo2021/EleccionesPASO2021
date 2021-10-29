package com.gruposeispoo.app;

import java.util.List;

import com.gruposeispoo.clases.Admin;
import com.gruposeispoo.clases.Elector;
import com.gruposeispoo.clases.ListaPolitica;
import com.gruposeispoo.clases.Voto;
import java.util.ArrayList;

public class Controlador {

    private int idVotante = 0;
    private int numeroListaVotadaUno = 0;
    private int numeroListaVotadaDos = 0;
    private List<ListaPolitica> listas;
    private List<Elector> electores = Admin.generarElectores();
    private List<Voto> votos;
    private Admin admin;
    private static Controlador controlador;

    /**
     * CONSTRUCTOR
     *
     */
    private Controlador() {
        admin = new Admin();
        listas = Admin.generaListas();
        votos = new ArrayList<>();
    }

    /**
     * SINGLETON
     *
     * @return
     */
    public static Controlador getInstancia() {
        if (controlador == null) {
            controlador = new Controlador();
        }
        return controlador;
    }

    public int getIdVotante() {
        return idVotante;
    }

    public void setIdVotante(int idDelVotante) {
        idVotante = idDelVotante;
    }

    public int getNumeroListaVotadaUno() {
        return numeroListaVotadaUno;
    }

    public int getNumeroListaVotadaDos() {
        return numeroListaVotadaDos;
    }

    public void setNumeroListaVotadaUno(int numeroListaVotadaUno) {
        this.numeroListaVotadaUno = numeroListaVotadaUno;
    }

    public void setNumeroListaVotadaDos(int numeroListaVotadaDos) {
        this.numeroListaVotadaDos = numeroListaVotadaDos;
    }

    /**
     * Obtener todas las listas votadas, ordenadas de acuerdo al ingreso del
     * voto y pueden estar repetidas, justamente esa es la utilidad que se busca
     *
     *
     * @return
     */
    public List<ListaPolitica> listasVotadas() {
        List<ListaPolitica> listasVotadasXVoto = new ArrayList<>();

        if (!votos.isEmpty()) {
            votos.forEach(voto -> {
                if (voto.getListas() != null) {
                    voto.getListas().forEach(listaVotada -> {
                        if (listaVotada.getNumero() != 0) {
                            listasVotadasXVoto.add(listaVotada);
                        }
                    });
                }
            });
        }

        return listasVotadasXVoto;
    }

    /**
     * Encuentra una lista politica dentro de una lista de listas polticas
     * pasado un numero de lista
     *
     * @param numeroDeLista
     * @return
     */
    private Elector buscarElectorPorId(List<Elector> electores, int idElector) {
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
    public Elector existeElector(int id) {
        for (Elector elector : electores) {
            if (elector.getId() == id) {
                return elector;
            }
        }
        return null;
    }

    /**
     * Crea un nuevo voto y lo almacena en la lista de votos.
     *
     * Voto por categoria: - Listas iguales para senadores y diputados: el voto
     * tiene 1 sola lista en listasVotadas - Listas distintas para senador y
     * diputado: el voto tiene 2 listas en listasVotadas - Una sola lista para
     * senador o diputado: el voto tiene 1 sola lista en listasVotadas si la
     * lista es de senador, se ubica en la segunda posición de la lista de
     * listasVotadas, se la lista es de diputados se ubica en la primera
     * posicion de la lista de listasVotadas
     *
     * Voto por lista: -
     */
    public Voto nuevoVoto() {
        Voto voto = new Voto();
        ListaPolitica listaAuxiliar;

        if (idVotante == 0) {
            throw new NullPointerException("Ningun votando a iniciado el proceso de votacion");
        }

        if (numeroListaVotadaDos == numeroListaVotadaUno || numeroListaVotadaDos == 0 || numeroListaVotadaUno == 0) {
            if (numeroListaVotadaDos == 0) {
                voto.setElector(buscarElectorPorId(electores, idVotante));
                if (numeroListaVotadaUno == 0) {
                    voto.agregarListaVotada(null);
                } else {
                    voto.agregarListaVotada(buscarListaPorNumero(listas, numeroListaVotadaUno));
                }
            } else {
                if (numeroListaVotadaDos == numeroListaVotadaUno) {
                    voto.setElector(buscarElectorPorId(electores, idVotante));
                    voto.agregarListaVotada(buscarListaPorNumero(listas, numeroListaVotadaUno));
                } else {
                    voto.setElector(buscarElectorPorId(electores, idVotante));
                    /*
                        ESTE NEW LISTAPOLITICA() ES PARA ESOS CASOS QUE EN UN VOTO POR CATEGORIA
                            SE VOTA SOLO LISTA DE SENADORES. Y PARA RESPETAR LA LOGICA DE QUE
                            LA LISTA DE SENADORES SIEMPRE ESTA EN LA SEGUNDA POSICION DE LA LISTA DE LISTAS 
                            VOTADAS DEL VOTO
                    
                            COMO CONTROLAR:
                                ESTA NEW LISTAPOLITICA() GENERA UNA LISTA POLITICA CON NUMERO CERO, ESO
                                SIGNIFICA QUE ESTA DE RELLENO DE DEBERIAMOS IGNORARLA. NINGUNA LISTA POLI
                                TICA EN GENERAL PARA ESTE SISTEMA DEBERIA TENER NUMERO DE LISTA = 0
                    
                            
                     */
                    voto.agregarListaVotada(new ListaPolitica());
                    voto.agregarListaVotada(buscarListaPorNumero(listas, numeroListaVotadaDos));
                }
            }
        } else {
            voto.setElector(buscarElectorPorId(electores, idVotante));
            listaAuxiliar = buscarListaPorNumero(listas, numeroListaVotadaUno);
            voto.agregarListaVotada(listaAuxiliar);
            listaAuxiliar = buscarListaPorNumero(listas, numeroListaVotadaDos);
            voto.agregarListaVotada(listaAuxiliar);
        }

        votos.add(voto);

        /*
                NO SE ASUSTEN. EL RETURN ES DE PRUEBA. LO UTILIZO PARA QUE CADA VEZ QUE SE HAGA CLICK EN VOTAR
                                    SE IMPRIMA POR CONSOLA EL VOTO GENERADO
         */
        return voto;
    }

    /**
     * Encuentra una lista politica dentro de una lista de listas polticas
     * pasado un numero de lista
     *
     * @param numeroDeLista
     * @return
     */
    private ListaPolitica buscarListaPorNumero(List<ListaPolitica> listas, int numeroDeLista) {
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
    public boolean existeUsuario(String nombreDeUsuario) {
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
    public boolean verificadorDeUsuario(String usuario, String contrasenia) {
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
    public List<ListaPolitica> getListasPolticas() {
        return listas;
    }
}
