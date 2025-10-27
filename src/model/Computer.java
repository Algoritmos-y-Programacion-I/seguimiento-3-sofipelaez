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

    public int getIncidentCount() {
        return incidents.size();
    }

    public String getSerial() {
        return serial;
    }

    public int getFloor() {
        return floor;
    }

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
     * Devuelve la lista de incidentes (si la necesitas en el controller).
     */
    public ArrayList<Incident> getIncidents() {
        return incidents;
    }
}
