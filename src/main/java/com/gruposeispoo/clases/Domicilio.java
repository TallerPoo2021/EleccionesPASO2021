package com.gruposeispoo.clases;
/*
    Representa el domicilio de un elector
*/
public class Domicilio {

    private String direccion;
    private String localidad;
    private String departamento;
    private String provincia;

    public Domicilio() {
        this.direccion = "";
        this.departamento = "";
        this.provincia = "";
    }

    public Domicilio(String direccion, String localidad, String departamento, String provincia) {
        this();
        this.direccion = direccion;
        this.localidad = localidad;
        this.departamento = departamento;
        this.provincia = provincia;
    }

    /**
     * 
     * @return String, la direccion del domicilio 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * 
     * @param direccion, la direccion a setear
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * 
     * @return String, la localidad del domicilio
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * 
     * @param localidad, la localidad a setear
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * 
     * @return String, el departamento del domicilio
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * 
     * @param departamento, el departamento a setear 
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * 
     * @return String, la provincia del domicilio 
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * 
     * @param provincia, la provincia a setear
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "direccion=" + direccion + ", localidad=" + localidad + ", departamento=" + departamento + ", provincia=" + provincia + '}';
    }

    
}
