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

    public Incident(LocalDate dateReport, String description) {
        this.dateReport = dateReport;
        this.description = description;
        this.solution = false;   // por defecto no solucionado
        this.solutionHours = 0;  // por defecto 0 horas
    }

    public LocalDate getDateReport() { return dateReport; }
    public String getDescription() { return description; }
    public boolean isSolution() { return solution; }
    public int getSolutionHours() { return solutionHours; }

    public void setSolution(boolean solution) { this.solution = solution; }
    public void setSolutionHours(int solutionHours) { this.solutionHours = solutionHours; }

    @Override
    public String toString() {
        String estado = solution ? "Solucionado" : "Pendiente";
        return "Incidente: " + description +
               "  Fecha: " + dateReport +
               "  Estado: " + estado +
               "  Horas: " + solutionHours;
    }
}

