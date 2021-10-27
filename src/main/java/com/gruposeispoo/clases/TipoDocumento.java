package com.gruposeispoo.clases;

/**
 *  Tipos de Documentos en Argentina
 */
public enum TipoDocumento {
    LIBRETA_VERDE("Libreta Verde"),
    LIBRETA_CELESTE("Libreta Celeste"),
    LIBRETA_ENROLAMIENTO("Libreta Enrolamiento"),
    LIBRETA_CIVICA("Libreta Civica"),
    DNI_EN_TRAMITE("DNI en Tramite"), //no valido
    DNI_EN_CELULAR("DNI en Celular"), //no valido
    DNI_TARJETA("DNI Tarjeta"); 
    
    private String descripcion;
    
    /**
     * Constructor
     * @param descripcion, la descripcion o nombre del tipo 
     */
    private TipoDocumento(String descripcion){
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return String, la descripcion del tipo 
     */
    public String getDescripcion() {
        return descripcion;
    }
}
