public class Lugar_C {
    private int ID_Lugar;
    private String Nombre_Lugar;
    private String Coordenadas; //(Calle Principal, Calle Secundaria)
    private String Apertura;
    private int Puntuacion;

    public Lugar_C(int ID_Lugar, String nombre_Lugar, String coordenadas, String apertura, int puntuacion) {
        this.ID_Lugar = ID_Lugar;
        Nombre_Lugar = nombre_Lugar;
        Coordenadas = coordenadas;
        Apertura = apertura;
        Puntuacion = puntuacion;
    }

    public int getID_Lugar() {
        return ID_Lugar;
    }

    public String getNombre_Lugar() {
        return Nombre_Lugar;
    }

    public String getCoordenadas() {
        return Coordenadas;
    }

    public String getApertura() {
        return Apertura;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }
}
