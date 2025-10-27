package ui;

import java.util.Scanner;
import model.SchoolController;
import model.Computer;

/**
 * Descripción:
 *  Consola para la escuela Computaricemos que permite:
 *  - Agregar computadores
 *  - Registrar incidentes
 *  - Consultar el computador con más incidentes
 *  - Listar computadores
 */
public class SchoolApp {

    //  Atributos
    private Scanner input;
    private SchoolController controller;

    //  Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
        controller = new SchoolController();
    }

    //  Método principal
    public static void main(String[] args) {
        SchoolApp ui = new SchoolApp();
        ui.menu();  // ejecuta el menú principal
    }

    //  Menú
    public void menu() {
        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\n MENÚ PRINCIPAL");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("4) Listar computadores");
            System.out.println("0) Salir del sistema");
            System.out.print("Opción: ");
            option = input.nextInt();
            input.nextLine(); // limpiar 

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 4:
                    listarComputadores();
                    break;
                case 0:
                    System.out.println("\n Gracias por usar nuestros servicios. Vuelva pronto!");
                    break;
                default:
                    System.out.println("\n Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);
    }

    // Métodos de opciones
    public void registrarComputador() {
        System.out.print("\n Ingrese el serial del computador: ");
        String serial = input.nextLine();

        System.out.print("Ingrese el piso (1-5): ");
        int piso = input.nextInt();
        input.nextLine();

        boolean agregado = controller.agregarComputador(serial, piso);
        if (agregado) {
            System.out.println(" Computador agregado correctamente.");
        } else {
            System.out.println(" No se pudo agregar el computador.");
        }
    }

    public void registrarIncidenteEnComputador() {
        System.out.print("\nIngrese el serial del computador: ");
        String serial = input.nextLine();

        System.out.print("Ingrese la descripción del incidente: ");
        String descripcion = input.nextLine();

        boolean agregado = controller.agregarIncidenteEnComputador(serial, descripcion);
        if (agregado) {
            System.out.println(" Incidente registrado correctamente.");
        } else {
            System.out.println(" No se encontró un computador con ese serial.");
        }
    }

    public void consultarComputadorConMasIncidentes() {
        Computer top = controller.getComputerWithMostIncidents();
        if (top != null) {
            System.out.println("\n Computador con más incidentes:");
            System.out.println(top);
        } else {
            System.out.println(" No hay computadores registrados.");
        }
    }

    public void listarComputadores() {
        System.out.println("\n Lista de computadores ");
        controller.getComputerList();
    }
}
