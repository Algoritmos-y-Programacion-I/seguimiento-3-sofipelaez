package model;

public class SchoolController {

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los
     * requerimientos.
     */
    //  Atributos
    private Computer [][] building;
    private int numFloors = 5;
    private int numCol = 10;

     //  Constructor
    public SchoolController() {
        building = new Computer[numFloors][numCol];

    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * MÉTODO MODIFICADOR
     * Agrega un computador nuevo en el piso indicado, en la primera columna disponible.
     * @param serial Serial único del computador.
     * @param floor Número de piso (1-5).
     * @return true si se agregó correctamente, false si el piso está lleno o el serial ya existe.
     * Precondición: el serial no debe repetirse.
     * Postcondición: el computador queda almacenado en la primera columna vacía del piso.
     */
    public void agregarComputador(String serial, int floor) {

        if(buscarPorSerial(serial)!= null) {
            System.out.println(""El serial ya existe.);
            return false;
        }

        for (int j=0; j < numCol; j++){
            if (building[floor - 1][j]==null){
                building[floor -1][j]= new Computer(serial, floor, j + 1);
                System.out.println("Computador agregado en piso"+floor +"columna"+ (j+1));
            }
        }

    }

    public void agregarIncidenteEnComputador() {

    }

    public void getComputerList() {

    }

}
