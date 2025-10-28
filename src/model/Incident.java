package model;

import java.time.LocalDate;

/**
 * Clase que representa un incidente asociado a un computador.
 * Contiene la fecha del reporte, la descripción del problema,
 * si fue solucionado o no, y las horas dedicadas a resolverlo.
 */
public class Incident {

    private LocalDate dateReport;
    private String description;
    private boolean solution;
    private int solutionHours;

    /**
 * Constructor de Incident.
 * @param dateReport Fecha del reporte (LocalDate).
 * @param description Descripción del incidente.
 */
    public Incident(LocalDate dateReport, String description) {
        this.dateReport = dateReport;
        this.description = description;
        this.solution = false;   // por defecto no solucionado
        this.solutionHours = 0;  // por defecto 0 horas
    }
    /** @return Fecha del reporte (LocalDate). */
    public LocalDate getDateReport() { return dateReport; }
    /** @return Descripción del incidente. */
    public String getDescription() { return description; }
    /** @return true si el incidente está solucionado. */
    public boolean isSolution() { return solution; }
    /** @return Horas empleadas en la solución. */
    public int getSolutionHours() { return solutionHours; }
    /**
 * Marca si el incidente fue solucionado.
 * @param solution true si está solucionado.
 */
    public void setSolution(boolean solution) { this.solution = solution; }
    public void setSolutionHours(int solutionHours) { this.solutionHours = solutionHours; }

    /**
 * Establece las horas dedicadas a la solución.
 * @param solutionHours número de horas.
 */
    public String toString() {
        String estado = solution ? "Solucionado" : "Pendiente";
        return "Incidente: " + description +
               "  Fecha: " + dateReport +
               "  Estado: " + estado +
               "  Horas: " + solutionHours;
    }
}

