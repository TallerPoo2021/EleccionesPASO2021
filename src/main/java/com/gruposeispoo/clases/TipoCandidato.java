package com.gruposeispoo.clases;

/**
 * Tipos de Candidatos 
 */
public enum TipoCandidato {
    SENADOR("Senador"),
    DIPUTADO("Diputado");
    
    private String descripcion;
    
    /**
     * Constructor
     * 
     * @param descripcion, descripcion o nombre del tipo 
     */
    private TipoCandidato(String descripcion){
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
