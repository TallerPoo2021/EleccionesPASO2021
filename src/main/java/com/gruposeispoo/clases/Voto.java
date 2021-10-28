package com.gruposeispoo.clases;

import java.util.*;

public class Voto {
    private boolean corteBoleta;
    private Date fechaVoto;
    private Elector elector;
    private List<Candidato> senadores;
    private List<Candidato> diputados;
    private MesaElectoral mesaElectoral;

    public Voto(Date fechaVoto, List<Candidato> senadores, List<Candidato> diputados, Elector elector, MesaElectoral mesaElectoral) throws Exception {
        if (!elector.getPuedeVotar()) throw new Exception("El elector no está autorizado para votar.");
        this.senadores = senadores;
        this.diputados = diputados;
        this.corteBoleta = false;
        if (senadores != null) {
            for (int i = 0; i < senadores.size()-1; i++) {
                if (senadores.get(i).getListaPolitica().equals(senadores.get(i + 1).getListaPolitica())) {
                    corteBoleta = true;
                    break;
                }
            }
        }
        if (!corteBoleta){
            if (diputados != null) {
                for (int i = 0; i < diputados.size()-1; i++) {
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
