package com.gruposeispoo.clases;

import java.util.List;

public class MesaElectoral {
    private Elector presidente;
    private Elector suplentePresidente;
    private String establecimiento;
    private int numero;
    private List<Elector> padron;
    private Circuito circuito;

    public MesaElectoral() {
    }
    
    public MesaElectoral(Elector presidente, Elector suplentePresidente, String establecimiento, int numero, List<Elector> padron, Circuito circuito) throws Exception {
        if (presidente.equals(suplentePresidente)) throw new Exception("El presidente y el suplente no pueden ser la misma persona.");
        this.presidente = presidente;
        this.suplentePresidente = suplentePresidente;
        this.establecimiento = establecimiento;
        this.numero = numero;
        this.padron = padron;
        this.circuito = circuito;
        circuito.agregarMesa(this);
    }

    public boolean verificarAutoridad(Elector autoridad){
        return presidente.equals(autoridad) || suplentePresidente.equals(autoridad);
    }

    public boolean contieneElector(Elector elector){
        return padron.contains(elector);
    }

    public Elector getPresidente() {
        return presidente;
    }

    public Elector getSuplentePresidente() {
        return suplentePresidente;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public int getNumero() {
        return numero;
    }

    public List<Elector> getPadron() {
        return padron;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setPresidente(Elector presidente) {
        this.presidente = presidente;
    }

    public void setSuplentePresidente(Elector suplentePresidente) {
        this.suplentePresidente = suplentePresidente;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPadron(List<Elector> padron) {
        this.padron = padron;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MesaElectoral other = (MesaElectoral) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n\t\t\tMesaElectoral: " + "\n\t\t\t\tpresidente=" + presidente + "\n\t\t\t\tsuplentePresidente=" + suplentePresidente + "\n\t\t\t\testablecimiento=" + establecimiento + "\n\t\t\t\tnumero=" + numero + "\n\t\t\t\tpadron=" + padron + "\n\t\t\t\tcircuito=" + circuito;
    }
}
