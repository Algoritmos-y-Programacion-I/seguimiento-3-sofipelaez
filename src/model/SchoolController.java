package model;

/**
 * Descripción:
 * Controla la gestión de los computadores en la escuela Computaricemos.
 * Maneja una matriz de objetos Computer (5 pisos x 10 columnas)
 * y permite registrar computadores, registrar incidentes, consultar el computador
 * con más incidentes y listar los computadores registrados.
 */
public class SchoolController {

    // Atributos (relaciones)
    private Computer[][] building;
    private int numFloors = 5;
    private int numCol = 10;

    // Constructor
    public SchoolController() {
        building = new Computer[numFloors][numCol];
    }

    // MÉTODOS MODIFICADORES

    /**
     * Agrega un computador nuevo en el piso indicado, en la primera columna disponible.
     * @param serial Serial único del computador.
     * @param floor Número de piso (1-5).
     * @return true si se agregó correctamente, false si el piso está lleno o el serial ya existe.
     * Precondición: el serial no debe repetirse.
     * Postcondición: el computador queda almacenado en la primera columna vacía del piso.
     */
    public boolean agregarComputador(String serial, int floor) {

        if (buscarPorSerial(serial) != null) {
            System.out.println("El serial ya existe.");
            return false;
        }

        if (floor < 1 || floor > numFloors) {
            System.out.println("Piso inválido. Debe estar entre 1 y " + numFloors);
            return false;
        }

        for (int j = 0; j < numCol; j++) {
            if (building[floor - 1][j] == null) {
                building[floor - 1][j] = new Computer(serial, floor, j + 1);
                System.out.println("Computador agregado en piso " + floor + ", columna " + (j + 1));
                return true;
            }
        }

        System.out.println("Piso lleno. No se pudo agregar el computador.");
        return false;
    }

    /**
     * Registra un incidente en el computador indicado por su serial.
     * @param serial Serial del computador.
     * @param description Descripción del incidente.
     * @return true si se agregó correctamente, false si el serial no existe.
     * Precondición: el computador debe existir.
     * Postcondición: el incidente se agrega a la lista de incidentes del computador.
     */
    public boolean agregarIncidenteEnComputador(String serial, String description) {
        Computer c = buscarPorSerial(serial);
        if (c != null) {
            c.addIncident(description);
            System.out.println("Incidente registrado en el computador " + serial);
            return true;
        } else {
            System.out.println("No se encontró un computador con ese serial.");
            return false;
        }
    }

    // MÉTODOS ANALIZADORES
    /**
     * Busca un computador por su serial.
     * @param serial Serial del computador.
     * @return El objeto Computer si existe, o null si no se encuentra.
     */
    public Computer buscarPorSerial(String serial) {
        for (int i = 0; i < numFloors; i++) {
            for (int j = 0; j < numCol; j++) {
                Computer c = building[i][j];
                if (c != null && c.getSerial().equalsIgnoreCase(serial)) {
                    return c;
                }
            }
        }
        return null;
    }

    /**
     * Retorna el computador con más incidentes en todo el edificio.
     * @return El objeto Computer con mayor cantidad de incidentes.
     * Precondición: Debe existir al menos un computador registrado.
     * Postcondición: Devuelve el computador con el mayor número de incidentes.
     */
    public Computer getComputerWithMostIncidents() {
        Computer max = null;
        int maxIncidents = -1;

        for (int i = 0; i < numFloors; i++) {
            for (int j = 0; j < numCol; j++) {
                Computer c = building[i][j];
                if (c != null && c.getIncidentCount() > maxIncidents) {
                    max = c;
                    maxIncidents = c.getIncidentCount();
                }
            }
        }

        return max;
    }

    /**
     * Muestra todos los computadores registrados junto con sus incidentes.
     */
    public void getComputerList() {
        boolean empty = true;

        for (int i = 0; i < numFloors; i++) {
            for (int j = 0; j < numCol; j++) {
                Computer c = building[i][j];
                if (c != null) {
                    // Imprime resumen del computador
                    System.out.println(c.toString());
                    // Imprime los incidentes con fecha, estado y horas
                    c.printIncidents();
                    System.out.println(" ");
                    empty = false;
                }
            }
        }

        if (empty) {
            System.out.println("No hay computadores registrados.");
        }
    }
}
