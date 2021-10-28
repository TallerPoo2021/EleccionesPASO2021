package com.gruposeispoo.clases;

import java.util.*;

public class Voto {

    private static int contadorDeVotos = 0;
    private int id;

    private boolean corteBoleta;
    private Date fechaVoto;
    private Elector elector;
    private List<Candidato> senadores;
    private List<Candidato> diputados;
    private List<ListaPolitica> listas;
    private MesaElectoral mesaElectoral;

    /**
     * CONSTRUCTOR
     *
     * por defecto un voto se inicializa con corte boleta en falso
     */
    public Voto() {
        Voto.contadorDeVotos++;
        this.id = Voto.contadorDeVotos;
        this.corteBoleta = false;
        this.fechaVoto = new Date();
        this.elector = null;
        this.senadores = new ArrayList<>();
        this.diputados = new ArrayList<>();
        this.listas = new ArrayList<>();
        this.mesaElectoral = null;
    }

    /**
     * CONSTRUCTOR
     *
     * @param fechaVoto
     * @param senadores
     * @param diputados
     * @param elector
     * @param mesaElectoral
     * @throws Exception
     */
    public Voto(Date fechaVoto, List<Candidato> senadores, List<Candidato> diputados, Elector elector, MesaElectoral mesaElectoral) throws Exception {
        this();

        if (!elector.isPuedeVotar()) {
            throw new Exception("El elector no está autorizado para votar.");
        }

        this.senadores = senadores;
        this.diputados = diputados;

        if (senadores != null) {
            for (int i = 0; i < senadores.size() - 1; i++) {
                if (senadores.get(i).getListaPolitica().equals(senadores.get(i + 1).getListaPolitica())) {
                    corteBoleta = true;
                    break;
                }
            }
        }

        if (!corteBoleta) {
            if (diputados != null) {
                for (int i = 0; i < diputados.size() - 1; i++) {
                    if (diputados.get(i).getListaPolitica().equals(diputados.get(i + 1).getListaPolitica())) {
                        corteBoleta = true;
                        break;
                    }
                }
            }
        }

        this.fechaVoto = fechaVoto;
        this.elector = elector;
        this.mesaElectoral = mesaElectoral;

        try {
            elector.getMesaElectoral().getCircuito().agregarVoto(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Agrega una lista votada
     *
     * @param listaVotada
     */
    public void agregarListaVotada(ListaPolitica listaVotada) {
        this.listas.add(listaVotada);
    }

    public static int getContadorDeVotos() {
        return contadorDeVotos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ListaPolitica> getListas() {
        return listas;
    }

    public void setListas(List<ListaPolitica> listas) {
        this.listas = listas;
    }

    public boolean isCorteBoleta() {
        return corteBoleta;
    }

    public void setCorteBoleta(boolean corteBoleta) {
        this.corteBoleta = corteBoleta;
    }

    public Date getFechaVoto() {
        return fechaVoto;
    }

    public void setFechaVoto(Date fechaVoto) {
        this.fechaVoto = fechaVoto;
    }

    public Elector getElector() {
        return elector;
    }

    public void setElector(Elector elector) {
        this.elector = elector;
    }

    public MesaElectoral getMesaElectoral() {
        return mesaElectoral;
    }

    public List<ListaPolitica> obtenerListasPoliticas() {
        List<Candidato> diputadosCopia = new ArrayList<>(diputados);
        List<Candidato> senadoresCopia = new ArrayList<>(senadores);
        List<ListaPolitica> listaPoliticas = new ArrayList<>();

        if (senadores != null) {
            for (int i = 0; i < senadores.size(); i++) {
                if (!listaPoliticas.contains(senadoresCopia.get(i).getListaPolitica())) {
                    listaPoliticas.add(senadoresCopia.get(i).getListaPolitica());
                }
            }
        }

        if (diputados != null) {
            for (int i = 0; i < diputados.size(); i++) {
                if (!listaPoliticas.contains(diputadosCopia.get(i).getListaPolitica())) {
                    listaPoliticas.add(diputadosCopia.get(i).getListaPolitica());
                }
            }
        }
        return listaPoliticas;
    }

    public List<Candidato> getSenadores() {
        return senadores;
    }

    public List<Candidato> getDiputados() {
        return diputados;
    }
}
