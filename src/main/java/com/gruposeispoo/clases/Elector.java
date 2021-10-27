package com.gruposeispoo.clases;

import java.util.Date;

/**
 * 
 *   Representa una persona (ya sea elector o candidato) 
 * 
 */
public class Elector {
    private static int cantidadDeElectores = 0;
    private int id;
    private boolean puedeVotar;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private TipoDocumento DNI;
    private Domicilio domicilio;
    private Voto voto;
    
    /**
     * 
     * Constructor
     * 
     * Por defecto, al crearse un elector, este no est� habilitado para votar
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
    public Elector(String nombre, String apellido, Date fechaNac) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }
    
    /**
     * 
     * Constructor parametrizado
     * 
     * @param nombre, nombre del elector
     * @param apellido, apellido del elector
     * @param DNI, DNI de TipoDocumento
     * @param fechaNac, fecha de nacimiento del elector
     * @param domicilio, domicilio del elector
     */
    public Elector(String nombre, String apellido, TipoDocumento DNI, Date fechaNac, Domicilio domicilio) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
    }

    public static int getCantidadDeElectores() {
        return cantidadDeElectores;
    }

    /**
     * 
     * @return int, el identificador �nico de este elector
     */
    public int getId() {
        return id;
    }  
  
    /**
     * 
     * Establece si esta elector esta habilitado para votar o no, dependiendo de su tipo de documento.
     * 
     */
    public void setHabilitadoParaVotar(){
        if (this.DNI == null) {
            throw new NullPointerException("Falta setear el atributo DNI");
        }
        
        boolean habilitado = this.DNI != TipoDocumento.DNI_EN_CELULAR && this.DNI != TipoDocumento.DNI_EN_TRAMITE;
        this.puedeVotar = habilitado;
    }

    /**
     * @return boolean, true si el elector esta habilitado para votar, false en caso contrario.
     */
    public boolean getPuedeVotar() {
        return puedeVotar;
    }
    
    /**
     * 
     * @return Voto, el voto realizado por este elector, NULL si este elector no ha votado a�n 
     */
    public Voto getVoto() {
        return voto;
    }

    /**
     * @param voto, el voto a setear
     */
    public void setVoto(Voto voto) {
        this.voto = voto;
    }
    
    /**
     * 
     * @return String, el nombre de este elector
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre, el nombre a setear
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return String, el apellido de este elector
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * 
     * @param apellido, el apellido a setear
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * 
     * @return TipoDocumento, el tipo de documento de este elector
     */
    public TipoDocumento getDNI() {
        return DNI;
    }

    /**
     * 
     * @param DNI, el tipo de dni a setear
     */
    public void setDNI(TipoDocumento DNI) {
        this.DNI = DNI;
    }

    /**
     * 
     * @return Date, la fecha de nacimiento de este elector
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * 
     * @param fechaNac, la fecha de nacimiento a setear
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }


    /**
     * 
     * @return Domicilio, el domicilio de este elector
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * 
     * @param domicilio, el domicilio a setear 
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    
    @Override
    public String toString() {
        return "Elector{" + "nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI + ", fechaNac=" + fechaNac + ", puedeVotar=" + puedeVotar + ", domicilio=" + domicilio + '}';
    }
   
}
