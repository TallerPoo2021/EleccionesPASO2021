package com.gruposeispoo.clases;

import java.util.Date;
import java.util.List;

public class Voto {
    private boolean corteBoleta;
    private Date fechaVoto;
    private List<ListaPolitica> listasVotadas;
    private Elector elector;
    private MesaElectoral mesaElectoral;

    public Voto(boolean corteBoleta, Date fechaVoto, List<ListaPolitica> listasVotadas, Elector elector, MesaElectoral mesaElectoral) {
        this.corteBoleta = corteBoleta;
        this.fechaVoto = fechaVoto;
        this.listasVotadas = listasVotadas;
        this.elector = elector;
        this.mesaElectoral = mesaElectoral;
//        try {
//            elector.getMesaElectoral().getCircuito().agregarVoto(this);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    public boolean esCorteBoleta() {
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

    public List<ListaPolitica> getListasVotadas() {
        return listasVotadas;
    }
}
