package com.gruposeispoo.clases;

import java.util.ArrayList;
import java.util.List;

public class Circuito implements IContadorVoto {
    private String nombre;
    private int numeracion;
    private List<MesaElectoral> listaMesas;
    private Seccion seccion;
    private List<Voto> votosCircuito;

    public Circuito(String nombre, int numeracion, List<MesaElectoral> listaMesas, Seccion seccion) throws Exception {
        if (listaMesas.isEmpty()) throw new Exception("Debe haber al menos una mesa.");
        this.nombre = nombre;
        this.numeracion = numeracion;
        this.listaMesas = listaMesas;
        this.seccion = seccion;
        this.votosCircuito = new ArrayList<>();
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void agregarVoto(Voto voto) throws Exception {
        if (voto == null) throw new NullPointerException();
        if (!listaMesas.contains(voto.getElector().getMesaElectoral())) throw new Exception("Este elector no vota en esta mesa.");
        if (votosCircuito.contains(voto)) throw new Exception("La persona DNI Nº " + voto.getElector().getDNI() + " ya votó.");
        votosCircuito.add(voto);
    }

    public List<Voto> getVotosCircuito() {
        return votosCircuito;
    }

    public List<MesaElectoral> getListaMesas() {
        return listaMesas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    @Override
    public int contarVotosBlanco(){
        int contador = 0;
        for (Voto voto : votosCircuito) {
            if (voto.getSenadores() == null || voto.getDiputados() == null) contador++;
        }
        return contador;
    }

    @Override
    public int contarVotosBlanco(TipoCandidato tipoCandidato){
        int contador = 0;
        for (Voto voto : votosCircuito) {
            if (tipoCandidato == TipoCandidato.SENADOR && voto.getSenadores() == null) contador++;
            if (tipoCandidato == TipoCandidato.DIPUTADO && voto.getDiputados() == null) contador++;
        }
        return contador;
    }

    @Override
    public int contarVotos(Candidato candidato) {
        int contador = 0;
        for (Voto voto : votosCircuito) {
            if ((voto.getSenadores() != null && voto.getSenadores().contains(candidato)) || (voto.getDiputados() != null && voto.getDiputados().contains(candidato))) contador++;
        }
        return contador;
    }

    @Override
    public int contarVotos(ListaPolitica listaPolitica) {
        int contador = 0;
        for (Voto voto : votosCircuito) {
            if (voto.obtenerListasPoliticas().contains(listaPolitica)){
                contador++;
            }
        }
        return contador;
    }
}