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
     * CONSTRUCTOR
     *
     */
    public LeerArchivos() {
    }

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
     * @return List<>, lista de electores
     *
     */
    public List<Elector> leerPadronElectores(String rutaArchivoElectores) {
        List<Elector> listaElectores = new ArrayList<Elector>();
 
        String nombre = "";
        String apellido = "";
        LocalDate fechaNac = null;
        TipoDocumento tipoDni = null;
        Domicilio domicilio = null;
        int anioNacimiento = 0;
        int mesNacimiento = 0;
        int diaNacimiento = 0;

        try {
            archivo = new File(rutaArchivoElectores);

            if (this.archivoVacio(archivo)) {
                throw new Error("El archivo" + rutaArchivoElectores + " esta vacio");
            }

            fr = new FileReader(archivo);
            csvRead = new CSVReader(fr);
            fila = null;
            
            while ((fila = csvRead.readNext()) != null) {

                /*
                    Los datos de la fecha de nacimiento del elector
                */
                anioNacimiento = Integer.parseInt(fila[2]);
                mesNacimiento = Integer.parseInt(fila[3]);
                diaNacimiento = Integer.parseInt(fila[4]);
                
                // tipo dni del elector
                tipoDni = TipoDocumento.valueOf(fila[5]);
                /*
                    Los datos del domicilio del elector
                */
                domicilio = new Domicilio();
                domicilio.setDireccion(fila[6]);
                domicilio.setLocalidad(fila[7]);
                domicilio.setDepartamento(fila[8]);
                domicilio.setProvincia(fila[9]);
                // nombre del elector
                nombre = fila[0];
                // apellido del elector
                apellido = fila[1];
                // fecha de nacimiento del elector
                fechaNac = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
                
                /*
                    Creando un nuevo elector
                */
                Elector electorAux = new Elector();

                /*
                    Seteando los datos del nuevo elector
                */
                electorAux.setNombre(nombre);
                electorAux.setApellido(apellido);
                electorAux.setFechaNac(fechaNac);
                electorAux.setTipoDni(tipoDni);
                electorAux.setDomicilio(domicilio);
                
                //elector agregado a la lista de electores
                listaElectores.add(electorAux);
            }

            csvRead.close();
        } catch (IOException | CsvValidationException e) {
            System.out.println(e);
        }

        return listaElectores;
    }
}
