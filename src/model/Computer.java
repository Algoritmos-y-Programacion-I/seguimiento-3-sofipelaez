package model;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Clase que representa un computador dentro del edificio.
 * Cada computador puede registrar varios incidentes.
 */
public class Computer {

    private String serial;
    private int floor;
    private int col;
    private ArrayList<Incident> incidents;

    /**
 * Constructor de Computer.
 * @param serial Serial único del computador.
 * @param floor Piso donde está ubicado (1..5).
 * @param col Columna/prefijo dentro del piso (1..numCol).
 */
     public Computer(String serial, int floor, int col) {
        this.serial = serial;
        this.floor = floor;
        this.col = col;
        this.incidents = new ArrayList<>();
    }

    /**
     * Agrega un nuevo incidente con la fecha actual.
     * @param description descripción del incidente.
     */
    public void addIncident(String description) {
        incidents.add(new Incident(LocalDate.now(), description));
    }
    /**
 * Retorna la cantidad de incidentes registrados en este computador.
 * @return número de incidentes.
 */
    public int getIncidentCount() {
        return incidents.size();
    }
    /**
 * Retorna el serial del computador.
 * @return serial como String.
 */
    public String getSerial() {
        return serial;
    }
    /**
 * Retorna el número de piso.
 * @return piso (int).
 */
    public int getFloor() {
        return floor;
    }
    /**
 * Retorna la columna del computador.
 * @return columna (int).
 */
    public int getCol() {
        return col;
    }

    /**
     * Devuelve un resumen del computador.
     */
    @Override
    public String toString() {
        return "Serial: " + serial +
               "  Piso: " + floor +
               "  Columna: " + col +
               "  Incidentes: " + incidents.size();
    }

    /**
     * Imprime todos los incidentes del computador con su detalle.
     */
    public void printIncidents() {
        if (incidents.isEmpty()) {
            System.out.println(" No hay incidentes registrados.");
        } else {
            for (Incident inc : incidents) {
                System.out.println("   - " + inc.toString());
            }
        }
    }

    /**
 * Retorna la lista de incidentes asociados a este computador.
 * @return ArrayList&lt;Incident&gt; con los incidentes (puede estar vacío).
 */
    public ArrayList<Incident> getIncidents() {
        return incidents;
    }
}
