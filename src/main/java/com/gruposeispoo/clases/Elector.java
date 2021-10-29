package com.gruposeispoo.clases;

import java.time.LocalDate;

/**
 *
 * Representa una persona (ya sea elector o candidato)
 *
 */
public class Elector {

    private static int cantidadDeElectores = 0;
    private int id;

    private boolean puedeVotar;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private TipoDocumento tipoDni;
    private Domicilio domicilio;
    private Voto voto;
    private MesaElectoral mesaElectoral;

    /**
     *
     * Constructor
     *
     * Por defecto, al crearse un elector, este no esta habilitado para votar
     *
     *
     */
    public Elector() {
        Elector.cantidadDeElectores++;
        this.id = Elector.cantidadDeElectores;
        this.puedeVotar = false;
    }

    /**
     * Constructor parametrizado
     *
     * @param nombre, nombre del elector
     * @param apellido, apellido del elector
     * @param fechaNac, fecha de nacimiento del elector
     */
    public Elector(String nombre, String apellido, LocalDate fechaNac) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    /**
     * Constructor parametrizado
     *
     * @param nombre
     * @param apellido
     * @param fechaNac
     * @param DNI
     * @param domicilio
     */
    public Elector(String nombre, String apellido, LocalDate fechaNac, TipoDocumento DNI,
            Domicilio domicilio) {
        this(nombre, apellido, fechaNac);
        this.setTipoDni(DNI);
        this.domicilio = domicilio;
    }

    public static int getCantidadDeElectores() {
        return cantidadDeElectores;
    }

    public int getId() {
        return id;
    }

    public boolean isPuedeVotar() {
        return puedeVotar;
    }

    public void setPuedeVotar(boolean puedeVotar) {
        this.puedeVotar = puedeVotar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public TipoDocumento getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(TipoDocumento tipoDni) {
        if (tipoDni == null) {
            throw new NullPointerException("Tipo de documento invalido");
        }
        puedeVotar = tipoDni != TipoDocumento.DNI_EN_CELULAR && tipoDni != TipoDocumento.DNI_EN_TRAMITE;
        this.tipoDni = tipoDni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    public MesaElectoral getMesaElectoral() {
        return mesaElectoral;
    }

    public void setMesaElectoral(MesaElectoral mesaElectoral) {
        this.mesaElectoral = mesaElectoral;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
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
        final Elector other = (Elector) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + "id=" + id + ", puedeVotar=" + puedeVotar + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", tipoDni=" + tipoDni + ", domicilio=" + domicilio + ", voto=" + voto + ", mesaElectoral=" + mesaElectoral + '}';
    }

}
