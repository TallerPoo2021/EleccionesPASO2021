package com.gruposeispoo.clases;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivos {
	private File archivo;
	private FileReader fr;
	private String[] fila;
	private CSVReader csvRead;

	/**
	 * Comprueba que el archivo no este vacio
	 *
	 * @param archivo, ruta del archivo a comprobar
	 * @return boolean, true si esta vacio el archivo
	 *
	 */
	private boolean archivoVacio(File archivo) {
		return archivo.length() == 0;
	}

	/**
	 * Carga de padron
	 *
	 * @param rutaArchivoElectores, ruta de Padron.csv
	 * @return List<Elector>, lista de electores
	 *
	 */
	public List<Elector> cargaElectores(String rutaArchivoElectores) {
		List<Elector> listaElectores = new ArrayList<Elector>();
		int idAutoIncrement = 0;
		try {
			archivo = new File(rutaArchivoElectores);
			if (this.archivoVacio(archivo)) {
				throw new Error("El archivo" + rutaArchivoElectores + " esta vacio");
			}

			fr = new FileReader(archivo);
			csvRead = new CSVReader(fr);
			fila = null;
			while ((fila = csvRead.readNext()) != null) {

				int anioNacimiento = Integer.parseInt(fila[2]);
				int mesNacimiento = Integer.parseInt(fila[3]);
				int diaNacimiento = Integer.parseInt(fila[4]);
				idAutoIncrement++;
				Elector electorAux = new Elector(fila[0], fila[1],
						LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento),
						TipoDocumento.valueOf(fila[5]),
						new Domicilio(fila[6], fila[7], fila[8], fila[9]),
						Integer.parseInt(fila[10]),
						CamaraElectoral.encontrarMesa(Integer.parseInt(fila[11])), idAutoIncrement);

				listaElectores.add(electorAux);
			}

			csvRead.close();
		} catch (IOException | CsvValidationException e) {
			System.out.println(e);
		}

		return listaElectores;
	}
}
