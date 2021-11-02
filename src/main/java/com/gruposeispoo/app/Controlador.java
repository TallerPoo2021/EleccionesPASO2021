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
    private int cantidadVotosRestantes = 0;
    private boolean votoPorLista = false;
    private final Admin admin;
    private final List<ListaPolitica> listas;
    private final List<Elector> electores;
    private final List<Voto> votos;
    private final List<Integer> electoresConocidos;
    private static Controlador controlador;

    /**
     * CONSTRUCTOR
     *
     */
    private Controlador() {
        admin = new Admin();
        electores = Admin.generarElectores();
        listas = Admin.generaListas();
        votos = new ArrayList<>();
        electoresConocidos = new ArrayList<>();
        cantidadVotosRestantes = electores.size();
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

    public void setVotoPorLista(boolean votoPorLista) {
        this.votoPorLista = votoPorLista;
    }

    private void reseteoADefault() {
        this.numeroListaVotadaUno = 0;
        this.numeroListaVotadaDos = 0;
        this.votoPorLista = false;
    }

    public List<Integer> electoresConocidos() {
        return electoresConocidos;
    }

    public void agregarElectorConocido(int idElector) {
        electoresConocidos.add(idElector);
    }

    public void descontarVoto() {
        cantidadVotosRestantes -= 1;
    }

    public int getCantidadVotosRestantes() {
        return cantidadVotosRestantes;
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
                if (!voto.getListas().isEmpty()) {
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
     * @param idElector
     * @return
     */
    public Elector buscarElectorPorId(int idElector) {
        Elector electorEncontrado = null;

        electorEncontrado = buscarElectorPorId(electores, idElector);

        return electorEncontrado;
    }

    /**
     * Encuentra una lista politica dentro de una lista de listas polticas
     * pasado un numero de lista
     *
     * @param electores
     * @param idElector
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
     * Crea un nuevo voto y lo almacena en la lista de votos.Voto por categoria:
     * - Listas iguales para senadores y diputados: el voto tiene 1 sola lista
     * en listasVotadas - Listas distintas para senador y diputado: el voto
     * tiene 2 listas en listasVotadas - Una sola lista para senador o diputado:
     * el voto tiene 1 sola lista en listasVotadas si la lista es de senador, se
     * ubica en la segunda posición de la lista de listasVotadas, se la lista es
     * de diputados se ubica en la primera posicion de la lista de listasVotadas

     */
    public void nuevoVoto() {
        Voto voto = new Voto();
        ListaPolitica listaAuxiliar;
        Elector electorAuxiliar;

        electorAuxiliar = buscarElectorPorId(electores, idVotante);
        voto.setElector(electorAuxiliar);

        if (numeroListaVotadaUno == 0 && numeroListaVotadaDos == 0) {
            voto.setCorteBoleta(!votoPorLista);
            votos.add(voto);
            return;
        }

        if (votoPorLista) {
            listaAuxiliar = this.buscarListaPorNumero(listas, numeroListaVotadaUno);

            voto.setCorteBoleta(false);
            voto.setDiputados(listaAuxiliar.getDiputados());
            voto.setSenadores(listaAuxiliar.getSenadores());
            voto.agregarListaVotada(listaAuxiliar);
        } else {
            voto.setCorteBoleta(true);

            /*
                SE VOTO DIPUTADO Y SENADOR DE LA MISMA BOLETA
             */
            if ((numeroListaVotadaUno == numeroListaVotadaDos) && (numeroListaVotadaUno != 0)) {
                listaAuxiliar = this.buscarListaPorNumero(listas, numeroListaVotadaUno);

                voto.setDiputados(listaAuxiliar.getDiputados());
                voto.setSenadores(listaAuxiliar.getSenadores());
                voto.agregarListaVotada(listaAuxiliar);
            }

            /*
                SE VOTO DIPUTADO Y SENADOR DE DISTINTAS BOLETAS
             */
            if ((numeroListaVotadaUno != numeroListaVotadaDos) && (numeroListaVotadaUno > 0 && numeroListaVotadaDos > 0)) {
                listaAuxiliar = this.buscarListaPorNumero(listas, numeroListaVotadaUno);

                voto.setDiputados(listaAuxiliar.getDiputados());
                voto.agregarListaVotada(listaAuxiliar);

                listaAuxiliar = this.buscarListaPorNumero(listas, numeroListaVotadaDos);

                voto.setSenadores(listaAuxiliar.getSenadores());
                voto.agregarListaVotada(listaAuxiliar);
            }

            /*
                SE VOTO SOLO DIPUTADOS
             */
            if (numeroListaVotadaUno > 0 && numeroListaVotadaDos == 0) {
                listaAuxiliar = this.buscarListaPorNumero(listas, numeroListaVotadaUno);

                voto.setDiputados(listaAuxiliar.getDiputados());
                voto.agregarListaVotada(listaAuxiliar);
            }
            /*
                SE VOTO SOLO SENADORES
             */
            if (numeroListaVotadaUno == 0 && numeroListaVotadaDos > 0) {
                listaAuxiliar = this.buscarListaPorNumero(listas, numeroListaVotadaDos);

                voto.setSenadores(listaAuxiliar.getSenadores());
                //Nueva Lista Para respetar le hecho de que la segunda lista, de la lista de listasVotadas dentro de un voto, 
                //                              si existe, representa la lista de senadores
                voto.agregarListaVotada(new ListaPolitica());
                voto.agregarListaVotada(listaAuxiliar);
            }
            
            reseteoADefault();
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

    /**
     * Otorga el padron de electores al cliente
     *
     * @return
     */
    public List<Elector> getPadronElectores() {
        return electores;
    }

    public List<Voto> votosRealizados() {
        return votos;
    }
}
