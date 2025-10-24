package model;

public class Computer {

    private String serial;
    private int floor;
    private int col;
    private ArrayList<Incident> incidents;

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los
     * requerimientos.
     */

    public Computer(String serial, int floor, int col) {
        this.seriar = serial;
        this.floor = floor;
        this.col = col;
        this.incidents = new ArrayList<>();
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria.
     */
    public void addIncident(String description) {
        incidents.add(new Incident(description));

    }

    public int getIncidentCount(){
        return incidents.size;
    }

    public String getSerial() {return serial};
    public int getFloor() {return floor};
    public String getCol() {return col};


    public String toString(){
        return "Serial:" + serial + "Piso:" + floor + "Columna:" +col+ "Incidente:" + incidents.size();
    }


}
