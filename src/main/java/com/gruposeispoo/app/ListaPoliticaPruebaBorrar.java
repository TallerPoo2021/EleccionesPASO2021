package com.gruposeispoo.app;


public class ListaPoliticaPruebaBorrar {

    private int numero;
    private String nombre;

    public ListaPoliticaPruebaBorrar() {
    }

    public ListaPoliticaPruebaBorrar(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ListaPolitica{" + "numero=" + numero + ", nombre=" + nombre + '}';
    }

}
