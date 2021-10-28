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
	private int dni;
	private MesaElectoral mesaElectoral;

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
	 * @param nombre,   nombre del elector
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
	 *
	 * Constructor parametrizado
	 *
	 * @param nombre,    nombre del elector
	 * @param apellido,  apellido del elector
	 * @param DNI,       DNI de TipoDocumento
	 * @param fechaNac,  fecha de nacimiento del elector
	 * @param domicilio, domicilio del elector
	 */
	public Elector(String nombre, String apellido, TipoDocumento DNI, LocalDate fechaNac,
			Domicilio domicilio) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDni = DNI;
		this.fechaNac = fechaNac;
		this.domicilio = domicilio;
	}

	/**
	 *
	 * Constructor parametrizado (usado para cargar padron)
	 *
	 * @param nombre,    nombre del elector
	 * @param apellido,  apellido del elector
	 * @param fechaNac,  fecha de nacimiento del elector
	 * @param tipoDni,   DNI de TipoDocumento
	 * @param domicilio, domicilio del elector
	 * @param dni,       dni del elector
	 * @param id,        id autoincremental del usuario
	 */
	public Elector(String nombre, String apellido, LocalDate fechaNac, TipoDocumento tipoDni,
			Domicilio domicilio, int dni, MesaElectoral mesaElectoral, int id) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.tipoDni = tipoDni;
		this.domicilio = domicilio;
		this.dni = dni;
		this.mesaElectoral = mesaElectoral;
		this.id = id;
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
	 * Establece si esta elector esta habilitado para votar o no, dependiendo de su
	 * tipo de documento.
	 *
	 */
	public void setHabilitadoParaVotar() {
		if (this.tipoDni == null) {
			throw new NullPointerException("Falta setear el atributo DNI");
		}

		boolean habilitado = this.tipoDni != TipoDocumento.DNI_EN_CELULAR
				&& this.tipoDni != TipoDocumento.DNI_EN_TRAMITE;
		this.puedeVotar = habilitado;
	}

	/**
	 * @return boolean, true si el elector esta habilitado para votar, false en caso
	 *         contrario.
	 */
	public boolean getPuedeVotar() {
		return puedeVotar;
	}

	/**
	 *
	 * @return Voto, el voto realizado por este elector, NULL si este elector no ha
	 *         votado a�n
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
		return tipoDni;
	}

	/**
	 *
	 * @param DNI, el tipo de dni a setear
	 */
	public void setDNI(TipoDocumento DNI) {
		this.tipoDni = DNI;
	}

	/**
	 *
	 * @return Date, la fecha de nacimiento de este elector
	 */
	public LocalDate getFechaNac() {
		return fechaNac;
	}

	/**
	 *
	 * @param fechaNac, la fecha de nacimiento a setear
	 */
	public void setFechaNac(LocalDate fechaNac) {
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

	/**
	 *
	 * @return dni, dni del votante
	 */
	public int getDni() {
		return dni;
	}

	/**
	 *
	 * @param dni, dni del votante
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Elector{" + "nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + tipoDni
				+ ", fechaNac=" + fechaNac + ", puedeVotar=" + puedeVotar + ", domicilio="
				+ domicilio + '}';
	}

	public MesaElectoral getMesaElectoral() {
		return mesaElectoral;
	}
}
